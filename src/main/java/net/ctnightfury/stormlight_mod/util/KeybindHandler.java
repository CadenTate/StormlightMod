package net.ctnightfury.stormlight_mod.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.ctnightfury.stormlight_mod.StormlightMod;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = StormlightMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class KeybindHandler {
    public static final KeyMapping ACTIVATE_PRIMARY_SURGE = new KeyMapping(
            "key.stormlight_mod.activateprimarysurge",
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_G,
            "key.categories.stormlight_mod.stormlight"
    );
    public static final KeyMapping CONTROL_PRIMARY_SURGE = new KeyMapping(
            "key.stormlight_mod.controlprimarysurge",
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_H,
            "key.categories.stormlight_mod.stormlight"
    );
    public static final KeyMapping LASHING_CHANGE = new KeyMapping(
            "key.stormlight_mod.lashingchange",
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_C,
            "key.categories.stormlight_mod.stormlight"
    );


    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(ACTIVATE_PRIMARY_SURGE);
        event.register(CONTROL_PRIMARY_SURGE);
        event.register(LASHING_CHANGE);
    }
}
