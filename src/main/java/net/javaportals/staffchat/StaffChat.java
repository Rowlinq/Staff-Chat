package net.javaportals.staffchat;

import java.util.ArrayList;

import net.javaportals.staffchat.commands.*;
import net.javaportals.staffchat.listener.*;
import net.javaportals.staffchat.updater.Updater;
import net.javaportals.staffchat.utils.*;
import net.milkbowl.vault.Vault;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.Bukkit;
import org.bukkit.entity.*;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class StaffChat extends JavaPlugin
{
	
	private Updater updater;
	private Configuration configuration;
	private Permission permission = null;
	private final ArrayList<Player> toggledStaffMembers = new ArrayList<Player>();
	
	public void onEnable()
	{
		
		this.setConfiguration(new Configuration());
		
		this.setUpdater(new Updater(this, 46910, this.getFile(), Updater.UpdateType.DEFAULT, true));
		
		if(this.isVaultPresent())
		{
			
			Log._("Found vault! Attempting to setup permissions!");
			
			if(this.setupPermissions())
			{
				
				Log._("Permissions setup!");
				
			}
			else
			{
				
				Log._("Unable to setup permissions");
				
			}
			
		}
		else
		{

			Log._("Vault is not present! Group features will not be available!");
			
		}

		this.getCommand("staffchat").setExecutor(new SpeakCommand());
		this.getCommand("togglestaffchat").setExecutor(new ToggleCommand());
		this.getCommand("reloadstaffchat").setExecutor(new ReloadCommand());
		Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
		Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
		
	}
	
	public static StaffChat getStaffChat()
	{
		
		return (StaffChat) Bukkit.getServer().getPluginManager().getPlugin("StaffChat");
		
	}
	
	public Updater getUpdater()
	{
	
		return this.updater;
	
	}

	public void setUpdater(Updater updater)
	{
	
		this.updater = updater;
	
	}

	public Configuration getConfiguration()
	{
	
		return this.configuration;
	
	}

	public void setConfiguration(Configuration configuration)
	{
	
		this.configuration = configuration;
	
	}

	public boolean isVaultPresent()
	{
		
		return this.getVault() != null;
		
	}
	
	public Vault getVault()
	{
		
		return (Vault) Bukkit.getPluginManager().getPlugin("Vault");
		
	}
	
	public boolean setupPermissions()
	{
		
		RegisteredServiceProvider<Permission> permissionProvider = this.getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
	       
		if (permissionProvider != null)
		{
        
			this.setPermission(permissionProvider.getProvider());
			
			return true;
        
		}	
		
		return false;
		
	}
	
	public boolean isPermissionsPresent()
	{
		
		return this.getPermission() != null;
		
	}

	public Permission getPermission()
	{
	
		return permission;
	
	}

	public void setPermission(Permission permission)
	{
	
		this.permission = permission;
	
	}
 
	public ArrayList<Player> getToggledStaffMembers()
	{
	
		return this.toggledStaffMembers;
	
	}
	
}