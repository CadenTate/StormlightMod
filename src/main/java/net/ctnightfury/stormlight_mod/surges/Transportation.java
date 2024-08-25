package net.ctnightfury.stormlight_mod.surges;

import net.ctnightfury.stormlight_mod.StormlightMod;
import net.ctnightfury.stormlight_mod.util.KeybindHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = StormlightMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)

public class Transportation {

    private static boolean active = false;

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Minecraft mc = Minecraft.getInstance();
            if (mc.level != null) {
                // "Activates" surge
                while (KeybindHandler.ACTIVATE_PRIMARY_SURGE.consumeClick()) {
                    active = !active;
                    if(active) {
                        mc.player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, -1));
                    }
                    else {

                    }
                }
            }
        }
    }
}
