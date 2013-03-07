package me.Destro168.FC_Suite_Shared.Messaging;

import java.text.DecimalFormat;
import java.util.List;

import me.Destro168.FC_Suite_Shared.ColorLib;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;

public class MessageLib extends YToString
{
	private CommandSender sender;
	
	public MessageLib(CommandSender sender_) { sender = sender_; }
	
	public boolean successCommand()
	{
		return sendTheMessage(cm.primaryTag + "Successfully performed command!");
	}
	
	public boolean errorInvalidCommand()
	{
		return sendTheMessage(cm.secondaryTag + "Invalid Command Usage.");
	}
	
	public boolean errorBadInput()
	{
		return sendTheMessage(cm.secondaryTag + "Invalid Input For Command Was Entered.");
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
	
	public boolean errorInvalidSelectionNoPoints()
	{
		return sendTheMessage(cm.secondaryTag + "Please select two points first!");
	}
	
	public boolean errorInvalidSelectionOnePoint()
	{
		return sendTheMessage(cm.secondaryTag + "Please make another selection first!");
	}
	
	public boolean standardMessage(String msg)
	{
		return sendTheMessage(ColorLib.parseCustom(cm.getColorPrimary(), cm.primaryTag + msg));
	}
	
	public boolean standardMessage(String msg, String msg2)
	{
		return sendTheMessage(ColorLib.parseCustom(cm.getColorPrimary(), cm.primaryTag + msg + ": " + cm.getColorSecondary() + msg2));
	}
	
	public boolean infiniteMessage(final String... messageArgs)
	{
		return sendTheMessage(ColorLib.parseCustom(cm.getColorPrimary(), cm.primaryTag + toString(messageArgs)));
	}
	
	public boolean standardMessage(String[] msg)
	{
		return sendTheMessage(ColorLib.parseCustom(cm.getColorPrimary(), cm.primaryTag + super.toString(msg)));
	}
	
	public boolean standardMessage(List<String> msg)
	{
		return sendTheMessage(ColorLib.parseCustom(cm.getColorPrimary(), cm.primaryTag + super.toString(msg)));
	}
	
	public boolean standardMessage(String prefix, List<String> msgList)
	{
		return sendTheMessage(ColorLib.parseCustom(cm.getColorPrimary(), cm.primaryTag + prefix + super.toString(msgList)));
	}
	
	public boolean standardMessage(String prefix, String[] msgList)
	{
		return sendTheMessage(ColorLib.parseCustom(cm.getColorPrimary(), cm.primaryTag + prefix + super.toString(msgList)));
	}
	
	public boolean secondaryMessage(String msg)
	{
		return sendTheMessage(ColorLib.parseCustom(cm.getColorSecondary(), cm.secondaryTag + msg));
	}
	
	public boolean standardError(String msg)
	{
		return sendTheMessage(ColorLib.parseCustom(cm.getColorSecondary(), cm.errorTag + msg));
	}
	
	public boolean infiniteError(final String... messageArgs)
	{
		return sendTheMessage(ColorLib.parseCustom(cm.getColorSecondary(), cm.errorTag + toString(messageArgs)));
	}
	
	public boolean standardHeader(String... msg)
	{
		for (int i = 0; i < msg.length; i++)
			msg[i] = cm.getColorHeaders() + msg[i];
		
		return sendTheMessage(ColorLib.parseCustom(cm.getColorSecondary(), cm.getTextHeadersPrefix() + super.toString(msg) + cm.getTextHeadersSuffix()));
	}
	
	public boolean displayFormattedList(List<String> msg)
	{
		return sendTheMessage(ColorLib.parseCustom(cm.getColorPrimary(), cm.primaryTag + super.toString(msg)));
	}
	
	public boolean displayLocation(String msg, Location loc)
	{
		if (loc == null)
			return true;
		
		DecimalFormat df = new DecimalFormat("#.###");
		
		return infiniteMessage(msg," -> [Name]: ",loc.getWorld().getName()," [X]: ",df.format(loc.getX())," [Y]: ",df.format(loc.getY())," [Z]: ",
				df.format(loc.getZ())," [Yaw]: ",df.format(loc.getYaw())," [Pitch]: ",df.format(loc.getPitch()));
	}
	
	public boolean infiniteLocation(Location loc, String... msg)
	{
		if (loc == null)
			return true;
		
		DecimalFormat df = new DecimalFormat("#.###");
		
		return infiniteMessage(toString(msg)," -> [Name]: ",loc.getWorld().getName()," [X]: ",df.format(loc.getX())," [Y]: ",df.format(loc.getY())," [Z]: ",
				df.format(loc.getZ())," [Yaw]: ",df.format(loc.getYaw())," [Pitch]: ",df.format(loc.getPitch()));
	}
	
	private boolean sendTheMessage(String msg)
	{
		sender.sendMessage(msg);
		return true;
	}
}









