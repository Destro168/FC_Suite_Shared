package me.Destro168.TimeUtils;

public class TimeInMilliseconds 
{
	int time;
	
	public TimeInMilliseconds() { }
	
	public long getSecondLength()
	{
		return 1000;
	}
	
	public long getMinuteLength()
	{
		return 60000;
	}
	
	public long getHourLength()
	{
		return 3600000;
	}
	
	public long getDayLength()
	{
		return 86400000;
	}
	
	public long getMonthLength()
	{
		return (long) (86400000 * 30);
	}
	
	public long getYearLength()
	{
		return (long) (86400000 * 365);
	}
}
