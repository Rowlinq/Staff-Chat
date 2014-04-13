package net.javaportals.staffchat.commands;

import net.javaportals.staffchat.StaffChat;
import net.javaportals.staffchat.utils.*;

import org.bukkit.command.*;

public class UpdateCommand implements CommandExecutor
{

	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args)
	{
		
		if(commandSender.hasPermission(Permissions.UPDATE))
		{

			commandSender.sendMessage(StringUtilities.formatInfo("Checking for updates"));
			StaffChat.getStaffChat().getUpdater().checkUpdate();
			
			if(!StaffChat.getStaffChat().getUpdater().isUpdateAvailable())
			{
				
				commandSender.sendMessage(StringUtilities.formatInfo("The plugin is up to date!"));
				
			}
			
			return true;
			
		}

		commandSender.sendMessage(StringUtilities.formatError("I'm sorry but you have insuficient permissions!"));
		
		return true;
	
	}

}