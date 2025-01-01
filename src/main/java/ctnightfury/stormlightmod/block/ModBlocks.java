package ctnightfury.stormlightmod.block;

import ctnightfury.stormlightmod.StormlightMod;
import ctnightfury.stormlightmod.block.custom.SphereLanternBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block CREM_STONE = registerBlock("crem_stone",
            new Block(AbstractBlock.Settings
                    .copy(Blocks.TUFF)
                    .strength(0.4f)
            )
    );
    public static final Block SAPPHIRE_ORE = registerBlock("sapphire_ore",
            new Block(AbstractBlock.Settings
                    .copy(Blocks.DIAMOND_ORE)
            )
    );
    public static final Block SMOKESTONE_ORE = registerBlock("smokestone_ore",
            new Block(AbstractBlock.Settings
                    .copy(Blocks.DIAMOND_ORE)
            )
    );
    public static final Block RUBY_ORE = registerBlock("ruby_ore",
            new Block(AbstractBlock.Settings
                    .copy(Blocks.DIAMOND_ORE)
            )
    );
    public static final Block GARNET_ORE = registerBlock("garnet_ore",
            new Block(AbstractBlock.Settings
                    .copy(Blocks.DIAMOND_ORE)
            )
    );
    public static final Block ZIRCON_ORE = registerBlock("zircon_ore",
            new Block(AbstractBlock.Settings
                    .copy(Blocks.DIAMOND_ORE)
            )
    );
    public static final Block TOPAZ_ORE = registerBlock("topaz_ore",
            new Block(AbstractBlock.Settings
                    .copy(Blocks.DIAMOND_ORE)
            )
    );
    public static final Block HELIODOR_ORE = registerBlock("heliodor_ore",
            new Block(AbstractBlock.Settings
                    .copy(Blocks.DIAMOND_ORE)
            )
    );

    // Other Items
    public static final Block SPHERE_LANTERN_BLOCK = registerBlock("sphere_lantern",
            new SphereLanternBlock(AbstractBlock.Settings.copy(Blocks.IRON_BARS)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(StormlightMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(StormlightMod.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        StormlightMod.LOGGER.info("Registering Mod Blocks for " + StormlightMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(CREM_STONE);
        });
    }
}
