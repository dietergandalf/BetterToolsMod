package io.github.dietergandalf.bettertoolsmod.core.init;

import io.github.dietergandalf.bettertoolsmod.BetterToolsMod;
import java.util.function.Supplier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {

  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(
    ForgeRegistries.BLOCKS,
    BetterToolsMod.MODID
  );

  //Naturally spawning ores
  public static final RegistryObject<Block> RUBY_ORE = register(
    "ruby_ore",
    () ->
      new Block(
        BlockBehaviour.Properties
          .of(Material.STONE)
          .requiresCorrectToolForDrops()
          .strength(2.0F, 3.0F)
          .friction(0.8F)
      ),
    new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)
  );
  public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = register(
    "deepslate_ruby_ore",
    () ->
      new Block(
        BlockBehaviour.Properties
          .of(Material.STONE)
          .requiresCorrectToolForDrops()
          .strength(2.5F, 3.0F)
          .friction(0.8F)
      ),
    new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)
  );

  //block of ruby
  public static final RegistryObject<Block> RUBY_BLOCK = register(
    "ruby_block",
    () ->
      new Block(
        BlockBehaviour.Properties
          .of(Material.AMETHYST)
          .strength(2.5F, 18F)
          .requiresCorrectToolForDrops()
          .strength(3.0F, 3.0F)
          .friction(0.8F)
      ),
    new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)
  );

  //register blocks
  private static <T extends Block> RegistryObject<T> register(
    String name,
    Supplier<T> supplier,
    Item.Properties properties
  ) {
    RegistryObject<T> block = BLOCKS.register(name, supplier);
    ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), properties));
    return block;
  }
}
