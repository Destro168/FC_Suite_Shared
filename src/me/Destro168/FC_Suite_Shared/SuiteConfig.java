package me.Destro168.FC_Suite_Shared;

import org.bukkit.configuration.file.FileConfiguration;

public class SuiteConfig 
{
	private FileConfiguration config;
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
	
	public boolean getDebug() { return config.getBoolean("debug"); }
	
	public SuiteConfig()
	{
		handleConfig();
	}
	
	public void handleConfig()
	{
		//Next we load up colors from the configuration file.
		config = FC_Suite_Shared.plugin.getConfig();
		
		if (config.getDouble("Version") < 1.0)
		{
			restoreDefaultColors();
		}
		
		if (config.getDouble("Version") < 1.1)
		{
			config.set("Version", 1.1);
			config.set("BroadcastTagText", "Broadcast");
			config.set("RestoreDefaultColors", false);
		}
		
		if (config.getDouble("Version") < 1.2)
		{
			config.set("Version", 1.2);
			config.set("ErrorBroadcastTagText", "&8[&cBroadcast&8] &6");
		}
		
		if (config.getDouble("Version") < 1.5)
		{
			config.set("Version", 1.5);
			
			//Get rid of old setting.
			config.set("NameHighlightColor", null);
			config.set("PlayerNameColor", "&d");
			config.set("MoneyColor", "&a");
			config.set("MoneyPrefix", "\\$");
			config.set("MoneySuffix", "");
		}
		
		if (config.getDouble("Version") < 1.6)
		{
			config.set("Version", 1.6);
			config.set("debug", "false");
		}
		
		if (config.getDouble("Version") < 1.81)
		{
			config.set("Version", 1.81);
			config.set("debug", "false");
		}
		
		if (config.getBoolean("RestoreDefaultColors") == true)
			restoreDefaultColors();
		
		//Load the configuration values.
		ultimatePrefixTagText = config.getString("UltimatePrefixTagText");
		broadcastTag = config.getString("BroadcastTagText");
		errorBroadcastTag = config.getString("ErrorBroadcastTagText");
		primaryColor = config.getString("PrimaryColor");
		secondaryColor = config.getString("SecondaryColor");
		playerNameColor = config.getString("PlayerNameColor");
		moneyColor = config.getString("MoneyColor");
		errorColor = config.getString("ErrorColor");
		primaryHeaderColor = config.getString("PrimaryHeaderColor");
		secondaryHeaderColor = config.getString("SecondaryHeaderColor");
		bracketColor = config.getString("BracketColor");
		moneyPrefix = config.getString("MoneyPrefix");
		moneySuffix = config.getString("MoneySuffix");
		adminBroadcastTag = bracketColor + "[" + secondaryColor + "Admin Broadcast" + bracketColor + "] " + secondaryColor;
		
		if (!ultimatePrefixTagText.equals("") && !ultimatePrefixTagText.equals("null"))
		{
			primaryTag = cLib.parse(bracketColor + "[" + primaryColor + ultimatePrefixTagText + bracketColor + "] " + primaryColor);
			secondaryTag = cLib.parse(bracketColor + "[" + secondaryColor + ultimatePrefixTagText + bracketColor + "] " + secondaryColor);
			errorTag = cLib.parse(bracketColor + "[" + errorColor + ultimatePrefixTagText + bracketColor + "] " + errorColor);
		}
		else
		{
			primaryTag = "";
			secondaryTag = "";
			errorTag = "";
		}
		
		FC_Suite_Shared.plugin.saveConfig();
	}
	
	private void restoreDefaultColors()
	{
		config.set("Version", 1.6);
		config.set("UltimatePrefixTagText", "FC");
		config.set("PrimaryColor", "&6");
		config.set("SecondaryColor", "&e");
		config.set("NameHighlightColor", "&2");
		config.set("ErrorColor", "&c");
		config.set("PrimaryHeaderColor", "&b");
		config.set("SecondaryHeaderColor", "&3");
		config.set("BracketColor", "&8");
		config.set("BroadcastTagText", "&8[&6Broadcast&8] &6");
		config.set("ErrorBroadcastTagText", "&8[&cBroadcast&8] &6");
		config.set("PlayerNameColor", "&d");
		config.set("MoneyColor", "&a");
		config.set("MoneyPrefix", "\\$");
		config.set("MoneySuffix", "");
		config.set("RestoreDefaultColors", false);
	}
}
