package me.Destro168.ConfigManagers;

import me.Destro168.FC_Suite_Shared.StringToY;

public class ConfigGod 
{
	protected CustomConfigurationManager ccm;
	protected String prefix;
	protected StringToY converter;
	
	protected void setVersion(double x) { ccm.set(prefix + "version", x); }
	protected double getVersion() { return ccm.getDouble(prefix + "version"); }
	
	//Need to give each config it's own folder.
	public ConfigGod(String path, String target)
	{
		//Initialize variables.
		converter = new StringToY();
		prefix = target + ".";
		ccm = new CustomConfigurationManager(path, target);
	}
}
