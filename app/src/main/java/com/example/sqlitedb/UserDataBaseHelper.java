package com.example.sqlitedb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UserDataBaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "UserDetails.db";

    public UserDataBaseHelper(Context aContextr){
        super(aContextr, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static final String CREATE_TABLE = "CREATE TABLE "+ UserContract.UserEntry.TABLE_NAME+
            "( "+ UserContract.UserEntry._ID+" INTEGER PRIMARY KEY, "+
            UserContract.UserEntry.FIRST_NAME+" TEXT, "+
            UserContract.UserEntry.LAST_NAME+" TEXT, "+
            UserContract.UserEntry.ADDRESS+" TEXT )";

    private static final String DELETE_TABLE = "DROP TABLE IF EXISTS "+ UserContract.UserEntry.TABLE_NAME;

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(DELETE_TABLE);
        onCreate(db);
    }
}
