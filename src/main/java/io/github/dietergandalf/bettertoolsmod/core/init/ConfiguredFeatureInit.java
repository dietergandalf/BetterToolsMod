package io.github.dietergandalf.bettertoolsmod.core.init;

import java.util.List;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

import io.github.dietergandalf.bettertoolsmod.BetterToolsMod;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ConfiguredFeatureInit {
  public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, BetterToolsMod.MODID);

  private static final Supplier<List<OreConfiguration.TargetBlockState>> RUBY_OVERWORLD_REPLACEMENT = Suppliers.memoize(() -> List.of(
    OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlockInit.RUBY_ORE.get().defaultBlockState()),
    OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlockInit.DEEPSLATE_RUBY_ORE.get().defaultBlockState())
    ));

  private static final Supplier<List<OreConfiguration.TargetBlockState>> NETHERITE_NETHER_REPLACEMENT = Suppliers.memoize(() -> List.of(
    OreConfiguration.target(OreFeatures.NETHERRACK, Blocks.NETHERITE_BLOCK.defaultBlockState())
    ));

  private static final Supplier<List<OreConfiguration.TargetBlockState>> MOD_END_REPLACEMENT = Suppliers.memoize(() -> List.of(
    OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), Blocks.GLOWSTONE.defaultBlockState())
    ));
  
  
  public static final RegistryObject<ConfiguredFeature<?, ?>> RUBY_OVERWORLD_ORE = CONFIGURED_FEATURES.register("ruby_overworld_ore", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(RUBY_OVERWORLD_REPLACEMENT.get(), 4)));

  public static final RegistryObject<ConfiguredFeature<?, ?>> NETHERITE_NETHER_ORE = CONFIGURED_FEATURES.register("netherite_nether_ore", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHERITE_NETHER_REPLACEMENT.get(), 2)));

  public static final RegistryObject<ConfiguredFeature<?, ?>> GLOWSTONE_END_ORE = CONFIGURED_FEATURES.register("glowstone_end_ore", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(MOD_END_REPLACEMENT.get(), 3)));
}
