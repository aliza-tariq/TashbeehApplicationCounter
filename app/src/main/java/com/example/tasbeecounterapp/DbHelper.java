package com.example.tasbeecounterapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {

    public static final String DATE1 = "2023-01-30";
    public static final String TASHBEEH1 ="TASHBEEH1";
    public static final String TASHBEEH2 = "TASHBEEH2";
    public static final String TASHBEEH3 = "TASHBEEH3";
    public static final String TASHBEEH4 = "TASHBEEH4";
    public static final String Tashbeeh_ID = "TashbeeID";

    public static final String Tashbeeh_TABLE = "TASHBEEH_TABLE";



    public DbHelper(@Nullable Context context) {
        super(context, "tashbeehDB.db", null, 4);
        System.out.println("constructor called");

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSTatement = "CREATE TABLE " + Tashbeeh_TABLE + "(" + Tashbeeh_ID +
                " Integer PRIMARY KEY AUTOINCREMENT, " +
                TASHBEEH1 + " String, " + TASHBEEH2 + " String, " +TASHBEEH3 + " String, "
                +TASHBEEH4 + " String ) ";


        db.execSQL(createTableSTatement);
        System.out.println("db made successfully");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + Tashbeeh_TABLE);
        onCreate(db);
    }

    public void addTashbeeCount(Tashbee tashbeeModel)
    {
        System.out.println("in add student");
        SQLiteDatabase db = this.getWritableDatabase();
        //Hash map, as we did in bundles
        ContentValues cv = new ContentValues();

        cv.put( DATE1, tashbeeModel.getDate());
        cv.put(TASHBEEH1, tashbeeModel.getTashbeeh1());
        cv.put(TASHBEEH2, tashbeeModel.getTashbeeh2());
        cv.put(TASHBEEH3, tashbeeModel.getTashbeeh3());
        cv.put(TASHBEEH4, tashbeeModel.getTashbeeh4());

        db.insert(Tashbeeh_TABLE, null, cv);
        db.close();
    }

    public ArrayList<Tashbee> getAllResults() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + Tashbeeh_TABLE +
                " order by "+DATE1, null);

        ArrayList<Tashbee> resultArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {

                //question, opta, optb, optc, optselected, result
                resultArrayList.add(new Tashbee(cursorCourses.getString(1),
                        cursorCourses.getInt(2),
                        cursorCourses.getInt(3), cursorCourses.getInt(4),
                        cursorCourses.getInt(5)));
            } while (cursorCourses.moveToNext());

        }

        cursorCourses.close();
        return resultArrayList;
    }

    public void updateTashbee(Tashbee lm)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        //Hash map, as we did in bundles
        ContentValues cv = new ContentValues();
        cv.put(DATE1, lm.getDate());
        cv.put(TASHBEEH1, lm.getTashbeeh1());

        cv.put(TASHBEEH2, lm.getTashbeeh2());
        cv.put(TASHBEEH3, lm.getTashbeeh3());
        cv.put(TASHBEEH4, lm.getTashbeeh4());
        db.update(Tashbeeh_TABLE,cv, "DATE1 = ?", new String[]{lm.getDate()});
        db.close();
    }


}
