package com.TheLuckyPerson.loopmod.player;

import com.TheLuckyPerson.loopmod.network.MessageInventoryUpdate;
import com.TheLuckyPerson.loopmod.network.NetworkHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;

public class PlayerDataSaver
{
    private static ArrayList<ItemStack> SAVED_PLAYER_ITEMS = new ArrayList<>();
    private static int PLAYER_INVENTROY_SIZE  = 42;

    @SubscribeEvent
    /**
     * saves current player inventory to SAVED_PLAYER_ITEMS
     */
    public static void saveInventory() {
        SAVED_PLAYER_ITEMS = new ArrayList<ItemStack>();
        for(int i = 0; i < PLAYER_INVENTROY_SIZE; i++) {
            ItemStack temp = Minecraft.getMinecraft().player.inventory.getStackInSlot(i);
            SAVED_PLAYER_ITEMS.add(temp);
            Minecraft.getMinecraft().player.sendChatMessage("Items " + SAVED_PLAYER_ITEMS.get(i) + " saved");
        }
        Minecraft.getMinecraft().player.sendChatMessage("Items Saved!");
    }

    @SubscribeEvent
    /**
     * copies SAVED_PLAYER_ITEMS to player Inventory
     * Will override Player's items
     */
    public static void loadInventory() {
        if(SAVED_PLAYER_ITEMS.size() != 0) {
            for(int i = 0; i < PLAYER_INVENTROY_SIZE; i++) {
                Minecraft.getMinecraft().player.inventory.setInventorySlotContents(i, SAVED_PLAYER_ITEMS.get(i));
                Minecraft.getMinecraft().player.sendChatMessage("Items " + SAVED_PLAYER_ITEMS.get(i));
            }
            NetworkHandler.sendToServer(new MessageInventoryUpdate(SAVED_PLAYER_ITEMS));
            Minecraft.getMinecraft().player.sendChatMessage("Items Loaded!");
        } else {
            Minecraft.getMinecraft().player.sendChatMessage("No Items Saved");
        }
    }
}
