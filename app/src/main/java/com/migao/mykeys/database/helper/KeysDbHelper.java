package com.migao.mykeys.database.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.migao.mykeys.database.account.AccountContract;
import com.migao.mykeys.database.password.PasswordContract;

/**
 * Created by Mike on 4/21/2015.
 */
public class KeysDbHelper extends SQLiteOpenHelper {
	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "MyKeys.db";

	public KeysDbHelper(final Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(AccountContract.SQL_CREATE_TABLE);
		db.execSQL(PasswordContract.SQL_CREATE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}
}
