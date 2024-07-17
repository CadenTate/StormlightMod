package net.ctnightfury.stormlight_mod.block;

import net.ctnightfury.stormlight_mod.StormlightMod;
import net.ctnightfury.stormlight_mod.block.custom.HookBlock;
import net.ctnightfury.stormlight_mod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, StormlightMod.MOD_ID);

    // Sphere Ores
    public static final RegistryObject<Block> GARNET_ORE = registerBlock("garnet_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE), UniformInt.of(4, 8)));
    public static final RegistryObject<Block> HELIODOR_ORE = registerBlock("heliodor_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE), UniformInt.of(4,8)));
    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE), UniformInt.of(4,8)));
    public static final RegistryObject<Block> SAPPHIRE_ORE = registerBlock("sapphire_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE), UniformInt.of(4,8)));
    public static final RegistryObject<Block> SMOKESTONE_ORE = registerBlock("smokestone_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE), UniformInt.of(4,8)));
    public static final RegistryObject<Block> TOPAZ_ORE = registerBlock("topaz_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE), UniformInt.of(4,8)));
    public static final RegistryObject<Block> ZIRCON_ORE = registerBlock("zircon_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE), UniformInt.of(4,8)));

    public static final List<RegistryObject<Block>> GEMSTONE_ORES = List.of(GARNET_ORE, HELIODOR_ORE, RUBY_ORE, SAPPHIRE_ORE, SMOKESTONE_ORE, TOPAZ_ORE, ZIRCON_ORE);

    //     Custom blocks
    public static final RegistryObject<Block> HOOK_BLOCK = registerBlock("hook_block",
            () -> new HookBlock(BlockBehaviour.Properties.copy(Blocks.CHAIN)));

    //     Crem Stuff
    public static final RegistryObject<Block> CREM_STONE = registerBlock("crem_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.TUFF).strength(0.4f)));
    public static final RegistryObject<Block> CREM_STAIRS = registerBlock("crem_stairs",
            () -> new StairBlock(() -> ModBlocks.CREM_STONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final RegistryObject<Block> CREM_SLAB = registerBlock("crem_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final RegistryObject<Block> CREM_BUTTON = registerBlock("crem_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).sound(SoundType.TUFF),
                    BlockSetType.IRON, 10, true));
    public static final RegistryObject<Block> CREM_PRESSURE_PLATE = registerBlock("crem_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.TUFF), BlockSetType.IRON));
    public static final RegistryObject<Block> CREM_WALL = registerBlock("crem_block",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.TUFF)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> blockObj = BLOCKS.register(name, block);
        registerBlockItem(name, blockObj);
        return blockObj;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}