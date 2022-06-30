package io.github.dietergandalf.bettertoolsmod.core.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class Nightvision extends Enchantment{

  protected Nightvision(Rarity p_44676_, EnchantmentCategory p_44677_, EquipmentSlot... p_44678_) {
    super(p_44676_, p_44677_, p_44678_);
  }
  
  @Override
  public int getMaxLevel() {
    return 1;
  }
}
