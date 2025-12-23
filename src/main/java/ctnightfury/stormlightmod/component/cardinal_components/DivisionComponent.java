package ctnightfury.stormlightmod.component.cardinal_components;

import ctnightfury.stormlightmod.component.cardinal_components.interfaces.SurgeInterface;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;

public class DivisionComponent implements SurgeInterface, AutoSyncedComponent {
    private final Object provider;

    private boolean isActive = false;
    private int power = 1;

    public DivisionComponent(Object provider) {
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
        power = amount;
    }

    @Override
    public int getNewPower() {
        return power;
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
