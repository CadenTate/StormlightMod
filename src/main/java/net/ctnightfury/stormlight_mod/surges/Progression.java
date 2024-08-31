//package net.ctnightfury.stormlight_mod.surges;
//
//import net.ctnightfury.stormlight_mod.StormlightMod;
//import net.ctnightfury.stormlight_mod.util.KeybindHandler;
//import net.minecraft.client.Minecraft;
//import net.minecraft.network.chat.Component;
//import net.minecraft.world.entity.player.Player;
//import net.minecraftforge.api.distmarker.Dist;
//import net.minecraftforge.event.TickEvent;
//import net.minecraftforge.event.entity.player.PlayerInteractEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
//// TODO: Add a way to show the selected player
//@Mod.EventBusSubscriber(modid = StormlightMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
//public class Progression {
//
//    private static Player healTarget;
//
//    // Event is on the Forge event bus only on the physical client
//    @SubscribeEvent
//    public static void onClientTick(TickEvent.ClientTickEvent event) {
//        // Only call code once as the tick event is called twice every tick
//        if (event.phase == TickEvent.Phase.END) {
//            Minecraft mc = Minecraft.getInstance();
//            if (healTarget != null) {
//                if (mc.player.isCloseEnough(healTarget, 1)) {
//                    healTarget = null;
//                    mc.player.sendSystemMessage(Component.literal("Out of Range"));
//                }
//                while (KeybindHandler.ACTIVATE_PRIMARY_SURGE.consumeClick()) {
//                    healTarget.setHealth(healTarget.getMaxHealth());
//                    mc.player.displayClientMessage(Component.literal("§2§l" +  healTarget.getDisplayName() + "has been healed!"),true);
//                }
//            }
//        }
//    }
//
//    @SubscribeEvent
//    public static void onEntityInteract(PlayerInteractEvent.EntityInteract event) {
//        try {
//            healTarget = (Player) event.getTarget();
//            event.getEntity().displayClientMessage(Component.literal("§2§l"+healTarget.getHealth() + " out of " + healTarget.getMaxHealth()),true);
//        } catch (Exception e) {
//            healTarget = null;
//        }
//    }
//}