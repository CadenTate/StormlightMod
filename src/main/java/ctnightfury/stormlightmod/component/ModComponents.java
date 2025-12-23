package ctnightfury.stormlightmod.component;

import ctnightfury.stormlightmod.StormlightMod;
import ctnightfury.stormlightmod.component.cardinal_components.AbrasionComponent;
import ctnightfury.stormlightmod.component.cardinal_components.DivisionComponent;
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
            ComponentRegistry.getOrCreate(Identifier.of(StormlightMod.MOD_ID, "stormlight"), StormlightComponent.class);
//
    public static final ComponentKey<GravitationComponent> GRAVITATION =
            ComponentRegistry.getOrCreate(Identifier.of(StormlightMod.MOD_ID, "gravitation"), GravitationComponent.class);
//    public static final ComponentKey<DivisionComponent> DIVISION =
//            ComponentRegistry.getOrCreate(Identifier.of(StormlightMod.MOD_ID, "division"), DivisionComponent.class);
//    public static final ComponentKey<AbrasionComponent> ABRASION =
//            ComponentRegistry.getOrCreate(Identifier.of(StormlightMod.MOD_ID, "abrasion"), AbrasionComponent.class);
//    public static final ComponentKey<GravitationComponent> PROGRESSION =
//            ComponentRegistry.getOrCreate(Identifier.of(StormlightMod.MOD_ID, "progression"), ProgressionComponent.class);
//    public static final ComponentKey<GravitationComponent> ILLUMINATION =
//            ComponentRegistry.getOrCreate(Identifier.of(StormlightMod.MOD_ID, "illumination"), IlluminationComponent.class);
//    public static final ComponentKey<GravitationComponent> TRANSFORMATION =
//            ComponentRegistry.getOrCreate(Identifier.of(StormlightMod.MOD_ID, "transformation"), TransformationComponent.class);
//    public static final ComponentKey<GravitationComponent> TRANSPORTATION =
//            ComponentRegistry.getOrCreate(Identifier.of(StormlightMod.MOD_ID, "transportation"), TransportationComponent.class);
//    public static final ComponentKey<GravitationComponent> COHESION =
//            ComponentRegistry.getOrCreate(Identifier.of(StormlightMod.MOD_ID, "cohesion"), CohesionComponent.class);
//    public static final ComponentKey<GravitationComponent> TENSION =
//            ComponentRegistry.getOrCreate(Identifier.of(StormlightMod.MOD_ID, "tension"), TensionComponent.class);
//    public static final ComponentKey<GravitationComponent> ADHESION =
//            ComponentRegistry.getOrCreate(Identifier.of(StormlightMod.MOD_ID, "adhesion"), AdhesionComponent.class);

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.registerForPlayers(STORMLIGHT, StormlightComponent::new, RespawnCopyStrategy.ALWAYS_COPY);
//
        registry.registerForPlayers(GRAVITATION, GravitationComponent::new, RespawnCopyStrategy.ALWAYS_COPY);
//        registry.registerForPlayers(DIVISION, DivisionComponent::new, RespawnCopyStrategy.ALWAYS_COPY);
//        registry.registerForPlayers(ABRASION, AbrasionComponent::new, RespawnCopyStrategy.ALWAYS_COPY);
//        registry.registerForPlayers(GRAVITATION, GravitationComponent::new, RespawnCopyStrategy.ALWAYS_COPY);
//        registry.registerForPlayers(GRAVITATION, GravitationComponent::new, RespawnCopyStrategy.ALWAYS_COPY);
//        registry.registerForPlayers(GRAVITATION, GravitationComponent::new, RespawnCopyStrategy.ALWAYS_COPY);
//        registry.registerForPlayers(GRAVITATION, GravitationComponent::new, RespawnCopyStrategy.ALWAYS_COPY);
//        registry.registerForPlayers(GRAVITATION, GravitationComponent::new, RespawnCopyStrategy.ALWAYS_COPY);
//        registry.registerForPlayers(GRAVITATION, GravitationComponent::new, RespawnCopyStrategy.ALWAYS_COPY);
//        registry.registerForPlayers(GRAVITATION, GravitationComponent::new, RespawnCopyStrategy.ALWAYS_COPY);
    }
}