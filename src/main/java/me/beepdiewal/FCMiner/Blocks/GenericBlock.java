package me.beepdiewal.FCMiner.Blocks;

import me.beepdiewal.FCMiner.Blocks.Tiles.OreTile;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by beepbeat on 23.12.2015.
 */
public class GenericBlock extends BlockContainer {
    protected GenericBlock(Material p_i45394_1_) {
        super(Material.iron);
        setCreativeTab(CreativeTabs.tabBlock);
    }

    public GenericBlock() {
        super(Material.iron);
        setCreativeTab(CreativeTabs.tabBlock);
    }
    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return null;
    }


}
