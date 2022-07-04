package io.github.dietergandalf.bettertoolsmod.core.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/*
 * The Nightvision enchantment adds Nightvision to the helmet.
 * @author DieterGandalf
 */
public class Nightvision extends Enchantment{

  protected Nightvision(Rarity p_44676_, EnchantmentCategory p_44677_, EquipmentSlot... p_44678_) {
    super(p_44676_, p_44677_, p_44678_);
  }
  
  /*
   * Returns the max level of the enchantment.
   * @return 1
   */
  @Override
  public int getMaxLevel() {
    return 1;
  }
}
