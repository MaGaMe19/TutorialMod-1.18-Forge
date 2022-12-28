package com.vantross.tutorialmod.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    // level 3 = diamond tier, enchantment value 22 = really well enchant-able, ingredient to repair
    // -> as fast as netherite, less durable than diamond, as well enchant-able as gold
    public static final ForgeTier CITRINE = new ForgeTier(3, 1265, 9f,
            3f, 22, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.CITRINE.get()));
}
