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
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CREM_STONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHIRE_ORE);
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
    }
}
