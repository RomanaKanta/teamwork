package com.kanta.dietmanager.datasource;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "diet_manager";

	// Alarm table name
	public static final String TABLE_NAME = "diet_chart";

	// Alarm Table Columns names
	public static final String KEY_ID = "id";
	public static final String KEY_FEAST = "feast";
	public static final String KEY_MENU = "menu";
	public static final String KEY_DATE = "date";
	public static final String KEY_TIME = "time";

	// Alarm table information
	public String CREATE_DIET_TABLE = "create table " + TABLE_NAME + "("
			                          + KEY_ID + " integer primary key autoincrement, " 
			                          + KEY_FEAST + " text not null, "
			                          + KEY_MENU + " text not null, " 
			                          + KEY_DATE + " text not null, " 
			                          + KEY_TIME + " text not null);";

   // Create Database
	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

   // Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_DIET_TABLE);
	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(DBHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
	
		db.execSQL("DROP TABLE IF EXISTS " + CREATE_DIET_TABLE);
		onCreate(db);
	}

	/**
	 * All CRUD(Create, Read, Update, Delete) Operations
	 */

	
}