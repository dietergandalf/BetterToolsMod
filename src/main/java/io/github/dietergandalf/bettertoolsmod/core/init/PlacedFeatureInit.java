package io.github.dietergandalf.bettertoolsmod.core.init;

import java.util.List;

import io.github.dietergandalf.bettertoolsmod.BetterToolsMod;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class PlacedFeatureInit {
  public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, BetterToolsMod.MODID);

  public static final RegistryObject<PlacedFeature> RUBY_OVERWORLD_ORE = PLACED_FEATURES.register("ruby_overworld_ore", () -> new PlacedFeature(ConfiguredFeatureInit.RUBY_OVERWORLD_ORE.getHolder().get(), commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(60)))));

  public static final RegistryObject<PlacedFeature> NETHERITE_NETHER_ORE = PLACED_FEATURES.register("netherite_nether_ore", () -> new PlacedFeature(ConfiguredFeatureInit.NETHERITE_NETHER_ORE.getHolder().get(), commonOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.top()))));

  public static final RegistryObject<PlacedFeature> GLOWSTONE_END_ORE = PLACED_FEATURES.register("glowstone_end_ore", () -> new PlacedFeature(ConfiguredFeatureInit.GLOWSTONE_END_ORE.getHolder().get(), commonOrePlacement(170, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top()))));

  private static List<PlacementModifier> commonOrePlacement(int countPerChunk, PlacementModifier height){
    return OrePlacement(CountPlacement.of(countPerChunk), height);
  }

  private static List<PlacementModifier> OrePlacement(PlacementModifier count, PlacementModifier height){
    return List.of(count, InSquarePlacement.spread(), height, BiomeFilter.biome());
  }
}
