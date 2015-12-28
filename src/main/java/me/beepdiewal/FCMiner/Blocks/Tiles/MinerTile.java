package me.beepdiewal.FCMiner.Blocks.Tiles;

import me.beepdiewal.FCMiner.Blocks.GenericOre;
import me.beepdiewal.FCMiner.Utils.BlockPos;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class MinerTile extends GenericTile {
    private BlockPos blockPos = null;
    private int counter = 0;
    @Override
    public void updateEntity() {
      //if (worldObj.isRemote) return;
        //region OreFinding
      if (blockPos == null) {
        for (int i = -1; i < 0;i++){
            if (worldObj.getBlock(xCoord + 1, yCoord, zCoord) instanceof GenericOre) {
                blockPos = new BlockPos(xCoord + 1, yCoord, zCoord); break;
            }
            if (worldObj.getBlock(xCoord - 1, yCoord, zCoord) instanceof GenericOre) {
                blockPos = new BlockPos(xCoord - 1, yCoord, zCoord); break;
            }
            if (worldObj.getBlock(xCoord, yCoord + 1, zCoord) instanceof GenericOre) {
                blockPos = new BlockPos(xCoord, yCoord + 1, zCoord); break;
            }
            if (worldObj.getBlock(xCoord, yCoord - 1, zCoord) instanceof GenericOre) {
                blockPos = new BlockPos(xCoord, yCoord - 1, zCoord); break;
            }
            if (worldObj.getBlock(xCoord, yCoord, zCoord + 1) instanceof GenericOre) {
                blockPos = new BlockPos(xCoord, yCoord, zCoord + 1); break;
            }
            if (worldObj.getBlock(xCoord, yCoord, zCoord - 1) instanceof GenericOre) {
                blockPos = new BlockPos(xCoord, yCoord, zCoord - 1); break;
            }
        }
        if (blockPos == null) {
            return;
        }
      }
      //endregion
        if (worldObj.getBlock(blockPos.x, blockPos.y, blockPos.z) instanceof GenericOre) {
            GenericOre ore = (GenericOre) worldObj.getBlock(blockPos.x, blockPos.y, blockPos.z);
        }
      counter++;
      if (counter % 10 != 0) return;

      OreTile tile = (OreTile) worldObj.getTileEntity(blockPos.x, blockPos.y, blockPos.z);
      int x = tile.mineOre(64);
      if (x > 0) {
        if (!worldObj.isRemote) {
          worldObj.spawnEntityInWorld(new EntityItem(worldObj, blockPos.x, blockPos.y + 1, blockPos.z, new ItemStack(Blocks.iron_ore, x)));
        }
      }
      else
        worldObj.setBlock(blockPos.x, blockPos.y, blockPos.z, Blocks.air);
      blockPos = null;
    }
}
