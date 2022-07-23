package io.github.dietergandalf.bettertoolsmod.core.events;

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
    BlockPos[] AdjacentBlocks = {null, null};
    if(enchLvl==1){
      int index = 0;
      int x = 0;
      int z = 0;
      for(int y = -1; y<=1; y++){  
            if(!(y==0)){
              AdjacentBlocks[index++] = new BlockPos(pos.getX()+x, pos.getY()+y, pos.getZ()+z);
            }
      }
    }else if(enchLvl==2){
      AdjacentBlocks = new BlockPos[26];
      int index = 0;
      for(int x = -1; x<=1; x++){
        for(int y = -1; y<=1; y++){
          for(int z = -1; z<=1; z++){
            if(!(x==0 && y==0 && z==0)){
              AdjacentBlocks[index++] = new BlockPos(pos.getX()+x, pos.getY()+y, pos.getZ()+z);
            }
          }
        }
      }
    }else{
      AdjacentBlocks = new BlockPos[99];
      int index = 0;
      for(int x = -2; x<=2; x++){
        for(int y = -1; y<=2; y++){
          for(int z = -2; z<=2; z++){
            if(!(x==0 && y==0 && z==0)){
              AdjacentBlocks[index++] = new BlockPos(pos.getX()+x, pos.getY()+y, pos.getZ()+z);
            }
          }
        }
      }
    }
    for(int i = 0; i < AdjacentBlocks.length; i++){
      BlockState tmp_state = world.getBlockState(AdjacentBlocks[i]);
      Block block = tmp_state.getBlock();
      if(player.getMainHandItem().getItem().isCorrectToolForDrops(tmp_state)){
        destroyBlock(world, AdjacentBlocks[i], tmp_state, player);
        MiningEvent.findExtraItems(world, block, AdjacentBlocks[i], player);
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
