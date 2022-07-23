package io.github.dietergandalf.bettertoolsmod.core.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class AreaMiner extends Enchantment {
  protected AreaMiner(Rarity rarity, EnchantmentCategory category, EquipmentSlot... eqipmentSlot) {
    super(rarity, category, eqipmentSlot);
  }

  @Override
  public int getMaxLevel() {
    return 3;
  }

}
  
