package net.javaportals.staffchat.server;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

import net.javaportals.staffchat.utils.Log;

import java.util.logging.Level;

public class Server extends Thread
{

	private boolean running = true;
	public final String ip;
	public final int port;
	private final ServerSocket socket;
	private final ArrayList<Connection> connections = new ArrayList<Connection>();
	
	public Server(String ip, int port) throws IOException
	{
	
		this._("Initializing, please make sure that you're allowed to bind to this ip and port by your host(If any)");
		
		this.ip = ip;
		this.port = port;
		this.socket = new ServerSocket();
		this.getSocket().bind(new InetSocketAddress(this.getIP(), this.getPort()));
		
	}
	
	public void run()
	{
		
		this._("Starting");
		
		while(this.isRunning())
		{
			
		}
		
	}

	public boolean isRunning()
	{
	
		return this.running;
	
	}

	public void setRunning(boolean running)
	{
	
		this.running = running;
	
	}
	
	public String getIP()
	{
		
		return this.ip;
		
	}
	
	public int getPort()
	{
		
		return this.port;
		
	}

	public ServerSocket getSocket()
	{
	
		return this.socket;
	
	}

	public ArrayList<Connection> getConnections()
	{
	
		return this.connections;
	
	}
	
	public void _(String message)
	{
		
		this._(message, Level.INFO);
		
	}
	
	public void _(String message, Level level)
	{
		
		Log._(message, "Server " + this.getIP() + ":" + this.getPort(), level);
		
	}
	
}