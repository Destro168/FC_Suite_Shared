package me.Destro168.FC_Suite_Shared;

import net.milkbowl.vault.permission.Permission;

import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class FC_Suite_Shared extends JavaPlugin
{
	public static FC_Suite_Shared plugin;
	public static SuiteConfig sc;
	
	@Override
	public void onDisable() 
	{
		this.getLogger().info("Disabled.");
	}
	
	@Override
	public void onEnable() 
	{
		plugin = this;
		
		//Set up permissions.
		if (setupPermissions() == false)
		{
			FC_Suite_Shared.plugin.getLogger().info("Please install Vault to use this plugin.");
			Bukkit.getServer().getPluginManager().disablePlugin(this);
			return;
		}
		
		//This is the suite config.
		sc = new SuiteConfig();
		
		//Log success.
		this.getLogger().info("Successfully found Vault. Enabled Successfully");
		
	    try {
			new AutoUpdate(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private boolean setupPermissions()
    {
		Permission permission = null;
		
        RegisteredServiceProvider<Permission> permissionProvider = FC_Suite_Shared.plugin.getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        
        if (permissionProvider != null) 
            permission = permissionProvider.getProvider();
        
        return (permission != null);
    }
}
