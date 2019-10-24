package com.TheLuckyPerson.loopmod.proxy;

import com.TheLuckyPerson.loopmod.keybinds.KeyInputHandler;
import com.TheLuckyPerson.loopmod.keybinds.Keybinds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class ClientProxy extends CommonProxy
{
    private void registerKebinds()
    {
        FMLCommonHandler.instance().bus().register(new KeyInputHandler());
        for (Keybinds key : Keybinds.values()) {
            ClientRegistry.registerKeyBinding(key.getKeybind());
        }
    }

    @Override
    public void preInit()
    {
        registerKebinds();
    }

    @Override
    public EntityPlayer getClientPlayer()
    {
        return Minecraft.getMinecraft().player;
    }

    @Override
    public void registerItemRenderer(Item item, int meta, String id)
    {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
    }
}