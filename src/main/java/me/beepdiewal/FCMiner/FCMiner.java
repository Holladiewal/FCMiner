package me.beepdiewal.FCMiner;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import me.beepdiewal.FCMiner.Blocks.GenericOre;
import me.beepdiewal.FCMiner.Blocks.Miner;
import me.beepdiewal.FCMiner.Blocks.Tiles.MinerTile;
import me.beepdiewal.FCMiner.Blocks.Tiles.OreTile;
import me.beepdiewal.FCMiner.Proxys.CommonProxy;
import me.beepdiewal.FCMiner.Refs.ModRefs;
import me.beepdiewal.FCMiner.Utils.DescriptionHandler;
import me.beepdiewal.FCMiner.Utils.NetworkHandler;
import net.minecraft.block.Block;

@Mod(modid = ModRefs.ModId, name = ModRefs.ModName, version = ModRefs.Version, dependencies = ModRefs.Dependencies)
public class FCMiner {

  @SidedProxy(clientSide = "me.beepdiewal.FCMiner.Proxys.ClientProxy", serverSide = "me.beepdiewal.FCMiner.Proxys.ServerProxy")
  public static CommonProxy proxy;
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        GameRegistry.registerBlock(new GenericOre("Iron"), "GenericOre");
        GameRegistry.registerTileEntity(OreTile.class, "GenericTile");

        GameRegistry.registerBlock(new Miner(), "Miner");
        GameRegistry.registerTileEntity(MinerTile.class, "MinerTile");

      DescriptionHandler.init();
      NetworkHandler.init();
    }
}
