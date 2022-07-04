package io.github.dietergandalf.bettertoolsmod.core.enchantment;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/**
 * An enchantment that creates a lightning strike when the weapon is used.
 * Max Lvl: 5
 * @author DieterGandalf
 */
public class LightningStriker extends Enchantment{

  /*
   * Constructor for the LightningStriker enchantment.
   */
  protected LightningStriker(Rarity rarity, EnchantmentCategory category, EquipmentSlot... slots) {
    super(rarity, category, slots);
  }
  

  /*
   * Creates a lightning strike when the weapon is used.
   * Scales with the lvl of the enchantment.
   */
  @Override
  public void doPostAttack(LivingEntity attacker, Entity target, int pLevel) {
    if (!attacker.level.isClientSide()){
      ServerLevel world = (ServerLevel) attacker.level;
      ServerPlayer player = (ServerPlayer) attacker;
      BlockPos position = target.blockPosition();

      attacker.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1, 10));

      if(pLevel == 1){
        EntityType.LIGHTNING_BOLT.spawn(world, null, player, position, MobSpawnType.TRIGGERED, true, true);
      }
      if(pLevel == 2){
        EntityType.LIGHTNING_BOLT.spawn(world, null, player, position, MobSpawnType.TRIGGERED, true, true);
        EntityType.LIGHTNING_BOLT.spawn(world, null, player, position, MobSpawnType.TRIGGERED, true, true);
      }
      if(pLevel == 3){
        EntityType.LIGHTNING_BOLT.spawn(world, null, player, position, MobSpawnType.TRIGGERED, true, true);
        EntityType.LIGHTNING_BOLT.spawn(world, null, player, position, MobSpawnType.TRIGGERED, true, true);
        EntityType.LIGHTNING_BOLT.spawn(world, null, player, position, MobSpawnType.TRIGGERED, true, true);
        
      }
      if(pLevel == 4){
        EntityType.LIGHTNING_BOLT.spawn(world, null, player, position, MobSpawnType.TRIGGERED, true, true);
        EntityType.LIGHTNING_BOLT.spawn(world, null, player, position, MobSpawnType.TRIGGERED, true, true);
        EntityType.LIGHTNING_BOLT.spawn(world, null, player, position, MobSpawnType.TRIGGERED, true, true);
        EntityType.LIGHTNING_BOLT.spawn(world, null, player, position, MobSpawnType.TRIGGERED, true, true);
      }
      if(pLevel == 5){
        EntityType.LIGHTNING_BOLT.spawn(world, null, player, position, MobSpawnType.TRIGGERED, true, true);
        EntityType.LIGHTNING_BOLT.spawn(world, null, player, position, MobSpawnType.TRIGGERED, true, true);
        EntityType.LIGHTNING_BOLT.spawn(world, null, player, position, MobSpawnType.TRIGGERED, true, true);
        EntityType.LIGHTNING_BOLT.spawn(world, null, player, position, MobSpawnType.TRIGGERED, true, true);
        EntityType.LIGHTNING_BOLT.spawn(world, null, player, position, MobSpawnType.TRIGGERED, true, true);
      }
    }

    super.doPostAttack(attacker, target, pLevel);
  }

  /*
   * Returns the max level of the enchantment.
   * @return 5
   * @see net.minecraft.world.item.enchantment.Enchantment#getMaxLevel()
   */
  @Override
  public int getMaxLevel() {
    return 5;
  }

}
