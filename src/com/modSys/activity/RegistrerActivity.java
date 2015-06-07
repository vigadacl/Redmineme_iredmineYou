package com.modSys.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.modSys.database.Database;
import com.modSys.model.User;
import com.tes.modulSystem.R;

public class RegistrerActivity extends UserActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);

		username = (EditText) findViewById(R.id.userId1);
		password = (EditText) findViewById(R.id.passId1);
		email = (EditText) findViewById(R.id.emailId1);

		showPwd = (CheckBox) findViewById(R.id.showPwd);
		setPasswortCheckBoxListener(showPwd, password);

	}

	/**
	 * check if user set his name, password and email and then register user
	 * 
	 * @param v
	 */
	public void onClickStart(View v) {
		if (v.getId() == R.id.register1) {
			username.setError(null);
			password.setError(null);
			email.setError(null);
			final String user1 = username.getText().toString().trim();
			final String pass = password.getText().toString().trim();
			final String emailA = email.getText().toString().trim();

			if (TextUtils.isEmpty(user1)) {
				username.requestFocus();
				username.setError(getString(R.string.login_username_empty));
			} else if (TextUtils.isEmpty(pass)) {
				password.requestFocus();
				password.setError(getString(R.string.login_password_empty));
			} else if (TextUtils.isEmpty(emailA)) {
				email.requestFocus();
				email.setError(getString(R.string.login_email_empty));
			} else if (password.length() < 6) {
				password.requestFocus();
				password.setError(getString(R.string.password_short));
			} else if (!isEmailValid(emailA)) {
				email.requestFocus();
				email.setError(getString(R.string.email_novalid));
			} else if (!com.tes.modulSystem.util.NetworkState.isNetworkAvailable(this)) {
				new AlertDialog.Builder(this)
						.setTitle(R.string.no_network_title)
						.setMessage(R.string.no_network_message).show();
			} else {
				Database db = new Database(this);
				boolean isda = false;

				if (db.containEmail(emailA)) {
					isda = true;
					email.requestFocus();
					email.setError(getString(R.string.email_exit));
				} else {
					User user = new User(emailA, user1, pass);
					db.createOrUpdateUser(user);
					Toast.makeText(this, "registration success",
							Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(RegistrerActivity.this,
							MainActivity.class);
					RegistrerActivity.this.startActivity(intent);
				}
			}
		}

	}
}
