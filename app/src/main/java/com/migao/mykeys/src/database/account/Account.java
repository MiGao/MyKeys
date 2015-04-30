package com.migao.mykeys.src.database.account;

import android.database.Cursor;

import com.activeandroid.Cache;
import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.migao.mykeys.src.database.account.AccountContract.AccountEntry;
import com.migao.mykeys.src.database.password.Password;

/**
 * Created by Mike on 4/21/2015.
 */
@Table(name = "Account", id = AccountEntry._ID)
public class Account extends Model {
	@Column(name = "account_name")
	private String accountName;

	@Column(name = "user_name")
	private String userName;

	public Account() {
		super();
	}

	public static Cursor fetchResultCursor() {
		String accountTableName = Cache.getTableInfo(Account.class).getTableName();
		String passwordTableName = Cache.getTableInfo(Password.class).getTableName();

		// Query all items without any conditions
		String resultRecords = new Select(accountTableName + ".*, " + accountTableName + ".Id AS _id")
				.from(Account.class)
				.innerJoin(Password.class)
				.on(
					passwordTableName + ".Id = " +
					accountTableName + ".Id"
				)
				.orderBy("account_name")
				.toSql();
		// Execute query on the underlying ActiveAndroid SQLite database
		Cursor resultCursor = Cache.openDatabase().rawQuery(resultRecords, null);
		return resultCursor;
	}

	public String getAccountName() {
		return accountName;
	}

	public String getUserName() {
		return userName;
	}

	public static class Builder {
		private String accountName;
		private String userName;

		public Builder withAccountName(final String accountName) {
			this.accountName = accountName;
			return this;
		}

		public Builder withUserName(final String userName) {
			this.userName = userName;
			return this;
		}

		public Builder withValues(final Account account) {
			accountName = account.accountName;
			userName = account.userName;
			return this;
		}

		public Account build() {
			return new Account(this);
		}
	}

	private Account(Builder b) {
		accountName = b.accountName;
		userName = b.userName;
	}
}
