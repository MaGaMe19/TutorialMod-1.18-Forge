package com.vantross.tutorialmod.item;

import com.vantross.tutorialmod.TutorialMod;
import com.vantross.tutorialmod.item.custom.CoalCokeItem;
import com.vantross.tutorialmod.item.custom.OreLocatorItem;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModItems {

    // holds all items of the mod
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    // citrine stuff
    public static final RegistryObject<Item> CITRINE = ITEMS.register("citrine",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> RAW_CITRINE = ITEMS.register("raw_citrine",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    // ore locator
    public static final RegistryObject<Item> ORE_LOCATOR = ITEMS.register("ore_locator",
            () -> new OreLocatorItem(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).durability(24)));


    // others
    public static final RegistryObject<Item> CITRINE_APPLE = ITEMS.register("citrine_apple",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)
                    .food(ModFoods.CITRINE_APPLE).stacksTo(16))
                // anonymous function for tooltip
            {
                @Override
                public void appendHoverText(ItemStack pStack, @Nullable Level pLevel,
                                            List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {

                    if (Screen.hasShiftDown()) {
                        pTooltipComponents.add(new TranslatableComponent("tooltip.tutorialmod.citrine_apple.shift"));
                    } else {
                        pTooltipComponents.add(new TranslatableComponent("tooltip.tutorialmod.generic.shift.more_info"));
                    }
                }
            });

    public static final RegistryObject<Item> COAL_COKE = ITEMS.register("coal_coke",
            () -> new CoalCokeItem(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    // tools
    public static final RegistryObject<Item> CITRINE_SWORD = ITEMS.register("citrine_sword",
            () -> new SwordItem(ModTiers.CITRINE, 5, 1f,
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> CITRINE_PICKAXE = ITEMS.register("citrine_pickaxe",
            () -> new PickaxeItem(ModTiers.CITRINE, 2, -2.5f,
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> CITRINE_AXE = ITEMS.register("citrine_axe",
            () -> new AxeItem(ModTiers.CITRINE, 6, -3f,
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> CITRINE_SHOVEL = ITEMS.register("citrine_shovel",
            () -> new ShovelItem(ModTiers.CITRINE, 2, 0f,
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> CITRINE_HOE = ITEMS.register("citrine_hoe",
            () -> new HoeItem(ModTiers.CITRINE, 1, 0f,
                    new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    // register Items
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
