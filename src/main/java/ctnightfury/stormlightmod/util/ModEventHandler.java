package ctnightfury.stormlightmod.util;

import ctnightfury.stormlightmod.component.ModComponents;
import ctnightfury.stormlightmod.component.cardinal_components.StormlightComponent;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class ModEventHandler {
    public static void registerEvents() {
        // Right-clicking entities
        UseEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (hitResult != null && !world.isClient && hand == Hand.MAIN_HAND && hitResult.getEntity().getTrackedPosition() != null) { // hitResult.getEntity().getTrackedPosition() != null kinda dirty way to combat the dual send
                if (entity instanceof LivingEntity livingEntity) {
                    float health = livingEntity.getHealth();
                    float healthDiff = livingEntity.getMaxHealth() - health;
                    StormlightComponent stormlight = ModComponents.STORMLIGHT.get(player);
                    if (stormlight.getStormlight() >= healthDiff) {
                        livingEntity.setHealth(livingEntity.getMaxHealth());
                        stormlight.subtractStormlight(Math.round(healthDiff));
                    }
                }
            }

            return ActionResult.PASS;
        });
    }
}
