package net.vertaloxi.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.vertaloxi.tutorialmod.TutorialMod;

public class ModItems {

    public static final Item SHY_GOLDEN_APPLE = registerItem("shy_golden_apple", new Item(new Item.Settings()));
    public static final Item LEGENDARY_DIAMOND = registerItem("legendary_diamond", new Item(new Item.Settings()));
    public static final Item BLUE_SWORD = registerItem("blue_sword", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
           entries.add(SHY_GOLDEN_APPLE);
           entries.add(LEGENDARY_DIAMOND);
           entries.add(BLUE_SWORD);
        });
    }
}
