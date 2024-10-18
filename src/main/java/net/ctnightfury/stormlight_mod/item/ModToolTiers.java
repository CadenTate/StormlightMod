package net.ctnightfury.stormlight_mod.item;

import net.ctnightfury.stormlight_mod.StormlightMod;
import net.ctnightfury.stormlight_mod.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier GOD_METAL = TierSortingRegistry.registerTier(
            new ForgeTier(5, 1500, 5f, 4f, 25, ModTags.Blocks.NEEDS_GODMETAL_TOOL, Ingredient::of),
            new ResourceLocation(StormlightMod.MOD_ID, "god_metal"),
            List.of(Tiers.NETHERITE),
            List.of()
    );
}
