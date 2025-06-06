package ctnightfury.stormlightmod;

import ctnightfury.stormlightmod.component.cardinal_components.GravitationComponent;
import ctnightfury.stormlightmod.component.ModComponents;
import ctnightfury.stormlightmod.networking.SyncGravitationPayload;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;
import screens.ModScreenHandlerTypes;
import screens.SpherePouchScreen;

public class StormlightModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlerTypes.SPHERE_POUCH_SCREEN_TYPE, SpherePouchScreen::new);

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
            if (client.player != null ) {
                // OLD CODE
//                boolean isStormlight = ModComponents.STORMLIGHT.get(client.player).getStormlight() > 0;
//                if(isStormlight) {
//                    // Negates current active state and sends appropriate On / Off msg
//                    while (activateSurge.wasPressed()) {
//                        Gravitation.isActive = !Gravitation.isActive;
//                        if (Gravitation.isActive) client.player.sendMessage(Text.literal("Surge Activated"), true);
//                        else client.player.sendMessage(Text.literal("Surge Deactivated"), true);
//                    }
//                    // Changes the direction traveling
//                    while (changeGravityDirection.wasPressed()) {
//                        Gravitation.changeGravityDirection(client.player);
//                    }
//                    // Looping portion that causes the movement
//                    if (Gravitation.isActive) {
//                        Gravitation.enable(client.player);
//                    }
//                }
//                else Gravitation.isActive = false;

                boolean hasStormlight = ModComponents.STORMLIGHT.get(client.player).getStormlight() > 0;
                GravitationComponent grav = ModComponents.GRAVITATION.get(client.player);

                if(hasStormlight) {
                    // Negates current active state and sends appropriate On / Off msg
                    while (activateSurge.wasPressed()) {
                        grav.invertActive();
                        if (grav.isActive()) client.player.sendMessage(Text.literal("Surge Activated"), true);
                        else client.player.sendMessage(Text.literal("Surge Deactivated"), true);
                    }
                    // Changes the direction traveling
                    while (changeGravityDirection.wasPressed()) {
                        grav.changeGravityDirection(client.player);
                    }
                    // Looping portion that causes the movement
                    if (grav.isActive()) {
                        grav.enable(client.player);
                    }
                }
                else grav.setActive(false);

                ClientPlayNetworking.send(new SyncGravitationPayload(grav.isActive()));
            }
        });


    }
}
