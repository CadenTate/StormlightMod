package ctnightfury.stormlightmod.component;

import ctnightfury.stormlightmod.component.interfaces.GravitationComponentInterface;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.Vec3d;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;

public class GravitationComponent implements GravitationComponentInterface, AutoSyncedComponent{
    private final Object provider;

    private boolean isActive = false;
    private int power = 1;
    private int newPower = 1;
    private final int maxPower = 5;
    private Vec3d velPercent3D = Vec3d.ZERO;

    public GravitationComponent(Object provider) {
        this.provider = provider;
    }

    @Override
    public boolean isActive() {
        return this.isActive;
    }

    @Override
    public void setActive(boolean activeState) {
        this.isActive = activeState;
    }

    @Override
    public void invertActive() {
        this.setActive(!this.isActive());
    }

    @Override
    public void changePower(int amount) {
        this.newPower += amount;
        if(this.newPower < 0) this.newPower = 0;
        else if (this.newPower > this.maxPower) this.newPower = 5;
    }

    @Override
    public int getNewPower() {
        return newPower;
    }


    // Client-side logic (e.g., player effects, animations)
    @Override
    public void changeGravityDirection(ClientPlayerEntity player) {
        power = newPower;
        // Convert yaw value to the one that is read in f3
        float yaw = player.getYaw() % 360;
        if (yaw > 180) {
            yaw -= 360;
        } else if (yaw < -180) {
            yaw += 360;
        }
        float pitch = player.getPitch();

        // Normalize values
        float yawSign = getSign(yaw);
        float velPercentX = yawSign * ((float)1/90 * Math.abs(yaw - yawSign * 90) - 1);
        float velPercentY = -pitch / 90;
        float velPercentZ = (Math.abs(yaw) - 90) / -90;

        this.velPercent3D = new Vec3d(velPercentX, velPercentY, velPercentZ);

//        player.sendMessage(Text.literal(Float.toString(velPercentX)));
//        player.sendMessage(Text.literal(Float.toString(velPercentY)));
//        player.sendMessage(Text.literal(Float.toString(velPercentZ)));
    }

    @Override
    public void enable(ClientPlayerEntity player) {
        player.setVelocity(this.velPercent3D.multiply(this.power));
    }

    private float getSign(float x) {
        return Math.abs(x) / x;
    }

    @Override
    public void readFromNbt(NbtCompound tag, RegistryWrapper.WrapperLookup registryLookup) {
        this.setActive(tag.getBoolean("isActive"));
        this.power = tag.getInt("power");
//        System.out.println("READ FROM NBT: " + this.isActive());
    }

    @Override
    public void writeToNbt(NbtCompound tag, RegistryWrapper.WrapperLookup registryLookup) {
        tag.putBoolean("isActive", this.isActive());
        tag.putInt("power", this.power);
//        System.out.println("WROTE TO NBT: " + this.isActive());
    }
}
