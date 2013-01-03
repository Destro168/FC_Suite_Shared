package me.Destro168.FC_Suite_Shared.ConfigManagers;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

public class FileConfigPlus 
{
	private FileConfiguration config;
	
	public FileConfigPlus(FileConfiguration config_)
	{
		config = config_;
	}
	
	public void setLocation(String field, String world, double x, double y, double z, float yaw, float pitch)
	{
		config.set(field, world + "," + x + "," + y + "," + z + "," + yaw + "," + pitch);
	}
	
	public Location getLocation(String field)
	{
		StringToY y = new StringToY();
		
		return y.getLocationFromString(config.getString(field));
	}
}



/*
//Attempt to create the location and return it.
try {  }
catch (NullPointerException e) { return null; }
catch (IndexOutOfBoundsException e) { return null; }
*/


