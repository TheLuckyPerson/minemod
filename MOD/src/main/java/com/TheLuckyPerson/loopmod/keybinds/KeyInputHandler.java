package com.TheLuckyPerson.loopmod.keybinds;

import com.TheLuckyPerson.loopmod.network.MessageInventoryUpdate;
import com.TheLuckyPerson.loopmod.network.NetworkHandler;
import com.TheLuckyPerson.loopmod.player.PlayerDataSaver;
import jdk.nashorn.internal.runtime.logging.Logger;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import sun.rmi.runtime.Log;

public class KeyInputHandler
{
    private Keybinds getPressedKey()
    {
        for(Keybinds key : Keybinds.values()) {
            if(key.isPressed()) return key;
        }
        return null;
    }

    @SubscribeEvent
    public void handleKeyInputEvent(InputEvent.KeyInputEvent event)
    {
        Keybinds key = getPressedKey();
        if(key != null) {
            switch(key) {
                case LOADINVENTORY:
                    PlayerDataSaver.loadInventory();
                    break;
                case SAVEINVENTORY:
                    PlayerDataSaver.saveInventory();
                    break;
                default:
                    break;
            }
        }
    }
}