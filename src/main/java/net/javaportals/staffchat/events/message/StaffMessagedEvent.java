package net.javaportals.staffchat.events.message;

import net.javaportals.staffchat.events.StaffChatEvent;

import org.bukkit.command.CommandSender;

public class StaffMessagedEvent extends StaffChatEvent
{
	
	private CommandSender staffMember;
	private String group = "";
	private String message = "";
	private String format = "";
	
	public StaffMessagedEvent(CommandSender staffMember, String group, String message, String format)
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

}