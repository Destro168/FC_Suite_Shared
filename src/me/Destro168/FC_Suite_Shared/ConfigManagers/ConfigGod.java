package me.Destro168.FC_Suite_Shared.ConfigManagers;

public class ConfigGod 
{
	public FileConfigurationWrapper fcw;
	public String prefix;
	
	protected void setVersion(double x) { fcw.set(prefix + "version", x); }
	protected double getVersion() { return fcw.getDouble(prefix + "version"); }
	
	//Need to give each config it's own folder.
	public ConfigGod(String path, String target)
	{
		//Initialize variables.
		prefix = target + ".";
		
		// Initialize the FCW.
		fcw = new FileConfigurationWrapper(path, target);
	}
}
