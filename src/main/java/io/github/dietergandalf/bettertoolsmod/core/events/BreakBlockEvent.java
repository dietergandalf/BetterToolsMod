package io.github.dietergandalf.bettertoolsmod.core.events;

import java.util.ArrayList;

import io.github.dietergandalf.bettertoolsmod.core.functions.CompareBlockFunctions;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;

public class BreakBlockEvent extends BreakEvent{

  private BreakBlockEvent(Level world, BlockPos pos, BlockState state, Player player) {
    super(world, pos, state, player);
  }

  public static void BreakBlocksEvent(Level world, BlockPos pos, BlockState state, Player player, int enchLvl) {
    ArrayList<BlockPos> AdjacentBlocksList = new ArrayList<BlockPos>();
    int area = 2;
    int height = 2;
    int floor = 1;
    
    if(enchLvl==1){
      area = 0;
      area = 0;
      height = 1;
      floor = 1;
    }else if(enchLvl==2){
      area = 1;
      height = 1;
      floor = 1;
    }

    for(int x = -area; x<=area; x++){
      for(int y = -floor; y<=height; y++){
        for(int z = -area; z<=area; z++){
          if(!(x==0 && y==0 && z==0)){
            AdjacentBlocksList.add(new BlockPos(pos.getX()+x, pos.getY()+y, pos.getZ()+z));
          }
        }
      }
    }

    for(int i = 0; i < AdjacentBlocksList.size(); i++){
      BlockState tmp_state = world.getBlockState(AdjacentBlocksList.get(i));
      Block block = tmp_state.getBlock();
      if(player.getMainHandItem().getItem().isCorrectToolForDrops(tmp_state)){
        destroyBlock(world, AdjacentBlocksList.get(i), tmp_state, player);

        //Find extra resources in stone blocks
        if(CompareBlockFunctions.isStoneBlock(block)){
          MiningEvent.findExtraItems(world, block, AdjacentBlocksList.get(i), player);
        }
      }
    }
  }


  /*
   * Destroy the block and drop the block's drops
   * @param world The world the block is in
   * @param pos The position of the block
   * @param state The state of the block
   * @param player The player who broke the block
   */
  private static void destroyBlock(Level world, BlockPos pos, BlockState state, Player player) {
    int fortuneLvl = player.getMainHandItem().getEnchantmentLevel(Enchantments.BLOCK_FORTUNE);
    int silktouch = player.getMainHandItem().getEnchantmentLevel(Enchantments.SILK_TOUCH);
    world.destroyBlock(pos, false, player, 11);
    world.setBlock(pos, Blocks.AIR.defaultBlockState(), 11);
    
    if(silktouch == 1){
      ItemStack itemStack = new ItemStack(state.getBlock(), 1);
      ItemEntity blockDrop = new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, itemStack);
      world.addFreshEntity(blockDrop);
    }else{
      Block.getDrops(state, world.getServer().getLevel(world.dimension()), pos, null).forEach(itemStack -> {
        itemStack.setCount(fortuneLvl+1);
        ItemEntity blockDrop = new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, itemStack);
        world.addFreshEntity(blockDrop);
      });
    }
  }
}
