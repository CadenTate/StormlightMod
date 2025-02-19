package ctnightfury.stormlightmod.block.custom;

import ctnightfury.stormlightmod.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import java.util.List;

public class SphereLanternBlock extends Block {
    public SphereLanternBlock(Settings settings) {
        super(settings);
    }


    public static final IntProperty LUMINANCE = IntProperty.of("luminance_level", 0, 15);
    private DefaultedList<ItemStack> SPHERES_HELD = DefaultedList.ofSize(5);

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if(!world.isClient()) {
            ItemStack itemInHand = player.getMainHandStack();
            // Add to lantern
            int sphereHolderSize = 5;
            if(itemInHand.isIn(ModTags.Items.SPHERES) && SPHERES_HELD.size() < sphereHolderSize) {
                SPHERES_HELD.add(itemInHand.splitUnlessCreative(1, player));
            }
            // Remove from lantern
            else if(!SPHERES_HELD.isEmpty()) {
                if(!player.isInCreativeMode()) player.getInventory().insertStack(SPHERES_HELD.getLast());
                SPHERES_HELD.removeLast();
            }

            world.setBlockState(pos, state.with(LUMINANCE, 3 * SPHERES_HELD.size()));

            System.out.println(SPHERES_HELD + Integer.toString(3 * SPHERES_HELD.size()));
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

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LUMINANCE);
    }
}
