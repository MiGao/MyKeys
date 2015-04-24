package com.migao.mykeys.database.password;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.migao.mykeys.database.account.Account;

/**
 * Created by Mike on 4/21/2015.
 */
@Table(name = "Password")
public class Password extends Model {
	@Column(name = "password")
	private String password;

	@Column(name = "effective_date")
	private String effectiveDate;

	@Column(name = "end_date")
	private String endDate;

	@Column(name = "account_id")
	private Account account;

	public Password() {
		super();
	}

	public String getPassword() {
		return password;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public Account getAccount() {
		return account;
	}

	public static class Builder {
		private String password;
		private String effectiveDate;
		private String endDate;
		private Account account;

		public Builder withPassword(final String password) {
			this.password = password;
			return this;
		}

		public Builder withEffectiveDate(final String effectiveDate) {
			this.effectiveDate = effectiveDate;
			return this;
		}

		public Builder withEndDate(final String endDate) {
			this.endDate = endDate;
			return this;
		}

		public Builder withAccount(final Account account) {
			this.account = account;
			return this;
		}

		public Builder withValues(final Password p) {
			password = p.password;
			effectiveDate = p.effectiveDate;
			endDate = p.endDate;
			account = p.account;
			return this;
		}

		public Password build() {
			return new Password(this);
		}
	}

	private Password(Builder b) {
		password = b.password;
		effectiveDate = b.effectiveDate;
		endDate = b.endDate;
		account = b.account;
	}
}
