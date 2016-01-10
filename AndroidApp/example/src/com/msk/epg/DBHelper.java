package com.msk.epg;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper 
{
	
	public static final String DB_NAME ="Moblie_epg.db";
	public static final String TABLE_NAME ="favorites";
	public static final String PROG_ID = "prog_id";
	public static final String CHANNEL_NAME="cname";
	public static final String PROG_NAME ="pname";
	public static final String PROG_DETAILS="pdetails";
	public static final String PROG_DATE ="pdate";
	public static final String PROG_STIME="pstime";
	public static final String PROG_ETIME="petime";
	
	private static final int DB_VERSION =1;
	private static final String TABLE_QUERY ="create table "+TABLE_NAME+"("+ PROG_ID+" integer primary key ,"+PROG_NAME+" text,"+CHANNEL_NAME+" text,"
		+PROG_DATE+" text,"+PROG_DETAILS+" text,"+PROG_STIME+" text,"+PROG_ETIME+" text)";

	public DBHelper(Context context) 
	{
		super(context, DB_NAME, null, DB_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		// TODO Auto-generated method stub
		db.execSQL(TABLE_QUERY);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) 
	{
		// TODO Auto-generated method stub
	}

}
