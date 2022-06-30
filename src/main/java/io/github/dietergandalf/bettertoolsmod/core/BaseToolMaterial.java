package io.github.dietergandalf.bettertoolsmod.core;

import java.util.function.Supplier;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

public class BaseToolMaterial implements Tier {

  private final float attackDamageBonus, speed;
  private final int enchantability, harvestLevel, durability;
  private final Supplier<Ingredient> repairMaterial;

  public BaseToolMaterial(
    float attackDamageBonus,
    float speed,
    int enchantability,
    int harvestLevel,
    int durability,
    Supplier<Ingredient> repairMaterial
  ) {
    this.attackDamageBonus = attackDamageBonus;
    this.speed = speed;
    this.enchantability = enchantability;
    this.harvestLevel = harvestLevel;
    this.durability = durability;
    this.repairMaterial = repairMaterial;
  }

  @Override
  public int getUses() {
    return this.durability;
  }

  @Override
  public float getSpeed() {
    return this.speed;
  }

  @Override
  public float getAttackDamageBonus() {
    return this.attackDamageBonus;
  }

  @Override
  public int getLevel() {
    return this.harvestLevel;
  }

  @Override
  public int getEnchantmentValue() {
    return this.enchantability;
  }

  @Override
  public @NotNull Ingredient getRepairIngredient() {
    return this.repairMaterial.get();
  }
}
