package com.TheLuckyPerson.loopmod.keybinds;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public enum Keybinds
{
    LOADINVENTORY("key.loopmod.Load", Keyboard.KEY_J),
    SAVEINVENTORY("key.loopmod.Save", Keyboard.KEY_K);;

    private final KeyBinding keybinding;

    private Keybinds(String keyName, int defaultKeyCode)
    {
        keybinding = new KeyBinding(keyName, defaultKeyCode,"key.categories.loopmod");
    }

    public KeyBinding getKeybind()
    {
        return keybinding;
    }

    public boolean isPressed()
    {
        return keybinding.isPressed();
    }
}