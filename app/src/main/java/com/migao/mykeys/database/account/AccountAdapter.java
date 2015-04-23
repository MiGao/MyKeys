package com.migao.mykeys.database.account;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.migao.mykeys.R;
import com.migao.mykeys.database.account.AccountContract.AccountEntry;

/**
 * Created by Mike on 4/22/2015.
 */
public class AccountAdapter extends CursorAdapter {
	public AccountAdapter(Context context, Cursor c, boolean autoRequery) {
		super(context, c, autoRequery);
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		return LayoutInflater.from(context).inflate(R.layout.item_account, parent, false);
	}

	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		final TextView tvAccountName = (TextView) view.findViewById(R.id.tvAccountName);
		final TextView tvUserName = (TextView) view.findViewById(R.id.tvUserName);

		final String accountName = cursor.getString(cursor.getColumnIndexOrThrow(AccountEntry.COLUMN_NAME_ACCOUNT_NAME));
		final String userName = cursor.getString(cursor.getColumnIndexOrThrow(AccountEntry.COLUMN_NAME_USER_NAME));

		tvAccountName.setText(accountName);
		tvUserName.setText(userName);
	}
}
