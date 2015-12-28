package me.beepdiewal.FCMiner.Blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.beepdiewal.FCMiner.Blocks.Tiles.OreTile;
import me.beepdiewal.FCMiner.FCMiner;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class GenericOre extends GenericBlock {
    private String OreType;
    protected GenericOre(Material p_i45394_1_) {
        super(Material.rock);
        needsRandomTick = false;

    }
    public GenericOre(String oreType){
        new GenericOre(Material.air);
        OreType = oreType;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
      return new OreTile("Iron");
    }
    @Override
    @SideOnly(Side.CLIENT)
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitx, float hity, float hitz) {
      if (!world.isRemote) return true;
      world.markBlockForUpdate(x, y, z);
      player.addChatComponentMessage(new ChatComponentText("OreType: " + ((OreTile) world.getTileEntity(x, y, z)).getOreType() + " Ore remaining: " + ((OreTile) world.getTileEntity(x, y, z)).getOreRemaining()));
      return true;
    }

}
