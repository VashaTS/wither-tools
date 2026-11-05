package net.vsh33.withertools;

import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;
import net.vsh33.withertools.block.ModBlocks;
import net.vsh33.withertools.item.ModCreativeTabs;
import net.vsh33.withertools.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WitherTools implements ModInitializer {
	public static final String MOD_ID = "withertools";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}

	@Override
	public void onInitialize() {
		ModItems.initialize();
		ModBlocks.initialize();
		ModCreativeTabs.initialize();
		LOGGER.info("Wither Tools loaded");
	}
}
