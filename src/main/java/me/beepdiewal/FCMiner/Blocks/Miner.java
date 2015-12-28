package me.beepdiewal.FCMiner.Blocks;


import me.beepdiewal.FCMiner.Blocks.Tiles.MinerTile;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Miner extends GenericBlock {

  @Override
  public TileEntity createNewTileEntity(World world, int metadata) {
    return new MinerTile();
  }
}
