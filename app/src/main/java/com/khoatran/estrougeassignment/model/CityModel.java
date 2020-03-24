package com.khoatran.estrougeassignment.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.khoatran.estrougeassignment.db.DataBaseManager;
import com.khoatran.estrougeassignment.view.main.IMainActivityView;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Khoa Tran Anh
 * Created on 24-03-2020
 */
public class CityModel implements ICityModel {
    private SQLiteDatabase mDB;

    public CityModel(IMainActivityView iMainActivityView) {
        mDB = new DataBaseManager((Context) iMainActivityView).getWritableDatabase();
    }

    /**
     * Init city object from cursor
     * @param cursor
     * @return city
     */
    private City initCityFromCursor(Cursor cursor) {

        City city = new City();
        city.setId(cursor.getString(cursor.getColumnIndexOrThrow("id")));
        city.setCountry(cursor.getString(cursor.getColumnIndexOrThrow("country")));
        city.setCity(cursor.getString(cursor.getColumnIndexOrThrow("city")));
        city.setPopulation(cursor.getInt(cursor.getColumnIndexOrThrow("population")));

        return city;
    }

    @Override
    public ArrayList<City> getListCityFromDatabase() {
        ArrayList<City> cities = new ArrayList<>();
        String sqlQueryText = "SELECT * FROM CITIES;";
        Cursor cursor = null;
        try {
            cursor = this.mDB.rawQuery(sqlQueryText, null);
            if (cursor != null) {
                City city;
                if (cursor.moveToFirst()) {
                    do {
                        city = initCityFromCursor(cursor);
                        cities.add(city);
                    } while (cursor.moveToNext());
                }
            }
        } catch (Exception e) {
            Log.e("getAllCity", Objects.requireNonNull(e.getMessage()));
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return cities;
    }

    @Override
    public ArrayList<City> getListCityFromDatabaseWithPaging(int limitRow, int offset) {
        ArrayList<City> cities = new ArrayList<>();
        String sqlQueryText = "SELECT * FROM CITIES LIMIT " + limitRow + " OFFSET " + offset;
        Cursor cursor = null;
        try {
            cursor = this.mDB.rawQuery(sqlQueryText, null);
            if (cursor != null) {
                City city;
                if (cursor.moveToFirst()) {
                    do {
                        city = initCityFromCursor(cursor);
                        cities.add(city);
                    } while (cursor.moveToNext());
                }
            }
        } catch (Exception e) {
            Log.e("Get city with paging ", Objects.requireNonNull(e.getMessage()));
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return cities;
    }
}
