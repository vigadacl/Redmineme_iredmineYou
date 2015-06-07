package com.modSys.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.modSys.database.Database;
import com.tes.modulSystem.R;
import com.tes.modulSystem.util.NetworkState;

public class MainActivity extends UserActivity implements OnClickListener {

	private String email2;

	private Button register;

	private TextView changedPass;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		email = (EditText) findViewById(R.id.emailId);
		password = (EditText) findViewById(R.id.passId);

		register = (Button) findViewById(R.id.register);
		register.setOnClickListener(this);

		showPwd = (CheckBox) findViewById(R.id.cbShowPwd);
		setPasswortCheckBoxListener(showPwd, password);

		this.changedPass = (TextView) findViewById(R.id.passwordForget);
		this.changedPass.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.register:
			Intent intent = new Intent(MainActivity.this,
					RegistrerActivity.class);
			MainActivity.this.startActivity(intent);
			break;

		case R.id.passwordForget:

			Intent intent2 = new Intent(MainActivity.this, ResetPassword.class);
			MainActivity.this.startActivity(intent2);
			break;

		default:
			break;
		}

	}

	public void onClickStart(View v) {
		if (v.getId() == R.id.login) {
			email.setError(null);
			password.setError(null);
			final String emailA = email.getText().toString().trim();
			final String pass = password.getText().toString().trim();

			if (TextUtils.isEmpty(emailA)) {
				email.requestFocus();
				email.setError(getString(R.string.login_username_empty));
			} else if (TextUtils.isEmpty(pass)) {
				password.requestFocus();
				password.setError(getString(R.string.login_password_empty));
			} else if (!NetworkState.isNetworkAvailable(this)) {
				new AlertDialog.Builder(this)
						.setTitle(R.string.no_network_title)
						.setMessage(R.string.no_network_message).show();
			} else {
				Database db = new Database(this);
				Cursor cs = db.getInformations(emailA, pass);
				cs.moveToFirst();
				boolean loginstatus = false;
				email2 = "";
				do {
					if (emailA.equals(cs.getString(0))
							&& !pass.equals(cs.getString(1))) {
						loginstatus = false;
						password.requestFocus();
						password.setError(getString(R.string.password_dont_matched_email));
						loginstatus = false;
					} else if (emailA.equals(cs.getString(0))
							&& pass.equals(cs.getString(1))) {
						loginstatus = true;
						email2 = cs.getString(0);
					}

				} while (cs.moveToNext());
				if (loginstatus) {
					Toast.makeText(this, "login success", Toast.LENGTH_SHORT)
							.show();
					Intent intent = new Intent(MainActivity.this,
							NextActivity.class);
					MainActivity.this.startActivity(intent);
				} else {
					Toast.makeText(this, "login fails", Toast.LENGTH_SHORT)
							.show();
				}

			}

		}

	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}
}
