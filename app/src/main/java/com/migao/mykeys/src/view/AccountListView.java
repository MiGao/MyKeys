package com.migao.mykeys.src.view;

import android.content.Context;
import android.database.Cursor;
import android.util.AttributeSet;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.migao.mykeys.src.database.account.AccountAdapter;

/**
 * Created by Mike on 4/25/2015.
 */
public class AccountListView extends ListView {
	private AccountAdapter accountAdapter;
	private Cursor cursor;

	public AccountListView(Context context) {
		super(context);
	}

	public AccountListView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public AccountListView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	public void setAdapter(ListAdapter adapter) {
		accountAdapter = (AccountAdapter) adapter;
		cursor = accountAdapter.getCursor();

		super.setAdapter(adapter);
	}

	/*@Override
	public boolean onTouchEvent(MotionEvent ev) {
		int action = ev.getActionMasked();
		int position = pointToPosition(Math.round(ev.getX()), Math.round(ev.getY()));

		switch (action) {
			case MotionEvent.ACTION_DOWN:
				cursor.moveToPosition(position);
				String accountId = cursor.getString(cursor.getColumnIndex(AccountContract.AccountEntry._ID));

				Log.e("Password", Password.retrievePassword(accountId).getPassword());

				return super.onTouchEvent(ev);
			case MotionEvent.ACTION_UP:
//				Log.d("ListView", "Action Up!");
				return super.onTouchEvent(ev);
			default:
				return super.onTouchEvent(ev);
		}
	}*/

}
