package net.ctnightfury.stormlight_mod.item;

import com.ibm.icu.impl.locale.XCldrStub;
import net.ctnightfury.stormlight_mod.StormlightMod;
import net.ctnightfury.stormlight_mod.item.custom.SoulCaster;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, StormlightMod.MOD_ID);

    // Add Spheres
//    public static final RegistryObject<Item> SAPPHIRE_SPHERE = ITEMS.register("sapphire_sphere",
//            () -> new Item(new Item.Properties()));
//    public static final RegistryObject<Item> SMOKESTONE_SPHERE = ITEMS.register("smokestone_sphere",
//            () -> new Item(new Item.Properties()));
//    public static final RegistryObject<Item> RUBY_SPHERE = ITEMS.register("ruby_sphere",
//            () -> new Item(new Item.Properties()));
//    public static final RegistryObject<Item> DIAMOND_SPHERE = ITEMS.register("diamond_sphere",
//            () -> new Item(new Item.Properties()));
//    public static final RegistryObject<Item> EMERALD_SPHERE = ITEMS.register("emerald_sphere",
//            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GARNET_SPHERE = ITEMS.register("garnet_sphere",
            () -> new Item(new Item.Properties()));
//    public static final RegistryObject<Item> ZIRCON_SPHERE = ITEMS.register("zircon_sphere",
//            () -> new Item(new Item.Properties()));
//    public static final RegistryObject<Item> AMETHYST_SPHERE = ITEMS.register("amethyst_sphere",
//            () -> new Item(new Item.Properties()));
//    public static final RegistryObject<Item> TOPAZ_SPHERE = ITEMS.register("topaz_sphere",
//            () -> new Item(new Item.Properties()));
//    public static final RegistryObject<Item> HELIODOR_SPHERE = ITEMS.register("heliodor_sphere",
//            () -> new Item(new Item.Properties()));

    // Add Gemstones
//    public static final RegistryObject<Item> SAPPHIRE_GEMSTONE = ITEMS.register("sapphire_gemstone",
//            () -> new Item(new Item.Properties()));
//    public static final RegistryObject<Item> SMOKESTONE_GEMSTONE = ITEMS.register("smokestone_gemstone",
//            () -> new Item(new Item.Properties()));
//    public static final RegistryObject<Item> RUBY_GEMSTONE = ITEMS.register("ruby_gemstone",
//            () -> new Item(new Item.Properties()));
////    public static final RegistryObject<Item> DIAMOND_GEMSTONE = ITEMS.register("diamond_gemstone",
////            () -> new Item(new Item.Properties()));
////    public static final RegistryObject<Item> EMERALD_GEMSTONE = ITEMS.register("emerald_gemstone",
////            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GARNET_GEMSTONE = ITEMS.register("garnet_gemstone",
            () -> new Item(new Item.Properties()));
//    public static final RegistryObject<Item> ZIRCON_GEMSTONE = ITEMS.register("zircon_gemstone",
//            () -> new Item(new Item.Properties()));
////    public static final RegistryObject<Item> AMETHYST_GEMSTONE = ITEMS.register("amethyst_gemstone",
////            () -> new Item(new Item.Properties()));
//    public static final RegistryObject<Item> TOPAZ_GEMSTONE = ITEMS.register("topaz_gemstone",
//            () -> new Item(new Item.Properties()));
//    public static final RegistryObject<Item> HELIODOR_GEMSTONE = ITEMS.register("heliodor_gemstone",
//            () -> new Item(new Item.Properties()));

    // Custom Advanced Items
    public static final RegistryObject<Item> SOULCASTER = ITEMS.register("soulcaster", () -> new SoulCaster(new Item.Properties()));

    // Food Items
    public static final RegistryObject<Item> LAVIS_BAR = ITEMS.register("lavis_bar",
            () -> new Item(new Item.Properties().food(ModFoods.LAVIS_BAR)));

    // Food Crafting Items
    public static final RegistryObject<Item> LAVIS_GRAIN = ITEMS.register("lavis_grain",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}