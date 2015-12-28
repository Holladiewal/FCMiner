package me.beepdiewal.FCMiner.Utils;
import cpw.mods.fml.common.patcher.GenDiffSet;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import me.beepdiewal.FCMiner.Blocks.GenericOre;
import me.beepdiewal.FCMiner.Blocks.Tiles.GenericTile;
import me.beepdiewal.FCMiner.FCMiner;
import me.beepdiewal.FCMiner.Refs.ModRefs;
import net.minecraft.tileentity.TileEntity;


import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;

@Sharable
public class DescriptionHandler extends SimpleChannelInboundHandler<FMLProxyPacket>{
  public static final String CHANNEL = ModRefs.ModId + "Description";

  static {
    NetworkRegistry.INSTANCE.newChannel(CHANNEL, new DescriptionHandler());
  }

  public static void init(){
    //not actually doing anything here, apart from loading the class. If the channel registry goes in here, Netty will throw a duplicate
    //channel error.
  }

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, FMLProxyPacket msg) throws Exception{
    ByteBuf buf = msg.payload();
    int x = buf.readInt();
    int y = buf.readInt();
    int z = buf.readInt();
    TileEntity te = FCMiner.proxy.getClientPlayer().worldObj.getTileEntity(x, y, z);
    if(te instanceof GenericTile) {
      ((GenericTile)te).readFromPacket(buf);
    }
  }

}