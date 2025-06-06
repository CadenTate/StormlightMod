package ctnightfury.stormlightmod.item.custom;

import java.util.List;
import java.util.Optional;

import ctnightfury.stormlightmod.component.ModDataComponentTypes;
import ctnightfury.stormlightmod.component.SpherePouchContentsComponent;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.tooltip.BundleTooltipData;
import net.minecraft.item.tooltip.TooltipData;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.apache.commons.lang3.math.Fraction;
import screens.SpherePouchScreenHandler;

public class SpherePouchItem extends Item {
    private static final int ITEM_BAR_COLOR = MathHelper.packRgb(0.4F, 0.4F, 1.0F);

    public SpherePouchItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public boolean onStackClicked(ItemStack stack, Slot slot, ClickType clickType, PlayerEntity player) {
        if (clickType != ClickType.RIGHT) {
            return false;
        } else {
            SpherePouchContentsComponent spherePouchContentsComponent = stack.get(ModDataComponentTypes.SPHERE_POUCH_CONTENTS);
            if (spherePouchContentsComponent == null) {
                return false;
            } else {
                ItemStack itemStack = slot.getStack();
                SpherePouchContentsComponent.Builder builder = new SpherePouchContentsComponent.Builder(spherePouchContentsComponent);
                if (itemStack.isEmpty()) {
                    this.playRemoveOneSound(player);
                    ItemStack itemStack2 = builder.removeFirst();
                    if (itemStack2 != null) {
                        ItemStack itemStack3 = slot.insertStack(itemStack2);
                        builder.add(itemStack3);
                    }
                } else if (itemStack.getItem().canBeNested()) {
                    int i = builder.add(slot, player);
                    if (i > 0) {
                        this.playInsertSound(player);
                    }
                }

                stack.set(ModDataComponentTypes.SPHERE_POUCH_CONTENTS, builder.build());
                return true;
            }
        }
    }

