package net.ctnightfury.stormlight_mod.datagen;

import net.ctnightfury.stormlight_mod.StormlightMod;
import net.ctnightfury.stormlight_mod.block.ModBlocks;
import net.ctnightfury.stormlight_mod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeBlockTagsProvider;
import net.minecraftforge.common.data.ForgeItemTagsProvider;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, StormlightMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        // Gives all Gemstone Ores a special tag
        this.tag(ModTags.Blocks.GEMSTONE_ORES)
                .add(
                        ModBlocks.GARNET_ORE.get(),
                        ModBlocks.HELIODOR_ORE.get(),
                        ModBlocks.RUBY_ORE.get(),
                        ModBlocks.SAPPHIRE_ORE.get(),
                        ModBlocks.SMOKESTONE_ORE.get(),
                        ModBlocks.TOPAZ_ORE.get(),
                        ModBlocks.ZIRCON_ORE.get()

                )
                .addTag(Tags.Blocks.ORES);

        // Tool Level
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(
                        ModBlocks.GARNET_ORE.get(),
                        ModBlocks.HELIODOR_ORE.get(),
                        ModBlocks.RUBY_ORE.get(),
                        ModBlocks.SAPPHIRE_ORE.get(),
                        ModBlocks.SMOKESTONE_ORE.get(),
                        ModBlocks.TOPAZ_ORE.get(),
                        ModBlocks.ZIRCON_ORE.get()
                );

        // Correct Tool
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        ModBlocks.GARNET_ORE.get(),
                        ModBlocks.HELIODOR_ORE.get(),
                        ModBlocks.RUBY_ORE.get(),
                        ModBlocks.SAPPHIRE_ORE.get(),
                        ModBlocks.SMOKESTONE_ORE.get(),
                        ModBlocks.TOPAZ_ORE.get(),
                        ModBlocks.ZIRCON_ORE.get()
                );
    }
}