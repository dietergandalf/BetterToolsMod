package io.github.dietergandalf.bettertoolsmod.util;

import io.github.dietergandalf.bettertoolsmod.collective.data.GlobalVariables;
import io.github.dietergandalf.bettertoolsmod.core.init.ItemInit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class Util {
	private static List<Item> overworld_minerals = new ArrayList<Item>(Arrays.asList(Items.DIAMOND, Items.GOLD_NUGGET, Items.IRON_NUGGET, Items.LAPIS_LAZULI, Items.REDSTONE, Items.EMERALD, ItemInit.RUBY.get()));
	private static List<Item> nether_minerals = new ArrayList<Item>(Arrays.asList(Items.QUARTZ, Items.GOLD_NUGGET, Items.NETHERITE_SCRAP));
	
	public static Item getRandomOverworldMineral() {
		return overworld_minerals.get(GlobalVariables.random.nextInt(overworld_minerals.size()));
	}
	public static Item getRandomNetherMineral() {
		return nether_minerals.get(GlobalVariables.random.nextInt(nether_minerals.size()));
	}
}
