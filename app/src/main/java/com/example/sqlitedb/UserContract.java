package com.example.sqlitedb;

import android.provider.BaseColumns;

public class UserContract {

    private UserContract(){}

    public static class UserEntry implements BaseColumns{
        public static final String TABLE_NAME = "user";
        public static final String FIRST_NAME = "first_name";
        public static final String LAST_NAME = "last_name";
        public static final String ADDRESS = "address";
    }

}
