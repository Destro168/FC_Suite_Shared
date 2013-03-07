package me.Destro168.FC_Suite_Shared.ConfigManagers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;

public class ListGetter
{
	final private int BREAK_COUNTER_LIMIT = 100;
	
	FileConfigurationWrapper fcw;
	String field;
	int breakCounter;
	
	public ListGetter(FileConfigurationWrapper fcw_, String field_)
	{
		fcw = fcw_;
		field = field_;
		breakCounter = 0;
	}
	
	public List<Integer> getFieldIntegerList()
	{
		List<Integer> a = new ArrayList<Integer>();
		
		for (int i = 0; i < 999999; i++)
		{
			if (fcw.isSet(field + i))
				a.add(i);
			else
			{
				breakCounter++;
				
				if (breakCounter > BREAK_COUNTER_LIMIT)
					return a;
			}
		}
		
		return a;
	}
	
	public List<String> getStringList()
	{
		List<String> a = new ArrayList<String>();
		String b;
		
		for (int i = 0; i < 999999; i++)
		{
			try {
				b = fcw.getString(field + "." + i);
				a.add(b);
			} catch (NullPointerException e) {
				breakCounter++;
				
				if (breakCounter > BREAK_COUNTER_LIMIT)
					return a;
			}
		}
		
		return a;
	}
	
	public List<Location> getLocationList()
	{
		List<Location> a = new ArrayList<Location>();
		Location b;
		
		for (int i = 0; i < 999999; i++)
		{
			b = fcw.getLocation(field + "." + i);
			
			if (b != null)
				a.add(b);
			else
			{
				breakCounter++;
				
				if (breakCounter > BREAK_COUNTER_LIMIT)
					return a;
			}
		}
		
		return a;
	}
	
	public static int attemptGetEntryFieldByNumberInput(List<Integer> fieldList, String input)
	{
		int intInput;
		
		try { intInput = Integer.valueOf(input); } catch (NumberFormatException e) { return -1; }
		
		if (intInput > -1 && intInput < fieldList.size())
			return intInput;
		
		return -1;
	}
}
