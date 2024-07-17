package net.ctnightfury.stormlight_mod.datagen;

import net.ctnightfury.stormlight_mod.StormlightMod;
import net.ctnightfury.stormlight_mod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, StormlightMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for(RegistryObject<Block> block : ModBlocks.GEMSTONE_ORES) {
            blockWithItem(block);
        }
        blockWithItem(ModBlocks.HOOK_BLOCK);
        blockWithItem(ModBlocks.CREM_STONE);
        blockWithItem(ModBlocks.CREM_STONE);

        stairsBlock(((StairBlock) ModBlocks.CREM_STAIRS.get()), blockTexture(ModBlocks.CREM_STONE.get()));
        slabBlock(((SlabBlock) ModBlocks.CREM_SLAB.get()), blockTexture(ModBlocks.CREM_STONE.get()), blockTexture(ModBlocks.CREM_STONE.get()));
        buttonBlock(((ButtonBlock) ModBlocks.CREM_BUTTON.get()), blockTexture(ModBlocks.CREM_STONE.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.CREM_PRESSURE_PLATE.get()), blockTexture(ModBlocks.CREM_STONE.get()));
        wallBlock(((WallBlock) ModBlocks.CREM_WALL.get()), blockTexture(ModBlocks.CREM_WALL.get()));
    }


    // Helper method to create blocks with item
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
