package me.Destro168.ConfigManagers;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

public class FileConfigPlus 
{
	private FileConfiguration config;
	
	public FileConfigPlus(FileConfiguration config_)
	{
		config = config_;
	}
	
	public void setLocation(String field, String world, double x, double y, double z)
	{
		config.set(field, world + "," + x + "," + y + "," + z);
	}
	
	public void setLocation(String field, String world, double x, double y, double z, float yaw, float pitch)
	{
		config.set(field, world + "," + x + "," + y + "," + z + "," + yaw + "," + pitch);
	}
	
	public Location getLocation(String field)
	{
		//Primary variable Declarations
		char[] c = config.getString(field).toCharArray();
		int lastPos = 0;
		int lastReadCounter = 0;
		String worldName = "";
		String x = "";
		String y = "";
		String z = "";
		String yaw = "";
		String pitch = "";
		
		for (int i = 0; i < c.length; i++)
		{
			if (c[i] == ',')
			{
				if (lastReadCounter == 0)
					worldName = returnMergedCharacters(lastPos, i, c);
				else if (lastReadCounter == 1)
					x = returnMergedCharacters(lastPos, i, c);
				else if (lastReadCounter == 2)
					y = returnMergedCharacters(lastPos, i, c);
				else if (lastReadCounter == 3)
					z = returnMergedCharacters(lastPos, i, c);
				else if (lastReadCounter == 4)
					yaw = returnMergedCharacters(lastPos, i, c);
				else if (lastReadCounter == 5)
					pitch = returnMergedCharacters(lastPos, i, c);
				
				lastPos = i + 1;
				lastReadCounter++;
			}
		}

		//Attempt to set the world.
		World world = Bukkit.getServer().getWorld(worldName);
		
		//If the world is null we return.
		if (world == null)
			return null;
		
		//Secondary variable Declarations
		double x2 = Double.valueOf(x);
		double y2 = Double.valueOf(y);
		double z2 = Double.valueOf(z);
		float yaw2 = 0;
		float pitch2 = 0;
		
		if (!yaw.equals(""))
			yaw2 = Float.valueOf(yaw);
		
		if (!pitch.equals(""))
			pitch2 = Float.valueOf(pitch);
		
		//Return the location comprised of all values.
		return new Location(world,x2,y2,z2,yaw2,pitch2);
	}
	
	private String returnMergedCharacters(int startPosition, int endPosition, char[] c)
	{
		String finalString = "";
		
		for (int j = startPosition; j < endPosition; j++)
			finalString = finalString + c[j];
		
		return finalString;
	}
}



/*
//Attempt to create the location and return it.
try {  }
catch (NullPointerException e) { return null; }
catch (IndexOutOfBoundsException e) { return null; }
*/


