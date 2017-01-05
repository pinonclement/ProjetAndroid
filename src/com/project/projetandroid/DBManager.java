package com.project.projetandroid;


import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.*;

public class DBManager {
	private SQLiteDatabase database;
	private MyDB dbHelper;
	private String filtre =MyDB.COLUMN_POINTS;
	private String[] allColumns = { MyDB.COLUMN_ID, MyDB.COLUMN_JOUEUR, MyDB.COLUMN_POINTS, MyDB.COLUMN_TEMPS, MyDB.COLUMN_DATE};

	public DBManager(Context context) {
		dbHelper = new MyDB(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

/*	public boolean checkLogin(String account, String password) {
		boolean accountFound = false;
		Cursor cursor = database.query(MyDB.ACCOUNT_TABLE, allColumns,
				dbHelper.COLUMN_NAME + " = '" + account + "' AND " + dbHelper.COLUMN_PWD + " = '" + password + "' ",
				null, null, null, null);
		if (cursor.getCount() == 1)
			accountFound = true;
		cursor.close();
		return accountFound;
	} */

	public boolean createPartie(String joueur, int i, String temps, String date) {
		try{
			
		open();
		ContentValues values = new ContentValues();
		values.put(MyDB.COLUMN_JOUEUR, joueur);
		values.put(MyDB.COLUMN_POINTS, i);
		values.put(MyDB.COLUMN_TEMPS, temps);
		values.put(MyDB.COLUMN_DATE, date);
		if (database.insert(MyDB.ACCOUNT_TABLE, "0", values) != -1)
			return true;
		else
			return false;
		}
		catch (Exception e) {
			close();
			return false;
		}

	}

	/*public void deletePartie(Account account) {
		database.delete(MyDB.ACCOUNT_TABLE, MyDB.COLUMN_NAME + " = " + account, null);
	} */

	public List<Partie> getAllPartie() {
		List<Partie> listpartie = new ArrayList<Partie>();
		Cursor cursor = database.query(MyDB.ACCOUNT_TABLE, allColumns, null, null, null, null, filtre);
		if(cursor!=null){
			int i=0;
			cursor.moveToFirst();
			while (i!=3) {
				if(!cursor.isAfterLast()){
					Partie partie = cursorToPartie(cursor);
					listpartie.add(partie);
					cursor.moveToNext();
				}
				else{
					Partie partie= new Partie(0,"","","","");
					listpartie.add(partie);
				}
				
				i++;
			}
			cursor.close();}
		else{
			Partie partie= new Partie(0,"","","","");
			listpartie.add(partie);
		}
		return listpartie;
	}

	private Partie cursorToPartie(Cursor cursor) {
		Partie partie = new Partie(0, null, null,null,null);
		partie.setId(cursor.getLong(0));
		partie.setJoueur(cursor.getString(1));
		partie.setPoints(cursor.getString(2));
		partie.setTemps(cursor.getString(3));
		partie.setDate(cursor.getString(4));
		return partie;

	}

}
