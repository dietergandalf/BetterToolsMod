package io.github.dietergandalf.bettertoolsmod.core.init;

import io.github.dietergandalf.bettertoolsmod.BetterToolsMod;
import io.github.dietergandalf.bettertoolsmod.core.BaseArmorMaterial;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public final class ArmorMaterialInit {

  private ArmorMaterialInit() {}

  public static final ArmorMaterial RUBY_NETHERITE = new BaseArmorMaterial(
    500,
    new int[] { 1400, 1800, 1600, 1400 },
    new int[] { 14, 18, 16, 14 },
    12.0F,
    0.5F,
    BetterToolsMod.MODID + ":ruby_netherite",
    SoundEvents.ARMOR_EQUIP_NETHERITE,
    () -> Ingredient.of(ItemInit.RUBY.get())
  );

  public static final ArmorMaterial EMERALD = new BaseArmorMaterial(
    500,
    new int[] { 400, 600, 600, 400 },
    new int[] { 3, 5, 4, 2 },
    1.0F,
    0.0F,
    BetterToolsMod.MODID + ":emerald",
    SoundEvents.ARMOR_EQUIP_DIAMOND,
    () -> Ingredient.of(Items.EMERALD)
  );
}
