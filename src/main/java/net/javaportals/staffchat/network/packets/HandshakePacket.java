package net.javaportals.staffchat.network.packets;

import net.javaportals.staffchat.network.ConnectionType;
import net.javaportals.staffchat.network.Packet;

public class HandshakePacket extends Packet
{

	private static final long serialVersionUID = 6946394984074853610L;
	private final String password;
	private final ConnectionType connectionType;
	
	public HandshakePacket(String password, ConnectionType connectionType)
	{
		
		this.password = password;
		this.connectionType = connectionType;
		
	}

	public String getPassword()
	{
	
		return this.password;
	
	}

	public ConnectionType getConnectionType()
	{
	
		return this.connectionType;
	
	}

}