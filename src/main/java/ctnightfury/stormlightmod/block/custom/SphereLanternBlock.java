package ctnightfury.stormlightmod.block.custom;

import ctnightfury.stormlightmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class SphereLanternBlock extends Block {
    public SphereLanternBlock(Settings settings) {
        super(settings);
    }

    private ArrayList<Item> SPHERES_HELD = new ArrayList<>();

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if(!world.isClient()) {
            Item itemInHand = player.getMainHandStack().getItem();
            if(ModItems.SPHERES.contains(itemInHand) && SPHERES_HELD.size() <= 4) {
                SPHERES_HELD.add(itemInHand);
            }
            else if(!SPHERES_HELD.isEmpty()) {
                SPHERES_HELD.removeLast();
            }
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.stormlightmod.sphere_lantern"));
        }
        else {
            tooltip.add(Text.translatable("tooltip.stormlightmod.sphere_lantern.shift"));
        }
        super.appendTooltip(stack, context, tooltip, options);
    }
}
