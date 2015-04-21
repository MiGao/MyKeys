package com.migao.mykeys.database.password;

import android.provider.BaseColumns;

import com.migao.mykeys.database.account.AccountContract;

/**
 * Created by Mike on 4/20/2015.
 */
public final class PasswordContract {
	public static final String SQL_CREATE_TABLE =
		"CREATE TABLE " + PasswordEntry.TABLE_NAME + " (" +
				PasswordEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
				PasswordEntry.COLUMN_NAME_PASSWORD + " TEXT NOT NULL, " +
				PasswordEntry.COLUMN_NAME_EFFECTIVE_DATE + " TEXT NOT NULL, " +
				PasswordEntry.COLUMN_NAME_END_DATE + " TEXT, " +
				"FOREIGN KEY (" + PasswordEntry.COLUMN_NAME_ACCOUNT_ID + ") REFERENCES Account(" + AccountContract.AccountEntry._ID + "));";

	public PasswordContract() {}

	public static abstract class PasswordEntry implements BaseColumns {
		public static final String TABLE_NAME = "Password";
		public static final String COLUMN_NAME_PASSWORD = "password";
		public static final String COLUMN_NAME_EFFECTIVE_DATE = "effective_date";
		public static final String COLUMN_NAME_END_DATE = "end_date";
		public static final String COLUMN_NAME_ACCOUNT_ID = "account_id";
	}
}
