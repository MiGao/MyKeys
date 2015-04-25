package com.migao.mykeys.src.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.activeandroid.ActiveAndroid;
import com.migao.mykeys.R;
import com.migao.mykeys.src.database.account.Account;
import com.migao.mykeys.src.database.password.Password;

import org.joda.time.DateTime;

public class AddAccountActivity extends ActionBarActivity {

	private EditText etAccount;
	private EditText etUserName;
	private EditText etPassword;
	private Button btnSave;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_account);

		setupViews();
	}

	private void setupViews() {
		etAccount = (EditText) findViewById(R.id.etAccount);
		etUserName = (EditText) findViewById(R.id.etUserName);
		etPassword = (EditText) findViewById(R.id.etPassword);
		btnSave = (Button) findViewById(R.id.btnSave);
	}

	public void save(final View view) {
		ActiveAndroid.beginTransaction();

		final Account account = new Account.Builder()
				.withAccountName(etAccount.getText().toString())
				.withUserName(etUserName.getText().toString())
				.build();

		account.save();

		final Password password = new Password.Builder()
				.withPassword(etPassword.getText().toString())
				.withEffectiveDate(DateTime.now().toString())
				.withAccount(account)
				.build();

		password.save();

		ActiveAndroid.setTransactionSuccessful();
		ActiveAndroid.endTransaction();

		Toast.makeText(this, etAccount.getText().toString() + " account saved!", Toast.LENGTH_LONG).show();

		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.menu_add_account, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
