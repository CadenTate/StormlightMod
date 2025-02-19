package ctnightfury.stormlightmod.datagen;

import ctnightfury.stormlightmod.block.ModBlocks;
import ctnightfury.stormlightmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool cremStonePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CREM_STONE);
        cremStonePool.stairs(ModBlocks.CREM_STAIRS);
        cremStonePool.slab(ModBlocks.CREM_SLAB);
        cremStonePool.button(ModBlocks.CREM_BUTTON);
        cremStonePool.pressurePlate(ModBlocks.CREM_PRESSURE_PLATE);
        cremStonePool.wall(ModBlocks.CREM_WAll);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHIRE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SMOKESTONE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GARNET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ZIRCON_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TOPAZ_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.HELIODOR_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // Sphere Models
        itemModelGenerator.register(ModItems.SAPPHIRE_SPHERE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SMOKESTONE_SPHERE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY_SPHERE, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIAMOND_SPHERE, Models.GENERATED);
        itemModelGenerator.register(ModItems.EMERALD_SPHERE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GARNET_SPHERE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ZIRCON_SPHERE, Models.GENERATED);
        itemModelGenerator.register(ModItems.AMETHYST_SPHERE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOPAZ_SPHERE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HELIODOR_SPHERE, Models.GENERATED);

        itemModelGenerator.register(ModItems.WINE, Models.GENERATED);
    }
}
