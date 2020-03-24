package com.khoatran.estrougeassignment.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * @author Khoa Tran Anh
 * Created on 24-03-2020
 */
public class DataBaseManager extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "utopia_cities.db";
    private static final String TABLE_NAME = "CITIES";
    private static final int DATABASE_VERSION = 1;

    public DataBaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public int getCount(){
        int count = 0;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if(cursor != null && !cursor.isClosed()){
            count = cursor.getCount();
            cursor.close();
        }
        return count;
    }
}

