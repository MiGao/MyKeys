package com.migao.mykeys.database;

import android.provider.BaseColumns;

/**
 * Created by Mike on 2/25/2015.
 */
public class AccountContract {
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ACCOUNT =
            "CREATE TABLE " + AccountEntry.TABLE_NAME + " (" +
            AccountEntry._ID + " INTEGER PRIMARY KEY, ";
            // TODO: Continue defining the table

    public AccountContract() {}

    public static abstract class AccountEntry implements BaseColumns {
        public static final String TABLE_NAME = "Account";
        public static final String COLUMN_NAME_ACCOUNT_NAME = "account_name";
    }
}
