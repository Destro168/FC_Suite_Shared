package me.Destro168.FC_Suite_Shared.ConfigManagers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class StringToY 
{
	public StringToY() { }
	
	public Location getLocationFromString(String xArg)
	{
		if (xArg == null || xArg.equalsIgnoreCase(""))
			return null;
		
		//Primary variable Declarations
		char[] c = xArg.toCharArray();
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
	
	public List<String> getStringListFromString(String xArg)
	{
		if (xArg == null || xArg.equalsIgnoreCase(""))
			return null;
		
		List<String> d = new ArrayList<String>();
		char[] c = xArg.toCharArray();
		int lastPos = 0;
		
		for (int i = 0; i < c.length; i++)
		{
			if (c[i] == ',')
			{
				d.add(returnMergedCharacters(lastPos, i, c));
				
				lastPos = i + 1;
			}
		}
		
		//Add final double.
		d.add(returnMergedCharacters(lastPos, c.length, c));
		
		return d;
	}
	
	public List<Double> getDoubleListFromString(String xArg)
	{
		if (xArg == null || xArg.equalsIgnoreCase(""))
			return null;
		
		List<Double> d = new ArrayList<Double>();
		char[] c = xArg.toCharArray();
		int lastPos = 0;
		
		for (int i = 0; i < c.length; i++)
		{
			if (c[i] == ',')
			{
				d.add(Double.valueOf(returnMergedCharacters(lastPos, i, c)));
				
				lastPos = i + 1;
			}
		}
		
		//Add final double.
		d.add(Double.valueOf(returnMergedCharacters(lastPos, c.length, c)));
		
		return d;
	}
	
	public List<Integer> getIntegerListFromString(String xArg)
	{
		if (xArg == null || xArg.equalsIgnoreCase(""))
			return null;
		
		List<Integer> d = new ArrayList<Integer>();
		char[] c = xArg.toCharArray();
		int lastPos = 0;
		
		for (int i = 0; i < c.length; i++)
		{
			if (c[i] == ',')
			{
				d.add(Integer.valueOf(returnMergedCharacters(lastPos, i, c)));
				lastPos = i + 1;
			}
		}
		
		//Add the final integer.
		d.add(Integer.valueOf(returnMergedCharacters(lastPos, c.length, c)));
		
		return d;
	}
	
	public List<Byte> getByteListFromString(String xArg)
	{
		if (xArg == null || xArg.equalsIgnoreCase(""))
			return null;
		
		List<Byte> d = new ArrayList<Byte>();
		char[] c = xArg.toCharArray();
		int lastPos = 0;
		
		for (int i = 0; i < c.length; i++)
		{
			if (c[i] == ',')
			{
				d.add(Byte.valueOf(returnMergedCharacters(lastPos, i, c)));
				lastPos = i + 1;
			}
		}
		
		//Add the final integer.
		d.add(Byte.valueOf(returnMergedCharacters(lastPos, c.length, c)));
		
		return d;
	}
	
	public String returnMergedCharacters(int startPosition, int endPosition, char[] c)
	{
		String finalString = "";
		
		for (int j = startPosition; j < endPosition; j++)
			finalString = finalString + c[j];
		
		return finalString;
	}
}
