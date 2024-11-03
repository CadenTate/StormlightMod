package ctnightfury.stormlightmod.item;

import ctnightfury.stormlightmod.StormlightMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    // Sphere Items
    public static final Item SAPPHIRE_SPHERE = registerItem("sapphire_sphere", new Item(new Item.Settings()));
    public static final Item SMOKESTONE_SPHERE = registerItem("smokestone_sphere", new Item(new Item.Settings()));
    public static final Item RUBY_SPHERE = registerItem("ruby_sphere", new Item(new Item.Settings()));
    public static final Item DIAMOND_SPHERE = registerItem("diamond_sphere", new Item(new Item.Settings()));
    public static final Item EMERALD_SPHERE = registerItem("emerald_sphere", new Item(new Item.Settings()));
    public static final Item GARNET_SPHERE = registerItem("garnet_sphere", new Item(new Item.Settings()));
    public static final Item ZIRCON_SPHERE = registerItem("zircon_sphere", new Item(new Item.Settings()));
    public static final Item AMETHYST_SPHERE = registerItem("amethyst_sphere", new Item(new Item.Settings()));
    public static final Item TOPAZ_SPHERE = registerItem("topaz_sphere", new Item(new Item.Settings()));
    public static final Item HELIODOR_SPHERE = registerItem("heliodor_sphere", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(StormlightMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        StormlightMod.LOGGER.info("Registering Mod Items for " + StormlightMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(SAPPHIRE_SPHERE);
        });
    }
}
