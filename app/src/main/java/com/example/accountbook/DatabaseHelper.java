package com.example.accountbook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static  final String DATABASE_NAME="accountbook.db";
    public static  final String TABLE_NAME="account book";
    public static  final  String COL_1="date";
    public static  final  String COL_2="content";
    public static  final  String COL_3="number";
    public static  final  String COL_4="note";
    public DatabaseHelper(@Nullable Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
