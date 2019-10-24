package com.TheLuckyPerson.loopmod.network;
import com.TheLuckyPerson.loopmod.util.Reference;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class NetworkHandler{
    private static SimpleNetworkWrapper INSTANCE;

    public static void init(){
        INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);

        INSTANCE.registerMessage(MessageInventoryUpdate.class, MessageInventoryUpdate.class, 0, Side.SERVER);
    }

    public static void sendToServer(IMessage message){
        INSTANCE.sendToServer(message);
    }

    public static void sendTo(IMessage message, EntityPlayerMP player){
        INSTANCE.sendTo(message, player);
    }

    public static void sendToAllAround(IMessage message, TargetPoint point){
        INSTANCE.sendToAllAround(message, point);
    }

    /**
     * Will send the given packet to every player within 64 blocks of the XYZ of the XYZ packet.
     * @param message
     * @param world
     */
    public static void sendToAllAround(MessageXYZ message, World world){
        INSTANCE.sendToAllAround(message, new TargetPoint(world.provider.getDimension(), message.x, message.y, message.z, 64D));
    }

    public static void sendToAll(IMessage message){
        INSTANCE.sendToAll(message);
    }

    public static void sendToDimension(IMessage message, int dimensionId){
        INSTANCE.sendToDimension(message, dimensionId);
    }

}