package ctnightfury.stormlightmod.item;

import ctnightfury.stormlightmod.StormlightMod;
import ctnightfury.stormlightmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup ALL_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(StormlightMod.MOD_ID, "all_items_group"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.DIAMOND_SPHERE))
                    .displayName(Text.translatable("itemgroup.stormlightmod.all_items"))
                    .entries((displayContext, entries) -> {
                        // Add Items Here
                        entries.add(ModItems.SAPPHIRE_SPHERE);
                        entries.add(ModItems.SMOKESTONE_SPHERE);
                        entries.add(ModItems.RUBY_SPHERE);
                        entries.add(ModItems.DIAMOND_SPHERE);
                        entries.add(ModItems.EMERALD_SPHERE);
                        entries.add(ModItems.GARNET_SPHERE);
                        entries.add(ModItems.ZIRCON_SPHERE);
                        entries.add(ModItems.AMETHYST_SPHERE);
                        entries.add(ModItems.TOPAZ_SPHERE);
                        entries.add(ModItems.HELIODOR_SPHERE);
                        // Other Items
                        entries.add(ModItems.SOULCASTER);
                        entries.add(ModItems.LAVIS_BAR);
                        entries.add(ModItems.WINE);
                        entries.add(ModItems.DRIED_LAVIS_POLYP);

                        // Add Blocks here
                        entries.add(ModBlocks.CREM_STONE);
                        entries.add(ModBlocks.CREM_STAIRS);
                        entries.add(ModBlocks.CREM_SLAB);
                        entries.add(ModBlocks.CREM_BUTTON);
                        entries.add(ModBlocks.CREM_PRESSURE_PLATE);
                        entries.add(ModBlocks.CREM_WAll);
                        entries.add(ModBlocks.SAPPHIRE_ORE);
                        entries.add(ModBlocks.SMOKESTONE_ORE);
                        entries.add(ModBlocks.RUBY_ORE);
                        entries.add(ModBlocks.GARNET_ORE);
                        entries.add(ModBlocks.ZIRCON_ORE);
                        entries.add(ModBlocks.TOPAZ_ORE);
                        entries.add(ModBlocks.HELIODOR_ORE);
                        entries.add(ModBlocks.SPHERE_LANTERN_BLOCK);
                    })
                    .build());

    public static void registerItemGroups() {
        StormlightMod.LOGGER.info("Registering Item Groups for "+StormlightMod.MOD_ID);
    }
}
