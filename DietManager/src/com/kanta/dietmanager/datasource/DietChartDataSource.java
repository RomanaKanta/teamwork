package com.kanta.dietmanager.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.kanta.dietmanager.modelclass.*;

public class DietChartDataSource {
	private SQLiteDatabase db;
	private DBHelper dbHelper;
	/*private String[] allColumns = { DBHelper.KEY_ID, DBHelper.KEY_FEAST,
			DBHelper.KEY_MENU,DBHelper.KEY_DATE,DBHelper.KEY_TIME };*/

	public DietChartDataSource(Context context) {
		dbHelper = new DBHelper(context);
	}

	public void open() throws SQLException {
		db = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	// Adding new contact
	public long addDiet(DietModel diet) {
		open();
		ContentValues values = new ContentValues();
		values.put(DBHelper.KEY_FEAST, diet.getFeast()); // get Feast
		values.put(DBHelper.KEY_MENU, diet.getMenu()); // get Menu
		values.put(DBHelper.KEY_DATE, diet.getDate()); // get Date
		values.put(DBHelper.KEY_TIME, diet.getTime()); // get time
		long inserted = db.insert(DBHelper.TABLE_NAME, null, values);
		close();
		return inserted;
	}

	// Getting single contact
	/*
	 * public Cursor getData(int id) { open(); Cursor cursor =
	 * db.rawQuery("select * from " + TABLE_NAME + " where _id=" + id + "",
	 * null); return cursor; }
	 * 
	 * // Updating single contact public long updateDiet(Integer id, DietModel
	 * dietUpdate) { SQLiteDatabase db = this.getWritableDatabase();
	 * 
	 * ContentValues values = new ContentValues();
	 * 
	 * values.put(KEY_FEAST, dietUpdate.getFeast()); // get Feast
	 * values.put(KEY_MENU, dietUpdate.getMenu()); // get Menu
	 * values.put(KEY_DATE, dietUpdate.getDate()); // get Date
	 * values.put(KEY_TIME, dietUpdate.getDate()); // get time
	 * 
	 * long updated = db.update(TABLE_NAME, values, "_id = ? ", new String[] {
	 * Integer.toString(id) }); return updated; }
	 * 
	 * // Deleting single contact public Integer deleteProfile(Integer id) {
	 * SQLiteDatabase db = this.getWritableDatabase(); return
	 * db.delete(TABLE_NAME, "_id = ? ", new String[] { Integer.toString(id) });
	 * }
	 * 
	 * // Getting contacts Count public int getDietCount() { String countQuery =
	 * "SELECT  * FROM " + TABLE_NAME; SQLiteDatabase db =
	 * this.getReadableDatabase(); Cursor cursor = db.rawQuery(countQuery,
	 * null); cursor.close();
	 * 
	 * // return count return cursor.getCount(); }
	 * 
	 * // Getting All Contacts public List<DietModel> getAllContacts() {
	 * List<DietModel> diet_list = new ArrayList<DietModel>(); // Select All
	 * Query String selectQuery = "SELECT  * FROM " + TABLE_NAME;
	 * 
	 * SQLiteDatabase db = this.getWritableDatabase(); Cursor cursor = db
	 * .query(TABLE_NAME, null, null, null, null, null, null); // looping
	 * through all rows and adding to list if (cursor != null &&
	 * cursor.getCount() > 0) { cursor.moveToFirst(); for (int i = 0; i <
	 * cursor.getCount(); i++) { int id =
	 * cursor.getInt(cursor.getColumnIndex(KEY_ID)); String feast =
	 * cursor.getString(cursor .getColumnIndex(KEY_FEAST)); String menu =
	 * cursor.getString(cursor.getColumnIndex(KEY_MENU)); String date =
	 * cursor.getString(cursor.getColumnIndex(KEY_DATE)); String time =
	 * cursor.getString(cursor.getColumnIndex(KEY_TIME));
	 * 
	 * DietModel diet = new DietModel(id, feast, menu, date, time);
	 * diet_list.add(diet); cursor.moveToNext(); } } cursor.close(); db.close();
	 * 
	 * // return contact list return diet_list; }
	 */
}
