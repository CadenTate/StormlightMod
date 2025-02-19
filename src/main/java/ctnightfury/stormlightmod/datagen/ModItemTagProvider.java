package ctnightfury.stormlightmod.datagen;

import ctnightfury.stormlightmod.item.ModItems;
import ctnightfury.stormlightmod.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.SPHERES)
                .add(ModItems.SAPPHIRE_SPHERE)
                .add(ModItems.SMOKESTONE_SPHERE)
                .add(ModItems.RUBY_SPHERE)
                .add(ModItems.DIAMOND_SPHERE)
                .add(ModItems.EMERALD_SPHERE)
                .add(ModItems.GARNET_SPHERE)
                .add(ModItems.ZIRCON_SPHERE)
                .add(ModItems.AMETHYST_SPHERE)
                .add(ModItems.TOPAZ_SPHERE)
                .add(ModItems.HELIODOR_SPHERE)
    ;}
}

