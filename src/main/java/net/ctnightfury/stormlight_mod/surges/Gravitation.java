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
    private static Vec3 lookAngle;
    private static boolean takeFallDamage = true;
    private static int lashings = 1;
    private static Vec3 momentum = Vec3.ZERO;
    private static Vec3 momentumDirection = Vec3.ZERO;
    // Divide by 20 to convert to seconds
    private static final double momentumReduction = 1.0 / 20.0;
    private static final double gravity = 0.08;

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
                    }
                    // On Disable
                    else {
                        mc.player.displayClientMessage(Component.literal("§4§lINACTIVE"), true);
                        takeFallDamage = true;
                        lashings = 1;
                        // Current Momentum is set to velocity / look angle
                        momentum = lookAngle;
                        // Get the signs
                        momentumDirection = new Vec3(getSign(momentum.x), getSign(momentum.y), getSign(momentum.z));
                    }
                    lookAngle = Vec3.ZERO;
                }
                // Change the flight direction
                while (KeybindHandler.CONTROL_PRIMARY_SURGE.consumeClick()) {
                    lookAngle = mc.player.getLookAngle().multiply(lashings,lashings,lashings);
                }
                // OPTIONAL: By default use scroll wheel
                while (KeybindHandler.LASHING_CHANGE.consumeClick()) {
                    lashings += 1;
                }

                // If the surge is not active and the player has momentum, add movement and remove momentum
                if(!active && !momentum.equals(Vec3.ZERO)) {
                    // Remove the proper momentum
                    if (momentum.x > 0) momentum = momentum.subtract(momentumReduction, 0, 0);
                    else momentum = new Vec3(0, momentum.y, momentum.z);

                    if (momentum.y > 0) momentum = momentum.subtract(0, momentumReduction, 0);
                    momentum = new Vec3(momentum.x, 0, momentum.z);

                    if (momentum.z > 0) momentum = momentum.subtract(0, 0, momentumReduction);
                    else momentum = new Vec3(momentum.x, momentum.y, 0);

                    /* Apply Momentum using add instead of set so that the gravity is not affected.
                    Multiply by the direction to either add or subtract from the current direction
                    */
                    mc.player.addDeltaMovement(momentum.multiply(momentumDirection));
                    System.out.printf("Momentum: %s\nMomentum Direction: %s\nDelta Movement: %s\n-------------------------------\n",momentum, momentumDirection, mc.player.getDeltaMovement());
                }

                // Add movement in direction. SHOULD BE LAST
                if(active && !lookAngle.equals(Vec3.ZERO) ) mc.player.setDeltaMovement(lookAngle);
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

            if (scrollDelta > 0) {
                // Scroll up action
                lashings += 1;
            } else if (scrollDelta < 0) {
                // Scroll down action
                lashings -= 1;
            }
            event.setCanceled(true);
        }
        // Cancel the event to prevent default behavior (optional)
    }

    /**
     * This function returns either a 1 or -1 depending on the sign of the input
     * @param value Double to be checked
     * @return double
     */
    private static double getSign(double value) {
        if (value == 0) return 0;
        return Math.abs(value) / value;
    }
}