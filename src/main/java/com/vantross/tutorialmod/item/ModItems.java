package com.vantross.tutorialmod.item;

import com.vantross.tutorialmod.TutorialMod;
import com.vantross.tutorialmod.item.custom.CoalCokeItem;
import com.vantross.tutorialmod.item.custom.OreLocatorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

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
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB).food(ModFoods.CITRINE_APPLE).stacksTo(8)));

   public static final RegistryObject<Item> COAL_COKE = ITEMS.register("coal_coke",
           () -> new CoalCokeItem(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    // register Items
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
