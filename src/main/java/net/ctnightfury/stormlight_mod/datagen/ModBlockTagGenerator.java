package net.ctnightfury.stormlight_mod.datagen;

import net.ctnightfury.stormlight_mod.StormlightMod;
import net.ctnightfury.stormlight_mod.block.ModBlocks;
import net.ctnightfury.stormlight_mod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, StormlightMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        // Add Ore tag
        ModBlocks.GEMSTONE_ORES.forEach(block -> this.tag(ModTags.Blocks.GEMSTONE_ORES)
                .add(block.get())
                .addTag(Tags.Blocks.ORES));

        // Add mineable with pickaxe
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        ModBlocks.CREM_STONE.get(),
                        ModBlocks.CREM_STAIRS.get(),
                        ModBlocks.HOOK_BLOCK.get()
                );
        // Loop for gemstone ores cause im lazy
        ModBlocks.GEMSTONE_ORES.forEach(block -> this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block.get()));

//        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
//                .add();

        // Lazy loop for making the gemstone ores need a diamond pickaxe
        ModBlocks.GEMSTONE_ORES.forEach(block -> this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(block.get()));

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.HOOK_BLOCK.get());

        this.tag(BlockTags.WALLS)
                .add(ModBlocks.CREM_WALL.get());
    }
}
