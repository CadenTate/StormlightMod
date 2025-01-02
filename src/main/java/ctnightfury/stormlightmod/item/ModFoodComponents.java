package ctnightfury.stormlightmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent LAVIS_BAR = new FoodComponent.Builder()
            .nutrition(8)
            .build();
    public static final FoodComponent WINE = new FoodComponent.Builder()
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200), 0.1f)
            .build();
}
