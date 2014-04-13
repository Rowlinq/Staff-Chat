package net.javaportals.staffchat.updater;

import java.io.*;
import java.net.*;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import net.javaportals.staffchat.StaffChat;
import net.javaportals.staffchat.utils.Log;
import net.javaportals.staffchat.utils.Permissions;
import net.javaportals.staffchat.utils.StringUtilities;

public class Updater
{

	private boolean updateAvailable = false;
	
	public Updater()
	{
		
		new BukkitRunnable()
		{
        
			@Override
            public void run()
			{

				StaffChat.getStaffChat().getUpdater().checkUpdate();
				
            }
        
		}.runTaskTimerAsynchronously(StaffChat.getStaffChat(), 0L, 18000L);
		
	}

	public void checkUpdate()
	{

		Log._("Looking for updates...", "Updater");
		BufferedReader reader = null;
		
		try
		{
		
			HttpURLConnection connection = (HttpURLConnection) new URL(StaffChat.getStaffChat().getDescription().getWebsite() + "staffchat/version.txt").openConnection();
			
			if(connection.getResponseCode() != 200)
			{

				Log._("Bad response code received! [" + connection.getResponseCode() + "]", "Updater", Level.SEVERE);
				
				return;
				
			}
			
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String in = "";
			String version = "";
			
			while((in = reader.readLine()) != null)
			{
				
				version += in;
				
			}
			
			String remoteVersion = version.replace(".", "");
			String pluginVersion = StaffChat.getStaffChat().getDescription().getVersion().replace(".", "");
			
			if(Integer.parseInt(remoteVersion) > Integer.parseInt(pluginVersion))
			{
				
				this.setUpdateAvailable(true);
				Log._("An update is available! get it at http://dev.bukkit.org/bukkit-plugins/staffchatbyroe", "Updater");
				
				for(Player player : Bukkit.getOnlinePlayers())
				{
					
					if(player.hasPermission(Permissions.UPDATE))
					{
						
						player.sendMessage(StringUtilities.formatSuccess("An update is available! get it at http://dev.bukkit.org/bukkit-plugins/staffchatbyroe"));
						
					}
					
				}
				
			}
			else
			{
				
				this.setUpdateAvailable(false);
				Log._("The plugin is up to date!", "Updater");
				
			}
			
		}
		catch (MalformedURLException e)
		{

			Log._("An internal error occoured while checking for updates", "Updater", Level.SEVERE);
			Log._(e);
		
		}
		catch (IOException e)
		{

			Log._("An internal error occoured while checking for updates", "Updater", Level.SEVERE);
			Log._(e);
		
		}
		finally
		{
			
			if(reader != null)
			{
				
				try
				{
				
					reader.close();
				
				}
				catch (IOException e)
				{
				
					e.printStackTrace();
			
				}
				
			}
			
		}
		
	}
	
	public boolean isUpdateAvailable()
	{
	
		return updateAvailable;
	
	}

	public void setUpdateAvailable(boolean updateAvailable)
	{
	
		this.updateAvailable = updateAvailable;
	
	}
	
}