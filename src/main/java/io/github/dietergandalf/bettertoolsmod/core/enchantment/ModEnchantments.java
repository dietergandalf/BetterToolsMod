package io.github.dietergandalf.bettertoolsmod.core.enchantment;

import io.github.dietergandalf.bettertoolsmod.BetterToolsMod;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantments {
  public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, BetterToolsMod.MODID);

  public static final RegistryObject<Enchantment> LIGHTNING_STRIKER = ENCHANTMENTS.register("lightning_striker", () -> new LightningStriker(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));

  public static final RegistryObject<Enchantment> LIFESTEAL = ENCHANTMENTS.register("lifesteal", () -> new Lifesteal(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND));

  public static final RegistryObject<Enchantment> RAMMUS_SHIELD = ENCHANTMENTS.register("rammus_shield", () -> new RammusShield(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.ARMOR_CHEST, EquipmentSlot.CHEST));

  public static final RegistryObject<Enchantment> FIREMASTER = ENCHANTMENTS.register("firemaster", () -> new Firemaster(Enchantment.Rarity.RARE, EnchantmentCategory.ARMOR_CHEST, EquipmentSlot.CHEST));

  public static final RegistryObject<Enchantment> NIGHTVISION = ENCHANTMENTS.register("nightvision", () -> new Nightvision(Enchantment.Rarity.RARE, EnchantmentCategory.ARMOR_HEAD, EquipmentSlot.HEAD));

  public static final RegistryObject<Enchantment> AREA_MINER = ENCHANTMENTS.register("area_miner", () -> new AreaMiner(Enchantment.Rarity.RARE, EnchantmentCategory.DIGGER, EquipmentSlot.MAINHAND));

  public static void register(IEventBus eventBus){
    ENCHANTMENTS.register(eventBus);
  }
}
