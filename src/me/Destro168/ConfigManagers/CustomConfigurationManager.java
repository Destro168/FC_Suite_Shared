package me.Destro168.ConfigManagers;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import me.Destro168.FC_Suite_Shared.FC_Suite_Shared;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class CustomConfigurationManager
{
	private FC_Suite_Shared plugin;
	private FileConfiguration config;
    private File trueFile;
	private String target;
	private String absoluteFolderPath;
	
	public CustomConfigurationManager(String absoluteFolderPath_, String target_) 
	{
		//Variable Declarations
		plugin = FC_Suite_Shared.plugin;
		target = target_;
		trueFile = null;
		absoluteFolderPath = absoluteFolderPath_;
		
		//Load up the custom config.
		loadCustomConfig();
	}
	
	private void loadCustomConfig() 
	{
		if (absoluteFolderPath.equals(""))
		{
			plugin.getLogger().log(Level.SEVERE, "No absolute path passed in to store information in.");
			return;
		}
		else if (target.equals("")) //If no target, then we are null and return no target.
		{
			plugin.getLogger().log(Level.SEVERE, "No target assigned to store information at path.");
			return;
		}
		
		//If they have the special bounty code, then we load bounty information.
		if (target.equalsIgnoreCase("%BountySpecialCode%"))
			loadBountyConfig(absoluteFolderPath);
		
		//If the special ban code, then we load up ban information.
		else if (target.equalsIgnoreCase("%BanSpecialCode%"))
			loadBanConfig(absoluteFolderPath);
		
		//Else we just load up the name as a member of user information.
		else
			loadPlayerConfig(absoluteFolderPath + "\\userinfo");
		
        config = YamlConfiguration.loadConfiguration(trueFile);
    }
	
	private void loadPlayerConfig(String truePath)
	{
		//Set it to the same config to get the path.
        if (trueFile == null)
        	trueFile = new File(truePath, target + ".yml");
	}
	
	private void loadBountyConfig(String truePath)
	{
		//Set it to the same config to get the path.
        if (trueFile == null)
        	trueFile = new File(truePath, "bounties.yml");
	}
	
	private void loadBanConfig(String truePath)
	{
		//Set it to the same config to get the path.
        if (trueFile == null)
        	trueFile = new File(truePath, "ipLogging.yml");
	}
	
    public void saveCustomConfig() 
    {
		//Return if the configs are null.
        if (config == null || trueFile == null)
        {
            plugin.getLogger().log(Level.SEVERE, "Could not save config to " + trueFile + " due to nulls.");
        	return;
        }
        
        //Attempt to save the files.
        try {
        	config.save(trueFile);
        } catch (IOException ex) {
            plugin.getLogger().log(Level.SEVERE, "Could not save config to " + trueFile, ex);
        }
    }
    
    //Clear specific player data.
    public synchronized void clearFileData()
    {
    	//Variable Declaration
		String truePath;
		
		truePath = absoluteFolderPath;
		
    	config.set(truePath, null);
    	
    	saveCustomConfig();
    }
    
    /*
    Get/Sets for:
    Long, Int, String, Double, Boolean
    */
    
    //Long
    public void set(final String field, final long x)
    {
    	config.set(field, x); saveCustomConfig();
    }
    
    public Long getLong(final String field)
    {
    	return config.getLong(field);
    }
    
    //String
    public void set(final String field, final String x)
    {
    	config.set(field, x); saveCustomConfig();
    }

    public String getString(final String field)
    {
    	return config.getString(field);
    }
    
    //Double
    public void set(final String field, final double x)
    {
    	config.set(field, x); saveCustomConfig();
    }
    
    public double getDouble(final String field)
    {
    	return config.getDouble(field);
    }
    
    //Boolean
    public void set(final String field, final boolean x)
    {
    	config.set(field, x); saveCustomConfig();
    }
    
    public boolean getBoolean(final String field)
    {
    	return config.getBoolean(field);
    }
    
    //Int
    public void set(final String field, final int x)
    {
    	config.set(field, x); saveCustomConfig();
    }
    
    public int getInt(final String field)
    {
    	return config.getInt(field);
    }
}









