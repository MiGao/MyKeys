package com.migao.mykeys.database.account;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.migao.mykeys.database.account.AccountContract.AccountEntry;
import com.migao.mykeys.database.helper.KeysDbHelper;

/**
 * Created by Mike on 4/21/2015.
 */
public final class AccountRepository {
	private SQLiteOpenHelper dbHelper;

	public AccountRepository(final Context context) {
		this.dbHelper = new KeysDbHelper(context);
	}

	public long insert(final Account account) {
		final ContentValues values = new ContentValues();
		values.put(AccountEntry.COLUMN_NAME_ACCOUNT_NAME, account.getAccount());

		final SQLiteDatabase db = dbHelper.getWritableDatabase();
		final long accountId = db.insert(AccountEntry.TABLE_NAME, null, values);
		db.close();

		return accountId;
	}

	public Cursor selectAll() {
		final SQLiteDatabase db = dbHelper.getReadableDatabase();

		final Cursor cursor = db.query(AccountEntry.TABLE_NAME, AccountContract.ALL_COLUMNS, null, null, null, null, null);

		db.close();

		return cursor;
	}
}
