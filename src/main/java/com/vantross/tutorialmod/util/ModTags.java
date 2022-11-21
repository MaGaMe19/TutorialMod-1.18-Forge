package com.vantross.tutorialmod.util;

import com.vantross.tutorialmod.TutorialMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

public class ModTags {
    public static class Blocks {
        // ore locator valuables tag, makes it easier to add new blocks
        public static final Tags.IOptionalNamedTag<Block> ORE_LOCATOR_VALUABLES = tag("ore_locator_valuables");

        private static Tags.IOptionalNamedTag<Block> tag(String name) {
            return BlockTags.createOptional(new ResourceLocation(TutorialMod.MOD_ID, name));
        }

        private static Tags.IOptionalNamedTag<Block> forgeTag(String name) {
            return BlockTags.createOptional(new ResourceLocation("forge", name));
        }
    }

    public static class Items {
        // citrine forge tag, if another mod were to add citrine, and they declared this in their mod, both citrine variants
        // could be used interchangeably in a modpack
        public static final Tags.IOptionalNamedTag<Item> CITRINE_GEMS = forgeTag("gems/citrine");

        private static Tags.IOptionalNamedTag<Item> tag(String name) {
            return ItemTags.createOptional(new ResourceLocation(TutorialMod.MOD_ID, name));
        }

        private static Tags.IOptionalNamedTag<Item> forgeTag(String name) {
            return ItemTags.createOptional(new ResourceLocation("forge", name));
        }
    }

}