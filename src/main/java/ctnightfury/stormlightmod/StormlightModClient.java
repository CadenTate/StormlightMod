package ctnightfury.stormlightmod;

import ctnightfury.stormlightmod.surges.Gravitation;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

import java.util.Timer;
import java.util.TimerTask;

public class StormlightModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KeyBinding activateSurge = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.stormlightmod.primaryactivation",
                InputUtil.Type.KEYSYM, // KEYSYM for Keyboard | MOUSE for Mouse
                GLFW.GLFW_KEY_G,
                "key.category.stormlightmod.stormlight"));

        KeyBinding changeGravityDirection = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.stormlightmod.secondaryactivation",
                InputUtil.Type.MOUSE, // KEYSYM for Keyboard | MOUSE for Mouse
                GLFW.GLFW_MOUSE_BUTTON_5,
                "key.category.stormlightmod.stormlight"));

        // END_CLIENT_TICK acts as a loop
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player != null) {
                while (activateSurge.wasPressed()) {
                    Gravitation.isActive = !Gravitation.isActive;
                    if (Gravitation.isActive) {
                        client.player.sendMessage(Text.literal("Surge Activated"), true);
                    } else client.player.sendMessage(Text.literal("Surge Deactivated"), true);
                }
                while(changeGravityDirection.wasPressed()) {
                    Gravitation.changeGravityDirection(client.player);
                }
                if (Gravitation.isActive)Gravitation.enable(client.player);
            }
        });
    }
}
