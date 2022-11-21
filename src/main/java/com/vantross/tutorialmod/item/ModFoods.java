package com.vantross.tutorialmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties CITRINE_APPLE = (new FoodProperties.Builder()).nutrition(10).saturationMod(1.5F)
            .alwaysEat()
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2400, 2), 1.0F)
            .effect(new MobEffectInstance(MobEffects.REGENERATION, 600, 1), 1.0F)
            .effect(new MobEffectInstance(MobEffects.GLOWING, 200), 1.0F).build();
}
