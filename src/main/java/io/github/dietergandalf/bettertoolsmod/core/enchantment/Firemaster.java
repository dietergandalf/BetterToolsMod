package io.github.dietergandalf.bettertoolsmod.core.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/**
 * The firemaster enchantment adds fire_resistance to the chestplate.
 * @author DieterGandalf
 * 
 */
public class Firemaster extends Enchantment{

  /**
   * Constructor for the firemaster enchantment.
   */
  protected Firemaster(Rarity rarity, EnchantmentCategory category, EquipmentSlot... eqipmentSlot) {
    super(rarity, category, eqipmentSlot);
  }
  
  /*Returns the max level of the enchantment.
   * @return 1
   * @see net.minecraft.world.item.enchantment.Enchantment#getMaxLevel()
  */
  @Override
  public int getMaxLevel() {
    return 1;
  }
}
