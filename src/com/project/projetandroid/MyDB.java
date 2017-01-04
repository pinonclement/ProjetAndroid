package com.project.projetandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDB extends SQLiteOpenHelper {

	//Table
	public static final String ACCOUNT_TABLE = "Partie";
	//column
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_JOUEUR = "joueur";
	public static final String COLUMN_POINTS = "points";
	public static final String COLUMN_TEMPS = "temps";
	public static final String COLUMN_DATE = "date";
	//Database info
	private static final String DATABASE_NAME = "partie.db";
	private static final int DATABASE_VERSION = 1;
	//Creation table request
	private static final String DATABASE_CREATE = "create table "
	+ ACCOUNT_TABLE + "(" + COLUMN_ID
	+ " integer primary key autoincrement, " + COLUMN_JOUEUR
	+ " text not null, " + 
	 COLUMN_POINTS
		+ " text not null, " + 
		 COLUMN_TEMPS
			+ " text not null, " + COLUMN_DATE
	+ " text not null);";
	//Init of sqlhelper
	public MyDB(Context context) {
	super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	//Method call on first call
	@Override
	public void onCreate(SQLiteDatabase database) {
	database.execSQL(DATABASE_CREATE);
	}
	//Method call when DATABASE_VERSION is different than actual
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	db.execSQL("DROP TABLE IF EXISTS " + ACCOUNT_TABLE);
	onCreate(db);
	}

	
}
