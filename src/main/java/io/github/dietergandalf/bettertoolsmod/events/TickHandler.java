package io.github.dietergandalf.bettertoolsmod.events;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.SubscribeEvent;


public class TickHandler {


  @SubscribeEvent
  public void tick(net.minecraftforge.event.TickEvent.PlayerTickEvent event) {
    Player player = event.player;
    //if the player has the firemaster enchantment, add the fireresistance effect to the player
    if(player.getInventory().getArmor(2).isEnchanted() && player.getInventory().getArmor(2).getEnchantmentTags().getAsString().contains("bettertoolsmod:firemaster")) {
      player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 2, 200, false, false, false));
    }

    //if player has the nightvision enchantment, add the nightvision effect to the player
    if(player.getInventory().getArmor(3).isEnchanted() && player.getInventory().getArmor(3).getEnchantmentTags().getAsString().contains("bettertoolsmod:nightvision")) {
      player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 500, 0, false, false, false));
    }
    
    //If player wears a full set of emerald armor, give them the Hero of the village effect
    if(player.getInventory().getArmor(0).getItem().toString().contains("emerald") && player.getInventory().getArmor(1).getItem().toString().contains("emerald") && player.getInventory().getArmor(2).getItem().toString().contains("emerald") && player.getInventory().getArmor(3).getItem().toString().contains("emerald")){
      player.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 4, 200, false, false, false));
    }

  }
}