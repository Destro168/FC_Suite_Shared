package me.Destro168.ConfigManagers;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

import me.Destro168.FC_Suite_Shared.FC_Suite_Shared;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class CustomConfigurationManager
{
	private FC_Suite_Shared plugin;
	private FileConfiguration config;
    private File trueFile;
	private String target;
	private String absoluteFolderPath;
	private FileConfigPlus fcp;
	
	public FileConfiguration getConfig() { return config; }
	
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
		
		//Load up player file from target.
        if (trueFile == null)
        	trueFile = new File(absoluteFolderPath, target + ".yml");
		
        config = YamlConfiguration.loadConfiguration(trueFile);
        fcp = new FileConfigPlus(config);
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
    
    /***************************************************
    * Get/Sets for: Long, Int, String, Double, Boolean
    ***************************************************/
    
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
    
    //Location
    public void setLocation(final String field, String worldName, double x, double y, double z, float a, float b)
    {
    	fcp.setLocation(field, worldName, x, y, z, a, b); saveCustomConfig();
    }
    
    public void setLocation(final String field, String worldName, double x, double y, double z)
    {
    	fcp.setLocation(field, worldName, x, y, z); saveCustomConfig();
    }
    
    public Location getLocation(final String field)
    {
    	return fcp.getLocation(field);
    }
    
    //Integer List
    public void setList(final String field, final List<?> x)
    {
    	config.set(field, x); saveCustomConfig();
    }
    
    public List<Integer> getIntegerList(final String field)
    {
    	return config.getIntegerList(field);
    }
    
    public List<String> getStringList(final String field)
    {
    	return config.getStringList(field);
    }
    
    public List<Double> getDoubleList(final String field)
    {
    	return config.getDoubleList(field);
    }
}


//String List
/*
public void set(final String field, final List<String> x)
{
	config.set(field, x); saveCustomConfig();
}
*/








