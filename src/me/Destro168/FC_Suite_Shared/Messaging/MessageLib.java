package me.Destro168.FC_Suite_Shared.Messaging;

import java.text.DecimalFormat;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.command.ColouredConsoleSender;
import org.bukkit.entity.Player;

public class MessageLib extends StringToY
{
	private Player player;
	private ColouredConsoleSender console;
	
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
	
	public boolean infiniteMessage(final String... messageArgs)
	{
		return sendTheMessage(cLib.parseCustom(cm.primaryColor, cm.primaryTag + toString(messageArgs)));
	}
	
	public boolean standardMessage(String[] msg)
	{
		return sendTheMessage(cLib.parseCustom(cm.primaryColor, cm.primaryTag + super.toString(msg)));
	}
	
	public boolean standardMessage(List<String> msg)
	{
		return sendTheMessage(cLib.parseCustom(cm.primaryColor, cm.primaryTag + super.toString(msg)));
	}
	
	public boolean standardMessage(String prefix, List<String> msgList)
	{
		return sendTheMessage(cLib.parseCustom(cm.primaryColor, cm.primaryTag + prefix + super.toString(msgList)));
	}
	
	public boolean standardMessage(String prefix, String[] msgList)
	{
		return sendTheMessage(cLib.parseCustom(cm.primaryColor, cm.primaryTag + prefix + super.toString(msgList)));
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
	
	public boolean displayFormattedList(List<String> msg)
	{
		return sendTheMessage(cLib.parseCustom(cm.primaryColor, cm.primaryTag + super.toString(msg)));
	}
	
	public boolean displayLocation(String header, Location loc)
	{
		if (loc == null)
			return true;
		
		DecimalFormat df = new DecimalFormat("#.###");
		
		return standardMessage(header + " -> [N]: " + loc.getWorld().getName() + " [X]: " + df.format(loc.getX()) + " [Y]: " + df.format(loc.getY()) + " [Z]: " +
				df.format(loc.getZ()) + " [Yaw]: " + df.format(loc.getYaw()) + " [Pitch]: " + df.format(loc.getPitch()));
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









