package com.chazknox.mashgamefinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chazk on 3/15/2016.
 */
public class MyDBHandler extends SQLiteOpenHelper {

    //database variables
    // DATABASE_VERSION needs to be increased as changes are committed
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "mash.db";
    private static final String TABLE_MASH = "mash";
    //private static final String TABLE_KIDS = "kids";
    //private static final String TABLE_JOBS = "jobs";
    //private static final String TABLE_HOMES = "homes";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "_name";
    private static final String COLUMN_KID = "_kid";
    private static final String COLUMN_JOB = "_job";
    private static final String COLUMN_HOME = "_home";

    // general setup for database
    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_MASH + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT " +
                COLUMN_KID + " TEXT " +
                COLUMN_JOB + " TEXT " +
                COLUMN_HOME + " TEXT " +");";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MASH);
        onCreate(db);
    }

    //Add new row to the database
    public void  addEntry(Entry entry) {
        //get product info
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, entry.get_name());
        values.put(COLUMN_KID, entry.get_kids());
        values.put(COLUMN_JOB, entry.get_job());
        values.put(COLUMN_HOME, entry.get_home());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_MASH, null, values);
        //always close database to save memory consumption
        db.close();

    }

    //delete a row
    public void deleteName(String name) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_MASH +
                " WHERE " + COLUMN_NAME + "=\"" + name + "\";");
    }

    //print out the database as a string
    public List<Entry> databaseToString(){

        List<Entry> entries = new ArrayList<Entry>();
        SQLiteDatabase db  = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_MASH + " WHERE 1";

        //cursor point to a location in your results
        Cursor c = db.rawQuery(query, null);
        //move to the first row in your results
        c.moveToFirst();

        while(!c.isAfterLast()){
            Entry entry = cursorToName(c);
            entries.add(entry);
            c.moveToNext();


        }
        db.close();
        return entries;
    }

    private Entry cursorToName(Cursor c) {
        Entry e = new Entry();
        e.set_id(c.getInt(0));
        e.set_name(c.getString(1));
        e.set_kids(c.getString(2));
        e.set_job(c.getString(3));
        e.set_home(c.getString(4));

        return e;
    }


}
