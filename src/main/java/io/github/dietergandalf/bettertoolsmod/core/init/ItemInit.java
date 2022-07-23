package io.github.dietergandalf.bettertoolsmod.core.init;

import io.github.dietergandalf.bettertoolsmod.BetterToolsMod;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {

  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(
    ForgeRegistries.ITEMS,
    BetterToolsMod.MODID
  );

  public static final RegistryObject<Item> RUBY = ITEMS.register(
    "ruby",
    () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS))
  );
  //Tools

  public static final RegistryObject<ShovelItem> RUBY_NETHERITE_SHOVEL = ITEMS.register(
    "ruby_netherite_shovel",
    () ->
      new ShovelItem(
        ToolMaterialInit.RUBY_NETHERITE,
        6,
        1.3F,
        new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)
      )
  );
  public static final RegistryObject<PickaxeItem> EMERALD_PICKAXE = ITEMS.register(
    "ruby_netherite_pickaxe",
    () ->
      new PickaxeItem(
        ToolMaterialInit.RUBY_NETHERITE,
        7,
        1.5F,
        new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)
      )
  );
  public static final RegistryObject<AxeItem> RUBY_NETHERITE_AXE = ITEMS.register(
    "ruby_netherite_axe",
    () ->
      new AxeItem(
        ToolMaterialInit.RUBY_NETHERITE,
        11,
        3F,
        new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)
      )
  );
  public static final RegistryObject<HoeItem> RUBY_NETHERITE_HOE = ITEMS.register(
    "ruby_netherite_hoe",
    () ->
      new HoeItem(
        ToolMaterialInit.RUBY_NETHERITE,
        5,
        1,
        new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)
      )
  );
  public static final RegistryObject<SwordItem> RUBY_NETHERITE_SWORD = ITEMS.register(
    "ruby_netherite_sword",
    () ->
      new SwordItem(
        ToolMaterialInit.RUBY_NETHERITE,
        9,
        1.25F,
        new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)
      )
  );
  public static final RegistryObject<ArmorItem> RUBY_NETHERITE_HELMET = ITEMS.register(
    "ruby_netherite_helmet",
    () ->
      new // Armor
      ArmorItem(
        ArmorMaterialInit.RUBY_NETHERITE,
        EquipmentSlot.HEAD,
        new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)
      )
  );
  public static final RegistryObject<ArmorItem> RUBY_NETHERITE_CHESTPLATE = ITEMS.register(
    "ruby_netherite_chestplate",
    () ->
      new ArmorItem(
        ArmorMaterialInit.RUBY_NETHERITE,
        EquipmentSlot.CHEST,
        new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)
      )
  );
  public static final RegistryObject<ArmorItem> RUBY_NETHERITE_LEGGINGS = ITEMS.register(
    "ruby_netherite_leggings",
    () ->
      new ArmorItem(
        ArmorMaterialInit.RUBY_NETHERITE,
        EquipmentSlot.LEGS,
        new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)
      )
  );
  public static final RegistryObject<ArmorItem> RUBY_NETHERITE_BOOTS = ITEMS.register(
    "ruby_netherite_boots",
    () ->
      new ArmorItem(
        ArmorMaterialInit.RUBY_NETHERITE,
        EquipmentSlot.FEET,
        new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)
      )
  );




  public static final RegistryObject<ShovelItem> EMERALD_SHOVEL = ITEMS.register(
    "emerald_shovel",
    () ->
      new ShovelItem(
        ToolMaterialInit.EMERALD,
        6,
        1.3F,
        new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)
      )
  );
  public static final RegistryObject<PickaxeItem> RUBY_NETHERITE_PICKAXE = ITEMS.register(
    "emerald_pickaxe",
    () ->
      new PickaxeItem(
        ToolMaterialInit.EMERALD,
        7,
        1.5F,
        new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)
      )
  );
  public static final RegistryObject<AxeItem> EMERALD_AXE = ITEMS.register(
    "emerald_axe",
    () ->
      new AxeItem(
        ToolMaterialInit.EMERALD,
        11,
        3F,
        new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)
      )
  );
  public static final RegistryObject<HoeItem> EMERALD_HOE = ITEMS.register(
    "emerald_hoe",
    () ->
      new HoeItem(
        ToolMaterialInit.EMERALD,
        5,
        1,
        new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)
      )
  );
  public static final RegistryObject<SwordItem> EMERALD_SWORD = ITEMS.register(
    "emerald_sword",
    () ->
      new SwordItem(
        ToolMaterialInit.EMERALD,
        9,
        1.25F,
        new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)
      )
  );
  public static final RegistryObject<ArmorItem> EMERALD_HELMET = ITEMS.register(
    "emerald_helmet",
    () ->
      new // Armor
      ArmorItem(
        ArmorMaterialInit.EMERALD,
        EquipmentSlot.HEAD,
        new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)
      )
  );
  public static final RegistryObject<ArmorItem> EMERALD_CHESTPLATE = ITEMS.register(
    "emerald_chestplate",
    () ->
      new ArmorItem(
        ArmorMaterialInit.EMERALD,
        EquipmentSlot.CHEST,
        new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)
      )
  );
  public static final RegistryObject<ArmorItem> EMERALD_LEGGINGS = ITEMS.register(
    "emerald_leggings",
    () ->
      new ArmorItem(
        ArmorMaterialInit.EMERALD,
        EquipmentSlot.LEGS,
        new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)
      )
  );
  public static final RegistryObject<ArmorItem> EMERALD_BOOTS = ITEMS.register(
    "emerald_boots",
    () ->
      new ArmorItem(
        ArmorMaterialInit.EMERALD,
        EquipmentSlot.FEET,
        new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)
      )
  );



  //public static final RegistryObject<Item> SUPER_FOOD = ITEMS.register("super_food", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(FoodInit.SUPER_FOOD)));


}
