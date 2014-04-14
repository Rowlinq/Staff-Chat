package net.javaportals.staffchat.utils;

import net.javaportals.staffchat.StaffChat;
import net.javaportals.staffchat.events.message.StaffMessageEvent;
import net.javaportals.staffchat.events.message.StaffMessagedEvent;

import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import static net.javaportals.staffchat.utils.StringUtilities.*;

public class StaffUtilities
{
	
	@Deprecated
	public static String parseStaffMessage(CommandSender sender, String message)
	{
		
		String format = StaffChat.getStaffChat().getConfiguration().getFormat();
		format = StringUtilities.replaceCodes(format);
		
		if(sender.hasPermission(Permissions.COLOR))
		{
			
			message = StringUtilities.replaceCodes(message);
			
		}
		
		format = format.replace("#MESSAGE#", message);
		
		if(sender instanceof ConsoleCommandSender)
		{

			
			format = format.replaceAll("#PLAYER#", "Console");
			format = format.replaceAll("#UUID#", "");
			format = format.replaceAll("#DISPLAY#", "");
			format = format.replaceAll("#GROUP#", "");
			format = format.replaceAll("#CUSTOM#", "");
			
			return format;
			
		}
		
		Player player = (Player) sender;
		
		if(StaffChat.getStaffChat().isPermissionsPresent())
		{
			
			if(StaffChat.getStaffChat().getPermission().hasGroupSupport())
			{
				
				format = format.replaceAll("#GROUP#", upperCaseFirstCharacter(StaffChat.getStaffChat().getPermission().getPrimaryGroup(player)));
				
			}
			else
			{

				format = format.replaceAll("#GROUP#", "");
				
			}
			
		}
		else
		{
			
			format = format.replaceAll("#GROUP#", "");
			
		}
		
		format = format.replaceAll("#PLAYER#", player.getName());
		format = format.replaceAll("#UUID#", player.getUniqueId().toString());
		format = format.replaceAll("#DISPLAY#", player.getDisplayName());
		
		try
		{
			
			format = format.replaceAll("#CUSTOM#", player.getCustomName());
			
		}
		catch(NullPointerException e)
		{
			
		}
		
		return format;
		
	}
	
	@Deprecated
	public static void broadcastStaffMessage(String message)
	{
		
		for(Player player : Bukkit.getOnlinePlayers())
		{
			
			if(!isStaff(player))
			{
				
				if(!player.hasPermission(Permissions.LISTEN))
				{
					
					return;
					
				}
				
			}
			
			player.sendMessage(message);
			
		}
		
		Bukkit.getConsoleSender().sendMessage(message);
		
	}
	
	public static void broadcastMessage(CommandSender staffMember, String message)
	{
		
		StaffMessageEvent event = new StaffMessageEvent(staffMember, message, StaffChat.getStaffChat().getConfiguration().getFormat());
		Bukkit.getPluginManager().callEvent(event);
		
		if(event.isCancelled())
		{
			
			return;
			
		}
		
		message = parse(event.getStaffMember(), event.getMessage(), event.getFormat(), event.getGroup());
		
		for(Player player : Bukkit.getOnlinePlayers())
		{
			
			if(!isStaff(player))
			{
				
				if(!player.hasPermission(Permissions.LISTEN))
				{
					
					return;
					
				}
				
			}
			
			player.sendMessage(message);
			Bukkit.getPluginManager().callEvent(new StaffMessagedEvent(player, event.getGroup(), event.getFormat(), message));
			
		}
		
		Bukkit.getConsoleSender().sendMessage(message);
		Bukkit.getPluginManager().callEvent(new StaffMessagedEvent(Bukkit.getConsoleSender(), event.getGroup(), event.getFormat(), message));
		
	}
	
	public static String parse(CommandSender sender, String message, String format, String group)
	{
		
		if(format.equalsIgnoreCase(""))
		{
			
			StaffChat.getStaffChat().getConfiguration().getFormat();
		
		}
		
		format = StringUtilities.replaceCodes(format);
		
		if(sender.hasPermission(Permissions.COLOR))
		{
			
			message = StringUtilities.replaceCodes(message);
			
		}
		
		format = format.replace("#MESSAGE#", message);
		
		if(sender instanceof ConsoleCommandSender)
		{

			
			format = format.replace("#PLAYER#", "Console");
			format = format.replace("#UUID#", "");
			format = format.replace("#DISPLAY#", "Console");
			format = format.replace("#GROUP#", "");
			format = format.replace("#CUSTOM#", "");
			
			return format;
			
		}
		
		Player player = (Player) sender;
		format = format.replace("#PLAYER#", player.getName());
		format = format.replace("#GROUP#", group);
		format = format.replace("#UUID#", player.getUniqueId().toString());
		format = format.replace("#DISPLAY#", player.getDisplayName());
		
		try
		{
			
			format = format.replace("#CUSTOM#", player.getCustomName());
			
		}
		catch(NullPointerException e)
		{
			
		}
		
		return format;
		
	}
	
	public static boolean isStaff(CommandSender sender)
	{
		
		if(sender instanceof ConsoleCommandSender)
		{
			
			return true;
			
		}
		
		Player player = (Player) sender;
		
		if(!StaffChat.getStaffChat().isVaultPresent())
		{
			
			return false;
			
		}
	
		if(StaffChat.getStaffChat().isPermissionsPresent())
		{
			
			if(StaffChat.getStaffChat().getPermission().hasGroupSupport())
			{
				
				for(String playerGroup : StaffChat.getStaffChat().getPermission().getPlayerGroups(player))
				{
					
					for(String staffGroup : StaffChat.getStaffChat().getConfiguration().getStaffGroups())
					{
						
						if(staffGroup.equalsIgnoreCase(playerGroup))
						{
							
							return true;
							
						}
						
					}
					
				}
				
			}
			
		}

		return false;
		
	}
	
}