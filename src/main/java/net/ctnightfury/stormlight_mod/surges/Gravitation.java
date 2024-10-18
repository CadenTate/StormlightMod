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
import net.minecraftforge.client.event.InputEvent.MouseScrollingEvent;


@Mod.EventBusSubscriber(modid = StormlightMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Gravitation {

    private static boolean active = false;
    private static Vec3 flightVelocity = Vec3.ZERO;
    private static boolean takeFallDamage = true;
    private static int lashings = 1;

    /**
     * Function triggers automatically every client tick
     * @param event What happens every tick
     */
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
                        flightVelocity = Vec3.ZERO;
                    }
                    // On Disable
                    else {
                        mc.player.displayClientMessage(Component.literal("§4§lINACTIVE"), true);
                        takeFallDamage = true;
                        lashings = 1;
                    }
                    
                }
                // Change the flight direction
                while (KeybindHandler.CONTROL_PRIMARY_SURGE.consumeClick()) {
                    flightVelocity = mc.player.getLookAngle().multiply(lashings,lashings,lashings);
                }
                // OPTIONAL: By default use scroll wheel
                while (KeybindHandler.LASHING_CHANGE.consumeClick()) {
                    lashings += 1;
                    mc.player.displayClientMessage(Component.literal("§l" + lashings), true);
                }

                // Add movement in direction. SHOULD BE LAST
                if(active && !flightVelocity.equals(Vec3.ZERO) ) mc.player.setDeltaMovement(flightVelocity);
            }
        }
    }

    /**
     * Function triggers automatically while the player is falling
     * @param event What happens every tick the player is falling
     */
    @SubscribeEvent
    public static void onLivingFall(LivingFallEvent event) {
        if(event.getEntity() instanceof Player) {
            System.out.println(event.getDistance() + " " + takeFallDamage);
            if(!takeFallDamage) event.setCanceled(true);
        }
    }

    /**
     * Function triggers automatically every time the scroll wheel is used
     * @param event What happens every time the scroll wheel is used
     */
    @SubscribeEvent
    public static void onMouseScroll(MouseScrollingEvent event) {
        if (active) {
            double scrollDelta = event.getScrollDelta(); // Positive if scrolled up, negative if scrolled down

            if (scrollDelta > 0 && lashings < 3) {
                // Scroll up action
                lashings += 1;
            } else if (scrollDelta < 0 && lashings > 0) {
                // Scroll down action
                lashings -= 1;
            }
            Minecraft.getInstance().player.displayClientMessage(Component.literal("§l" + lashings), true);
            // Cancel the event to prevent default behavior
            event.setCanceled(true);
        }

    }
}