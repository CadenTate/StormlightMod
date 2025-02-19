package  ctnightfury.stormlightmod.util;


import ctnightfury.stormlightmod.StormlightMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(StormlightMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> SPHERES = createTag("spheres");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(StormlightMod.MOD_ID, name));
        }
    }
}