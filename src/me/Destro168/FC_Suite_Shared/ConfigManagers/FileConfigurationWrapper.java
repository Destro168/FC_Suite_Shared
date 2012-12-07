package me.Destro168.FC_Suite_Shared.ConfigManagers;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import me.Destro168.FC_Suite_Shared.FC_Suite_Shared;
import me.Destro168.FC_Suite_Shared.Messaging.LogWrapper;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class FileConfigurationWrapper
{
	private FC_Suite_Shared plugin;
	private FileConfiguration config;
    private File trueFile;
	private String target;
	private String absoluteFolderPath;
	private FileConfigPlus fcp;
	
	public void setAbsoluteFolderPath(String x) { absoluteFolderPath = x; }
	
	public FileConfiguration getConfig() { return config; }
	
	public FileConfigurationWrapper(String absoluteFolderPath_, String target_) 
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
		
		//Attempt to create a new folder for the path if it doesn't exist.
		File f = new File(absoluteFolderPath);
		
		if (!f.exists())
			f.mkdir();
		
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
    public void clearFileData()
    {
    	LogWrapper log = new LogWrapper(FC_Suite_Shared.plugin.getLogger());
    	log.log_Debug(absoluteFolderPath);
    	
    	//Variable Declaration
    	File f = new File(absoluteFolderPath, target + ".yml");
    	
		if (!f.exists())
			return;
		
		f.delete();
    }
    
    /***************************************************
    
    * Get/Sets for: Long, Int, String, Double, Boolean
    * Now uses my brand new idea that absolutely rapes dicks.
    * Optimizes file accesses so that everything will be even faster.
    
    ***************************************************/
    
    private Map<String, Integer> ints = new HashMap<String, Integer>();
	private Map<String, Double> doubles = new HashMap<String, Double>();
	private Map<String, Long> longs = new HashMap<String, Long>();
	private Map<String, String> strings = new HashMap<String, String>();
	private Map<String, Boolean> booleans = new HashMap<String, Boolean>();
	private Map<String, Location> locations = new HashMap<String, Location>();
	
    //Long
    public void set(String field, long x)
    {
    	config.set(field, x); saveCustomConfig();
    }
    
    public Long getLong(String field)
    {
    	return config.getLong(field);
    }
    
    public Long getLongS(String field) //S is short for stagnant or special, whichever.
    {
    	if (longs.containsKey(field))
			return longs.get(field);
		else
		{
			longs.put(field, config.getLong(field));
			return longs.get(field);
		}
    }
    
    //String
    public void set(String field, String x)
    {
    	config.set(field, x); saveCustomConfig();
    }
    
    public String getString(String field)
    {
    	return config.getString(field);
    }
    
    public String getStringS(String field)
    {
    	if (strings.containsKey(field))
			return strings.get(field);
		else
		{
			strings.put(field, config.getString(field));
			return strings.get(field);
		}
    }
    
    //Double
    public void set(String field, double x)
    {
    	config.set(field, x); saveCustomConfig();
    }
    
    public double getDouble(String field)
    {
    	return config.getDouble(field);
    }
    
    public double getDoubleS(String field)
    {
    	if (doubles.containsKey(field))
			return doubles.get(field);
		else
		{
			doubles.put(field, config.getDouble(field));
			return doubles.get(field);
		}
    }
    
    //Boolean
    public void set(String field, boolean x)
    {
    	config.set(field, x); saveCustomConfig();
    }
    
    public boolean getBoolean(String field)
    {
    	return config.getBoolean(field);
    }
    
    public boolean getBooleanS(String field)
    {
    	if (booleans.containsKey(field))
			return booleans.get(field);
		else
		{
			booleans.put(field, config.getBoolean(field));
			return booleans.get(field);
		}
    }
    
    //Int
    public void set(String field, int x)
    {
    	config.set(field, x); saveCustomConfig();
    }
	
    public int getInt(String field)
    {
    	return config.getInt(field);
    }
    
    public int getIntS(String field)
    {
    	if (ints.containsKey(field))
			return ints.get(field);
		else
		{
			ints.put(field, config.getInt(field));
			return ints.get(field);
		}
    }
    
    //Location
    public void setLocation(String field, String worldName, double x, double y, double z, float a, float b)
    {
    	fcp.setLocation(field, worldName, x, y, z, a, b); saveCustomConfig();
    }
    
    public Location getLocation(String field)
    {
    	return fcp.getLocation(field);
    }
    
    public Location getLocationS(String field)
    {
    	if (locations.containsKey(field))
			return locations.get(field);
		else
		{
			locations.put(field, fcp.getLocation(field));
			return locations.get(field);
		}
    }
    
    //Lists
    public void setList(String field, List<?> x)
    {
    	config.set(field, x); saveCustomConfig();
    }
    
    public List<Integer> getIntegerList(String field)
    {
    	return config.getIntegerList(field);
    }
    
    public List<String> getStringList(String field)
    {
    	return config.getStringList(field);
    }
    
    public List<Double> getDoubleList(String field)
    {
    	return config.getDoubleList(field);
    }
    
    public List<Byte> getByteList(String field)
    {
    	return config.getByteList(field);
    }
    
    //Custom List
    public void setCustomList(String field, List<?> x)
   	{
    	if (x == null)
    	{
    		set(field, null);
    		return;
    	}
    	
    	if (x.get(0) == null)
    	{
    		set(field, "");
    		return;
   		}
    	
   		String a = String.valueOf(x.get(0));
   		
   		for (int i = 1; i < x.size(); i++) 
   			a += "," + String.valueOf(x.get(i));
   		
   		set(field, a);
   	}
    
    //Object
    public void set(String field, Object o)
    {
    	config.set(field, o); saveCustomConfig();
    }
    
    public Object get(String field)
    {
    	return config.get(field);
    }
    
    public boolean isSet(String field)
    {
    	return config.isSet(field);
    }
}


//String List
/*
public void set(final String field, final List<String> x)
{
	config.set(field, x); saveCustomConfig();
}
*/








