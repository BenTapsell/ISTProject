package com.Ben.GuildToggle;

import net.minecraft.client.Minecraft;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = GuildToggle.MODID, version = GuildToggle.VERSION)
public class GuildToggle {
	
	public static final String MODID = "GuildToggle";
	public static final String VERSION = "1.0";

	private static Minecraft mc;
	private boolean showGuildChat = true;
	private static GuildToggle instance; 
	
	public GuildToggle(){
		instance = this;
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e){
		
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent e){
		MinecraftForge.EVENT_BUS.register(this);
		ClientCommandHandler.instance.registerCommand(new CommandGtoggle());
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e){
		mc = Minecraft.getMinecraft();
		
	}
	
	@SubscribeEvent
	public void onChat(ClientChatReceivedEvent e){
		IChatComponent component = e.message;
		String message = component.getUnformattedText();
		
		String error = "";
		if(message.startsWith("Guild > ") && !showGuildChat){
			e.setCanceled(true);
		
		}else{
			message = "Error!";
		}
	}
	
	
	public static GuildToggle instance(){
		return instance;
	}
	
	public boolean toggleGuildChat(){
		return (showGuildChat = !showGuildChat);
		
	}
}
