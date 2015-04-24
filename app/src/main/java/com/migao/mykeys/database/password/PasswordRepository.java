package com.migao.mykeys.database.password;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.migao.mykeys.database.helper.KeysDbHelper;
import com.migao.mykeys.database.password.PasswordContract.PasswordEntry;

/**
 * Created by Mike on 4/21/2015.
 */
public class PasswordRepository {
	private SQLiteOpenHelper dbHelper;

	public PasswordRepository(final Context context) {
		dbHelper = new KeysDbHelper(context);
	}

	public long insert(final Password password) {
		final ContentValues values = new ContentValues();
		values.put(PasswordEntry.COLUMN_NAME_PASSWORD, password.getPassword());
		values.put(PasswordEntry.COLUMN_NAME_EFFECTIVE_DATE, password.getEffectiveDate());
		values.put(PasswordEntry.COLUMN_NAME_END_DATE, password.getEndDate());
		values.put(PasswordEntry.COLUMN_NAME_ACCOUNT_ID, password.getAccount().getId());

		final SQLiteDatabase db = dbHelper.getWritableDatabase();
		final long accountId = db.insert(PasswordEntry.TABLE_NAME, null, values);
		db.close();

		return accountId;
	}
}
