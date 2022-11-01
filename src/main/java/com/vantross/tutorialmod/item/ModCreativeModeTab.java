package com.vantross.tutorialmod.item;

import com.vantross.tutorialmod.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    // this constructor is needed for every new tab
    public static final CreativeModeTab TUTORIAL_TAB = new CreativeModeTab("tutorialtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.CITRINE_BLOCK.get());
        }
    };
}
