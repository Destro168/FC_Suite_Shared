package me.Destro168.Messaging;

import org.bukkit.ChatColor;

public class StringFormatter 
{
	public StringFormatter() { }
	
	public String getFormattedMoney(Double amount, String messageColor)
	{
		try { return ChatColor.GREEN + "$" + String.valueOf(amount) + messageColor; }
		catch (NumberFormatException e) { return ""; }
	}
	
	public String getFormattedMoney(int amount, String messageColor)
	{
		try { return ChatColor.GREEN + "$" + String.valueOf(amount) + messageColor; }
		catch (NumberFormatException e) { return ""; }
	}
	
	public String getFormattedMoney(String amount, String messageColor)
	{
		return ChatColor.GREEN + "$" + amount + messageColor;
	}
	
	public String getFormattedTime(int seconds, String messageColor)
	{
		String msg = "";
		
		try
		{
			msg = "[" + ChatColor.GREEN + String.valueOf(seconds) + messageColor + "]";
			
			return msg;
		}
		catch (NumberFormatException e)
		{
			return "";
		}
	}
}
