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
        FabricTagBuilder tagBuilder = getOrCreateTagBuilder(ModTags.Items.SPHERES);
        for(Item item : ModItems.SPHERES.values()) {
            tagBuilder.add(item);
        }
    }
}

