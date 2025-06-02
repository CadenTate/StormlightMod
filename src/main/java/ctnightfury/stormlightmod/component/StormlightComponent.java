package ctnightfury.stormlightmod.component;


import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import ctnightfury.stormlightmod.component.interfaces.StormlightComponentInterface;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;
import org.ladysnake.cca.api.v3.component.tick.ServerTickingComponent;

public class StormlightComponent implements StormlightComponentInterface, ServerTickingComponent, AutoSyncedComponent {
    private final Object provider;
    private int stormlight = 0;
    private int tickCounter = 0;
    // Time in sec that it takes to lose 1 stormlight
    private final int lossRate = 1;

    public StormlightComponent(Object provider) {
        this.provider = provider;
    }

    public int getStormlight() {
        return this.stormlight;
    }

    public void setStormlight(int amount) {
        this.stormlight = Math.max(0, amount);
        ModComponents.STORMLIGHT.sync(this.provider);
    }

    public void addStormlight(int amount) {
        this.stormlight += amount;
        ModComponents.STORMLIGHT.sync(this.provider);
    }

    public void subtractStormlight(int amount) {
        this.stormlight = Math.max(0, this.stormlight - amount);
        ModComponents.STORMLIGHT.sync(this.provider);
    }

    @Override
    public void readFromNbt(NbtCompound tag, RegistryWrapper.WrapperLookup registryLookup) {
        this.stormlight = tag.getInt("stormlight");
    }

    @Override
    public void writeToNbt(NbtCompound tag, RegistryWrapper.WrapperLookup registryLookup) {
        tag.putInt("stormlight", stormlight);
    }

    @Override
    public void serverTick() {
        if(tickCounter >= 20 * lossRate) {
            tickCounter = 0;
            subtractStormlight(1);
        }
        tickCounter++;
    }
}
