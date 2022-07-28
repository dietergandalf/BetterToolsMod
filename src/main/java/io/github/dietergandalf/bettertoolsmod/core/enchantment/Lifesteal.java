package io.github.dietergandalf.bettertoolsmod.core.enchantment;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/**
 * The Lifesteal enchantment adds Lifesteal to a weapon.
 * Max Lvl: 5
 * @author DieterGandalf
 *
 */
public class Lifesteal extends Enchantment{

  /*
   * Constructor for the Lifesteal enchantment.
   */
  protected Lifesteal(Rarity rarity, EnchantmentCategory category, EquipmentSlot... slots) {
    super(rarity, category, slots);
  }
  

  /*
   * Heals the attacker when the weapon is used.
   * Scales with the lvl of the enchantment.
   */
  @Override
  public void doPostAttack(LivingEntity attacker, Entity target, int pLevel) {
    if (!attacker.level.isClientSide()){
      attacker.heal(pLevel);
    }

    super.doPostAttack(attacker, target, pLevel);
  }

  /**
   * Returns the max level of the enchantment.
   * @return 5
   */
  @Override
  public int getMaxLevel() {
    return 5;
  }

}