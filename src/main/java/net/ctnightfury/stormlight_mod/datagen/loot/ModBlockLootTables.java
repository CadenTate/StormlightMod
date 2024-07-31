package net.ctnightfury.stormlight_mod.datagen.loot;

import net.ctnightfury.stormlight_mod.block.ModBlocks;
import net.ctnightfury.stormlight_mod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.HOOK_BLOCK.get());
        this.dropSelf(ModBlocks.CREM_STONE.get());
        this.dropSelf(ModBlocks.CREM_STAIRS.get());
        this.dropSelf(ModBlocks.CREM_BUTTON.get());
        this.dropSelf(ModBlocks.CREM_WALL.get());
        this.dropSelf(ModBlocks.CREM_PRESSURE_PLATE.get());

        this.add(ModBlocks.CREM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CREM_SLAB.get()));

        for(int i = 0; i < ModBlocks.GEMSTONE_ORES.size(); i++) {
            Block input = ModBlocks.GEMSTONE_ORES.get(i).get();
            Item output = ModItems.GEMSTONES.get(i).get();
            this.add(input, block -> createGemstoneDrops(input, output));
        }
    }

    protected LootTable.Builder createGemstoneDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,1)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
