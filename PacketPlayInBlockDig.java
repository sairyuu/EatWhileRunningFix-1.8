package net.minecraft.server;

import java.io.IOException;

public class PacketPlayInBlockDig implements Packet<PacketListenerPlayIn> {
    private BlockPosition a;
    private EnumDirection b;
    private PacketPlayInBlockDig.EnumPlayerDigType c;
  
    // Myouren starts - Fix eat while running
    // We shall first save the timeStamp of a "drop" packet (which is the same as digging a block; Mojang being lazy)
    public final long timestamp = System.currentTimeMillis();
    // Myouren ends

    public PacketPlayInBlockDig() {
    }

    public void a(PacketDataSerializer var1) throws IOException {
        this.c = var1.a(EnumPlayerDigType.class);
        this.a = var1.c();
        this.b = EnumDirection.fromType1(var1.readUnsignedByte());
    }

    public void b(PacketDataSerializer var1) throws IOException {
        var1.a(this.c);
        var1.a(this.a);
        var1.writeByte(this.b.a());
    }

    public void a(PacketListenerPlayIn var1) {
        var1.a(this);
    }

    public BlockPosition a() {
        return this.a;
    }

    public EnumDirection b() {
        return this.b;
    }

    public PacketPlayInBlockDig.EnumPlayerDigType c() {
        return this.c;
    }

    public static enum EnumPlayerDigType {
        START_DESTROY_BLOCK,
        ABORT_DESTROY_BLOCK,
        STOP_DESTROY_BLOCK,
        DROP_ALL_ITEMS,
        DROP_ITEM,
        RELEASE_USE_ITEM;

        private EnumPlayerDigType() {
        }
    }
}
