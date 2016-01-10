package com.msk.epg;

public class Channel 
{
	private String name;
	private String id;
	
	public Channel( String name,String logo, String chId) 
	{
		// TODO Auto-generated constructor stub
		this.name = name;
		this.id = chId;
	}

	public String getName() 
	{
		return name;
	}

	public String getId() 
	{
		return id;
	}

}
