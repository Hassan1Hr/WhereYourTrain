package com.example.hassan.know_your_train.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.hassan.know_your_train.model.Station;

import java.util.ArrayList;


/**
 * User: YourPc
 * Date: 8/9/2017
 */

public class Db {

    private static final String QUERY_STATION = "SELECT * FROM Station";

    public static ArrayList<Station> getStations(Context context) {
        SQLiteDatabase db = new DbHelper(context).getReadableDatabase();
        Cursor cursor = db.rawQuery(QUERY_STATION, null);

        ArrayList<Station> stations = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                stations.add(Station.create(
                        getString(cursor, "_id"),
                        getString(cursor, "StationName"),
                        getString(cursor, "StationArabic")
                ));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return stations;
    }



    private static String getString(Cursor cursor, String s) { return cursor.getString(cursor.getColumnIndex(s)); }

    private static int getInt(Cursor cursor, String s) { return cursor.getInt(cursor.getColumnIndex(s)); }
}
