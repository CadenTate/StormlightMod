package ctnightfury.stormlightmod.datagen;

import ctnightfury.stormlightmod.block.ModBlocks;
import ctnightfury.stormlightmod.item.ModItemGroups;
import ctnightfury.stormlightmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

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
        for (Item item : ModItems.SPHERES.values()) {
            itemModelGenerator.register(item, Models.GENERATED);
        }

        itemModelGenerator.register(ModItems.WINE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPHERE_POUCH_ITEM, Models.GENERATED);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.SHARDPLATE_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.SHARDPLATE_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.SHARDPLATE_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.SHARDPLATE_BOOTS);
    }
}
