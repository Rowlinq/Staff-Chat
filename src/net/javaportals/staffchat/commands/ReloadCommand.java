package net.javaportals.staffchat.commands;

import net.javaportals.staffchat.StaffChat;
import net.javaportals.staffchat.utils.*;

import org.bukkit.command.*;

public class ReloadCommand implements CommandExecutor
{

	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args)
	{
		
		if(commandSender.hasPermission(Permissions.RELOAD))
		{
			
			StaffChat.getStaffChat().reloadConfig();
			commandSender.sendMessage(StringUtilities.formatSuccess("The configuration have been reloaded!"));
			
			return true;
			
		}

		commandSender.sendMessage(StringUtilities.formatError("I'm sorry but you have insuficient permissions!"));
		
		return true;
	
	}

}