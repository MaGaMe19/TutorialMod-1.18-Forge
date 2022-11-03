package com.vantross.tutorialmod.item.custom;

import com.vantross.tutorialmod.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

// advanced Item: Dowsing Rod, checks every block under the block that was clicked on and returns information about any valuable ores

public class OreLocatorItem extends Item {
    public OreLocatorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        // client side only
        if (pContext.getLevel().isClientSide()) {
            BlockPos posClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for (int i = 0; i <= posClicked.getY() + 64; i++) {
                // check block i blocks below clicked blocks
                Block blockBelow = pContext.getLevel().getBlockState(posClicked.below(i)).getBlock();

                if (isValuableBlock(blockBelow)) {
                    outputValuableCoordinates(posClicked.below(i), player, blockBelow);
                    foundBlock = true;
                    break;
                }
            }

            if (!foundBlock) {
                player.sendMessage(new TranslatableComponent("item.tutorialmod.dowsing_rod.no_valuables"), player.getUUID());
            }
        }

        // damage item after every use
        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                (player) -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return super.useOn(pContext);
    }

    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block blockBelow) {
        player.sendMessage(new TextComponent("Found " + blockBelow.asItem().getRegistryName().toString() + " at " +
                "(" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"), player.getUUID());
    }

    private boolean isValuableBlock(Block block) {
        return  block == Blocks.COPPER_ORE || block == Blocks.IRON_ORE || block == Blocks.DIAMOND_ORE
                || block == Blocks.GOLD_ORE || block == Blocks.EMERALD_ORE || block == Blocks.REDSTONE_ORE || block == Blocks.LAPIS_ORE
                || block == Blocks.DEEPSLATE_COPPER_ORE || block == Blocks.DEEPSLATE_IRON_ORE || block == Blocks.DEEPSLATE_DIAMOND_ORE
                || block == Blocks.DEEPSLATE_GOLD_ORE || block == Blocks.DEEPSLATE_EMERALD_ORE || block == Blocks.DEEPSLATE_REDSTONE_ORE || block == Blocks.DEEPSLATE_LAPIS_ORE
                || block == ModBlocks.CITRINE_ORE.get() || block == ModBlocks.DEEPSLATE_CITRINE_ORE.get();
    }
}
