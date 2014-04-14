package net.javaportals.staffchat.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class StaffChatEvent extends Event
{
	
	private static final HandlerList handlers = new HandlerList();

	@Override
	public HandlerList getHandlers()
	{

		return handlers;

	}

}