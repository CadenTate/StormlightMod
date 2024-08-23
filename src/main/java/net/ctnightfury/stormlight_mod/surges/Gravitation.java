package net.ctnightfury.stormlight_mod.surges;

import net.ctnightfury.stormlight_mod.StormlightMod;
import net.ctnightfury.stormlight_mod.util.KeybindHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = StormlightMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Gravitation {

    private static boolean active = false;
    private static Vec3 lookAngle;
    private static boolean takeFallDamage = true;

    // Event is on the Forge event bus only on the physical client
    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        // Only call code once as the tick event is called twice every tick
        if (event.phase == TickEvent.Phase.END) {
            Minecraft mc = Minecraft.getInstance();
            if (mc.level != null) {
                // "Activates" gravitation
                while (KeybindHandler.ACTIVATE_PRIMARY_SURGE.consumeClick()) {
                    // State tracker
                    active = !active;
                    // Logic depending on active state
                    if(active) {
                        mc.player.displayClientMessage(Component.literal("§2§lACTIVE"), true);
                        takeFallDamage = false;
                    }
                    else {
                        mc.player.displayClientMessage(Component.literal("§4§lINACTIVE"), true);
                        takeFallDamage = true;
                    }
                    lookAngle = null;

                }
                while (KeybindHandler.CONTROL_PRIMARY_SURGE.consumeClick()) {
                    lookAngle = mc.player.getLookAngle();
                }
                if(active && lookAngle != null) mc.player.setDeltaMovement(lookAngle);
            }
        }
    }

    @SubscribeEvent
    public static void onLivingFall(LivingFallEvent event) {
        if(event.getEntity() instanceof Player) {
            System.out.println(event.getDistance() + " " + takeFallDamage);
            if(!takeFallDamage) event.setCanceled(true);
        }
    }
}