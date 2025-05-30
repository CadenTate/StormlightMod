package ctnightfury.stormlightmod.item;

import ctnightfury.stormlightmod.StormlightMod;
import ctnightfury.stormlightmod.item.custom.SoulcasterItem;
import ctnightfury.stormlightmod.item.custom.SphereItem;
import ctnightfury.stormlightmod.item.custom_drinks.Wine;
import ctnightfury.stormlightmod.item.enums.SphereGemstone;
import ctnightfury.stormlightmod.item.enums.SphereSize;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ModItems {

    // Sphere Items
    public static final Map<String, Item> SPHERES = new LinkedHashMap<>();

//    public static final Item SAPPHIRE_SPHERE = registerItem("sapphire_sphere", new Item(new Item.Settings()));
//    public static final Item SMOKESTONE_SPHERE = registerItem("smokestone_sphere", new Item(new Item.Settings()));
//    public static final Item RUBY_SPHERE = registerItem("ruby_sphere", new Item(new Item.Settings()));
//    public static final Item DIAMOND_SPHERE = registerItem("diamond_sphere", new Item(new Item.Settings()));
//    public static final Item EMERALD_SPHERE = registerItem("emerald_sphere", new Item(new Item.Settings()));
//    public static final Item GARNET_SPHERE = registerItem("garnet_sphere", new Item(new Item.Settings()));
//    public static final Item ZIRCON_SPHERE = registerItem("zircon_sphere", new Item(new Item.Settings()));
//    public static final Item AMETHYST_SPHERE = registerItem("amethyst_sphere", new Item(new Item.Settings()));
//    public static final Item TOPAZ_SPHERE = registerItem("topaz_sphere", new Item(new Item.Settings()));
//    public static final Item HELIODOR_SPHERE = registerItem("heliodor_sphere", new Item(new Item.Settings()));

    public static void registerSpheres() {
        for (SphereGemstone gemstone : SphereGemstone.values()) {
            for (SphereSize size : SphereSize.values()) {
                String id = gemstone.name().toLowerCase() + "_" + size.name().toLowerCase() + "_sphere";
                Item item = new SphereItem(size, gemstone, new Item.Settings());
                registerItem(id,item);
                SPHERES.put(id, item);
            }
        }
        System.out.println(SPHERES.keySet());
    }

    public static final Item DRIED_LAVIS_POLYP = registerItem("dried_lavis_polyp", new Item(new Item.Settings()));
    public static final Item LAVIS_BAR = registerItem("lavis_bar", new Item(new Item.Settings().food(ModFoodComponents.LAVIS_BAR)));
    public static final Item WINE = registerItem("wine", new Wine(new Item.Settings().food(ModFoodComponents.WINE).maxCount(1)));
    // Demonstrates how to add tooltips to non-custom class items
    public static final Item SOULCASTER = registerItem("soulcaster", new SoulcasterItem(new Item.Settings()){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.stormlightmod.soulcaster"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(StormlightMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        StormlightMod.LOGGER.info("Registering Mod Items for " + StormlightMod.MOD_ID);

        // Adds custom item to existing ItemGroup
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
//            entries.add(<INSERT ITEM HERE>);
//        });
    }
}
