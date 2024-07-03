package net.ctnightfury.stormlight_mod.item.custom;

import net.ctnightfury.stormlight_mod.surges.Transformation;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class SoulCaster extends Item {
    public SoulCaster(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if(!world.isClientSide()) {
            Transformation.Soulcast(world, player);
        }
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}
