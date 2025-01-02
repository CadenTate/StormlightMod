package ctnightfury.stormlightmod.item;

import ctnightfury.stormlightmod.StormlightMod;
import ctnightfury.stormlightmod.item.custom.SoulcasterItem;
import ctnightfury.stormlightmod.item.custom_drinks.Wine;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Set;

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
    public static final Set<Item> SPHERES = Set.of(
            SAPPHIRE_SPHERE,
            SMOKESTONE_SPHERE,
            RUBY_SPHERE,
            DIAMOND_SPHERE,
            EMERALD_SPHERE,
            GARNET_SPHERE,
            ZIRCON_SPHERE,
            AMETHYST_SPHERE,
            TOPAZ_SPHERE,
            HELIODOR_SPHERE
    );

    public static final Item DRIED_LAVIS_POLYP = registerItem("dried_lavis_polyp", new Item(new Item.Settings()));
    public static final Item LAVIS_BAR = registerItem("lavis_bar", new Item(new Item.Settings().food(ModFoodComponents.LAVIS_BAR)));
    // Demonstrates how to add tooltips to non-custom class items
    public static final Item WINE = registerItem("wine", new Wine(new Item.Settings().food(ModFoodComponents.WINE)){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.stormlightmod.wine"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item SOULCASTER = registerItem("soulcaster", new SoulcasterItem(new Item.Settings()));

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
