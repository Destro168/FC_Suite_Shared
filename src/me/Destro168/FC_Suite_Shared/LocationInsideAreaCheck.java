package me.Destro168.FC_Suite_Shared;

import org.bukkit.Location;

public class LocationInsideAreaCheck
{
	boolean isInside;
	
	public boolean getIsInside() { return isInside; }
	
	//Check if x is inside y and z.
	public LocationInsideAreaCheck(Location point, Location outerBound, Location innerBound)
	{
		isInside = false;
		
		double x1;
		double y1;
		double z1;
		double x2;
		double y2;
		double z2;
		double temp;
		
		x1 = outerBound.getX();
		y1 = outerBound.getY();
		z1 = outerBound.getZ();
		
		x2 = innerBound.getX();
		y2 = innerBound.getY();
		z2 = innerBound.getZ();
		
		//If all coords are at 0, meaning there is a defined zone, then success is true.
		if (x1 == 0 && y1 == 0 && z1 == 0 && x2 == 0 && y2 == 0 && z2 == 0)
		{
			isInside = true;
			return;
		}
		
		//Else if even one coord isn't 0, then success is parsed by zone.
		
		//Check if in the x range.
		if (x1 > x2)
		{
			temp = x1;
			x1 = x2;
			x2 = temp;
		}
		
		//Have to add 1 for some reason.
		x2 = x2 + 1;
		
		if (!(point.getX() >= x1 && point.getX() <= x2))
		{
			isInside = false;
			return;
		}
		
		//Check if in the z range.
		if (z1 > z2)
		{
			temp = z1;
			z1 = z2;
			z2 = temp;
		}
		
		//Have to add 1 for some reason.
		z2 = z2 + 1;
		
		if (!(point.getZ() >= z1 && point.getZ() <= z2)) 
		{
			isInside = false;
			return;
		}
		
		//Check if in the y range.
		if (y1 > y2)
		{
			temp = y1;
			y1 = y2;
			y2 = temp;
		}

		if (!(point.getY() >= y1 && point.getY() <= y2))
		{
			isInside = false;
			return;
		}
		
		//If all checks were successful return true.
		isInside = true;
	}
}





