package io.github.dietergandalf.bettertoolsmod.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class InventoryBlockEntity extends BlockEntity {
    
  public final int size;
  protected int timer;
  protected boolean requiresUpdate;
  
  public final ItemStackHandler inventory;
  protected LazyOptional<ItemStackHandler> inventoryHandler;
  
  public InventoryBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state, int size) {
    super(type, pos, state);
    if(size<=0){
      size = 1;
    }
    this.size = size;
    this.inventory = createInventory();
    this.inventoryHandler = LazyOptional.of(() -> this.inventory);

  }

  @Override
  public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side){
    return cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? this.inventoryHandler.cast() : super.getCapability(cap, side);
  }

  public LazyOptional<ItemStackHandler> getInventoryHandler() {
    return this.inventoryHandler;
  }


  protected ItemStackHandler createInventory() {
    return new ItemStackHandler(this.size){
      @Override
      public ItemStack extractItem(int slot, int amount, boolean simulate) {
        InventoryBlockEntity.this.update();
        return super.extractItem(slot, amount, simulate);
      }

      @Override
      public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
        InventoryBlockEntity.this.update();
        return super.insertItem(slot, stack, simulate);
      }
    };
  }

  @Override
  public Packet<ClientGamePacketListener> getUpdatePacket() {
    return ClientboundBlockEntityDataPacket.create(this);
  }

  @Override
  public CompoundTag getUpdateTag(){
    return serializeNBT();
  }

  @Override
  public void handleUpdateTag(CompoundTag tag) {
    super.handleUpdateTag(tag);
    load(tag);
  }

  @Override
  public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
    super.onDataPacket(net, pkt);
    handleUpdateTag(pkt.getTag());
  }

  @Override
  protected void saveAdditional(CompoundTag tag) {
    super.saveAdditional(tag);
    tag.put("inventory", this.inventory.serializeNBT());
  }

  @Override
  public void load(CompoundTag tag) {
    super.load(tag);
    this.inventory.deserializeNBT(tag.getCompound("inventory"));
  }

  @Override
  public void invalidateCaps() {
    super.invalidateCaps();
    this.inventoryHandler.invalidate();
  }

  public void update(){
    requestModelDataUpdate();
    setChanged();
    if(this.level != null){
      this.level.setBlockAndUpdate(this.worldPosition, getBlockState());
    }
  }

  public void tick(){
    this.timer++;
    if(this.requiresUpdate && this.level != null){
      update();
      this.requiresUpdate = false;
    }
  }

  public ItemStack extractItem(int slot){
    final int count = getItemInSlot(slot).getCount();
    this.requiresUpdate = true;
    return this.inventoryHandler.map(inv -> inv.extractItem(slot, count, false)).orElse(ItemStack.EMPTY);
  }

  public ItemStack getItemInSlot(int slot) {
    return this.inventoryHandler.map(inv -> inv.getStackInSlot(slot)).orElse(ItemStack.EMPTY);
  }

  public ItemStack insertItem(int slot, ItemStack stack) {
    ItemStack copy = stack.copy();
    stack.shrink(copy.getCount());
    this.requiresUpdate = true;
    return this.inventoryHandler.map(inv -> inv.insertItem(slot, copy, false)).orElse(ItemStack.EMPTY);
  }
}
