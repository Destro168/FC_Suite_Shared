package me.Destro168.Messaging;

import java.util.List;

import me.Destro168.ConfigManagers.ConfigManager;
import me.Destro168.FC_Suite_Shared.ColorLib;
import me.Destro168.FC_Suite_Shared.PermissionManager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class BroadcastLib extends StringFormatter
{
	public ConfigManager cm = new ConfigManager();
	public ColorLib cLib = new ColorLib();
	
	public BroadcastLib() { }
	
	public boolean standardBroadcast(String msg)
	{
		Bukkit.getServer().broadcastMessage(cLib.parseColors(cm.broadcastTag + msg));
		return true;
	}
	
	public boolean standardBroadcast(String[] msg)
	{
		Bukkit.getServer().broadcastMessage(cLib.parseColors(cm.broadcastTag + convertStringArrayToString(msg)));
		return true;
	}
	
	public boolean standardBroadcast(List<String> msg)
	{
		Bukkit.getServer().broadcastMessage(cLib.parseColors(cm.broadcastTag + convertStringListToString(msg)));
		return true;
	}
	
	public boolean errorBroadcast(String msg)
	{
		ConfigManager cm = new ConfigManager();
		Bukkit.getServer().broadcastMessage(cLib.parseColors(cm.errorBroadcastTag + msg));
		return true;
	}
	
	public boolean broadcastToAdmins(String msg)
	{
		MessageLib msgLib;
		PermissionManager perms;
		
		for (Player staff: Bukkit.getServer().getOnlinePlayers())
		{
			perms = new PermissionManager(staff);
			
			if (perms.isGlobalAdmin())
			{
				msgLib = new MessageLib(staff);
				msgLib.standardMessage(msg);
			}
		}
		
		return true;
	}
	
	public boolean broadcastToMods(String msg)
	{
		MessageLib msgLib;
		PermissionManager perms;
		
		for (Player staff: Bukkit.getServer().getOnlinePlayers())
		{
			perms = new PermissionManager(staff);
			
			if (perms.isGlobalMod())
			{
				msgLib = new MessageLib(staff);
				msgLib.standardMessage(msg);
			}
			else if (perms.isGlobalAdmin())
			{
				msgLib = new MessageLib(staff);
				msgLib.standardMessage(msg);
			}
		}
		
		return true;
	}
	
	protected String convertStringListToString(List<String> msg)
	{
		//Variable Declarations
		String message = "";
		boolean alternate = true;
		
		//We want to alternate the colors for the standard  message.
		for (int i = 0; i < msg.size(); i++)
		{
			if (msg.get(i) != null)
			{
				if (alternate == true)
				{
					message += cm.secondaryColor + "" + msg.get(i);
					alternate = false;
				}
				else if (alternate == false)
				{
					message += cm.primaryColor + "" + msg.get(i);
					alternate = true;
				}
			}
		}
		
		return message;
	}
	
	protected String convertStringArrayToString(String[] msg)
	{
		//Variable Declarations
		String message = "";
		boolean alternate = true;
		
		//We want to alternate the colors for the standard  message.
		for (int i = 0; i < msg.length; i++)
		{
			if (msg[i] != null)
			{
				if (alternate == true)
				{
					message += cm.primaryColor + "" + msg[i];
					alternate = false;
				}
				else if (alternate == false)
				{
					message += cm.secondaryColor + "" + msg[i];
					alternate = true;
				}
			}
		}
		
		return message;
	}
}




















