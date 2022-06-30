package io.github.dietergandalf.bettertoolsmod.core.functions;

import java.util.List;

import io.github.dietergandalf.bettertoolsmod.collective.data.GlobalVariables;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EndPortalFrameBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BlockFunctions {
	// START: Checks whether specific_block equals to_check_block
	public static Boolean isSpecificBlock(Block specific_block, Block to_check_block) {
		if (specific_block == null || to_check_block == null) {
			return false;
		}
        return specific_block.equals(to_check_block);
    }
	public static Boolean isSpecificBlock(Block specific_block, ItemStack to_check_item_stack) {
		if (to_check_item_stack == null) {
			return false;
		}
		Item to_check_item = to_check_item_stack.getItem();
		if (to_check_item == null) {
			return false;
		}
		
		Block to_check_block = Block.byItem(to_check_item);
		return isSpecificBlock(specific_block, to_check_block);
	}
	public static Boolean isSpecificBlock(Block specific_block, Level world, BlockPos pos) {
		Block to_check_block = world.getBlockState(pos).getBlock();
		return isSpecificBlock(specific_block, to_check_block);
	}
	// END: Checks whether specific_block equals to_check_block
	
	public static void dropBlock(Level world, BlockPos pos) {
		BlockState block_state = world.getBlockState(pos);
		BlockEntity tile_entity = block_state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
		Block.dropResources(block_state, world, pos, tile_entity);
		world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
	}
	
	// START: Check whether the block to check is one of the blocks in the array.
	public static Boolean isOneOfBlocks(List<Block> blocks, Block to_check_block) {
		if (blocks.size() < 1) {
			return false;
		}
		
		for (Block specific_block : blocks) {
			if (isSpecificBlock(specific_block, to_check_block)) {
				return true;
			}
		}
		
		return false;
	}
	public static Boolean isOneOfBlocks(List<Block> blocks, ItemStack to_check_item_stack) {
		if (to_check_item_stack == null) {
			return false;
		}
		Item to_check_item = to_check_item_stack.getItem();
		if (to_check_item == null) {
			return false;
		}
		
		Block to_check_block = Block.byItem(to_check_item);
		return isOneOfBlocks(blocks, to_check_block);
	}
	public static Boolean isOneOfBlocks(List<Block> blocks, Level world, BlockPos pos) {
		Block to_check_block = world.getBlockState(pos).getBlock();
		return isOneOfBlocks(blocks, to_check_block);
	}
	// END: Check whether the block to check is one of the blocks in the array.
	
	// For bamboo
	public static boolean isGrowBlock(Block block) {
        return GlobalVariables.growblocks.contains(block);
    }
	
	public static boolean isStoneTypeBlock(Block block) {
        return GlobalVariables.stoneblocks.contains(block);
    }
	
	public static Boolean isFilledPortalFrame(BlockState block_state) {
		Block block = block_state.getBlock();
		if (!block.equals(Blocks.END_PORTAL_FRAME)) {
			return false;
		}
		
		return block_state.getValue(EndPortalFrameBlock.HAS_EYE);
	}
	
	public static String blockToReadableString(Block block, int amount) {
		String block_string;
		String[] block_split = block.getDescriptionId().replace("block.", "").split("\\.");
		if (block_split.length > 1) {
			block_string = block_split[1];
		}
		else {
			block_string = block_split[0];
		}
		
		block_string = block_string.replace("_", " ");
		if (amount > 1) {
			block_string = block_string + "s";
		}
		
		return block_string;
	}
	public static String blockToReadableString(Block block) {
		return blockToReadableString(block, 1);
	}
}