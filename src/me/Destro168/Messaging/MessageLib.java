package me.Destro168.Messaging;

import java.util.List;

import me.Destro168.ConfigManagers.ConfigManager;

import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.command.ColouredConsoleSender;
import org.bukkit.entity.Player;

public class MessageLib extends BroadcastLib
{
	ConfigManager cm = new ConfigManager();
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
	
	public boolean standardMessage(String msg)
	{
		return sendTheMessage(cLib.parseColors(cm.primaryTag + msg));
	}
	
	public boolean standardMessage(String msg, String msg2)
	{
		return sendTheMessage(cLib.parseColors(cm.primaryTag + msg + ": " + cm.secondaryColor + msg2));
	}
	
	public boolean secondaryMessage(String msg)
	{
		return sendTheMessage(cLib.parseColors(cm.secondaryTag + msg));
	}
	
	public boolean standardMessage(String[] msg)
	{
		return sendTheMessage(cLib.parseColors(cm.primaryTag + convertStringArrayToString(msg)));
	}
	
	public boolean standardMessage(List<String> msg)
	{
		return sendTheMessage(cLib.parseColors(cm.primaryTag + convertStringListToString(msg)));
	}
	
	public boolean standardMessage(String prefix, List<String> msgList)
	{
		return sendTheMessage(cLib.parseColors(cm.primaryTag + prefix + convertStringListToString(msgList)));
	}
	
	public boolean standardError(String msg)
	{
		return sendTheMessage(cLib.parseColors(cm.errorTag + msg));
	}
	
	public boolean standardHeader(String msg)
	{
		return sendTheMessage(cLib.parseColors(cm.secondaryHeaderColor + ".: " + cm.primaryHeaderColor + ChatColor.ITALIC + ChatColor.BOLD + msg + cm.secondaryHeaderColor + " :."));
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









