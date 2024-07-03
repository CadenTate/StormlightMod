package net.ctnightfury.stormlight_mod.datagen.loot;

import net.ctnightfury.stormlight_mod.block.ModBlocks;
import net.ctnightfury.stormlight_mod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    protected ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.HOOK_BLOCK.get());
        this.dropSelf(ModBlocks.CREM_STONE.get());

        addGemstoneOre(ModBlocks.GARNET_ORE.get(), ModItems.GARNET_GEMSTONE.get());
    }

    private void addGemstoneOre(Block inputBlock, Item outputItem) {
        this.add(inputBlock, block -> createGemstoneOreDrops(inputBlock, outputItem));
    }

    private LootTable.Builder createGemstoneOreDrops(Block block, Item item) {
        return createOreDrop(block, item).apply(SetItemCountFunction.setCount(UniformGenerator.between(1,1)));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
