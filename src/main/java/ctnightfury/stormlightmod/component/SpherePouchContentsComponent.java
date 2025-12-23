package ctnightfury.stormlightmod.component;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import net.minecraft.block.entity.BeehiveBlockEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipData;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.screen.slot.Slot;
import org.apache.commons.lang3.math.Fraction;
import org.jetbrains.annotations.Nullable;

public final class SpherePouchContentsComponent implements TooltipData {
    public static final SpherePouchContentsComponent DEFAULT = new SpherePouchContentsComponent(List.of());
    public static final Codec<SpherePouchContentsComponent> CODEC = ItemStack.CODEC.listOf().xmap(SpherePouchContentsComponent::new, component -> component.stacks);
    public static final PacketCodec<RegistryByteBuf, SpherePouchContentsComponent> PACKET_CODEC = ItemStack.PACKET_CODEC
            .collect(PacketCodecs.toList())
            .xmap(SpherePouchContentsComponent::new, component -> component.stacks);
    private static final Fraction NESTED_BUNDLE_OCCUPANCY = Fraction.getFraction(1, 16);
    final List<ItemStack> stacks;
    final Fraction occupancy;

    SpherePouchContentsComponent(List<ItemStack> stacks, Fraction occupancy) {
        this.stacks = stacks;
        this.occupancy = occupancy;
    }

    public SpherePouchContentsComponent(List<ItemStack> stacks) {
        this(stacks, calculateOccupancy(stacks));
    }

    private static Fraction calculateOccupancy(List<ItemStack> stacks) {
        Fraction fraction = Fraction.ZERO;

        for (ItemStack itemStack : stacks) {
            fraction = fraction.add(getOccupancy(itemStack).multiplyBy(Fraction.getFraction(itemStack.getCount(), 1)));
        }

        return fraction;
    }

    static Fraction getOccupancy(ItemStack stack) {
        SpherePouchContentsComponent spherePouchContentsComponent = stack.get(ModDataComponentTypes.SPHERE_POUCH_CONTENTS);
        if (spherePouchContentsComponent != null) {
            return NESTED_BUNDLE_OCCUPANCY.add(spherePouchContentsComponent.getOccupancy());
        } else {
            List<BeehiveBlockEntity.BeeData> list = stack.getOrDefault(DataComponentTypes.BEES, List.of());
            return !list.isEmpty() ? Fraction.ONE : Fraction.getFraction(1, stack.getMaxCount());
        }
    }

    public ItemStack get(int index) {
        return this.stacks.get(index);
    }

    public Iterable<ItemStack> iterate() {
        return this.stacks;
    }

    public Iterable<ItemStack> iterateCopy() {
        return Lists.transform(this.stacks, ItemStack::copy);
    }

    public int size() {
        return this.stacks.size();
    }

    public Fraction getOccupancy() {
        return this.occupancy;
    }

    public boolean isEmpty() {
        return this.stacks.isEmpty();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else {
            return o instanceof SpherePouchContentsComponent SpherePouchContentsComponent && this.occupancy.equals(SpherePouchContentsComponent.occupancy) && stacksEqual(this.stacks, SpherePouchContentsComponent.stacks);
        }
    }

    private static boolean stacksEqual(List<ItemStack> left, List<ItemStack> right) {
        if (left.size() != right.size()) {
            return false;
        } else {
            for (int i = 0; i < left.size(); i++) {
                if (!ItemStack.areEqual(left.get(i), right.get(i))) {
                    return false;
                }
            }

            return true;
        }
    }

    public int hashCode() {
        return listHashCode(this.stacks);
    }

    private static int listHashCode(List<ItemStack> stacks) {
        int i = 0;

        for (ItemStack itemStack : stacks) {
            i = i * 31 + ItemStack.hashCode(itemStack);
        }

        return i;
    }

    public String toString() {
        return "BundleContents" + this.stacks;
    }

    public static class Builder {
        private final List<ItemStack> stacks;
        private Fraction occupancy;

        public Builder(SpherePouchContentsComponent base) {
            this.stacks = new ArrayList<>(base.stacks);
            this.occupancy = base.occupancy;
        }

        public SpherePouchContentsComponent.Builder clear() {
            this.stacks.clear();
            this.occupancy = Fraction.ZERO;
            return this;
        }

        private int addInternal(ItemStack stack) {
            if (stack.isStackable()) {
                for (int i = 0; i < this.stacks.size(); i++) {
                    if (ItemStack.areItemsAndComponentsEqual(this.stacks.get(i), stack)) {
                        return i;
                    }
                }
            }
            return -1;
        }

        private int getMaxAllowed(ItemStack stack) {
            Fraction fraction = Fraction.ONE.subtract(this.occupancy);
            return Math.max(fraction.divideBy(SpherePouchContentsComponent.getOccupancy(stack)).intValue(), 0);
        }

        public int add(ItemStack stack) {
            if (!stack.isEmpty() && stack.getItem().canBeNested()) {
                int i = Math.min(stack.getCount(), this.getMaxAllowed(stack));
                if (i == 0) {
                    return 0;
                } else {
                    this.occupancy = this.occupancy.add(SpherePouchContentsComponent.getOccupancy(stack).multiplyBy(Fraction.getFraction(i, 1)));
                    int j = this.addInternal(stack);
                    if (j != -1) {
                        ItemStack itemStack = this.stacks.remove(j);
                        ItemStack itemStack2 = itemStack.copyWithCount(itemStack.getCount() + i);
                        stack.decrement(i);
                        this.stacks.addFirst(itemStack2);
                    } else {
                        this.stacks.addFirst(stack.split(i));
                    }

                    return i;
                }
            } else {
                return 0;
            }
        }

        public int add(Slot slot, PlayerEntity player) {
            ItemStack itemStack = slot.getStack();
            int i = this.getMaxAllowed(itemStack);
            return this.add(slot.takeStackRange(itemStack.getCount(), i, player));
        }

        @Nullable
        public ItemStack removeFirst() {
            if (this.stacks.isEmpty()) {
                return null;
            } else {
                ItemStack itemStack = this.stacks.removeFirst().copy();
                this.occupancy = this.occupancy.subtract(SpherePouchContentsComponent.getOccupancy(itemStack).multiplyBy(Fraction.getFraction(itemStack.getCount(), 1)));
                return itemStack;
            }
        }

        public Fraction getOccupancy() {
            return this.occupancy;
        }

        public SpherePouchContentsComponent build() {
            return new SpherePouchContentsComponent(List.copyOf(this.stacks), this.occupancy);
        }
    }
}
