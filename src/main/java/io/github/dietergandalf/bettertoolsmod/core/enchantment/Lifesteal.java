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

      if(pLevel == 1){
        attacker.heal(1);
      }
      if(pLevel == 2){
        attacker.heal(2);
      }
      if(pLevel == 3){
        attacker.heal(3);
      }
      if(pLevel == 4){
        attacker.heal(4);
      }
      if(pLevel == 5){
        attacker.heal(5);
      }
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