package me.Destro168.FC_Suite_Shared;

import me.Destro168.FC_Suite_Shared.Messaging.MessageLib;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
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
		
		CommandGod cg = new CommandGod();
		getCommand("FCinfo").setExecutor(cg);
		
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
	
	public class CommandGod implements CommandExecutor
	{
		public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args2)
	    {
			if (command.getName().equalsIgnoreCase("FCinfo"))
			{
				MessageLib msgLib = new MessageLib(sender);
				
				msgLib.standardHeader("FC Plugins Info Page");
				msgLib.standardMessage("The FC plugins are created by Destro168.");
				msgLib.standardMessage("For more FC plugins and information, please visit the link: http://dev.bukkit.org/profiles/Destro168/");
			}
			
			return true;
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
