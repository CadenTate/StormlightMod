package ctnightfury.stormlightmod.component.interfaces;

import net.minecraft.client.network.ClientPlayerEntity;
import org.ladysnake.cca.api.v3.component.Component;
import net.minecraft.util.math.Vec3d;

public interface GravitationComponentInterface extends Component {
    public boolean isActive();
    public void setActive(boolean activeState);
    public void invertActive();
    public void changePower(int amount);
    public int getNewPower();
    public void changeGravityDirection(ClientPlayerEntity player);
    public void enable(ClientPlayerEntity player);
}
