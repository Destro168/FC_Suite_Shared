package me.Destro168.FC_Suite_Shared;

import me.Destro168.FC_Suite_Shared.ConfigManagers.FileConfigurationWrapper;

public class SuiteConfig 
{
	private FileConfigurationWrapper fcw;
	private ColorLib cLib = new ColorLib();
	
	public String ultimatePrefixTagText;
	public String broadcastTag;
	public String adminBroadcastTag;
	public String errorBroadcastTag;
	public String primaryColor;
	public String secondaryColor;
	public String moneyColor;
	public String playerNameColor;
	public String errorColor;
	public String primaryHeaderColor;
	public String secondaryHeaderColor;
	public String bracketColor;
	public String moneyPrefix;
	public String moneySuffix;
	public String primaryTag;
	public String secondaryTag;
	public String errorTag;
	
	public FileConfigurationWrapper getFileConfigurationWrapper() { return fcw; }
	
	//Sets
	public void setVersion(double x) { fcw.set("Version", x); }
	public void setDebug(boolean x) { fcw.set("Debug", x); }
	
	//Gets
	public double getVersion() { return fcw.getDouble("Version"); }
	public boolean getDebug() { return fcw.getBoolean("Debug"); }
	
	public SuiteConfig()
	{
		handleConfig();
	}
	
	public void handleConfig()
	{
		fcw = new FileConfigurationWrapper(FC_Suite_Shared.plugin.getDataFolder().getAbsolutePath(), "config");
		
		if (getVersion() < 1.82)
		{
			setVersion(1.82);
			restoreDefaultColors();
			setDebug(false);
		}
		
		if (getVersion() < 2.3)
		{
			setVersion(2.3);
		}
		
		if (fcw.getBoolean("RestoreDefaultColors") == true)
			restoreDefaultColors();
		
		loadConfigValues();
	}
	
	private void loadConfigValues()
	{
		//Load the configuration values.
		ultimatePrefixTagText = fcw.getString("UltimatePrefixTagText");
		broadcastTag = fcw.getString("BroadcastTagText");
		errorBroadcastTag = fcw.getString("ErrorBroadcastTagText");
		primaryColor = fcw.getString("PrimaryColor");
		secondaryColor = fcw.getString("SecondaryColor");
		playerNameColor = fcw.getString("PlayerNameColor");
		moneyColor = fcw.getString("MoneyColor");
		errorColor = fcw.getString("ErrorColor");
		primaryHeaderColor = fcw.getString("PrimaryHeaderColor");
		secondaryHeaderColor = fcw.getString("SecondaryHeaderColor");
		bracketColor = fcw.getString("BracketColor");
		moneyPrefix = fcw.getString("MoneyPrefix");
		moneySuffix = fcw.getString("MoneySuffix");
		adminBroadcastTag = bracketColor + "[" + secondaryColor + "Admin Broadcast" + bracketColor + "] " + secondaryColor;
		
		if (isEmpty(ultimatePrefixTagText))
		{
			primaryTag = cLib.parse("" + primaryColor);
			secondaryTag = cLib.parse("" + secondaryColor);
			errorTag = cLib.parse("" + errorColor);
		}
		else
		{
			primaryTag = cLib.parse(bracketColor + "[" + primaryColor + ultimatePrefixTagText + bracketColor + "] " + primaryColor);
			secondaryTag = cLib.parse(bracketColor + "[" + secondaryColor + ultimatePrefixTagText + bracketColor + "] " + secondaryColor);
			errorTag = cLib.parse(bracketColor + "[" + errorColor + ultimatePrefixTagText + bracketColor + "] " + errorColor);
		}
	}
	
	private boolean isEmpty(String x)
	{
		if (x.equals("") || x.equalsIgnoreCase("null"))
			return true;
		
		return false;
	}
	private void restoreDefaultColors()
	{
		fcw.set("Version", 2.0);
		fcw.set("UltimatePrefixTagText", "FC");
		fcw.set("PrimaryColor", "&6");
		fcw.set("SecondaryColor", "&e");
		fcw.set("NameHighlightColor", "&2");
		fcw.set("ErrorColor", "&c");
		fcw.set("PrimaryHeaderColor", "&b");
		fcw.set("SecondaryHeaderColor", "&3");
		fcw.set("BracketColor", "&8");
		fcw.set("BroadcastTagText", "&8[&2Broadcast&8] &6");
		fcw.set("ErrorBroadcastTagText", "&8[&cBroadcast&8] &6");
		fcw.set("PlayerNameColor", "&d");
		fcw.set("MoneyColor", "&a");
		fcw.set("MoneyPrefix", "\\$");
		fcw.set("MoneySuffix", "");
		fcw.set("RestoreDefaultColors", false);
	}
}
