package me.Destro168.FC_Suite_Shared;

import org.bukkit.ChatColor;

public class ColorLib
{
	public String parseColors(String line)
	{
		//Replace colors
		line = line.replaceAll("&0", ChatColor.BLACK + "");
		line = line.replaceAll("&1", ChatColor.DARK_BLUE + "");
		line = line.replaceAll("&2", ChatColor.DARK_GREEN + "");
		line = line.replaceAll("&3", ChatColor.DARK_AQUA + "");
		line = line.replaceAll("&4", ChatColor.DARK_RED + "");
		line = line.replaceAll("&5", ChatColor.DARK_PURPLE + "");
		line = line.replaceAll("&6", ChatColor.GOLD + "");
		line = line.replaceAll("&7", ChatColor.GRAY + "");
		line = line.replaceAll("&8", ChatColor.DARK_GRAY + "");
		line = line.replaceAll("&9", ChatColor.BLUE + "");
		line = line.replaceAll("&a", ChatColor.GREEN + "");
		line = line.replaceAll("&b", ChatColor.AQUA + "");
		line = line.replaceAll("&c", ChatColor.RED + "");
		line = line.replaceAll("&d", ChatColor.LIGHT_PURPLE + "");
		line = line.replaceAll("&e", ChatColor.YELLOW + "");
		line = line.replaceAll("&f", ChatColor.WHITE + "");
		line = line.replaceAll("&l", ChatColor.BOLD + "");
		line = line.replaceAll("&0", ChatColor.ITALIC + "");
		line = line.replaceAll("&n", ChatColor.UNDERLINE + "");
		line = line.replaceAll("&m", ChatColor.STRIKETHROUGH + "");
		line = line.replaceAll("&k", ChatColor.MAGIC + "");
		line = line.replaceAll("&z", " ");
		
		return line;
	}
	
	public String removeColors(String line)
	{
		//Replace colors
		line = line.replaceAll(ChatColor.BLACK + "", "");
		line = line.replaceAll(ChatColor.DARK_BLUE + "", "");
		line = line.replaceAll(ChatColor.DARK_GREEN + "", "");
		line = line.replaceAll(ChatColor.DARK_AQUA + "", "");
		line = line.replaceAll(ChatColor.DARK_RED + "", "");
		line = line.replaceAll(ChatColor.DARK_PURPLE + "", "");
		line = line.replaceAll(ChatColor.GOLD + "", "");
		line = line.replaceAll(ChatColor.GRAY + "", "");
		line = line.replaceAll(ChatColor.DARK_GRAY + "", "");
		line = line.replaceAll(ChatColor.BLUE + "", "");
		line = line.replaceAll(ChatColor.GREEN + "", "");
		line = line.replaceAll(ChatColor.AQUA + "", "");
		line = line.replaceAll(ChatColor.RED + "", "");
		line = line.replaceAll(ChatColor.LIGHT_PURPLE + "", "");
		line = line.replaceAll(ChatColor.YELLOW + "", "");
		line = line.replaceAll(ChatColor.WHITE + "", "");
		
		return line;
	}
}
