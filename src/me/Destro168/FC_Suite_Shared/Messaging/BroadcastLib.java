package me.Destro168.FC_Suite_Shared.Messaging;

import java.util.List;

import me.Destro168.FC_Suite_Shared.ColorLib;
import me.Destro168.FC_Suite_Shared.SuiteConfig;
import me.Destro168.FC_Suite_Shared.PermissionManager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class BroadcastLib extends YToString
{
	public BroadcastLib() { }
	
	public boolean infiniteBroadcast(String... msg)
	{
		Bukkit.getServer().broadcastMessage(ColorLib.parseCustom(cm.getColorPrimary(), cm.getTextBroadcastStandard() + toString(msg)));
		return true;
	}
	
	public boolean standardBroadcast(String msg)
	{
		Bukkit.getServer().broadcastMessage(ColorLib.parseCustom(cm.getColorPrimary(), cm.getTextBroadcastStandard() + msg));
		return true;
	}
	
	public boolean standardBroadcast(String[] msg)
	{
		Bukkit.getServer().broadcastMessage(ColorLib.parseCustom(cm.getColorPrimary(), cm.getTextBroadcastStandard() + super.toString(msg)));
		return true;
	}
	
	public boolean standardBroadcast(List<String> msg)
	{
		Bukkit.getServer().broadcastMessage(ColorLib.parseCustom(cm.getColorPrimary(), cm.getTextBroadcastStandard() + super.toString(msg)));
		return true;
	}
	
	public boolean errorBroadcast(String msg)
	{
		SuiteConfig cm = new SuiteConfig();
		Bukkit.getServer().broadcastMessage(ColorLib.parseCustom(cm.getColorPrimary(), cm.getTextBroadcastError() + msg));
		return true;
	}
	
	public boolean broadcastToAdmins(String msg)
	{
		PermissionManager perms;
		
		for (Player staff: Bukkit.getServer().getOnlinePlayers())
		{
			perms = new PermissionManager(staff);
			
			if (perms.isGlobalAdmin())
				staff.sendMessage(ColorLib.parseCustom(cm.getColorPrimary(), cm.adminBroadcastTag + msg));
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
}




















