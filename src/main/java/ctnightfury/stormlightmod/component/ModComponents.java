package ctnightfury.stormlightmod.component;

import ctnightfury.stormlightmod.component.cardinal_components.GravitationComponent;
import ctnightfury.stormlightmod.component.cardinal_components.StormlightComponent;
import net.minecraft.util.Identifier;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.ComponentRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentFactoryRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentInitializer;
import org.ladysnake.cca.api.v3.entity.RespawnCopyStrategy;

public class ModComponents implements EntityComponentInitializer {
    public static final ComponentKey<StormlightComponent> STORMLIGHT =
            ComponentRegistry.getOrCreate(Identifier.of("stormlight", "stormlight"), StormlightComponent.class);

    public static final ComponentKey<GravitationComponent> GRAVITATION =
            ComponentRegistry.getOrCreate(Identifier.of("stormlight", "gravitation"), GravitationComponent.class);

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.registerForPlayers(STORMLIGHT, StormlightComponent::new, RespawnCopyStrategy.ALWAYS_COPY);
        registry.registerForPlayers(GRAVITATION, GravitationComponent::new, RespawnCopyStrategy.ALWAYS_COPY);
    }
}