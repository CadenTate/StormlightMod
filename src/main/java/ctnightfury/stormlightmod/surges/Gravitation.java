package ctnightfury.stormlightmod.surges;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;

public class Gravitation {
    public static boolean isActive = false;
    public static int power = 1;
    private static Vec3d velPercent3D = Vec3d.ZERO;

    // Client-side logic (e.g., player effects, animations)
    public static void changeGravityDirection(ClientPlayerEntity player) {
        // Convert yaw value to the one that is read in f3
        float yaw = player.getYaw() % 360;
        if (yaw > 180) {
            yaw -= 360;
        } else if (yaw < -180) {
            yaw += 360;
        }
        float pitch = player.getPitch();

        // Normalize values
        float yawSign = getSign(yaw);
        float velPercentX = yawSign * ((float)1/90 * Math.abs(yaw - yawSign * 90) - 1);
        float velPercentY = -pitch / 90;
        float velPercentZ = (Math.abs(yaw) - 90) / -90;

        velPercent3D = new Vec3d(velPercentX, velPercentY, velPercentZ);

//        player.sendMessage(Text.literal(Float.toString(velPercentX)));
//        player.sendMessage(Text.literal(Float.toString(velPercentY)));
//        player.sendMessage(Text.literal(Float.toString(velPercentZ)));
    }

    public static void enable(ClientPlayerEntity player) {
        player.setVelocity(velPercent3D.multiply(power));
    }

    private static float getSign(float x) {
        return Math.abs(x) / x;
    }
}