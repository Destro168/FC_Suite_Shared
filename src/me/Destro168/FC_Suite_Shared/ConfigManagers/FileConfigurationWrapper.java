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
	
	private StringToY converter;
	
	private Map<String, Integer> staticIntMap = new HashMap<String, Integer>();
	private Map<String, Short> staticShortMap = new HashMap<String, Short>();
	private Map<String, Double> staticDoubleMap = new HashMap<String, Double>();
	private Map<String, Long> staticLongMap = new HashMap<String, Long>();
	private Map<String, String> staticStringMap = new HashMap<String, String>();
	private Map<String, Boolean> staticBooleanMap = new HashMap<String, Boolean>();
	private Map<String, Location> staticLocationMap = new HashMap<String, Location>();
	private Map<String, List<Integer>> staticIntegerListMap = new HashMap<String, List<Integer>>();
	private Map<String, List<String>> staticStringListMap = new HashMap<String, List<String>>();
	private Map<String, List<Double>> staticDoubleListMap = new HashMap<String, List<Double>>();
	private Map<String, List<Byte>> staticByteListMap = new HashMap<String, List<Byte>>();
	
	public void setAbsoluteFolderPath(String x) { absoluteFolderPath = x; }
	public FileConfiguration getConfig() { return config; }
	
	public FileConfigurationWrapper(String absoluteFolderPath_, String target_)
	{
		// Variable Declarations
		plugin = FC_Suite_Shared.plugin;
		target = target_;
		trueFile = null;
		absoluteFolderPath = absoluteFolderPath_;
		converter = new StringToY();
		
		// Load up the custom config.
		loadCustomConfig();
	}

	private void loadCustomConfig()
	{
		if (absoluteFolderPath.equals(""))
		{
			plugin.getLogger().log(Level.SEVERE, "No absolute path passed in to store information in.");
			return;
		}
		else if (target.equals("")) // If no target, then we are null and return no target.
		{
			plugin.getLogger().log(Level.SEVERE, "No target assigned to store information at path.");
			return;
		}

		// Attempt to create a new folder for the path if it doesn't exist.
		File f = new File(absoluteFolderPath);

		if (!f.exists())
			f.mkdir();

		// Load up player file from target.
		if (trueFile == null)
			trueFile = new File(absoluteFolderPath, target + ".yml");

		config = YamlConfiguration.loadConfiguration(trueFile);
		fcp = new FileConfigPlus(config);
	}

	public void saveCustomConfig()
	{
		// Return if the configs are null.
		if (config == null || trueFile == null)
		{
			plugin.getLogger().log(Level.SEVERE, "Could not save config to " + trueFile + " due to nulls.");
			return;
		}
		
		// Attempt to save the files.
		try
		{
			config.save(trueFile);
		} catch (IOException ex)
		{
			plugin.getLogger().log(Level.SEVERE, "Could not save config to " + trueFile, ex);
		}
	}

	// Clear specific player data.
	public void clearFileData()
	{
		LogWrapper log = new LogWrapper(FC_Suite_Shared.plugin.getLogger());
		log.log(absoluteFolderPath);
		
		// Variable Declaration
		File f = new File(absoluteFolderPath, target + ".yml");

		if (!f.exists())
			return;

		f.delete();
	}

	/************************************************************************************************************************************************************************************************************
	 * 
	 * Get/Sets for: Long, Int, String, Double, Boolean Now uses my brand new idea that absolutely rapes dicks. Optimizes file accesses so that everything will be even faster.
	 * 
	 ************************************************************************************************************************************************************************************************************/

	// Object
	public void set(String field, Object o)
	{
		config.set(field, o);
		saveCustomConfig();
	}
	
	public void setNull(String... fields)
	{
		for (String s : fields)
			config.set(s, null);
	
		saveCustomConfig();
	}
	
	public Object get(String field)
	{
		return config.get(field);
	}
	
	public boolean isSet(String field)
	{
		return config.isSet(field);
	}
	
	// Long
	public void set(String field, long x)
	{
		config.set(field, x);
		saveCustomConfig();
	}

	public Long getLong(String field)
	{
		return config.getLong(field);
	}

	public Long getStaticLong(String field, long defaultValue)
	{
		if (staticLongMap.containsKey(field))
			return staticLongMap.get(field);
		else if (config.isSet(field))
			staticLongMap.put(field, config.getLong(field));
		else
		{
			set(field, defaultValue);
			staticLongMap.put(field, defaultValue);
		}
		
		return staticLongMap.get(field);
	}
	
	// String
	public void set(String field, String x)
	{
		config.set(field, x);
		saveCustomConfig();
	}

	public String getString(String field)
	{
		return config.getString(field);
	}
	
	public String getStaticString(String field, String defaultValue)
	{
		if (staticStringMap.containsKey(field))
			return staticStringMap.get(field);
		else if (config.isSet(field))
			staticStringMap.put(field, config.getString(field));
		else
		{
			set(field, defaultValue);
			staticStringMap.put(field, defaultValue);
		}
		
		return staticStringMap.get(field);
	}
	
	// Double
	public void set(String field, double x)
	{
		config.set(field, x);
		saveCustomConfig();
	}

	public double getDouble(String field)
	{
		return config.getDouble(field);
	}
	
	public Double getStaticDouble(String field, double defaultValue)
	{
		if (staticDoubleMap.containsKey(field))
			return staticDoubleMap.get(field);
		else if (config.isSet(field))
			staticDoubleMap.put(field, config.getDouble(field));
		else
		{
			set(field, defaultValue);
			staticDoubleMap.put(field, defaultValue);
		}

		return staticDoubleMap.get(field);
	}

	// Boolean
	public void set(String field, boolean x)
	{
		config.set(field, x);
		saveCustomConfig();
	}

	public boolean getBoolean(String field)
	{
		return config.getBoolean(field);
	}

	public Boolean getStaticBoolean(String field, boolean defaultValue)
	{
		if (staticBooleanMap.containsKey(field))
			return staticBooleanMap.get(field);
		else if (config.isSet(field))
			staticBooleanMap.put(field, config.getBoolean(field));
		else
		{
			set(field, defaultValue);
			staticBooleanMap.put(field, defaultValue);
		}

		return staticBooleanMap.get(field);
	}

	// Int
	public void set(String field, int x)
	{
		config.set(field, x);
		saveCustomConfig();
	}

	public int getInt(String field)
	{
		return config.getInt(field);
	}

	public int getStaticInt(String field, int defaultValue)
	{
		if (staticIntMap.containsKey(field))
			return staticIntMap.get(field);
		else if (config.isSet(field))
			staticIntMap.put(field, config.getInt(field));
		else
		{
			set(field, defaultValue);
			staticIntMap.put(field, defaultValue);
		}
		
		return staticIntMap.get(field);
	}
	
	// Short
	public void set(String field, short x)
	{
		config.set(field, x);
		saveCustomConfig();
	}

	public short getShort(String field)
	{
		return (short) config.getInt(field);
	}

	public short getStaticShort(String field, short defaultValue)
	{
		if (staticShortMap.containsKey(field))
			return staticShortMap.get(field);
		else if (config.isSet(field))
			staticShortMap.put(field, (short) config.getInt(field));
		else
		{
			set(field, defaultValue);
			staticShortMap.put(field, defaultValue);
		}
		
		return staticShortMap.get(field);
	}

	// Location
	public void setLocation(String field, Location loc)
	{
		fcp.setLocation(field, loc.getWorld().getName(), loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
		saveCustomConfig();
	}

	public void setLocation(String field, String worldName, double x, double y, double z, float a, float b)
	{
		fcp.setLocation(field, worldName, x, y, z, a, b);
		saveCustomConfig();
	}
	
	public Location getLocation(String field)
	{
		return fcp.getLocation(field);
	}

	public Location getStaticLocation(String field, Location defaultValue)
	{
		if (staticLocationMap.containsKey(field))
			return staticLocationMap.get(field);
		else if (config.isSet(field))
			staticLocationMap.put(field, fcp.getLocation(field));
		else
		{
			setLocation(field, defaultValue);
			staticLocationMap.put(field, defaultValue);
		}
		
		return staticLocationMap.get(field);
	}
	
	// Lists
	public void setList(String field, List<?> x)
	{
		config.set(field, x);
		saveCustomConfig();
	}
	
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
	
	//Custom lists
	public List<Integer> getCustomIntegerList(String field)
	{
		return converter.getIntegerListFromString(config.getString(field));
	}
	
	public List<String> getCustomStringList(String field)
	{
		return converter.getStringListFromString(config.getString(field));
	}
	
	public List<Double> getCustomDoubleList(String field)
	{
		return converter.getDoubleListFromString(config.getString(field));
	}
	
	public List<Byte> getCustomByteList(String field)
	{
		return converter.getByteListFromString(config.getString(field));
	}
	
	// Normal list static gets
	public List<Integer> getStaticIntegerList(String field, List<Integer> defaultList)
	{
		if (staticIntegerListMap.containsKey(field))
			return staticIntegerListMap.get(field);
		
		if (config.isSet(field))
			staticIntegerListMap.put(field, config.getIntegerList(field));
		else
		{
			setList(field, defaultList);
			staticIntegerListMap.put(field, defaultList);
		}
		
		return staticIntegerListMap.get(field);
	}
	
	public List<String> getStaticStringList(String field, List<String> defaultList)
	{
		if (staticStringListMap.containsKey(field))
			return staticStringListMap.get(field);

		if (config.isSet(field))
			staticStringListMap.put(field, config.getStringList(field));
		else
		{
			setList(field, defaultList);
			staticStringListMap.put(field, defaultList);
		}
		
		return staticStringListMap.get(field);
	}
	
	public List<Double> getStaticDoubleList(String field, List<Double> defaultList)
	{
		if (staticDoubleListMap.containsKey(field))
			return staticDoubleListMap.get(field);
		
		if (config.isSet(field))
			staticDoubleListMap.put(field, config.getDoubleList(field));
		else
		{
			setList(field, defaultList);
			staticDoubleListMap.put(field, defaultList);
		}
		
		return staticDoubleListMap.get(field);
	}
	
	public List<Byte> getStaticByteList(String field, List<Byte> defaultList)
	{
		if (staticByteListMap.containsKey(field))
			return staticByteListMap.get(field);
		
		if (config.isSet(field))
			staticByteListMap.put(field, config.getByteList(field));
		else
		{
			setList(field, defaultList);
			staticByteListMap.put(field, defaultList);
		}
		
		return staticByteListMap.get(field);
	}
	
	// Custom List static gets
	public List<Integer> getStaticCustomIntegerList(String field, String defaultList)
	{
		if (staticIntegerListMap.containsKey(field))
			return staticIntegerListMap.get(field);
		
		if (config.isSet(field))
			staticIntegerListMap.put(field, converter.getIntegerListFromString(config.getString(field)));
		else
		{
			List<Integer> list = converter.getIntegerListFromString(defaultList);
			setCustomList(field, list);
			staticIntegerListMap.put(field, list);
		}
		
		return staticIntegerListMap.get(field);
	}
	
	public List<String> getStaticCustomStringList(String field, String defaultList)
	{
		if (staticStringListMap.containsKey(field))
			return staticStringListMap.get(field);
		
		if (config.isSet(field))
			staticStringListMap.put(field, converter.getStringListFromString(config.getString(field)));
		else
		{
			List<String> list = converter.getStringListFromString(defaultList);
			setCustomList(field, list);
			staticStringListMap.put(field, list);
		}
		
		return staticStringListMap.get(field);
	}
	
	public List<Double> getStaticCustomDoubleList(String field, String defaultList)
	{
		if (staticDoubleListMap.containsKey(field))
			return staticDoubleListMap.get(field);
		
		if (config.isSet(field))
			staticDoubleListMap.put(field, converter.getDoubleListFromString(config.getString(field)));
		else
		{
			List<Double> list = converter.getDoubleListFromString(defaultList);
			setCustomList(field, list);
			staticDoubleListMap.put(field, list);
		}
		
		return staticDoubleListMap.get(field);
	}
	
	public List<Byte> getStaticCustomByteList(String field, String defaultList)
	{
		if (staticByteListMap.containsKey(field))
			return staticByteListMap.get(field);
		
		if (config.isSet(field))
			staticByteListMap.put(field, converter.getByteListFromString(config.getString(field)));
		else
		{
			List<Byte> list = converter.getByteListFromString(defaultList);
			setCustomList(field, list);
			staticByteListMap.put(field, list);
		}
		
		return staticByteListMap.get(field);
	}
}














