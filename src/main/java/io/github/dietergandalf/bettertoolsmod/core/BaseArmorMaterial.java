package io.github.dietergandalf.bettertoolsmod.core;

import java.util.function.Supplier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public class BaseArmorMaterial implements ArmorMaterial {

  private final int enchantability;
  private final int[] durability, damageReduction;
  private final float toughness, knockbackResistance;
  private final String name;
  private final SoundEvent equipSound;
  private final Supplier<Ingredient> repairMaterial;

  public BaseArmorMaterial(
    int enchantability,
    int[] durability,
    int[] damageReduction,
    float toughness,
    float knockbackResistance,
    String name,
    SoundEvent equipSound,
    Supplier<Ingredient> repairMaterial
  ) {
    this.enchantability = enchantability;
    this.durability = durability;
    this.damageReduction = damageReduction;
    this.toughness = toughness;
    this.knockbackResistance = knockbackResistance;
    this.name = name;
    this.equipSound = equipSound;
    this.repairMaterial = repairMaterial;
  }

  @Override
  public int getDurabilityForSlot(EquipmentSlot slot) {
    return this.durability[slot.getIndex()];
  }

  @Override
  public int getDefenseForSlot(EquipmentSlot slot) {
    return this.damageReduction[slot.getIndex()];
  }

  @Override
  public int getEnchantmentValue() {
    return this.enchantability;
  }

  @Override
  public SoundEvent getEquipSound() {
    return this.equipSound;
  }

  @Override
  public Ingredient getRepairIngredient() {
    return this.repairMaterial.get();
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public float getToughness() {
    return this.toughness;
  }

  @Override
  public float getKnockbackResistance() {
    return this.knockbackResistance;
  }
}
