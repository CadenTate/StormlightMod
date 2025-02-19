package ctnightfury.stormlightmod.surges;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;

public class Gravitation {
    // Client-side logic (e.g., player effects, animations)
    public static void changeGravityDirection(ClientPlayerEntity player) {
        float yaw = player.getYaw() % 360;
        float pitch = player.getPitch();
        if (yaw > 180) {
            yaw -= 360;
        } else if (yaw < -180) {
            yaw += 360;
        }
        player.sendMessage(Text.literal(Float.toString(yaw)));
        player.sendMessage(Text.literal(Float.toString(pitch)));

        player.setVelocity(yaw, pitch, yaw);
    }
}