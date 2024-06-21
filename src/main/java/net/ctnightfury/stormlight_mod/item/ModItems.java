package net.ctnightfury.stormlight_mod.item;

import net.ctnightfury.stormlight_mod.StormlightMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, StormlightMod.MOD_ID);

    // Add Spheres
    public static final RegistryObject<Item> SAPPHIRE_SPHERE = ITEMS.register("sapphire_sphere",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SMOKESTONE_SPHERE = ITEMS.register("smokestone_sphere",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RUBY_SPHERE = ITEMS.register("ruby_sphere",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_SPHERE = ITEMS.register("diamond_sphere",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_SPHERE = ITEMS.register("emerald_sphere",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GARNET_SPHERE = ITEMS.register("garnet_sphere",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ZIRCON_SPHERE = ITEMS.register("zircon_sphere",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_SPHERE = ITEMS.register("amethyst_sphere",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TOPAZ_SPHERE = ITEMS.register("topaz_sphere",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HELIODOR_SPHERE = ITEMS.register("heliodor_sphere",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
