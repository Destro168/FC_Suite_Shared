package me.Destro168.FC_Suite_Shared.Messaging;

import java.util.logging.Logger;

import me.Destro168.FC_Suite_Shared.FC_Suite_Shared;

public class LogWrapper 
{
	public Logger log;
	private static int debugCounter;
	
	public void resetDebugCounter() { debugCounter = 0; }
	
	public LogWrapper(Logger log_)
	{
		log = log_;
		debugCounter = 0;
	}
	
	public void log_Text(String text)
	{
		if (text == null)
			text = "Null";
		
		log.info(text);
	}
	
	public void log_Debug(Object text)
	{
		if (text == null)
			text = "Null";
		
		if (FC_Suite_Shared.sc.getDebug() == true)
		{
			log.severe("DEBUGING -> " + String.valueOf(text));
		}
	}
	
	public void log_Debug_Count2()
	{
		if (FC_Suite_Shared.sc.getDebug() == true)
		{
			log.severe("DEBUGING COUNTER -> " + debugCounter);
			debugCounter += 2;
		}
	}
	
	public void log_Debug_Count()
	{
		if (FC_Suite_Shared.sc.getDebug() == true)
		{
			log.severe("DEBUGING COUNTER -> " + debugCounter);
			debugCounter++;
		}
	}
}
