package me.Destro168.FC_Suite_Shared.TimeUtils;

public class TimeStringParser 
{
	private String durationTimeText;
	
	private int int_Seconds;
	private int int_Minutes;
	private int int_Hours;
	private int int_Days;
	private int int_Weeks;
	
	public String getDurationTimeText() { return durationTimeText; }
	public int getIntSeconds() { return int_Seconds; }
	
	public TimeStringParser()
	{
		setDefaults();
	}
	
	public TimeStringParser(String userInput)
	{
		setDefaults();
		
		parseUserInputTimeString(userInput);
	}
	
	private void setDefaults()
	{
		//Set variable defaults.
		durationTimeText = "";
		
		int_Seconds = 0;
		int_Minutes = 0;
		int_Hours = 0;
		int_Days = 0;
		int_Weeks = 0;
	}
	
	//Parse the duration / Standard format: 1s5m8h10d3w
	public String parseUserInputTimeString(String userInput)
	{
		//Variable Declarations
		char[] userInputCharArray = userInput.toCharArray();
		int currentPosition = 0;
		String str_Seconds = "";
		String str_Minutes = "";
		String str_Hours = "";
		String str_Days = "";
		String str_Weeks = "";
		
		try
		{
			//Perform the actual parse.
			for (int i = 0; i < userInputCharArray.length; i++)
			{
				if (userInputCharArray[i] == 's')
				{
					for (int j = currentPosition; j < i; j++)
						str_Seconds += userInputCharArray[j];
					
					int_Seconds = Integer.valueOf(str_Seconds);
					
					currentPosition = i + 1;

					str_Seconds = "";
				}
				
				else if (userInputCharArray[i] == 'm')
				{
					for (int j = currentPosition; j < i; j++)
						str_Minutes += userInputCharArray[j];
					
					int_Minutes = Integer.valueOf(str_Minutes);
					
					currentPosition = i + 1;
					
					str_Minutes = "";
				}
				
				else if (userInputCharArray[i] == 'h')
				{
					for (int j = currentPosition; j < i; j++)
						str_Hours += userInputCharArray[j];
					
					int_Hours = Integer.valueOf(str_Hours);
					
					currentPosition = i + 1;
					
					str_Hours = "";
				}
				
				else if (userInputCharArray[i] == 'd')
				{
					for (int j = currentPosition; j < i; j++)
						str_Days += userInputCharArray[j];
					
					int_Days = Integer.valueOf(str_Days);
					
					currentPosition = i + 1;
					
					str_Days = "";
				}
				
				else if (userInputCharArray[i] == 'w')
				{
					for (int j = currentPosition; j < i; j++)
						str_Weeks += userInputCharArray[j];
					
					int_Weeks = Integer.valueOf(str_Weeks);
					
					currentPosition = i + 1;
					
					str_Weeks = "";
				}
			}
		}
		catch (NumberFormatException e) { return ""; }
		
		//Automatically call this.
		return convertTimesToString();
	}
	
	//Take the times and convert them into a duration time text.
	private String convertTimesToString()
	{
		//Variable Declarations
		DateManager dm = new DateManager();
		
		//Store the proper amount of time all in the seconds variable and form the proper duration text.
		if (int_Weeks > 0)
			int_Seconds += int_Weeks*604800;
		
		if (int_Days > 0)
			int_Seconds += int_Days*86400;
		
		if (int_Hours > 0)
			int_Seconds += int_Hours*3600;
		
		if (int_Minutes > 0)
			int_Seconds += int_Minutes*60;
		
		//Set duration time text.
		durationTimeText = dm.getTimeStringFromTimeInteger(int_Seconds);
		
		//Return it.
		return durationTimeText;
	}
}
