package net.javaportals.staffchat.network.packets;

import net.javaportals.staffchat.network.Packet;

public class MessagePacket extends Packet
{

	private static final long serialVersionUID = -1010808469153619738L;
	private final String user;
	private final String display;
	private final String custom;
	private final String group;
	private final String format;
	private final String message;
	
	public MessagePacket(String user, String display, String custom, String group, String format, String message)
	{
		
		this.user = user;
		this.display = display;
		this.custom = custom;
		this.group = group;
		this.format = format;
		this.message = message;
		
	}
	
	public String getUser()
	{
	
		return this.user;
	
	}

	public String getDisplay()
	{
	
		return this.display;
	
	}

	public String getCustom()
	{
	
		return this.custom;
	
	}

	public String getGroup()
	{
	
		return this.group;
	
	}

	public String getFormat()
	{
	
		return this.format;
	
	}

	public String getMessage()
	{
	
		return this.message;

	}

}