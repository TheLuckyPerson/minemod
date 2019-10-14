package com.TheLuckyPerson.loopMod.setup.keybinds;

import net.java.games.input.Keyboard;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

import static net.java.games.input.Keyboard.*;

public class Keybinds
{
    public static KeyBinding saveInventory;
    public static KeyBinding loadInventory;

    public static void register()
    {
        saveInventory = new KeyBinding("Save Inventory", 21, "key.categories.misc");
        loadInventory = new KeyBinding("Load Inventory", 22, "key.categories.misc");
        ClientRegistry.registerKeyBinding(loadInventory);
        ClientRegistry.registerKeyBinding(saveInventory);
    }
}