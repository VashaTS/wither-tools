package net.vsh33.withertools.block;

import java.util.function.Function;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.vsh33.withertools.WitherTools;

public final class ModBlocks {
	/**
	 * Matches the 1.21.1 settings: hardness 3, explosion resistance 360000,
	 * requires correct tool, stone sounds / dark map colour.
	 */
	public static final Block WITHERPROOF_BLOCK = register(
			"witherproof_block",
			WitherProofBlock::new,
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.COLOR_BLACK)
					.strength(3.0F, 360000.0F)
					.requiresCorrectToolForDrops()
					.sound(SoundType.STONE)
					.pushReaction(PushReaction.IMMOVEABLE),
			true
	);

	/**
	 * Glass variant: transparent / non-occluding, same wither-proof strength.
	 */
	public static final Block WITHERPROOF_GLASS = register(
			"witherproof_glass",
			WitherProofGlassBlock::new,
			BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)
					.mapColor(MapColor.COLOR_BLACK)
					.strength(3.0F, 360000.0F)
					.requiresCorrectToolForDrops()
					.sound(SoundType.GLASS)
					.noOcclusion()
					.isViewBlocking((state, level, pos, box) -> false)
					.isSuffocating((state, level, pos) -> false)
					.pushReaction(PushReaction.IMMOVEABLE),
			true
	);

	private static Block register(
			String name,
			Function<BlockBehaviour.Properties, Block> blockFactory,
			BlockBehaviour.Properties properties,
			boolean shouldRegisterItem
	) {
		ResourceKey<Block> blockKey = ResourceKey.create(Registries.BLOCK, WitherTools.id(name));
		Block block = blockFactory.apply(properties.setId(blockKey));

		if (shouldRegisterItem) {
			ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, WitherTools.id(name));
			BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
			Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
		}

		return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
	}

	public static void initialize() {
	}

	private ModBlocks() {
	}
}
