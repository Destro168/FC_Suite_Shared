package me.Destro168.FC_Suite_Shared;


import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager 
{
	private FileConfiguration config;
	private ColorLib cLib = new ColorLib();
	
	public String ultimatePrefixTagText;
	public String broadcastTag;
	public String errorBroadcastTag;
	
	public String primaryColor;
	public String secondaryColor;
	public String nameHighlightColor;
	public String errorColor;
	public String primaryHeaderColor;
	public String secondaryHeaderColor;
	public String bracketColor;

	public String primaryTag;
	public String secondaryTag;
	public String errorTag;
	
	public ConfigManager()
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
		
		if (config.getDouble("Version") < 1.4)
		{
			config.set("Version", 1.4);
		}
		
		if (config.getBoolean("RestoreDefaultColors") == true)
			restoreDefaultColors();
		
		//Load the configuration values.
		ultimatePrefixTagText = config.getString("UltimatePrefixTagText");
		broadcastTag = config.getString("BroadcastTagText");
		errorBroadcastTag = config.getString("ErrorBroadcastTagText");
		primaryColor = config.getString("PrimaryColor");
		secondaryColor = config.getString("SecondaryColor");
		nameHighlightColor = config.getString("NameHighlightColor");
		errorColor = config.getString("ErrorColor");
		primaryHeaderColor = config.getString("PrimaryHeaderColor");
		secondaryHeaderColor = config.getString("SecondaryHeaderColor");
		bracketColor = config.getString("BracketColor");
		
		if (!ultimatePrefixTagText.equals("") && !ultimatePrefixTagText.equals("null"))
		{
			primaryTag = cLib.parseColors(bracketColor + "[" + primaryColor + ultimatePrefixTagText + bracketColor + "] " + primaryColor);
			secondaryTag = cLib.parseColors(bracketColor + "[" + secondaryColor + ultimatePrefixTagText + bracketColor + "] " + secondaryColor);
			errorTag = cLib.parseColors(bracketColor + "[" + errorColor + ultimatePrefixTagText + bracketColor + "] " + errorColor);
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
		config.set("Version", 1.2);
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
		config.set("RestoreDefaultColors", false);
	}
}
