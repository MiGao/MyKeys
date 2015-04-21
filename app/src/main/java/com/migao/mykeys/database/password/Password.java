package com.migao.mykeys.database.password;

/**
 * Created by Mike on 4/21/2015.
 */
public class Password {
	private String password;
	private String effectiveDate;
	private String endDate;
	private String accountId;

	public String getPassword() {
		return password;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public String getAccountId() {
		return accountId;
	}

	public static class Builder {
		private String password;
		private String effectiveDate;
		private String endDate;
		private String accountId;

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

		public Builder withValues(final Password p) {
			password = p.password;
			effectiveDate = p.effectiveDate;
			endDate = p.endDate;
			accountId = p.accountId;
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
		accountId = b.accountId;
	}
}
