package ctnightfury.stormlightmod.datagen;

import ctnightfury.stormlightmod.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.CREM_STONE)
                .add(ModBlocks.SAPPHIRE_ORE);
//        .add(ModBlocks.GARNET_ORE)
//        .add(ModBlocks.GARNET_ORE)
//        .add(ModBlocks.GARNET_ORE)
//        .add(ModBlocks.GARNET_ORE)
//        .add(ModBlocks.GARNET_ORE)
//        .add(ModBlocks.GARNET_ORE)
//        .add(ModBlocks.GARNET_ORE)
//        .add(ModBlocks.GARNET_ORE)
//        .add(ModBlocks.GARNET_ORE)
//        .add(ModBlocks.GARNET_ORE)
//        .add(ModBlocks.GARNET_ORE)
//        .add(ModBlocks.GARNET_ORE)
//        .add(ModBlocks.GARNET_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL);
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL);
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.SAPPHIRE_ORE);
    }
}
