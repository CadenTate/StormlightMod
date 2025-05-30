package ctnightfury.stormlightmod.item.enums;

public enum SphereSize {
    CHIP(100), MARK(500), BROAM(1000);

    public final int capacity;
    SphereSize(int capacity) {
        this.capacity = capacity;
    }
}
