package ctnightfury.stormlightmod.networking;

import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public record SyncGravitationPayload(boolean active) implements CustomPayload {
    public static final Id<SyncGravitationPayload> ID =
            new Id<>(Identifier.of("stormlight", "sync_gravitation"));

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
