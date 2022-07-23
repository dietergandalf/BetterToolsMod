package io.github.dietergandalf.bettertoolsmod.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.Builder;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class ConfigHandler {
    private static final Builder BUILDER = new Builder();
    public static final ConfigHandler.General GENERAL;
    public static final ForgeConfigSpec spec;

    public ConfigHandler() {
    }

    static {
        GENERAL = new ConfigHandler.General(BUILDER);
        spec = BUILDER.build();
    }

    public static class General {
        public final ConfigValue<Double> extraMineralChanceOnOverworldStoneBreak;
        public final ConfigValue<Double> extraMineralChanceOnNetherStoneBreak;
        public final ConfigValue<Boolean> enableOverworldMinerals;
        public final ConfigValue<Boolean> enableNetherMinerals;
        public final ConfigValue<Boolean> sendMessageOnMineralFind;
        public final ConfigValue<String> foundMineralMessage;
        public final ConfigValue<Boolean> ignoreFakePlayers;

        public General(Builder builder) {
            builder.push("General");
            this.extraMineralChanceOnOverworldStoneBreak = builder.comment("The chance a mineral is dropped when an overworld stone block is broken. By default 1/100.").defineInRange("extraMineralChanceOnOverworldStoneBreak", 0.01D, 0.0D, 1.0D);
            this.extraMineralChanceOnNetherStoneBreak = builder.comment("The chance a mineral is dropped when a nether stone block is broken. By default 1/100.").defineInRange("extraMineralChanceOnNetherStoneBreak", 0.01D, 0.0D, 1.0D);
            this.enableOverworldMinerals = builder.comment("If enabled, mining overworld stone blocks in the overworld has a chance to drop an overworld mineral. These consist of diamonds, gold nuggets, iron nuggets, lapis lazuli, redstone and emeralds.").define("enableOverworldMinerals", true);
            this.enableNetherMinerals = builder.comment("If enabled, mining nether stone blocks in the nether has a chance to drop a nether mineral. These consist of quartz and gold nuggets.").define("enableNetherMinerals", true);
            this.sendMessageOnMineralFind = builder.comment("If enabled, sends a message when a mineral is found to the player who broke the stone block.").define("sendMessageOnMineralFind", true);
            this.foundMineralMessage = builder.comment("The message sent to the player who found a hidden mineral when 'sendMessageOnMineralFind' is enabled.").define("foundMineralMessage", "You've found %s hidden in the block!");
            this.ignoreFakePlayers = builder.comment("If enabled, minerals won't be dropped if the player is a fake. For example when a mod breaks a block as a simulated player.").define("ignoreFakePlayers", true);
            builder.pop();
        }
    }
  }
