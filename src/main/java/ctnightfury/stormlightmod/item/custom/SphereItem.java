package ctnightfury.stormlightmod.item.custom;

import ctnightfury.stormlightmod.item.enums.SphereSize;
import ctnightfury.stormlightmod.item.enums.SphereGemstone;
import net.minecraft.item.Item;

public class SphereItem extends Item {
    private final SphereSize size;
    private final SphereGemstone gemstone;

    public SphereItem(SphereSize size, SphereGemstone gemstone, Settings settings) {
        super(settings);
        this.size = size;
        this.gemstone = gemstone;
    }

    public int getCapacity() {
        return size.capacity;
    }

    public int getGlowColor() {
        return gemstone.glowColor;
    }

    public SphereSize getSize() {
        return size;
    }

    public SphereGemstone getColor() {
        return gemstone;
    }
}
