package io.github.dietergandalf.bettertoolsmod.collective.functions;

import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class WorldFunctions {

  public static Level getWorldIfInstanceOfAndNotRemote(LevelAccessor world) {
    
    if (world instanceof Level) {
      return (Level)world;
    }
    
    return null;
  }

  public static boolean isOverworld(Level world) {
    return world.dimension().equals(Level.OVERWORLD);
  }

  public static boolean isNether(Level world) {
    return world.dimension().equals(Level.NETHER);
  }
  
}
