package com.tes.modulSystem.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;

import com.tes.modulSystem.R;

public class MainActivity extends Activity implements OnClickListener {

	// input user name
	protected EditText user;
	// input password
	protected EditText password;
	// show password
	private CheckBox showPwd;
	// register button
	private Button register;
	// to change password
	private TextView changedPass;
	protected Button login;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.user = (EditText) findViewById(R.id.userId);
		this.password = (EditText) findViewById(R.id.passId);

		this.register = (Button) findViewById(R.id.register);
		this.register.setOnClickListener(this);

		this.showPwd = (CheckBox) findViewById(R.id.cbShowPwd);
		setPasswortCheckBoxListener(showPwd, password);

		this.login = (Button) findViewById(R.id.login);

		this.changedPass = (TextView) findViewById(R.id.passwordForget);
		this.changedPass.setOnClickListener(this);
	}

	public EditText getUser() {
		return user;
	}

	public void setUser(EditText user) {
		this.user = user;
	}

	public EditText getPassword() {
		return password;
	}

	public void setPassword(EditText password) {
		this.password = password;
	}

	/**
	 * when user clicks on this checkbox, then show password
	 * 
	 * @param showPwd2
	 * @param password2
	 */
	protected void setPasswortCheckBoxListener(CheckBox showPwd2,
			final EditText password2) {

		// add onCheckedListener on checkbox
		// when user clicks on this checkbox, this is the handler.
		showPwd2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// checkbox status is changed from uncheck to checked.
				if (!isChecked) {
					// show password
					password2
							.setTransformationMethod(PasswordTransformationMethod
									.getInstance());
					password2.setSelection(password2.length());

				} else {
					// hide password
					password2
							.setTransformationMethod(HideReturnsTransformationMethod
									.getInstance());
					password2.setSelection(password2.length());
				}
			}
		});
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
			user.setError(null);
			password.setError(null);
			final String username = user.getText().toString().trim();
			final String pass = password.getText().toString().trim();

			if (TextUtils.isEmpty(username)) {
				user.requestFocus();
				user.setError(getString(R.string.login_username_empty));
			} else if (TextUtils.isEmpty(pass)) {
				password.requestFocus();
				password.setError(getString(R.string.login_password_empty));
			} else {
				Intent intent = new Intent(MainActivity.this,
						NextActivity.class);
				MainActivity.this.startActivity(intent);

			}

		}

	}
}
