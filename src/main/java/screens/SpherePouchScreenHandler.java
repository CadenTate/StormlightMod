package screens;

import ctnightfury.stormlightmod.component.ModDataComponentTypes;
import ctnightfury.stormlightmod.component.SpherePouchContentsComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;

public class SpherePouchScreenHandler extends ScreenHandler {
    private static final int NUM_COLUMNS = 10;
    private static final int NUM_ROWS = 3;
    private final Inventory inventory;

    public SpherePouchScreenHandler(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(type, syncId);
        checkSize(inventory, NUM_ROWS * NUM_COLUMNS);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);
        int i = (NUM_ROWS - 4) * 18;

        // X and Y in pixel values for top left corner of slot

        // Creates Pouch Inventory
        for (int j = 0; j < NUM_ROWS; j++) {
            for (int k = 0; k < NUM_COLUMNS; k++) {
                this.addSlot(new Slot(inventory, k + j * NUM_COLUMNS, -1 + k * 18, 18 + j * 18));
            }
        }

        // Creates player inventory
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 9; k++) {
                this.addSlot(new Slot(playerInventory, k + j * 9 + 9, 8 + k * 18, 103 + j * 18 + i));
            }
        }

        // Creates Hot Bar
        for (int j = 0; j < 9; j++) {
            this.addSlot(new Slot(playerInventory, j, 8 + j * 18, 161 + i));
        }
    }

    private SpherePouchScreenHandler(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory) {
        this(type, syncId, playerInventory, new SimpleInventory(NUM_ROWS * NUM_COLUMNS));
    }

    public static SpherePouchScreenHandler createScreen(int syncId, PlayerInventory playerInventory) {
        return new SpherePouchScreenHandler(ModScreenHandlerTypes.SPHERE_POUCH_SCREEN_TYPE, syncId, playerInventory);
    }

    public static SpherePouchScreenHandler createScreen(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        return new SpherePouchScreenHandler(ModScreenHandlerTypes.SPHERE_POUCH_SCREEN_TYPE, syncId, playerInventory, inventory);
    }


    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot2 = this.slots.get(slot);
        if (slot2 != null && slot2.hasStack()) {
            ItemStack itemStack2 = slot2.getStack();
            itemStack = itemStack2.copy();
            if (slot < NUM_ROWS * NUM_COLUMNS) {
                if (!this.insertItem(itemStack2, NUM_ROWS * NUM_COLUMNS, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(itemStack2, 0, NUM_ROWS * NUM_COLUMNS, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack2.isEmpty()) {
                slot2.setStack(ItemStack.EMPTY);
            } else {
                slot2.markDirty();
            }
        }

        return itemStack;
    }
    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }

    public int getRows() {
        return NUM_ROWS;
    }

    @Override
    public void onClosed(PlayerEntity player) {
        ItemStack stack = player.getMainHandStack();
        SpherePouchContentsComponent.Builder builder = new SpherePouchContentsComponent.Builder(SpherePouchContentsComponent.DEFAULT);

        for (int i = NUM_COLUMNS * NUM_ROWS; i >= 0; i--) {
            ItemStack itemStack = inventory.getStack(i);
            if(!itemStack.getItem().equals(Items.AIR)) builder.add(itemStack);
            stack.set(ModDataComponentTypes.SPHERE_POUCH_CONTENTS, builder.build());
        }
        inventory.onClose(player);
    }
}
