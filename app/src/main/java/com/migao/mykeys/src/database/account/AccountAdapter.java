package com.migao.mykeys.src.database.account;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.migao.mykeys.R;
import com.migao.mykeys.src.database.account.AccountContract.AccountEntry;

/**
 * Created by Mike on 4/22/2015.
 */
public class AccountAdapter extends CursorAdapter {
	static class ViewHolder {
		TextView tvAccountName;
		TextView tvUserName;
	}

	private final LayoutInflater mInflater;
	private final Cursor cursor;

	public AccountAdapter(Context context, Cursor c, boolean autoRequery) {
		super(context, c, autoRequery);
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.cursor = c;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder viewHolder;

		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.item_account, parent, false);

			viewHolder = new ViewHolder();
			viewHolder.tvAccountName = (TextView) convertView.findViewById(R.id.tvAccountName);
			viewHolder.tvUserName = (TextView) convertView.findViewById(R.id.tvUserName);

			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		cursor.moveToPosition(position);

		final String accountName = cursor.getString(cursor.getColumnIndexOrThrow(AccountEntry.COLUMN_NAME_ACCOUNT_NAME));
		final String userName = cursor.getString(cursor.getColumnIndexOrThrow(AccountEntry.COLUMN_NAME_USER_NAME));

		viewHolder.tvAccountName.setText(accountName);
		viewHolder.tvUserName.setText(userName);

		return convertView;
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		return mInflater.inflate(R.layout.item_account, parent, false);
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
