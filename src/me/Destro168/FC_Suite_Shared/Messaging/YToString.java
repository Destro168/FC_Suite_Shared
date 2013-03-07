package me.Destro168.FC_Suite_Shared.Messaging;

import java.util.List;

import me.Destro168.FC_Suite_Shared.ColorLib;
import me.Destro168.FC_Suite_Shared.SuiteConfig;

public class YToString
{
	public SuiteConfig cm;
	public ColorLib cLib = new ColorLib();
	
	public YToString()
	{
		cm = new SuiteConfig();
		cLib = new ColorLib();
	}
	
	public String toString(List<String> msg)
	{
		//Variable Declarations
		String message = "";
		boolean alternate = true;
		
		//We want to alternate the colors for the standard  message.
		for (int i = 0; i < msg.size(); i++)
		{
			if (msg.get(i) != null)
			{
				if (alternate == true)
					message += cm.getColorPrimary() + "" + msg.get(i);
				else if (alternate == false)
					message += cm.getColorSecondary() + "" + msg.get(i);
				
				alternate = !alternate;
			}
		}
		
		return message;
	}
	
	public String toString(String[] msg)
	{
		//Variable Declarations
		String message = "";
		boolean alternate = true;
		
		//We want to alternate the colors for the standard  message.
		for (int i = 0; i < msg.length; i++)
		{
			if (msg[i] != null)
			{
				if (alternate == true)
					message += cm.getColorPrimary() + "" + msg[i];
				else if (alternate == false)
					message += cm.getColorSecondary() + "" + msg[i];
				
				alternate = !alternate;
			}
		}
		
		return message;
	}
}