    @Override
    public boolean onClicked(ItemStack stack, ItemStack otherStack, Slot slot, ClickType clickType, PlayerEntity player, StackReference cursorStackReference) {
        if (clickType == ClickType.RIGHT && slot.canTakePartial(player)) {
            SpherePouchContentsComponent spherePouchContentsComponent = stack.get(ModDataComponentTypes.SPHERE_POUCH_CONTENTS);
            if (spherePouchContentsComponent == null) {
                return false;
            } else {
                SpherePouchContentsComponent.Builder builder = new SpherePouchContentsComponent.Builder(spherePouchContentsComponent);
                if (otherStack.isEmpty()) {
                    ItemStack itemStack = builder.removeFirst();
                    if (itemStack != null) {
                        this.playRemoveOneSound(player);
                        cursorStackReference.set(itemStack);
                    }
                } else {
                    int i = builder.add(otherStack);
                    if (i > 0) {
                        this.playInsertSound(player);
                    }
                }

                stack.set(ModDataComponentTypes.SPHERE_POUCH_CONTENTS, builder.build());
                return true;
            }
        } else {
            return false;
        }
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        // DROPPING ITEMS CODE
        ItemStack itemStack = user.getStackInHand(hand);

        // SCREEN CODE
        if (world.isClient) {
            if (!Screen.hasShiftDown()) return TypedActionResult.success(itemStack, world.isClient());
            else if (dropAllBundledItems(itemStack, user)) {
                this.playDropContentsSound(user);
                return TypedActionResult.success(itemStack, world.isClient());
            } else {
                return TypedActionResult.fail(itemStack);
            }
        } else if(!Screen.hasShiftDown()){
            NamedScreenHandlerFactory namedScreenHandlerFactory = new NamedScreenHandlerFactory() {
                @Override
                public Text getDisplayName() {
                    return Text.of("Sphere Pouch");
                }

                @Override
                public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
                    SpherePouchContentsComponent spherePouchContentsComponent = player.getMainHandStack().get(ModDataComponentTypes.SPHERE_POUCH_CONTENTS);
                    SimpleInventory inventory;

                    // Copy items from the component
                    if (spherePouchContentsComponent != null) {
                        ItemStack[] stacks = new ItemStack[30];
                        int index = 0;

                        for (ItemStack stack : spherePouchContentsComponent.iterate()) {
                            if (index >= 30) break; // Safety check to prevent overflow
                            stacks[index++] = stack;
                        }

                        // Fill remaining slots with empty (air) items
                        while (index < 30) {
                            stacks[index++] = ItemStack.EMPTY;
                        }
                        inventory = new SimpleInventory(stacks);
                    } else inventory = new SimpleInventory(30);



                    return SpherePouchScreenHandler.createScreen(syncId, playerInventory, inventory);
                }
            };
            user.openHandledScreen(namedScreenHandlerFactory);

            return TypedActionResult.consume(itemStack);
        }
        return TypedActionResult.fail(itemStack);
    }

    @Override
    public boolean isItemBarVisible(ItemStack stack) {
        SpherePouchContentsComponent spherePouchContentsComponent = stack.getOrDefault(ModDataComponentTypes.SPHERE_POUCH_CONTENTS, SpherePouchContentsComponent.DEFAULT);
        return spherePouchContentsComponent.getOccupancy().compareTo(Fraction.ZERO) > 0;
    }

    @Override
    public int getItemBarStep(ItemStack stack) {
        SpherePouchContentsComponent spherePouchContentsComponent = stack.getOrDefault(ModDataComponentTypes.SPHERE_POUCH_CONTENTS, SpherePouchContentsComponent.DEFAULT);
        return Math.min(1 + MathHelper.multiplyFraction(spherePouchContentsComponent.getOccupancy(), 12), 13);
    }

    @Override
    public int getItemBarColor(ItemStack stack) {
        return ITEM_BAR_COLOR;
    }

    private static boolean dropAllBundledItems(ItemStack stack, PlayerEntity player) {
        SpherePouchContentsComponent spherePouchContentsComponent = stack.get(ModDataComponentTypes.SPHERE_POUCH_CONTENTS);
        if (spherePouchContentsComponent != null && !spherePouchContentsComponent.isEmpty()) {
            stack.set(ModDataComponentTypes.SPHERE_POUCH_CONTENTS, SpherePouchContentsComponent.DEFAULT);
            if (player instanceof ServerPlayerEntity) {
                spherePouchContentsComponent.iterateCopy().forEach(stackx -> player.dropItem(stackx, true));
            }
            System.out.println("DROPPED");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Optional<TooltipData> getTooltipData(ItemStack stack) {
        return !stack.contains(DataComponentTypes.HIDE_TOOLTIP) && !stack.contains(DataComponentTypes.HIDE_ADDITIONAL_TOOLTIP)
                ? Optional.ofNullable(stack.get(DataComponentTypes.BUNDLE_CONTENTS)).map(BundleTooltipData::new)
                : Optional.empty();
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        SpherePouchContentsComponent spherePouchContentsComponent = stack.get(ModDataComponentTypes.SPHERE_POUCH_CONTENTS);
        if (spherePouchContentsComponent != null) {
            int i = MathHelper.multiplyFraction(spherePouchContentsComponent.getOccupancy(), 64);
            tooltip.add(Text.translatable("item.minecraft.bundle.fullness", i, 64).formatted(Formatting.GRAY));
        }
    }

    @Override
    public void onItemEntityDestroyed(ItemEntity entity) {
        SpherePouchContentsComponent spherePouchContentsComponent = entity.getStack().get(ModDataComponentTypes.SPHERE_POUCH_CONTENTS);
        if (spherePouchContentsComponent != null) {
            entity.getStack().set(ModDataComponentTypes.SPHERE_POUCH_CONTENTS, SpherePouchContentsComponent.DEFAULT);
            ItemUsage.spawnItemContents(entity, spherePouchContentsComponent.iterateCopy());
        }
    }

    private void playRemoveOneSound(Entity entity) {
        entity.playSound(SoundEvents.ITEM_BUNDLE_REMOVE_ONE, 0.8F, 0.8F + entity.getWorld().getRandom().nextFloat() * 0.4F);
    }

    private void playInsertSound(Entity entity) {
        entity.playSound(SoundEvents.ITEM_BUNDLE_INSERT, 0.8F, 0.8F + entity.getWorld().getRandom().nextFloat() * 0.4F);
    }

    private void playDropContentsSound(Entity entity) {
        entity.playSound(SoundEvents.ITEM_BUNDLE_DROP_CONTENTS, 0.8F, 0.8F + entity.getWorld().getRandom().nextFloat() * 0.4F);
    }
}
