package ctnightfury.stormlightmod.item.enums;

public enum SphereGemstone {
    SAPPHIRE(0x0000FF),
    SMOKESTONE(0x000000),
    RUBY(0xFF0000),
    DIAMOND(0xFFFFFF),
    EMERALD(0x00FF00),
    GARNET(0xFF0000),
    ZIRCON(0x000000),
    AMETHYST(0x800080),
    TOPAZ(0xFFA500),
    HELIODOR(0xFFFF00);

    public final int glowColor;
    SphereGemstone(int glowColor) {
        this.glowColor = glowColor;
    }
}
