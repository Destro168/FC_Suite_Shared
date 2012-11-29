package me.Destro168.FC_Suite_Shared;

import java.util.HashMap;
import java.util.Map;

import me.Destro168.FC_Suite_Shared.Messaging.MessageLib;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class SelectionVector 
{
	private MessageLib msgLib;
	private Map<Player, Location> blockLoc1 = new HashMap<Player, Location>();
	private Map<Player, Location> blockLoc2 = new HashMap<Player, Location>();
	
	public Location getBlockLoc1(Player player)
	{
		if (blockLoc1.containsKey(player))
			return blockLoc1.get(player);
		
		return null;
	}
	
	public Location getBlockLoc2(Player player)
	{
		if (blockLoc2.containsKey(player))
			return blockLoc2.get(player);
		
		return null;
	}

    public SelectionVector() { }
    
    public void selectNewPoint(Player player, Location blockLoc, boolean isLeftClick)
    {
    	msgLib = new MessageLib(player);
    	
    	if (isLeftClick == true)
    	{
    		if (blockLoc1.containsKey(player))
    			blockLoc1.remove(player);
    		
    		blockLoc1.put(player, blockLoc);
			msgLib.standardMessage("Successfully Selected First Point.");
    	}
    	else
    	{
    		if (blockLoc2.containsKey(player))
    			blockLoc2.remove(player);
    		
			blockLoc2.put(player, blockLoc);
			msgLib.standardMessage("Successfully Selected Second Point.");
    	}
    }
    
   public boolean expandVert(Player player)
   {
	   if (blockLoc1.containsKey(player))
		   blockLoc1.get(player).setY(0);
	   
	   if (blockLoc2.containsKey(player))
		   blockLoc2.get(player).setY(999);
	   
	   return true;
   }
}















