package ctnightfury.stormlightmod.component.cardinal_components.interfaces;

import net.minecraft.client.network.ClientPlayerEntity;
import org.ladysnake.cca.api.v3.component.Component;

public interface SurgeInterface extends Component {
    boolean isActive();
    void setActive(boolean activeState);
    void invertActive();
    void changePower(int amount);
    int getNewPower();
    void enable(ClientPlayerEntity player);
}
