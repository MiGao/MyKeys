package com.migao.mykeys.src.database.account;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.migao.mykeys.R;
import com.migao.mykeys.src.database.account.AccountContract.AccountEntry;
import com.migao.mykeys.src.database.password.Password;

/**
 * Created by Mike on 4/22/2015.
 */
public class AccountAdapter extends CursorAdapter implements View.OnTouchListener {
	public static class ViewHolder {
		int position;
		TextView tvAccountName;
		TextView tvUserName;
		TextView tvPassword;
	}

	private final LayoutInflater mInflater;
	private Cursor cursor;

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
			viewHolder.tvPassword = (TextView) convertView.findViewById(R.id.tvPassword);

			convertView.setOnTouchListener(this);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		viewHolder.position = position;
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

	@Override
	public Cursor swapCursor(Cursor newCursor) {
		this.cursor = newCursor;
		return super.swapCursor(newCursor);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		int action = event.getActionMasked();
		ViewHolder viewHolder = (ViewHolder) v.getTag();
		//int position = pointToPosition(Math.round(event.getX()), Math.round(event.getY()));

		switch (action) {
			case MotionEvent.ACTION_DOWN:
				cursor.moveToPosition(viewHolder.position);

				if (viewHolder != null) {
					String accountId = cursor.getString(cursor.getColumnIndex(AccountContract.AccountEntry._ID));
					String password = Password.retrievePassword(accountId).getPassword();

					viewHolder.tvAccountName.setVisibility(View.GONE);
					viewHolder.tvUserName.setVisibility(View.GONE);
					viewHolder.tvPassword.setVisibility(View.VISIBLE);
					viewHolder.tvPassword.setText(password);
				} else {
					Log.d("ViewHolder", "NULL");
				}
				return true;
			default:
				if (viewHolder != null) {
					viewHolder.tvAccountName.setVisibility(View.VISIBLE);
					viewHolder.tvUserName.setVisibility(View.VISIBLE);
					viewHolder.tvPassword.setVisibility(View.GONE);
					viewHolder.tvPassword.setText("");
				} else {
					Log.d("ViewHolder", "NULL");
				}
				return true;
		}
	}
}
