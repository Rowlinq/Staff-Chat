package net.javaportals.staffchat;

import java.util.*;

import net.javaportals.staffchat.utils.StringUtilities;

import org.bukkit.configuration.file.FileConfiguration;

public class Configuration
{

	public Configuration()
	{
		
		List<String> groups = new ArrayList<String>();
		groups.add("mod");
		groups.add("admin");
		groups.add("owner");
		List<String> servers = new ArrayList<String>();
		servers.add("default");

		this.getConfiguration().options().header("Please check http://dev.bukkit.org/bukkit-plugins/staffchatbyroe/pages/setup/ for a guide on how to set the plugin up");
		this.getConfiguration().options().copyHeader(true);
		this.getConfiguration().addDefault("checkForUpdates", true);
		this.getConfiguration().addDefault("groups", groups);
		this.getConfiguration().addDefault("format", "&2[&aStaffChat&2] &e#PLAYER# &3(&b#GROUP#&3)&7: &6#MESSAGE#");
		this.getConfiguration().addDefault("servers", servers);
		this.getConfiguration().addDefault("server.default.ip", "127.0.0.1");
		this.getConfiguration().addDefault("server.default.port", 24731);
		this.getConfiguration().addDefault("server.default.format", "theirs");
		this.getConfiguration().addDefault("server.default.type", "listen");
		this.getConfiguration().addDefault("server.default.password", "Enter password here");
		this.getConfiguration().addDefault("internalservers", servers);
		this.getConfiguration().addDefault("internalserver.default.ip", "0.0.0.0");
		this.getConfiguration().addDefault("internalserver.default.port", "24731");
		this.getConfiguration().addDefault("internalserver.default.password", StringUtilities.generateRandomString());
		this.getConfiguration().addDefault("internalserver.default.allow", "both");
		this.getConfiguration().options().copyDefaults(true);
		StaffChat.getStaffChat().saveConfig();
		
	}
	
	public boolean shouldCheckForUpdate()
	{
		
		return this.getConfiguration().getBoolean("checkForUpdates", true);
		
	}
	
	public FileConfiguration getConfiguration()
	{
	
		return StaffChat.getStaffChat().getConfig();
		
	}
	
	public List<String> getStaffGroups()
	{
		
		return this.getConfiguration().getStringList("groups");
		
	}
	
	public void setStaffGroups(List<String> groups)
	{
		
		this.getConfiguration().set("groups", groups);
		StaffChat.getStaffChat().saveConfig();
		
	}
  
	public String getFormat()
	{
		
		return this.getConfiguration().getString("format", "&2[&aStaffChat&2] &e#PLAYER# &3(&b#GROUP#&3)&7: &6#MESSAGE#");
		
	}
	
	public void setFormat(String format)
	{
		
		this.getConfiguration().set("format", format);
		StaffChat.getStaffChat().saveConfig();
		
	}
	
	public List<String> getEnabledServers()
	{

		return this.getConfiguration().getStringList("servers");
		
	}
	
	public void setEnabledServers(List<String> servers)
	{
		
		this.getConfiguration().set("servers", servers);
		StaffChat.getStaffChat().saveConfig();
		
	}
	
	public void addServer(String name, String ip, int port, String format, String type, String password, boolean enable)
	{
		
		if(this.getEnabledServers().contains(name))
		{
			
			return;
			
		}
		
		this.setServerIP(name, ip);
		this.setServerPort(name, port);
		this.setServerFormat(name, format);
		this.setServerType(name, type);
		this.setServerPassword(name, password);
		
		if(enable)
		{
			
			List<String> servers = this.getEnabledServers();
			servers.add(name);
			this.setEnabledServers(servers);
			
		}
		
	}
	
	public String getServerIP(String name)
	{
		
		return this.getConfiguration().getString("server." + name + ".ip", "NULL");
		
	}
	
	public void setServerIP(String name, String ip)
	{
		
		this.getConfiguration().set("server." + name + ".ip", ip);
		StaffChat.getStaffChat().saveConfig();
		
	}
	
	public int getServerPort(String name)
	{
		
		return this.getConfiguration().getInt("server." + name + ".port", -1);
		
	}
	
	public void setServerPort(String name, int port)
	{
		
		this.getConfiguration().set("server." + name + ".port", port);
		StaffChat.getStaffChat().saveConfig();
		
	}
	
	public String getServerFormat(String name)
	{
		
		return this.getConfiguration().getString("server." + name + ".format", "thiers");
		
	}
	
	public void setServerFormat(String name, String format)
	{
		
		this.getConfiguration().set("server." + name + ".format", format);
		StaffChat.getStaffChat().saveConfig();
		
	}
	
	public String getServerType(String name)
	{
		
		return this.getConfiguration().getString("server." + name + ".type", "listens");
		
	}
	
	public void setServerType(String name, String type)
	{
		
		this.getConfiguration().set("server." + name + ".type", type);
		StaffChat.getStaffChat().saveConfig();
		
	}
	
	public String getServerPassword(String name)
	{
		
		return this.getConfiguration().getString("server." + name + ".password", "");
		
	}
	
	public void setServerPassword(String name, String password)
	{
		
		this.getConfiguration().set("server." + name + ".password", password);
		StaffChat.getStaffChat().saveConfig();
		
	}
	
	public List<String> getInternalServers()
	{
		
		return this.getConfiguration().getStringList("internalservers");
		
	}
	
	public String getInternalServerIP(String name)
	{
		
		return this.getConfiguration().getString("internalserver." + name + ".ip", "NULL");
		
	}
	
	public void setInternalServerIP(String name, String ip)
	{
		
		this.getConfiguration().set("internalserver." + name + ".ip", ip);
		StaffChat.getStaffChat().saveConfig();
		
	}
	
	public int getInternalServerPort(String name)
	{
		
		return this.getConfiguration().getInt("internalserver." + name + "port", -1);
		
	}
	
	public void setInternalServerPort(String name, int port)
	{
		
		this.getConfiguration().set("internalserver." + name + ".port", port);
		StaffChat.getStaffChat().saveConfig();
		
	}
	
	public String getInternalServerAllowedMethods(String name)
	{
		
		return this.getConfiguration().getString("internalserver." + name + ".allow", "both");
		
	}
	
	public void setInternalServerAllowedMethods(String name, String method)
	{
		
		this.getConfiguration().set("internalserver." + name + ".allow", method);
		StaffChat.getStaffChat().saveConfig();
		
	}
	
	public String getInternalServerPassword(String name)
	{
		
		return this.getConfiguration().getString("internalserver." + name + ".password", "");
		
	}
	
	public void setInternalServerPassword(String name, String password)
	{
		
		this.getConfiguration().set("internalserver." + name + ".password", password);
		StaffChat.getStaffChat().saveConfig();
		
	}
	
}