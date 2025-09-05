package net.vertaloxi.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.vertaloxi.tutorialmod.block.ModBlocks;
import net.vertaloxi.tutorialmod.item.ModItemGroups;
import net.vertaloxi.tutorialmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Not important comment
public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItemGroups.registerItemGroups();

        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
	}
}