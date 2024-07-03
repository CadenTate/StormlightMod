package net.ctnightfury.stormlight_mod.util;

import net.ctnightfury.stormlight_mod.StormlightMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> GEMSTONE_ORES = tag("gemstone_ores");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(ResourceLocation.m_338530_(name));
        }
    }

    public static class Items {
        public static final TagKey<Item> SPHERES = tag("sphere");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(ResourceLocation.m_338530_(StormlightMod.MOD_ID));
        }
    }
}