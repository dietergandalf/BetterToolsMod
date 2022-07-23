package io.github.dietergandalf.bettertoolsmod.util;

import io.github.dietergandalf.bettertoolsmod.collective.data.GlobalVariables;
import io.github.dietergandalf.bettertoolsmod.core.init.BlockInit;
import io.github.dietergandalf.bettertoolsmod.core.init.ItemInit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class Util {
	private static List<Item> overworld_minerals = new ArrayList<Item>(Arrays.asList(Items.DIAMOND, Items.GOLD_NUGGET, Items.IRON_NUGGET, Items.LAPIS_LAZULI, Items.REDSTONE, Items.EMERALD, ItemInit.RUBY.get()));
	private static List<Item> nether_minerals = new ArrayList<Item>(Arrays.asList(Items.QUARTZ, Items.GOLD_NUGGET, Items.NETHERITE_SCRAP));
	
  public static List<Block> minerals = new ArrayList<Block>(Arrays.asList(Blocks.COAL_ORE, Blocks.DEEPSLATE_COAL_ORE, Blocks.IRON_ORE, Blocks.DEEPSLATE_IRON_ORE, Blocks.COPPER_ORE, Blocks.DEEPSLATE_COPPER_ORE, Blocks.GOLD_ORE, Blocks.DEEPSLATE_GOLD_ORE, Blocks.LAPIS_ORE, Blocks.DEEPSLATE_LAPIS_ORE, Blocks.REDSTONE_ORE, Blocks.DEEPSLATE_REDSTONE_ORE, Blocks.EMERALD_ORE, Blocks.DEEPSLATE_EMERALD_ORE, Blocks.DIAMOND_ORE, Blocks.DEEPSLATE_DIAMOND_ORE, Blocks.NETHER_QUARTZ_ORE, Blocks.ANCIENT_DEBRIS, Blocks.NETHERITE_BLOCK, BlockInit.RUBY_ORE.get(), BlockInit.DEEPSLATE_RUBY_ORE.get()));

	public static Item getRandomOverworldMineral() {
		return overworld_minerals.get(GlobalVariables.random.nextInt(overworld_minerals.size()));
	}
	public static Item getRandomNetherMineral() {
		return nether_minerals.get(GlobalVariables.random.nextInt(nether_minerals.size()));
	}
  public static boolean blockInList(Block block, List<Block> list) {
    for(int i = 0; i < list.size(); i++) {
      if(block.equals(list.get(i))) {
        return true;
      }
    }
    return false;
  }
}
