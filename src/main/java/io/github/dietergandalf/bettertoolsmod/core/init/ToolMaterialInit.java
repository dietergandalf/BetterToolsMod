package io.github.dietergandalf.bettertoolsmod.core.init;

import io.github.dietergandalf.bettertoolsmod.core.BaseToolMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public final class ToolMaterialInit {

  private ToolMaterialInit() {}

  public static final Tier RUBY_NETHERITE = new BaseToolMaterial(
    5.5F,
    75F,
    100,
    7,
    2500,
    () -> Ingredient.of(ItemInit.RUBY.get())
  );

  public static final Tier EMERALD = new BaseToolMaterial(
    -2.5F,
    40F,
    100,
    4,
    500,
    () -> Ingredient.of(Items.EMERALD)
  );
}
