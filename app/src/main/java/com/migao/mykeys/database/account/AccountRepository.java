package com.migao.mykeys.database.account;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mike on 4/21/2015.
 */
public final class AccountRepository {
	private SQLiteOpenHelper dbHelper;

	public AccountRepository(final SQLiteOpenHelper dbHelper) {
		this.dbHelper = dbHelper;
	}

	public long insert(final Account account) {
		final SQLiteDatabase db = dbHelper.getWritableDatabase();

		final ContentValues values = new ContentValues();
		values.put(AccountContract.AccountEntry.COLUMN_NAME_ACCOUNT_NAME, account.getAccount());

		final long accountId = db.insert(AccountContract.AccountEntry.TABLE_NAME, null, values);

		db.close();

		return accountId;
	}
}
