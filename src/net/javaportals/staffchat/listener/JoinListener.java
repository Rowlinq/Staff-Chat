package net.javaportals.staffchat.listener;

import net.javaportals.staffchat.StaffChat;
import net.javaportals.staffchat.utils.Permissions;
import net.javaportals.staffchat.utils.StringUtilities;

import org.bukkit.event.*;
import org.bukkit.event.player.PlayerJoinEvent;

import static net.javaportals.staffchat.utils.StaffUtilities.*;

public class JoinListener implements Listener
{

	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = false)
	public void onJoin(PlayerJoinEvent e)
	{
		
		if(!isStaff(e.getPlayer()))
		{
			
			if(!e.getPlayer().hasPermission(Permissions.SPEAK))
			{
				
				return;
				
			}
			
		}
	
		if(StaffChat.getStaffChat().getToggledStaffMembers().contains(e.getPlayer()))
		{
			
			e.getPlayer().sendMessage(StringUtilities.formatInfo("You have the staff chat enabled! All of your chat messages will go to it. Type in /togglestaffchat to disable it"));
			
		}
		
		if(e.getPlayer().hasPermission(Permissions.UPDATE) && StaffChat.getStaffChat().getUpdater().isUpdateAvailable())
		{
			
			e.getPlayer().sendMessage(StringUtilities.formatInfo("An update is available! get it at http://dev.bukkit.org/bukkit-plugins/staffchatbyroet"));
			
		}
		
	}
	
}