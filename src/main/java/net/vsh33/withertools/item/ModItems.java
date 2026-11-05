package net.vsh33.withertools.item;

import java.util.function.Function;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.vsh33.withertools.WitherTools;

public final class ModItems {
	public static final Item OBSIDIAN_BALL = register("obsidian_ball", Item::new, new Item.Properties());

	private static Item register(String name, Function<Item.Properties, Item> factory, Item.Properties properties) {
		ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, WitherTools.id(name));
		Item item = factory.apply(properties.setId(key));
		return Registry.register(BuiltInRegistries.ITEM, key, item);
	}

	public static void initialize() {
	}

	private ModItems() {
	}
}
