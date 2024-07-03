package net.ctnightfury.stormlight_mod.item;

import net.ctnightfury.stormlight_mod.StormlightMod;
import net.ctnightfury.stormlight_mod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, StormlightMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> STORMLIGHT_CREATIVE_MODE_TAB = CREATIVE_MODE_TABS.register("stormlight_mod_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ZIRCON_SPHERE.get()))
                    .title(Component.translatable("creativeModeTab.stormlight_mod_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        for(RegistryObject<Item> item : ModItems.ITEMS.getEntries()) {
                            output.accept(item.get());
                        }
                        for(RegistryObject<Block> block : ModBlocks.BLOCKS.getEntries()) {
                            output.accept(block.get());
                        }
                    })
                    .build());

    public static void regster(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
