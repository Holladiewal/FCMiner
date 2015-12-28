package me.beepdiewal.FCMiner.Utils;
import me.beepdiewal.FCMiner.Refs.ModRefs;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public class NetworkHandler{
  private static SimpleNetworkWrapper INSTANCE;

  public static void init(){
    INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(ModRefs.ModId);

  }

  public static void sendToServer(IMessage message){
    INSTANCE.sendToServer(message);
  }

  public static void sendTo(IMessage message, EntityPlayerMP player){
    INSTANCE.sendTo(message, player);
  }

  public static void sendToAllAround(IMessage message, TargetPoint point){
    INSTANCE.sendToAllAround(message, point);
  }
/*
  /**
   * Will send the given packet to every player within 64 blocks of the XYZ of the XYZ packet.
   * @param message
   * @param world
   */
/*
  public static void sendToAllAround(MessageXYZ message, World world){
    INSTANCE.sendToAllAround(message, new TargetPoint(world.provider.dimensionId, message.x, message.y, message.z, 64D));
  }
*/

  public static void sendToAll(IMessage message){
    INSTANCE.sendToAll(message);
  }

  public static void sendToDimension(IMessage message, int dimensionId){
    INSTANCE.sendToDimension(message, dimensionId);
  }

}