package net.vertaloxi.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.vertaloxi.tutorialmod.TutorialMod;
import net.vertaloxi.tutorialmod.block.ModBlocks;


public class ModItemGroups {

    public static final ItemGroup MY_ITEMS = Registry.register(Registries.ITEM_GROUP, Identifier.of(TutorialMod.MOD_ID, "my_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.LEGENDARY_DIAMOND))
                    .displayName(Text.translatable("itemgroup.tutorialmod.my_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.LEGENDARY_DIAMOND);
                        entries.add(ModItems.SHY_GOLDEN_APPLE);

                    }).build());
    public static final ItemGroup MY_BLOCKS = Registry.register(Registries.ITEM_GROUP, Identifier.of(TutorialMod.MOD_ID, "my_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.LEGENDARY_DIAMOND_BLOCK))
                    .displayName(Text.translatable("itemgroup.tutorialmod.my_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.LEGENDARY_DIAMOND_BLOCK);
                        entries.add(ModBlocks.SHY_GOLDEN_APPLE_BLOCK);

                    }).build());

    public static void registerItemGroups() {
        TutorialMod.LOGGER.info("Registering Item Grouos for " + TutorialMod.MOD_ID);
    }
}
