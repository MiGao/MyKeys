package com.migao.mykeys.database.account;

import android.provider.BaseColumns;

/**
 * Created by Mike on 2/25/2015.
 */
public final class AccountContract {
    public static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + AccountEntry.TABLE_NAME + " (" +
                    AccountEntry._ID + " INTEGER AUTOINCREMENT, " +
                    AccountEntry.COLUMN_NAME_ACCOUNT_NAME + " TEXT NOT NULL, " +
                    AccountEntry.COLUMN_NAME_USER_NAME + " TEXT NOT NULL, " +
                    " PRIMARY KEY(" + AccountEntry._ID + ", " +
                    AccountEntry.COLUMN_NAME_ACCOUNT_NAME + ", " +
                    AccountEntry.COLUMN_NAME_USER_NAME + "));";

    public AccountContract() {}

    public static abstract class AccountEntry implements BaseColumns {
        public static final String TABLE_NAME = "Account";
        public static final String COLUMN_NAME_ACCOUNT_NAME = "account_name";
        public static final String COLUMN_NAME_USER_NAME = "user_name";
    }
}
