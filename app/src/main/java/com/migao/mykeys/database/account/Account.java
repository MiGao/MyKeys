package com.migao.mykeys.database.account;

import android.database.Cursor;

import com.activeandroid.Cache;
import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

/**
 * Created by Mike on 4/21/2015.
 */
@Table(name = "Account")
public class Account extends Model {
	@Column(name = "account_name")
	private String accountName;

	@Column(name = "user_name")
	private String userName;

	public Account() {
		super();
	}

	public static Cursor fetchResultCursor() {
		String tableName = Cache.getTableInfo(Account.class).getTableName();
		// Query all items without any conditions
		String resultRecords = new Select(tableName + ".*, " + tableName + ".Id AS _id")
				.from(Account.class)
				.toSql();
		// Execute query on the underlying ActiveAndroid SQLite database
		Cursor resultCursor = Cache.openDatabase().rawQuery(resultRecords, null);
		return resultCursor;
	}

	public String getAccount() {
		return accountName;
	}

	public static class Builder {
		private String accountName;

		public Builder withAccountName(final String accountName) {
			this.accountName = accountName;
			return this;
		}

		public Builder withValues(final Account account) {
			accountName = account.accountName;
			return this;
		}

		public Account build() {
			return new Account(this);
		}
	}

	private Account(Builder b) {
		accountName = b.accountName;
	}
}
