//package net.ctnightfury.stormlight_mod.surges;
//
//import net.ctnightfury.stormlight_mod.StormlightMod;
//import net.ctnightfury.stormlight_mod.util.KeybindHandler;
//import net.minecraft.client.Minecraft;
//import net.minecraft.core.BlockPos;
//import net.minecraft.core.Vec3i;
//import net.minecraft.world.level.block.Blocks;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.phys.BlockHitResult;
//import net.minecraft.world.phys.HitResult;
//import net.minecraft.world.phys.Vec3;
//import net.minecraftforge.event.TickEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
//@Mod.EventBusSubscriber(modid = StormlightMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
//
//public class Transportation {
//
//    private static int teleportAmount = 10;
//
//    @SubscribeEvent
//    public static void onClientTick(TickEvent.ClientTickEvent event) {
//        if (event.phase == TickEvent.Phase.END) {
//            Minecraft mc = Minecraft.getInstance();
//            // "Activates" surge
//            while (KeybindHandler.ACTIVATE_PRIMARY_SURGE.consumeClick()) {
//
//                HitResult hitResult = mc.player.pick(teleportAmount, 0.0F, false);
//
//                if (hitResult.getType() == HitResult.Type.BLOCK) {
//                    BlockPos hitBlockPos = ((BlockHitResult) hitResult).getBlockPos();
//                    BlockState hitBlockState = mc.level.getBlockState(hitBlockPos);
//
//
//                    if (hitBlockState.getBlock() != Blocks.AIR) {
//                        System.out.println("Teleportation failed: ray hit a solid block.");
//                        // Prevent teleportation or adjust the target position
//                        return;
//                    }
//                }
//
//                // Safe to teleport
//                Vec3 teleportAmounts = mc.player.getLookAngle().multiply(teleportAmount, teleportAmount, teleportAmount);
//                Vec3 targetPos = mc.player.position().add(teleportAmounts);
//                mc.player.setPos(targetPos);
//                System.out.println("Teleportation successful.");
//            }
//        }
//    }
//}