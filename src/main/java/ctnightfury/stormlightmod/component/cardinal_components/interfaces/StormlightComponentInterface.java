package ctnightfury.stormlightmod.component.cardinal_components.interfaces;

import org.ladysnake.cca.api.v3.component.Component;

public interface StormlightComponentInterface extends Component {
    int getStormlight();
    void addStormlight(int amount);
    void subtractStormlight(int amount);
    void setStormlight(int amount);
}
