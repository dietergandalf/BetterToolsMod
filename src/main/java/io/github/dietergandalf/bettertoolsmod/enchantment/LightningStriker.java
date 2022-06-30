package io.github.dietergandalf.bettertoolsmod.enchantment;

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

public class LightningStriker extends Enchantment{

  protected LightningStriker(Rarity rarity, EnchantmentCategory category, EquipmentSlot... slots) {
    super(rarity, category, slots);
  }
  

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

  @Override
  public int getMaxLevel() {
    return 5;
  }

}
