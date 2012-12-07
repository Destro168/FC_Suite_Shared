package me.Destro168.FC_Suite_Shared.ConfigManagers;

import me.Destro168.FC_Suite_Shared.StringToY;

public class ConfigGod 
{
	protected FileConfigurationWrapper fcw;
	protected String prefix;
	protected StringToY converter;
	
	public FileConfigurationWrapper getFileConfigurationWrapper() { return fcw; }
	
	protected void setVersion(double x) { fcw.set(prefix + "version", x); }
	protected double getVersion() { return fcw.getDouble(prefix + "version"); }
	
	//Need to give each config it's own folder.
	public ConfigGod(String path, String target)
	{
		//Initialize variables.
		converter = new StringToY();
		prefix = target + ".";
		fcw = new FileConfigurationWrapper(path, target);
	}
}
