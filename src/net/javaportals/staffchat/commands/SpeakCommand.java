package net.javaportals.staffchat.commands;

import static net.javaportals.staffchat.utils.StaffUtilities.*;
import net.javaportals.staffchat.utils.Permissions;
import net.javaportals.staffchat.utils.StringUtilities;

import org.bukkit.command.*;

public class SpeakCommand implements CommandExecutor
{

	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args)
	{
		
		if(!isStaff(commandSender))
		{
		
			if(!commandSender.hasPermission(Permissions.SPEAK))
			{
				
				commandSender.sendMessage(StringUtilities.formatError("I'm sorry but you have insuficient permissions!"));
				
				return true;
				
			}
			
		}
		
		broadcastStaffMessage(parseStaffMessage(commandSender, StringUtilities.toString(args)));
		
		return true;
	
	}

}