package com.Ben.GuildToggle;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class CommandGtoggle implements ICommand{

	private final List aliases;
	
	public CommandGtoggle(){
		aliases = new ArrayList<String>();
		aliases.add("gtoggle");
		aliases.add("gt");
	}
	@Override
	public int compareTo(ICommand o) {
		return 0;
	}

	@Override
	public List<String> addTabCompletionOptions(ICommandSender arg0, String[] arg1, BlockPos arg2) {
		return null;
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender arg0) {
		return true;
	}

	@Override
	public List<String> getCommandAliases() {
		return aliases;
	}

	@Override
	public String getCommandName() {
		return "gtoggle";
	}	

	@Override
	public String getCommandUsage(ICommandSender arg0) {
		return "gtoggle";
	}

	@Override
	public boolean isUsernameIndex(String[] arg0, int arg1) {
		return false;
	}

	@Override
	public void processCommand(ICommandSender arg0, String[] arg1) throws CommandException {
		if(arg1.length == 0){
			boolean toggled = GuildToggle.instance().toggleGuildChat();
			String message = "";
			if(toggled){
				message = EnumChatFormatting.GREEN + "" + EnumChatFormatting.BOLD + "Guild chat is now enabled!";
			}else{
				message = EnumChatFormatting.RED + "" + EnumChatFormatting.BOLD + "Guild chat is now disabled!";
			}
			Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(message));
		}else{
			ChatComponentText moreargs = new ChatComponentText(EnumChatFormatting.RED + "" + EnumChatFormatting.BOLD + "Invalid args");
			Minecraft.getMinecraft().thePlayer.addChatComponentMessage(moreargs);
		}
		}
	}