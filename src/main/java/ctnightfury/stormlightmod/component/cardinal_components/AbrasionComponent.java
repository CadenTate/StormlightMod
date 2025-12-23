package ctnightfury.stormlightmod.component.cardinal_components;

import ctnightfury.stormlightmod.component.cardinal_components.interfaces.SurgeInterface;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.Vec3d;

public class AbrasionComponent implements SurgeInterface {
    private final Object provider;

    private boolean isActive = false;
    private int power = 1;
    private int newPower = 1;
    private final int maxPower = 5;

    public AbrasionComponent(Object provider) {
        this.provider = provider;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public void setActive(boolean activeState) {
        isActive = activeState;
    }

    @Override
    public void invertActive() {
        isActive = !isActive;
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

    @Override
    public void enable(ClientPlayerEntity player) {

    }

    @Override
    public void readFromNbt(NbtCompound tag, RegistryWrapper.WrapperLookup registryLookup) {

    }

    @Override
    public void writeToNbt(NbtCompound tag, RegistryWrapper.WrapperLookup registryLookup) {

    }
}
