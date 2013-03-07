package me.Destro168.FC_Suite_Shared;

import me.Destro168.FC_Suite_Shared.ConfigManagers.FileConfigurationWrapper;

public class SuiteConfig
{
	private FileConfigurationWrapper fcw;
	private String prefix = "SuiteMain" + ".";
	
	public String adminBroadcastTag;
	public String primaryTag;
	public String secondaryTag;
	public String errorTag;
	
	//Sets
	public void setVersion(double x) { fcw.set(prefix + "Version", x); }
	public void setDebug(boolean x) { fcw.set(prefix + "Debug", x); }
	
	//Gets
	public double getVersion() { return fcw.getDouble(prefix + "Version"); }
	public boolean getDebug() { return fcw.getStaticBoolean(prefix + "Debug", false); }
	
	public String getTextGlobalPrefix() { return fcw.getStaticString(prefix + "text.globalPrefix", "FC"); }
	public String getTextBroadcastStandard() { return fcw.getStaticString(prefix + "text.broadcast.standard", "&8[&2Broadcast&8] &6"); }
	public String getTextBroadcastError() { return fcw.getStaticString(prefix + "text.broadcast.error", "&8[&cBroadcast&8] &6"); }
	public String getTextHeadersPrefix() { return fcw.getStaticString(prefix + "text.headers.prefix", "&9.: "); }
	public String getTextHeadersSuffix() { return fcw.getStaticString(prefix + "text.headers.suffix", "&9 :."); }
	public String getTextEconomyPrefix() { return fcw.getStaticString(prefix + "text.economy.prefix", "\\$"); }
	public String getTextEconomySuffix() { return fcw.getStaticString(prefix + "text.economy.suffix", ""); }
	public String getColorPrimary() { return fcw.getStaticString(prefix + "color.primary", "&6"); }
	public String getColorSecondary() { return fcw.getStaticString(prefix + "color.secondary", "&e"); }
	public String getColorErrors() { return fcw.getStaticString(prefix + "color.errors", "&c"); }
	public String getColorPlayerNames() { return fcw.getStaticString(prefix + "color.playerNames", "&d"); }
	public String getColorHeaders() { return fcw.getStaticString(prefix + "color.headers", "&b"); }
	public String getColorBrackets() { return fcw.getStaticString(prefix + "color.brackets", "&8"); }
	public String getColorEconomy() { return fcw.getStaticString(prefix + "color.economy", "&a"); }
	
	public SuiteConfig()
	{
		handleConfig();
	}
	
	private void handleConfig()
	{
		// Load up default config.
		fcw = new FileConfigurationWrapper(FC_Suite_Shared.plugin.getDataFolder().getAbsolutePath(), "config");
		
		// Update to version 3.0.
		if (getVersion() < 3.0)
			setVersion(3.0);
		
		getDebug();
		getTextGlobalPrefix();
		getTextBroadcastStandard();
		getTextBroadcastError();
		getTextHeadersPrefix();
		getTextHeadersSuffix();
		getTextEconomyPrefix();
		getTextEconomySuffix();
		getColorPrimary();
		getColorSecondary();
		getColorErrors();
		getColorPlayerNames();
		getColorHeaders();
		getColorBrackets();
		getColorEconomy();
		
		// Set some tags based on values loaded.
		adminBroadcastTag = getColorBrackets() + "[" + getColorSecondary() + "Admin Broadcast" + getColorBrackets() + "] " + getColorSecondary();
		
		// If empty text, don't add brackets.
		if (this.getTextGlobalPrefix().equalsIgnoreCase(""))
		{
			primaryTag = ColorLib.parse("" + getColorPrimary());
			secondaryTag = ColorLib.parse("" + getColorSecondary());
			errorTag = ColorLib.parse("" + getColorErrors());
		}
		else
		{
			primaryTag = ColorLib.parse(getColorBrackets() + "[" + getColorPrimary() + getTextGlobalPrefix() + getColorBrackets() + "] " + getColorPrimary());
			secondaryTag = ColorLib.parse(getColorBrackets() + "[" + getColorSecondary() + getTextGlobalPrefix() + getColorBrackets() + "] " + getColorSecondary());
			errorTag = ColorLib.parse(getColorBrackets() + "[" + getColorErrors() + getTextGlobalPrefix() + getColorBrackets() + "] " + getColorErrors());
		}
	}
}












