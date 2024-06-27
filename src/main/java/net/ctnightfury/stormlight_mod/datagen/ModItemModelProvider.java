package net.ctnightfury.stormlight_mod.datagen;

import net.ctnightfury.stormlight_mod.StormlightMod;
import net.ctnightfury.stormlight_mod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, StormlightMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for(RegistryObject<Item> item : ModItems.ITEMS.getEntries()) {
            simpleItem(item);
        }
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(), "item/generated")
                .texture("layer0", "item/" + item.getId().getPath());
    }
}
