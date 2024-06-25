package net.ctnightfury.stormlight_mod.surges;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class Transformation {
    public static void Soulcast(Level world, Player player) {
        Block block = world.getBlockState(player.getOnPos()).getBlock();

        switch (block.toString()) {
            case "Block{minecraft:air}":
                world.setBlock(player.getOnPos().below(),Blocks.STONE.defaultBlockState(), 2);
        }
    }
}
