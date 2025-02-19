package ctnightfury.stormlightmod;

import ctnightfury.stormlightmod.surges.Gravitation;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class StormlightModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KeyBinding changeGravityDirection = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.stormlightmod.primaryactivation",
                InputUtil.Type.MOUSE, // KEYSYM for Keyboard | MOUSE for Mouse
                GLFW.GLFW_KEY_G,
                "key.category.stormlightmod.stormlight"));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (changeGravityDirection.wasPressed()) {
                client.player.sendMessage(Text.literal("Surge Activated"), true);
                Gravitation.changeGravityDirection(client.player);
            }
        });
    }
}
