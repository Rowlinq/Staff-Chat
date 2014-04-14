package net.javaportals.staffchat.network;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public abstract class Packet implements Serializable 
{

	private static final long serialVersionUID = -6839019122889820821L;

	public String getName()
	{
		
		return this.getClass().getSimpleName().substring(0, this.getClass().getSimpleName().length() - "Packet".length());
		
	}
	
	@Override
	public String toString()
	{
		
		String s = "";
		
		for(Field field : this.getClass().getFields())
		{
			
			s += Modifier.toString( field.getModifiers()) + " " + field.getClass().getSimpleName() + ", ";
			
		}
		
		return s.substring(0, s.length() - ", ".length());
		
	}
	
}