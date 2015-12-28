package me.beepdiewal.FCMiner.Blocks.Tiles;

import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import me.beepdiewal.FCMiner.Utils.DescriptionHandler;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by beepbeat on 23.12.2015.
 */
public class GenericTile extends TileEntity {
    public GenericTile() {

    }
    @Override
    public Packet getDescriptionPacket(){
        ByteBuf buf = Unpooled.buffer();
        buf.writeInt(xCoord);
        buf.writeInt(yCoord);
        buf.writeInt(zCoord);
        writeToPacket(buf);
        return new FMLProxyPacket(buf, DescriptionHandler.CHANNEL);
    }

    public void writeToPacket(ByteBuf buf){

    }

    public void readFromPacket(ByteBuf buf){

    }

}
