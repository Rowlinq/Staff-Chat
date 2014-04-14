package net.javaportals.staffchat.utils;

import java.util.Random;

import org.bukkit.ChatColor;

import net.javaportals.staffchat.StaffChat;

public class StringUtilities
{

	public static String toString(String[] args)
	{
		
		return toString(args, " ");
		
	}
	
	public static String toString(String[] args, String seperator)
	{
		
		String string = "";
		
		for(String s : args)
		{
			
			string += s + seperator;
			
		}
		
		return string.substring(0, string.length() - seperator.length());
		
	}
	
	public static String upperCaseFirstCharacter(String s)
	{
		
		return s.substring(0, 1).toUpperCase() + s.substring(1, s.length());
		
	}

	public static String formatSuccess(String message)
	{
		
		return replaceCodes("&2[&a" + StaffChat.getStaffChat().getName() + "&2]&7:&a ") + message;
		
	}
	
	public static String formatError(String message)
	{

		return replaceCodes("&4[&c" + StaffChat.getStaffChat().getName() + "&4]&7:&c ") + message;
	
	}
	
	public static String formatInfo(String message)
	{

		return replaceCodes("&9[&b" + StaffChat.getStaffChat().getName() + "&9]&7:&f ") + message;
		
	}

	public static String replaceCodes(String message)
	{
		
		return ChatColor.translateAlternateColorCodes('&', message);
		
	}
	
	public static String generateRandomString()
	{
		
		return generateRandomString(75);
		
	}
	
	public static String generateRandomString(int length)
	{
		
		return generateRandomString("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890", length);
		
	}
	
	public static String generateRandomString(String characters, int length)
	{
		
		String s = "";
		Random r = new Random();
		
		for(int i = 0; i < length; i++)
		{
			
			s += characters.toCharArray()[r.nextInt(characters.length())];
			
		}
		
		return s;
		
	}
	
}