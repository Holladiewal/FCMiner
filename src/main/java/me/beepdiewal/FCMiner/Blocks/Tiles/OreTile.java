package me.beepdiewal.FCMiner.Blocks.Tiles;

import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;

public class OreTile extends GenericTile {
    private int OreRemaining = 0;
    private String OreType;

    public OreTile(String OreType){
        OreRemaining = (int) (Math.random() * 2500 + 2500);
        this.OreType = OreType;
    }

    public OreTile(){
      OreRemaining = 1;
      OreType = "N/A";
    }


    public String getOreType(){
        return OreType;
    }

    public int getOreRemaining(){
        return OreRemaining;
    }
    public int mineOre(int i){
      if (OreRemaining - i >= 0){
        OreRemaining -= i;
        return i;
      }
      OreRemaining = 0;
      return OreRemaining;
      //return OreRemaining - i >= 0 ? i : OreRemaining;
    }

    @Override
    public void writeToPacket(ByteBuf buf) {
        //super.writeToPacket(buf);
        //buf.setInt(0, OreRemaining);
    }

  @Override
  public void readFromPacket(ByteBuf buf) {
    OreRemaining = buf.getInt(0);
  }

  @Override
  public void writeToNBT(NBTTagCompound cmp) {
    super.writeToNBT(cmp);
    cmp.setInteger("OreRemaining", OreRemaining);
    cmp.setString("OreType", OreType);
  }

  @Override
  public void readFromNBT(NBTTagCompound cmp) {
    super.readFromNBT(cmp);
    OreRemaining = cmp.getInteger("OreRemaining");
    OreType = cmp.getString("OreType");
  }

  @Override
  public Packet getDescriptionPacket() {
    NBTTagCompound syncData = new NBTTagCompound();
    this.writeToNBT(syncData);
    return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, syncData);
  }

  @Override
  public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
    readFromNBT(pkt.func_148857_g());
  }
}
