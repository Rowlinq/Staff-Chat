package net.javaportals.staffchat.utils;

import java.util.logging.Level;

import net.javaportals.staffchat.StaffChat;

public class Log
{

	public static void _(String message)
	{
		
		_(message, "", Level.INFO);
		
	}

	public static void _(String message, Level level)
	{
		
		_(message, "", level);

	}

	public static void _(String message, String prefix)
	{
		
		_(message, prefix, Level.INFO);
		
	}
	
	public static void _(String message, String prefix, Level level)
	{
		
		if(!prefix.equalsIgnoreCase(""))
		{
			
			prefix = "[" + prefix + "]: ";
			
		}
		
		StaffChat.getStaffChat().getLogger().log(level, prefix + message);
		
	}

	public static void _(Exception e)
	{
		
		_(e, "", Level.INFO);
		
	}
	
	public static void _(Exception e, Level level)
	{
		
		_(e, "", level);
		
	}
	
	public static void _(Exception e, String prefix)
	{
		
		_(e, prefix, Level.INFO);
		
	}
	
	public static void _(Exception e, String prefix, Level level)
	{
		
		_(e.getClass().getCanonicalName() 
				+ (e.getMessage().equalsIgnoreCase("") 
						|| e.getMessage() == null 
						|| e.getMessage().equalsIgnoreCase(null) ? "" : ": " 
								+ e.getMessage())
								, prefix, level);
		
		for(StackTraceElement element : e.getStackTrace())
		{
			
			_(element.toString(), prefix, level);
			
		}
		
	}
	
}