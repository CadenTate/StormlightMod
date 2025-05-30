package ctnightfury.stormlightmod.datagen;

import ctnightfury.stormlightmod.block.ModBlocks;
import ctnightfury.stormlightmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        // Refer to #11 video for code for different recipes
        // Refer to #12 video for non-block blocks

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SPHERES.get("diamond_broam_sphere"))
                .pattern("GGG")
                .pattern("GXG")
                .pattern("GGG")
                .input('G', Blocks.GLASS)
                .input('X', Items.DIAMOND)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .offerTo(recipeExporter);

        createStairsRecipe(ModBlocks.CREM_STAIRS, Ingredient.ofItems(ModBlocks.CREM_STONE))
                .criterion(hasItem(ModBlocks.CREM_STONE), conditionsFromItem(ModBlocks.CREM_STONE))
                .offerTo(recipeExporter);

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CREM_STONE, Ingredient.ofItems(ModBlocks.CREM_STONE))
                .criterion(hasItem(ModBlocks.CREM_STONE), conditionsFromItem(ModBlocks.CREM_STONE))
                .offerTo(recipeExporter);

        offerSingleOutputShapelessRecipe(recipeExporter, ModBlocks.CREM_BUTTON, ModBlocks.CREM_STONE, "buttons");

        offerPressurePlateRecipe(recipeExporter, ModBlocks.CREM_PRESSURE_PLATE, ModBlocks.CREM_STONE);

        offerWallRecipe(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CREM_WAll, ModBlocks. CREM_STONE);
    }
}
