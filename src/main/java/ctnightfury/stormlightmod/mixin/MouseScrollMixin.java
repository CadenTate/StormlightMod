package ctnightfury.stormlightmod.mixin;

import ctnightfury.stormlightmod.component.cardinal_components.GravitationComponent;
import ctnightfury.stormlightmod.component.ModComponents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Mouse.class)
public class MouseScrollMixin {
    @Inject(method = "onMouseScroll", at = @At("HEAD"), cancellable = true)
    private void interceptScroll(long window, double horizontal, double vertical, CallbackInfo ci) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player == null) return;

        GravitationComponent grav = ModComponents.GRAVITATION.get(player);
        if (grav.isActive()) {
            grav.changePower((int) vertical);
            player.sendMessage(
                    Text.literal(Double.toString(grav.getNewPower())),
                    true
            );
            ci.cancel();
        }
    }
}
