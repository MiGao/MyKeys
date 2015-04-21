package com.migao.mykeys.database.account;

/**
 * Created by Mike on 4/21/2015.
 */
public class Account {
	private String accountName;

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
