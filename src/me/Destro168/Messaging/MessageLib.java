package me.Destro168.Messaging;

import java.util.List;

import me.Destro168.FC_Suite_Shared.SuiteConfig;

import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.command.ColouredConsoleSender;
import org.bukkit.entity.Player;

public class MessageLib extends BroadcastLib
{
	SuiteConfig cm = new SuiteConfig();
	Player player;
	ColouredConsoleSender console;
	
	public MessageLib(Player player_) { player = player_; console = null; }
	public MessageLib(ColouredConsoleSender console_) { console = console_; player = null; }
	
	public boolean successCommand()
	{
		return sendTheMessage(cm.primaryTag + "Successfully performed command!");
	}
	
	public boolean errorInvalidCommand()
	{
		return sendTheMessage(cm.secondaryTag + "Invalid Command Usage.");
	}
	
	public boolean errorNoPermission()
	{
		return sendTheMessage(cm.secondaryTag + "You do not have access to this command.");
	}
	
	public boolean errorPlayerNotOnline()
	{
		return sendTheMessage(cm.secondaryTag + "Player is not online!");
	}
	
	public boolean errorPlayerNotFound()
	{
		return sendTheMessage(cm.secondaryTag + "Player is not online!");
	}
	
	public boolean errorNotEnoughMoney()
	{
		return sendTheMessage(cm.secondaryTag + "You don't have enough money!");
	}
	
	public boolean errorInvalidSelection()
	{
		return sendTheMessage(cm.secondaryTag + "Please select two points first!");
	}
	
	public boolean standardMessage(String msg)
	{
		return sendTheMessage(cLib.parseCustom(cm.primaryColor, cm.primaryTag + msg));
	}
	
	public boolean standardMessage(String msg, String msg2)
	{
		return sendTheMessage(cLib.parseCustom(cm.primaryColor, cm.primaryTag + msg + ": " + cm.secondaryColor + msg2));
	}
	
	public boolean standardMessage(String[] msg)
	{
		return sendTheMessage(cLib.parseCustom(cm.primaryColor, cm.primaryTag + convertStringArrayToString(msg)));
	}
	
	public boolean standardMessage(List<String> msg)
	{
		return sendTheMessage(cLib.parseCustom(cm.primaryColor, cm.primaryTag + convertStringListToString(msg)));
	}
	
	public boolean standardMessage(String prefix, List<String> msgList)
	{
		return sendTheMessage(cLib.parseCustom(cm.primaryColor, cm.primaryTag + prefix + convertStringListToString(msgList)));
	}
	
	public boolean standardMessage(String prefix, String[] msgList)
	{
		return sendTheMessage(cLib.parseCustom(cm.primaryColor, cm.primaryTag + prefix + convertStringArrayToString(msgList)));
	}
	
	public boolean secondaryMessage(String msg)
	{
		return sendTheMessage(cLib.parseCustom(cm.secondaryColor, cm.secondaryTag + msg));
	}
	
	public boolean standardError(String msg)
	{
		return sendTheMessage(cLib.parseCustom(cm.secondaryColor, cm.errorTag + msg));
	}
	
	public boolean standardHeader(String msg)
	{
		return sendTheMessage(cLib.parseCustom(cm.secondaryColor, cm.secondaryHeaderColor + ".: " + cm.primaryHeaderColor + ChatColor.ITALIC + ChatColor.BOLD + msg + cm.secondaryHeaderColor + " :."));
	}
	
	private boolean sendTheMessage(String msg)
	{
		if (player != null)
			player.sendMessage(msg);
		else if (console != null)
			console.sendMessage(msg);
		
		return true;
	}
}









