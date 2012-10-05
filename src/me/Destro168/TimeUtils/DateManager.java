package me.Destro168.TimeUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateManager 
{
	private Long timeInMillis;
	
	public Long getTimeInMillis() { return timeInMillis; }
	
	public DateManager() { }
	
	public String getTimeStringFromTimeInteger(int seconds)
	{
		String strDate = "";
		int weeks;
		int days;
		int hours;
		int minutes;
		
		//Set up the weeks.
		weeks = seconds / 604800;
		
		if (weeks > 0)
			seconds = (int) (seconds - 604800 * weeks);
		
		//Set up the days.
		days = seconds / 86400;
		
		if (days > 0)
			seconds = (int) (seconds - 86400 * days);
		
		//Set up the hours.
		hours = seconds / 3600;
		
		if (hours > 0)
			seconds = (int) (seconds - 3600 * hours);
		
		//Set up the minutes.
		minutes = seconds / 60;
		
		if (minutes > 0)
			seconds = (int) (seconds - 60 * minutes);
		
		//Form the string for the date.
		
		//Start with weeks.
		if (weeks > 0)
		{
			//Put in the primilary value.
			strDate += String.valueOf(weeks) + " week";
			
			//Add s if more than 1.
			if (weeks > 1)
				strDate += "s";
			
			//Add dash if any more times are remaining.
			if (days != 0 || hours != 0 || minutes != 0 || seconds != 0)
				strDate += " - ";
		}
		
		//Next days
		if (days > 0)
		{
			//Put in the primilary value.
			strDate += String.valueOf(days) + " day";
			
			//Add s if more than 1.
			if (days > 1)
				strDate += "s";
			
			//Add dash if any more times are remaining.
			if (hours != 0 || minutes != 0 || seconds != 0)
				strDate += " - ";
		}
		
		//Next hours
		if (hours > 0)
		{
			//Put in the primilary value.
			strDate += String.valueOf(hours) + " hour";
			
			//Add s if more than 1.
			if (hours > 1)
				strDate += "s";
			
			//Add dash if any more times are remaining.
			if (minutes != 0 || seconds != 0)
				strDate += " - ";
		}
		
		//Next minutes
		if (minutes > 0)
		{
			//Put in the primilary value.
			strDate += String.valueOf(minutes) + " minute";
			
			//Add s if more than 1.
			if (minutes > 1)
				strDate += "s";
			
			//Add dash if any more times are remaining.
			if (seconds != 0)
				strDate += " - ";
		}
		
		//Lastly Seconds
		if (seconds > 0)
		{
			//Put in the primilary value.
			strDate += String.valueOf(seconds) + " second";
			
			//Add s if more than 1.
			if (seconds > 1)
				strDate += "s";
		}
		
		//Add a period
		strDate += ".";
		
		return strDate;
	}
	
	public long getFutureDate_Seconds(int int_Seconds)
	{
		//Set punishment end to future date
		Calendar gc = new GregorianCalendar();
		
		//Referesh now.
		Date now = new Date();
		
		//Set starting time
		gc.setTime(now);
		
		//Add the time.
		gc.add(Calendar.SECOND, int_Seconds);
		
		//Set the time in milliseconds.
		timeInMillis = gc.getTimeInMillis();
		
		return timeInMillis;
	}
	
	public long getFutureDate_Hours(int int_Hours)
	{
		//Set punishment end to future date
		Calendar gc = new GregorianCalendar();
		
		//Referesh now.
		Date now = new Date();
		
		//Set starting time
		gc.setTime(now);
		
		//Add the time.
		gc.add(Calendar.HOUR, int_Hours);
		
		//Set the time in milliseconds.
		timeInMillis = gc.getTimeInMillis();
		
		return timeInMillis;
	}
	
	public long getFutureDate_Months(int int_Months)
	{
		//Set punishment end to future date
		Calendar gc = new GregorianCalendar();
		
		//Referesh now.
		Date now = new Date();
		
		//Set starting time
		gc.setTime(now);
		
		//Add the time.
		gc.add(Calendar.MONTH, int_Months);
		
		//Set the time in milliseconds.
		timeInMillis = gc.getTimeInMillis();
		
		return timeInMillis;
	}
	
	public long getFutureDate(long int_Milliseconds)
	{
		//Set punishment end to future date
		Calendar gc = new GregorianCalendar();
		
		//Referesh now.
		Date now = new Date();
		
		//Set starting time
		gc.setTime(now);
		
		//Add the time.
		gc.add(Calendar.SECOND, (int) (int_Milliseconds * 1000));
		
		//Set the time in milliseconds.
		timeInMillis = gc.getTimeInMillis();
		
		return timeInMillis;
	}
	
	public long getLongAddition(Long long1, Long long2)
	{
		//Set punishment end to future date
		Calendar gc = new GregorianCalendar();
		
		//Referesh now.
		Date long1Date = new Date(long1);
		
		//Set starting time
		gc.setTime(long1Date);
		
		//Add the time.
		gc.add(Calendar.SECOND, (int) (long2 * 1000));
		
		//Set the time in milliseconds.
		timeInMillis = gc.getTimeInMillis();
		
		return timeInMillis;
	}
}


















