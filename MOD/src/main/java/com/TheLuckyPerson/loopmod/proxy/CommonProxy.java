package com.TheLuckyPerson.loopmod.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;

public abstract class CommonProxy
{

    public abstract void preInit();

    public abstract void registerItemRenderer(Item item, int meta, String id);

    public abstract EntityPlayer getClientPlayer();
}