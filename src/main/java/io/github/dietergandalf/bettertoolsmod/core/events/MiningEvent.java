package io.github.dietergandalf.bettertoolsmod.core.events;

import io.github.dietergandalf.bettertoolsmod.collective.data.GlobalVariables;
import io.github.dietergandalf.bettertoolsmod.config.ConfigHandler;
import io.github.dietergandalf.bettertoolsmod.core.enchantment.ModEnchantments;
import io.github.dietergandalf.bettertoolsmod.core.functions.CompareBlockFunctions;
import io.github.dietergandalf.bettertoolsmod.core.functions.StringFunctions;
import io.github.dietergandalf.bettertoolsmod.core.functions.WorldFunctions;
import io.github.dietergandalf.bettertoolsmod.util.Util;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class MiningEvent {

	@SubscribeEvent
	public void onBlockBreak(BlockEvent.BreakEvent e) {
		Level world = WorldFunctions.getWorldIfInstanceOfAndNotRemote(e.getWorld());
		if (world == null) {return;}
		
		Player player = e.getPlayer();
		if (ConfigHandler.GENERAL.ignoreFakePlayers.get()) {
			if (player instanceof FakePlayer) {return;}
		}
		
		if (player.isCreative()) {return;}

    BlockState state = e.getState();
		Block block = state.getBlock();
    BlockPos pos = e.getPos();
    
    if(player.getMainHandItem().getEnchantmentLevel(ModEnchantments.AREA_MINER.get()) > 0){
      int enchantmentLvl = player.getMainHandItem().getEnchantmentLevel(ModEnchantments.AREA_MINER.get());
      BreakBlockEvent.BreakBlocksEvent(world, pos, e.getState(), player, enchantmentLvl);
    }
		
		if (!CompareBlockFunctions.isStoneBlock(block) && !CompareBlockFunctions.isNetherStoneBlock(block)) {
			return;
		}
		findExtraItems(world, block, pos, player);
	}

  public static void findExtraItems(Level world, Block block, BlockPos pos, Player player){
    Item randommineral;
		if (WorldFunctions.isOverworld(world)) {
			if (!ConfigHandler.GENERAL.enableOverworldMinerals.get()) {
				return;
			}
			if (CompareBlockFunctions.isNetherStoneBlock(block)) {
				return;
			}
			if (GlobalVariables.random.nextDouble() > ConfigHandler.GENERAL.extraMineralChanceOnOverworldStoneBreak.get()) {
				return;
			}
			randommineral = Util.getRandomOverworldMineral();
		}
		else if (WorldFunctions.isNether(world)) {
			if (!ConfigHandler.GENERAL.enableNetherMinerals.get()) {
				return;
			}
			if (!CompareBlockFunctions.isNetherStoneBlock(block)) {
				return;
			}
			if (GlobalVariables.random.nextDouble() > ConfigHandler.GENERAL.extraMineralChanceOnNetherStoneBreak.get()) {
				return;
			}
			randommineral = Util.getRandomNetherMineral();
		}
		else {
			return;
		}
		
		ItemEntity mineralentity = new ItemEntity(world, pos.getX()+0.5, pos.getY()+0.5, pos.getZ()+0.5, new ItemStack(randommineral, 1));
		world.addFreshEntity(mineralentity);
		
		if (ConfigHandler.GENERAL.sendMessageOnMineralFind.get()) {
			StringFunctions.sendMessage(player, ConfigHandler.GENERAL.foundMineralMessage.get(), mineralentity.getName().getString(), ChatFormatting.DARK_GREEN);
		}
  }
}
