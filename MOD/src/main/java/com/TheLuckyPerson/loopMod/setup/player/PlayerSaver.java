package com.TheLuckyPerson.loopMod.setup.player;


import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MinecartItem;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.ArrayList;

/**
 * Class with satic methods that save and write Player data
 */
public class PlayerSaver {
    private static ArrayList<ItemStack> SAVED_PLAYER_ITEMS = new ArrayList<ItemStack>();
    private static int PLAYER_INVENTROY_SIZE  = 42;

    @SubscribeEvent
    /**
     * saves current player inventory to SAVED_PLAYER_ITEMS
     */
    public static void saveInventory() {
        if (SAVED_PLAYER_ITEMS.size() != 0)
            SAVED_PLAYER_ITEMS = new ArrayList<ItemStack>();
        for(int i = 0; i < PLAYER_INVENTROY_SIZE; i++) {
             SAVED_PLAYER_ITEMS.add(Minecraft.getInstance().player.inventory.getStackInSlot(i));
        }
        Minecraft.getInstance().player.sendChatMessage("Items Saved!");
    }

    @SubscribeEvent
    /**
     * copies SAVED_PLAYER_ITEMS to player Inventory
     * Will override Player's items
     */
    public static void loadInventory() {
        if(SAVED_PLAYER_ITEMS.size() != 0) {
            for(int i = 0; i < PLAYER_INVENTROY_SIZE; i++) {
                Minecraft.getInstance().player.dr.inventory.setInventorySlotContents(i, SAVED_PLAYER_ITEMS.get(i));
                Minecraft.getInstance().player.sendChatMessage("Items " + SAVED_PLAYER_ITEMS.get(i));
            }
            Minecraft.getInstance().player.sendChatMessage("Items Loaded!");
        } else {
            Minecraft.getInstance().player.sendChatMessage("No Items Saved");
        }
    }
}
