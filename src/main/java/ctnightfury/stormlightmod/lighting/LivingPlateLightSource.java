package ctnightfury.stormlightmod.lighting;

import dev.lambdaurora.lambdynlights.api.entity.EntityLightSourceManager;
import dev.yumi.commons.event.Event;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Range;

public class LivingPlateLightSource implements EntityLightSourceManager {

    private final PlayerEntity player;

    public LivingPlateLightSource(PlayerEntity player) {
        this.player = player;
    }

    @Override
    public int getLuminance() {
        return isWearingLivingPlate(player) ? 12 : 0;
    }

    @Override
    public double getDynamicLightX() {
        return player.getX();
    }

    @Override
    public double getDynamicLightY() {
        return player.getEyeY();
    }

    @Override
    public double getDynamicLightZ() {
        return player.getZ();
    }

    @Override
    public Event<Identifier, OnRegister> onRegisterEvent() {
        return null;
    }

    @Override
    public @Range(from = 0L, to = 15L) int getLuminance(Entity entity) {
        return 0;
    }
}
