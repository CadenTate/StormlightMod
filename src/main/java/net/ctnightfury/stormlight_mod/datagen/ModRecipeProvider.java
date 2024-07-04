package net.ctnightfury.stormlight_mod.datagen;

import net.ctnightfury.stormlight_mod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GARNET_SPHERE.get())
                .pattern("SSS")
                .pattern("SOS")
                .pattern("SSS")
                .define('S', Items.GLASS)
                .define('O',ModItems.GARNET_GEMSTONE.get())
                .unlockedBy(getHasName(ModItems.GARNET_GEMSTONE.get()), has(ModItems.GARNET_GEMSTONE.get()))
                .save(pWriter);
    }
}
