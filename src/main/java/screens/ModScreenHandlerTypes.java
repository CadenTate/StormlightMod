package screens;

import ctnightfury.stormlightmod.StormlightMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.resource.featuretoggle.ToggleableFeature;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlerTypes<T extends ScreenHandler> implements ToggleableFeature {
    public static final ScreenHandlerType<SpherePouchScreenHandler> SPHERE_POUCH_SCREEN_TYPE = register("sphere_pouch_screen", SpherePouchScreenHandler::createScreen);

    private static <T extends ScreenHandler> ScreenHandlerType<T> register(String id, ScreenHandlerType.Factory<T> factory) {
        return Registry.register(Registries.SCREEN_HANDLER, Identifier.of(StormlightMod.MOD_ID + id), new ScreenHandlerType<>(factory, FeatureFlags.VANILLA_FEATURES));
    }

    public static void registerScreenHandlers() {
        StormlightMod.LOGGER.info("Registering Screen Handlers for stormlightmod");
    }

    @Override
    public FeatureSet getRequiredFeatures() {
        return null;
    }
}
