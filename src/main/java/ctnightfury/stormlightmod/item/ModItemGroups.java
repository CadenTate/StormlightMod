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
                    .icon(() -> new ItemStack(ModItems.SPHERES.get("diamond_broam_sphere")))
                    .displayName(Text.translatable("itemgroup.stormlightmod.all_items"))
                    .entries((displayContext, entries) -> {
                        // Add Items Here
                        for(Item item : ModItems.SPHERES.values()) {
                            entries.add(item);
                        }
                        // Other Items
                        entries.add(ModItems.SOULCASTER);
                        entries.add(ModItems.LAVIS_BAR);
                        entries.add(ModItems.WINE);
                        entries.add(ModItems.DRIED_LAVIS_POLYP);
                        entries.add(ModItems.SPHERE_POUCH_ITEM);

                        // Shardplate
                        entries.add(ModItems.SHARDPLATE_HELMET);
                        entries.add(ModItems.SHARDPLATE_CHESTPLATE);
                        entries.add(ModItems.SHARDPLATE_LEGGINGS);
                        entries.add(ModItems.SHARDPLATE_BOOTS);

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
//                        entries.add(ModBlocks.CUSTOM_CHEST);
                    })
                    .build());

    public static void registerItemGroups() {
        StormlightMod.LOGGER.info("Registering Item Groups for "+StormlightMod.MOD_ID);
    }
}
