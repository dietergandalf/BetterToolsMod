package io.github.dietergandalf.bettertoolsmod.core.enchantment;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/**
 * The RammusShield enchantment adds thorn_damage and protection to the armor.
 * @author DieterGandalf
 *
 */
public class RammusShield extends Enchantment {

  protected RammusShield(Rarity rarity, EnchantmentCategory category, EquipmentSlot... slots) {
    super(rarity, category, slots);
  }
  
  @Override
  public int getDamageProtection(int damage, DamageSource source) {
    if (source.getEntity() instanceof Entity) {
      
      damage = damage / 2;
      super.getDamageProtection(damage, source);
      return damage;
    }
    return 0;
  }

  @Override
  public void doPostHurt(LivingEntity target, Entity attacker, int enchantmentLevel) {
    if (!target.level.isClientSide()){

      if(enchantmentLevel == 1){
        attacker.hurt(target.getLastDamageSource(), 2.0F);
      }
      if(enchantmentLevel == 2){
        attacker.hurt(target.getLastDamageSource(), 4.0F);
      }
      if(enchantmentLevel == 3){
        attacker.hurt(target.getLastDamageSource(), 6.0F);
      }
      if(enchantmentLevel == 4){
        attacker.hurt(target.getLastDamageSource(), 8.0F);
      }
      if(enchantmentLevel == 5){
        attacker.hurt(target.getLastDamageSource(), 10.0F);
      }
    }
    super.doPostHurt(target, attacker, enchantmentLevel);
  }

  @Override
  public int getMaxLevel() {
    return 5;
  }

}
