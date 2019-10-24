package com.TheLuckyPerson.loopmod.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

import java.util.ArrayList;

public class MessageInventoryUpdate extends MessageBase<MessageInventoryUpdate>
{
    private ArrayList<ItemStack> items = new ArrayList<>();
    private int size;

    public MessageInventoryUpdate(){}

    public MessageInventoryUpdate(ArrayList<ItemStack> items){
        this.items = items;
    }

    @Override
    public void fromBytes(ByteBuf buf){
        size = buf.readInt();
       for(int i = 0; i < size; i++) {
           ItemStack temp = new ItemStack(Item.getItemById(buf.readInt()), buf.readInt(), buf.readInt());
           Minecraft.getMinecraft().player.sendChatMessage(temp.getDisplayName());
           items.add(temp);
       }
    }

    @Override
    public void toBytes(ByteBuf buf){
        buf.writeInt(items.size());
        for(ItemStack item : items) {
            buf.writeInt(Item.getIdFromItem(item.getItem()));
            buf.writeInt(item.getCount());
            buf.writeInt(item.getMetadata());
        }
    }

    @Override
    public void handleClientSide(MessageInventoryUpdate message, EntityPlayer player){

    }

    @Override
    public void handleServerSide(MessageInventoryUpdate message, EntityPlayer player) {
        for(int i = 0; i < 42; i++) {
            player.inventory.setInventorySlotContents(i, message.items.get(i));
        }
    }
}
