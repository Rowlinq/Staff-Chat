package net.javaportals.staffchat.events.message;

import net.javaportals.staffchat.StaffChat;
import net.javaportals.staffchat.events.StaffChatEvent;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;

public class StaffMessageEvent extends StaffChatEvent implements Cancellable
{
	
	private boolean cancelled = false;
	private CommandSender staffMember;
	private String group = "";
	private String message = "";
	private String format = "";
	
	public StaffMessageEvent(CommandSender staffMember, String message, String format)
	{
	
		this.staffMember = staffMember;
		
		if(StaffChat.getStaffChat().isPermissionsPresent() && staffMember instanceof Player)
		{
			
			if(StaffChat.getStaffChat().getPermission().hasGroupSupport())
			{
				
				this.group = StaffChat.getStaffChat().getPermission().getPrimaryGroup((Player) this.getStaffMember());
				
			}
			
		}
		
		this.message = message;
		this.format = format;
		
	}
	
	public StaffMessageEvent(CommandSender staffMember, String group, String message, String format)
	{
	
		this.staffMember = staffMember;
		this.group = group;
		this.message = message;
		this.format = format;
		
	}
	
	public CommandSender getStaffMember()
	{
	
		return this.staffMember;

	}
	
	public void setStaffMember(CommandSender staffMember)
	{
		
		this.staffMember = staffMember;
		
	}

	public String getGroup()
	{
	
		return group;
	
	}

	public void setGroup(String group)
	{
		
		this.group = group;
		
	}
	
	public String getMessage()
	{
	
		return message;
	
	}

	public void setMessage(String message)
	{
		
		this.message = message;
		
	}
	
	public String getFormat()
	{
	
		return this.format;
	
	}
	
	public void setFormat(String format)
	{
		
		this.format = format;
		
	}

	@Override
	public boolean isCancelled()
	{

		return this.cancelled;
	
	}

	@Override
	public void setCancelled(boolean cancelled)
	{
		
		this.cancelled = cancelled;
		
	}

}