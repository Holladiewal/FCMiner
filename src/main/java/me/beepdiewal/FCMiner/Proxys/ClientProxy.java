package me.beepdiewal.FCMiner.Proxys;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by beepbeat/holladiewal on 24.12.2015.
 */
public class ClientProxy extends CommonProxy {
  @Override
  public void preInit() {

  }

  @Override
  public void init() {

  }

  @Override
  public void postInit() {

  }

  @Override
  public EntityPlayer getClientPlayer() {
    return Minecraft.getMinecraft().thePlayer;
  }
}
