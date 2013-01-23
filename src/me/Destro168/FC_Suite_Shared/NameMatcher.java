package me.Destro168.FC_Suite_Shared;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class NameMatcher 
{
	public NameMatcher() { }
	
	public String getNameByMatch(String name)
	{
		//Require 3 characters.
		if (name.length() < 3)
			return null;
		
		for (Player player: Bukkit.getServer().getOnlinePlayers())
		{
			if (player.getName().equalsIgnoreCase(name))
				return player.getName();
			
			if (player.getName().toLowerCase().contains(name.toLowerCase()))
				return player.getName();
		}
		
		for (OfflinePlayer player: Bukkit.getServer().getOfflinePlayers())
		{
			if (player.getName().equalsIgnoreCase(name))
				return player.getName();
			
			if (player.getName().toLowerCase().contains(name.toLowerCase()))
				return player.getName();
		}
		
		if (Bukkit.getServer().matchPlayer(name) != null)
		{
			try
			{
				if (Bukkit.getServer().matchPlayer(name).get(0) != null)
				{
					return Bukkit.getServer().matchPlayer(name).get(0).getName();
				}
			}
			catch (IndexOutOfBoundsException e)
			{
				return "";
			}
		}
		
		return "";
	}
}
