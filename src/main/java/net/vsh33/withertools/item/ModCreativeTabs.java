package net.vsh33.withertools.item;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.vsh33.withertools.WitherTools;
import net.vsh33.withertools.block.ModBlocks;

public final class ModCreativeTabs {
	public static final ResourceKey<CreativeModeTab> WITHERTOOLS_GROUP_KEY = ResourceKey.create(
			Registries.CREATIVE_MODE_TAB,
			WitherTools.id("withertools_group")
	);

	public static final CreativeModeTab WITHERTOOLS_GROUP = FabricCreativeModeTab.builder()
			.icon(() -> new ItemStack(ModBlocks.WITHERPROOF_BLOCK.asItem()))
			.title(Component.translatable("itemgroup.withertools.withertools_group"))
			.displayItems((params, output) -> {
				output.accept(ModItems.OBSIDIAN_BALL);
				output.accept(ModBlocks.WITHERPROOF_BLOCK.asItem());
				output.accept(ModBlocks.WITHERPROOF_GLASS.asItem());
			})
			.build();

	public static void initialize() {
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, WITHERTOOLS_GROUP_KEY, WITHERTOOLS_GROUP);
	}

	private ModCreativeTabs() {
	}
}
