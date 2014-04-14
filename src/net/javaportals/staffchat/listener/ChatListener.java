package net.javaportals.staffchat.listener;

import static net.javaportals.staffchat.utils.StaffUtilities.*;
import net.javaportals.staffchat.StaffChat;
import net.javaportals.staffchat.utils.Permissions;

import org.bukkit.event.*;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener
{

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = false)
	public void onChat(AsyncPlayerChatEvent e)
	{
		
		if(!isStaff(e.getPlayer()))
		{
			
			if(!e.getPlayer().hasPermission(Permissions.SPEAK))
			{
				
				return;
				
			}
			
		}
	
		if(!StaffChat.getStaffChat().getToggledStaffMembers().contains(e.getPlayer()))
		{
			
			return;
			
		}
		
		e.setCancelled(true);
		broadcastMessage(e.getPlayer(), e.getMessage());
		
	}
	
}