package ctnightfury.stormlightmod.util;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import ctnightfury.stormlightmod.component.ModComponents;
import ctnightfury.stormlightmod.component.cardinal_components.interfaces.StormlightComponentInterface;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class StormlightCommands {

    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(CommandManager.literal("stormlight")
                .requires(source -> source.hasPermissionLevel(2)) // op level check (optional)

                // GET
                .then(CommandManager.literal("get")
                        .then(CommandManager.argument("target", EntityArgumentType.player())
                                .executes(context -> {
                                    ServerPlayerEntity player = EntityArgumentType.getPlayer(context, "target");
                                    int amount = ModComponents.STORMLIGHT.get(player).getStormlight();
                                    context.getSource().sendFeedback(() ->
                                            Text.literal(player.getName().getString() + " has " + amount + " stormlight."), false);
                                    return 1;
                                })
                        )
                )

                // SET
                .then(CommandManager.literal("set")
                        .then(CommandManager.argument("target", EntityArgumentType.player())
                                .then(CommandManager.argument("amount", IntegerArgumentType.integer(0))
                                        .executes(context -> {
                                            ServerPlayerEntity player = EntityArgumentType.getPlayer(context, "target");
                                            int amount = IntegerArgumentType.getInteger(context, "amount");
                                            ModComponents.STORMLIGHT.get(player).setStormlight(amount);
                                            context.getSource().sendFeedback(() ->
                                                    Text.literal("Set " + player.getName().getString() + "'s stormlight to " + amount), false);
                                            return 1;
                                        }))
                        )
                )

                // ADD
                .then(CommandManager.literal("add")
                        .then(CommandManager.argument("target", EntityArgumentType.player())
                                .then(CommandManager.argument("amount", IntegerArgumentType.integer())
                                        .executes(context -> {
                                            ServerPlayerEntity player = EntityArgumentType.getPlayer(context, "target");
                                            int amount = IntegerArgumentType.getInteger(context, "amount");
                                            StormlightComponentInterface comp = ModComponents.STORMLIGHT.get(player);
                                            comp.addStormlight(amount);
                                            context.getSource().sendFeedback(() ->
                                                    Text.literal("Added " + amount + " stormlight to " + player.getName().getString()), false);
                                            return 1;
                                        }))
                        )
                )

                // CLEAR
                .then(CommandManager.literal("clear")
                        .then(CommandManager.argument("target", EntityArgumentType.player())
                                .executes(context -> {
                                    ServerPlayerEntity player = EntityArgumentType.getPlayer(context, "target");
                                    ModComponents.STORMLIGHT.get(player).setStormlight(0);
                                    context.getSource().sendFeedback(() ->
                                            Text.literal("Cleared stormlight from " + player.getName().getString()), false);
                                    return 1;
                                })
                        )
                )
        ));
    }
}
