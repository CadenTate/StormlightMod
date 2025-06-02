package ctnightfury.stormlightmod.networking;

import ctnightfury.stormlightmod.component.GravitationComponent;
import ctnightfury.stormlightmod.component.ModComponents;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.server.network.ServerPlayerEntity;

public class ModNetworkingHandler {
    public static void registerPayloads() {
        PayloadTypeRegistry.playC2S().register(
                SyncGravitationPayload.ID,
                PacketCodecs.BOOL.xmap(SyncGravitationPayload::new, SyncGravitationPayload::active)
        );
    }

    public static void registerReceivers() {
        ServerPlayNetworking.registerGlobalReceiver(
                SyncGravitationPayload.ID,
                (payload, context) -> {
                    ServerPlayerEntity player = context.player();
                    GravitationComponent comp = ModComponents.GRAVITATION.get(player);
                    comp.setActive(payload.active());
                }
        );
    }
}
