package ctnightfury.stormlightmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Map;

public class SoulcasterItem extends Item {
    public static final Map<Block, Block> SOULCAST_MAP =
            Map.of(
                    Blocks.OAK_LOG, Blocks.BIRCH_LOG
            );

    public SoulcasterItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(SOULCAST_MAP.containsKey(clickedBlock)) {
            if(!world.isClient()) {
                world.setBlockState(context.getBlockPos(), SOULCAST_MAP.get(clickedBlock).getDefaultState());
            }
        }

        return ActionResult.SUCCESS;

    }
}
