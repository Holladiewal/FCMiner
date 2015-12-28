package me.beepdiewal.FCMiner.Proxys;

import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by beepbeat/holladiewal on 24.12.2015.
 */
public abstract class CommonProxy{
  public abstract void preInit();

  public abstract void init();

  public abstract void postInit();

  public abstract EntityPlayer getClientPlayer();
}
