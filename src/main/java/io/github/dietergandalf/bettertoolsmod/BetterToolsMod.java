package io.github.dietergandalf.bettertoolsmod;

import io.github.dietergandalf.bettertoolsmod.config.ConfigHandler;
import io.github.dietergandalf.bettertoolsmod.core.enchantment.ModEnchantments;
import io.github.dietergandalf.bettertoolsmod.core.events.MiningEvent;
import io.github.dietergandalf.bettertoolsmod.core.events.TickHandler;
import io.github.dietergandalf.bettertoolsmod.core.init.BlockInit;
import io.github.dietergandalf.bettertoolsmod.core.init.ItemInit;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.ModLoadingContext;

@Mod(BetterToolsMod.MODID)
public class BetterToolsMod {

  public static BetterToolsMod instance;
  public static final String MODID = "bettertoolsmod";

  public BetterToolsMod() {
    instance = this;
    ModLoadingContext modLoadingContext = ModLoadingContext.get();
    IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    modEventBus.addListener(this::loadComplete);
    modLoadingContext.registerConfig(Type.COMMON, ConfigHandler.spec);

    BlockInit.BLOCKS.register(modEventBus);
    ItemInit.ITEMS.register(modEventBus);
    ModEnchantments.register(modEventBus);
    //OreGeneration.registerOres();
  }

  /*
  public static final CreativeModeTab TAB = new CreativeModeTab(MODID) {
    @Override
    public @NotNull ItemStack makeIcon() {
      return ItemInit.RUBY.get().getDefaultInstance();
    }
  };
  */

  private void loadComplete(FMLLoadCompleteEvent event){
    MinecraftForge.EVENT_BUS.register(new MiningEvent());
    MinecraftForge.EVENT_BUS.register(new TickHandler());
  }

}
