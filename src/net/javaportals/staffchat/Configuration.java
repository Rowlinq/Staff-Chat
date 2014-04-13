package net.javaportals.staffchat;

import java.util.*;

import org.bukkit.configuration.file.FileConfiguration;

public class Configuration
{

	public Configuration()
	{
		
		List<String> groups = new ArrayList<String>();
		groups.add("mod");
		groups.add("admin");
		groups.add("owner");

		this.getConfiguration().addDefault("groups", groups);
		this.getConfiguration().addDefault("format", "&2[&aStaffChat&2] &e#PLAYER# &3(&b#GROUP#&3)&7: &6#MESSAGE#");
		this.getConfiguration().options().copyDefaults(true);
		StaffChat.getStaffChat().saveConfig();
		
	}
	
	public FileConfiguration getConfiguration()
	{
	
		return StaffChat.getStaffChat().getConfig();
		
	}
	
	public List<String> getStaffGroups()
	{
		
		List<String> groups = new ArrayList<String>();
		groups.add("mod");
		groups.add("admin");
		groups.add("owner");
		
		if(this.getConfiguration().isList("groups"))
		{
			
			if(this.getConfiguration().getStringList("groups").size() > 0)
			{
				
				return this.getConfiguration().getStringList("groups");
				
			}
			
		}
		
		return groups;
		
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
	
}