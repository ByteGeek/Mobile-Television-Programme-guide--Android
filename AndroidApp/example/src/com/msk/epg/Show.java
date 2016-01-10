package com.msk.epg;

public class Show 
{
	private String pname;
	private String pid;
	private String cname;
	private String pstime;
	private String petime;
	private String pdate;
	private String pdetails;
	
	public Show(String pid,String pname, String cname, String pdate, String pdetails,String pstime, String petime) 
	{
		// TODO Auto-generated constructor stub
		this.pname = pname;
		this.pid = pid;
		this.pdate = pdate;
		this.pstime = pstime;
		this.petime = petime;
		this.cname = cname;
		this.pdetails=pdetails;
	}

	public String getpname() 
	{
		return pname;
	}

	public String getpid() 
	{
		return pid;
	}

	public String getpstime()
	{
		return pstime;
	}

	public String getpetime() 
	{
		return petime;
	}

	public String getpdate()
	{
		return pdate;
	}

	public String getcname() 
	{
		return cname;
	}

	public String getpdetails()
	{
		return pdetails;	
	}
}