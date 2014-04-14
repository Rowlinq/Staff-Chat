package net.javaportals.staffchat.commands;

import static net.javaportals.staffchat.utils.StaffUtilities.*;
import net.javaportals.staffchat.StaffChat;
import net.javaportals.staffchat.utils.*;

import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class ToggleCommand implements CommandExecutor
{

	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args)
	{
		
		if(commandSender instanceof ConsoleCommandSender)
		{
			
			commandSender.sendMessage(StringUtilities.formatError("I'm sorry but this is a player only command!"));
			
			return true;
			
		}
		
		if(!isStaff(commandSender))
		{
		
			if(!commandSender.hasPermission(Permissions.SPEAK))
			{
				
				commandSender.sendMessage(StringUtilities.formatError("I'm sorry but you have insuficient permissions!"));
				
				return true;
				
			}
			
		}
		
		if(!commandSender.hasPermission(Permissions.TOGGLE))
		{
			
			commandSender.sendMessage(StringUtilities.formatError("I'm sorry but you have insuficient permissions!"));
			
			return true;
			
		} 
		
		Player player = (Player) commandSender;
		
		if(StaffChat.getStaffChat().getToggledStaffMembers().contains(player))
		{
			
			StaffChat.getStaffChat().getToggledStaffMembers().remove(player);
			commandSender.sendMessage(StringUtilities.formatSuccess("All chat messages will now go to the regular chat!"));
			
		}
		else
		{
			
			StaffChat.getStaffChat().getToggledStaffMembers().add(player);
			commandSender.sendMessage(StringUtilities.formatSuccess("All chat messages will now go to the staff chat!"));
			
		}
		
		return true;
	
	}

}