package ctnightfury.stormlightmod.block;

import ctnightfury.stormlightmod.StormlightMod;
import ctnightfury.stormlightmod.block.custom.CustomChest;
import ctnightfury.stormlightmod.block.custom.SphereLanternBlock;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block CREM_STONE = registerBlock("crem_stone",
            new Block(AbstractBlock.Settings.copy(Blocks.TUFF).strength(0.4f)));

    public static final Block CREM_STAIRS = registerBlock("crem_stairs",
            new StairsBlock(ModBlocks.CREM_STONE.getDefaultState(), AbstractBlock.Settings.copy(CREM_STONE)));

    public static final Block CREM_SLAB = registerBlock("crem_slab",
            new SlabBlock(AbstractBlock.Settings.copy(CREM_STONE)));

    public static final Block CREM_BUTTON = registerBlock("crem_button",
            new ButtonBlock(BlockSetType.STONE, 2, AbstractBlock.Settings.copy(CREM_STONE).noCollision()));

    public static final Block CREM_PRESSURE_PLATE = registerBlock("crem_pressure_plate",
            new PressurePlateBlock(BlockSetType.STONE, AbstractBlock.Settings.copy(CREM_STONE)));

    public static final Block CREM_WAll = registerBlock("crem_wall",
            new WallBlock(AbstractBlock.Settings.copy(CREM_STONE)));

    public static final Block SAPPHIRE_ORE = registerBlock("sapphire_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE)));

    public static final Block SMOKESTONE_ORE = registerBlock("smokestone_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE)));

    public static final Block RUBY_ORE = registerBlock("ruby_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE)));

    public static final Block GARNET_ORE = registerBlock("garnet_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE)));

    public static final Block ZIRCON_ORE = registerBlock("zircon_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE)));

    public static final Block TOPAZ_ORE = registerBlock("topaz_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE)));

    public static final Block HELIODOR_ORE = registerBlock("heliodor_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.DIAMOND_ORE)));

    // Other Blocks
    public static final Block SPHERE_LANTERN_BLOCK = registerBlock("sphere_lantern",
            new SphereLanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN).luminance(state -> state.get(SphereLanternBlock.LUMINANCE))));

//    public static final Block CUSTOM_CHEST = registerBlock("custom_chest", new CustomChest(
//            AbstractBlock.Settings.copy(Blocks.CHEST),
//            () -> BlockEntityType.CHEST)
//    );

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(StormlightMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(StormlightMod.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        StormlightMod.LOGGER.info("Registering Mod Blocks for " + StormlightMod.MOD_ID);

        // How to add to existing item groups
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).registerPackets(entries -> {
//            entries.add(CREM_STONE);
//        });
    }
}
