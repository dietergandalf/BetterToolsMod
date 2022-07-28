package io.github.dietergandalf.bettertoolsmod.core.events;

import io.github.dietergandalf.bettertoolsmod.core.enchantment.ModEnchantments;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.SubscribeEvent;


public class TickHandler {


  @SubscribeEvent
  public void tick(net.minecraftforge.event.TickEvent.PlayerTickEvent event) {
    Player player = event.player;
    //if the player has the firemaster enchantment, add the fire_resistance effect to the player
    if(player.getInventory().getArmor(2).getEnchantmentLevel(ModEnchantments.FIREMASTER.get()) > 0) {
      player.addEffect(createEffect(MobEffects.FIRE_RESISTANCE, 2, 200, false, false, false));
    }

    //if player has the nightvision enchantment, add the nightvision effect to the player
    if(player.getInventory().getArmor(3).getEnchantmentLevel(ModEnchantments.NIGHTVISION.get()) > 0) {
      player.addEffect(createEffect(MobEffects.NIGHT_VISION, 500, 0, false, false, false));
    }
    
    //If player wears a full set of emerald armor, give them the Hero of the village effect
    if(player.getInventory().getArmor(0).getItem().toString().contains("emerald") && 
       player.getInventory().getArmor(1).getItem().toString().contains("emerald") && 
       player.getInventory().getArmor(2).getItem().toString().contains("emerald") && 
       player.getInventory().getArmor(3).getItem().toString().contains("emerald"))
    {
      player.addEffect(createEffect(MobEffects.HERO_OF_THE_VILLAGE, 4, 200, false, false, false));
    }

  }
  private MobEffectInstance createEffect(MobEffect effect, int duration, int amplifier, boolean ambient, boolean visible, boolean showIcon) {
    return new MobEffectInstance(effect, duration, amplifier, ambient, visible, showIcon);
  }
}