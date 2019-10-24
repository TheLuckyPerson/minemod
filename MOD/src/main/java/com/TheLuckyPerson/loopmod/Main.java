package com.TheLuckyPerson.loopmod;

import com.TheLuckyPerson.loopmod.keybinds.Keybinds;
import com.TheLuckyPerson.loopmod.network.NetworkHandler;
import com.TheLuckyPerson.loopmod.player.PlayerDataSaver;
import com.TheLuckyPerson.loopmod.proxy.ClientProxy;
import com.TheLuckyPerson.loopmod.proxy.CommonProxy;
import com.TheLuckyPerson.loopmod.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.Sys;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main
{
    @Mod.Instance
    public static Main instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public static void PreInit(FMLPreInitializationEvent event)
    {
        proxy.preInit();
        NetworkHandler.init();
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event)
    {

    }

    @Mod.EventHandler
    public static void PostInit(FMLPostInitializationEvent event)
    {

    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onClientTick(TickEvent.ClientTickEvent event) throws Exception {

    }
}