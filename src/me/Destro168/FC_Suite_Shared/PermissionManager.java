package me.Destro168.FC_Suite_Shared;

import net.milkbowl.vault.permission.Permission;

import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

public class PermissionManager 
{
	public Player player;
	public Permission permission;
	public boolean isConsole;
	
	public boolean permissionsEnabled() { if (isConsole == true) return true; else return (permission != null); }
	public Permission getPermission() { setupPermissions(); return permission; }
	
	public PermissionManager(Player player_) 
	{
		setDefaults();
		player = player_;
		setupPermissions();
	}
	
	public PermissionManager(boolean isConsole_)
	{
		setDefaults();
		
		if (isConsole_ == true)
			isConsole = true;
		else
			isConsole = false;
	}
	
	private void setDefaults()
	{
		player = null;
		permission = null;
		isConsole = false;
	}
	
	//Tested in main to make sure that this works so it should work 100% for sure no matter what from now on.
	protected void setupPermissions()
    {
        RegisteredServiceProvider<Permission> permissionProvider = FC_Suite_Shared.plugin.getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        
        if (permissionProvider == null)
        {
        	FC_Suite_Shared.plugin.getLogger().info("PP Not Found.");
        	return;
        }
        
        permission = permissionProvider.getProvider();
    }
	
	public boolean isOwner()
	{
		if (isConsole == true)
			return true;
		
		else if (permission.has(player, "FC_Suite.owner"))
			return true;
		
		return false;
	}
	
	public boolean isGlobalAdmin()
	{
		if (isOwner() == true)
			return true;
		
		else if (permission.has(player, "FC_Suite.admin"))
			return true;
		
		else if (player.isOp() == true)
			return true;
		
		return false;
	}
	
	public boolean isGlobalMod()
	{
		if (isGlobalAdmin() == true)
			return true;
		
		else if (permission.has(player, "FC_Suite.mod"))
			return true;
		
		return false;
	}
}