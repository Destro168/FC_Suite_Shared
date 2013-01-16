package me.Destro168.FC_Suite_Shared.Leaderboards;

import java.util.List;

import me.Destro168.FC_Suite_Shared.ConfigManagers.FileConfigurationWrapper;
import me.Destro168.FC_Suite_Shared.Messaging.BroadcastLib;
import me.Destro168.FC_Suite_Shared.Messaging.MessageLib;

public class Leaderboard
{
	protected FileConfigurationWrapper fcw;
	protected BroadcastLib bLib = new BroadcastLib();
	protected List<String> playerNameList;
	protected List<Integer> playerCountList;
	protected String name;
	protected String header;
	protected String countSuffix;
	
	private void setNameList(List<String> x) { fcw.setList(name + ".name", x); }
	private void setNameCount(List<Integer> x) { fcw.setList(name + ".count", x); }
	
	public List<String> getNames() { return fcw.getStringList(name + ".name"); }
	public List<Integer> getCounts() { return fcw.getIntegerList(name + ".count"); }
	
	//Header should be plural. Name is the file access.
	public Leaderboard(FileConfigurationWrapper fcw_, String name_, String header_, String countSuffix_)
	{
		name = name_;
		header = header_;
		fcw = fcw_;
		countSuffix = countSuffix_;
		
		playerNameList = getNames();
		playerCountList = getCounts();
		
		//If the topkillers board hasn't been made yet, then....
		if (playerNameList.size() == 0 && playerCountList.size() == 0)
		{
			//Create five default bounties.
			for (int i = 0; i < 5; i++)
			{
				playerNameList.add("[Nobody]");
				playerCountList.add(-1);
			}
			
			//Update the names and counts.
			updateConfigLists();
		}
	}
	
	private void updateConfigLists() 
	{
		setNameList(playerNameList);
		setNameCount(playerCountList);
	}
	
	public void attemptUpdate(String name, int totalCount)
	{
		int size = playerCountList.size();
		
		//If the new entry exists in the list, then....
		for (int i = 0; i < size; i++)
		{
			if (playerNameList.get(i).equals(name))
			{
				//Shift everything up to fill the entry spot up.
				for (int j = i; j > 0; j--)
				{
					playerCountList.set(j, playerCountList.get(j-1));
					playerNameList.set(j, playerNameList.get(j-1));
				}
			}
		}
		
		//Going from size -> 0.
		for (int i = size - 1; i > -1; i--)
		{
			//If we reach a spot, store there immediately and end.
			if (playerCountList.get(i) == 0)
			{
				playerCountList.set(i, totalCount);
				playerNameList.set(i, name);
				break;
			}
			
			//Else we want to only store names on the list if they are greater than a previous entry.
			else if (playerCountList.get(i) < totalCount)
			{
				//Shift everything down at that spot by 1.
				for (int j = 0; j < i; j++)
				{
					playerCountList.set(j, playerCountList.get(j+1));
					playerNameList.set(j, playerNameList.get(j+1));
				}
				
				//Put the new entry at that location.
				playerCountList.set(i, totalCount);
				playerNameList.set(i, name);
				break;
			}
		}
		
		updateConfigLists();
	}
	
	public void displayLeaderboard(MessageLib msgLib)
	{
		//Variable Declarations
		int positionCount = 1;
		
		List<String> names = getNames();
		List<Integer> counts = getCounts();
		
		//Display that information to the player.
		msgLib.standardHeader("Top " + header);
		
		for (int j = names.size() - 1; j > names.size() - 6; j--)
		{
			if (counts.get(j) > 0)
			{
				msgLib.standardMessage("#" + positionCount + ": &p" + names.get(j) + "&p at " + counts.get(j) + " " + countSuffix);
				positionCount++;
			}
			else
			{
				msgLib.standardMessage("#" + positionCount + ": " + "[None]!");
				positionCount++;
			}
		}
		
		if (positionCount <= 1)
			msgLib.standardMessage("The leaderboard Is Empty!");
		else
			msgLib.standardMessage("Finished Listing.");
	}
}







