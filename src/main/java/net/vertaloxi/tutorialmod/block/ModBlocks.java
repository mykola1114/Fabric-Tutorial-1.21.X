package net.vertaloxi.tutorialmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.vertaloxi.tutorialmod.TutorialMod;
import net.vertaloxi.tutorialmod.block.custom.MagicBlock;

public class ModBlocks {

    public static final Block LEGENDARY_DIAMOND_BLOCK = registerBlock("legendary_diamond_block",
            new Block(AbstractBlock.Settings.create().strength(5.0F,6.0F).mapColor(MapColor.DIAMOND_BLUE).requiresTool().sounds(BlockSoundGroup.METAL)));
    public static final Block SHY_GOLDEN_APPLE_BLOCK = registerBlock("shy_golden_apple_block",
            new Block(AbstractBlock.Settings.create().strength(1f).requiresTool()));
    public static final Block LEGENDARY_DIAMOND_ORE = registerBlock("legendary_diamond_ore",
            new Block(AbstractBlock.Settings.create().strength(3.0F,3.0F).mapColor(MapColor.STONE_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresTool()));

    public static final Block MAGIC_BLOCK = registerBlock("magic_block", new MagicBlock(AbstractBlock.Settings.create().strength(1f).requiresTool()));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        TutorialMod.LOGGER.info("Registering Mod Blocks for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.LEGENDARY_DIAMOND_BLOCK);
            entries.add(ModBlocks.SHY_GOLDEN_APPLE_BLOCK);
            entries.add(ModBlocks.LEGENDARY_DIAMOND_ORE);
            entries.add(ModBlocks.MAGIC_BLOCK);
        });
    }
}
