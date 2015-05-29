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
import android.widget.EditText;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.tes.modulSystem.R;

public class RegistrerActivity extends Activity implements
		OnClickListener {

	// input user name
	protected EditText user;
	// input password
	protected EditText password;
	// input email
	protected EditText email;
	// register button
	private Button register;
	// show password
	private CheckBox showPwd;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		this.user = (EditText) findViewById(R.id.userId1);
		this.password = (EditText) findViewById(R.id.passId1);
		this.email = (EditText) findViewById(R.id.emailId1);

		this.showPwd = (CheckBox) findViewById(R.id.showPwd);
		setPasswortCheckBoxListener(showPwd, password);
		this.register = (Button) findViewById(R.id.register1);
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

	public EditText getEmail() {
		return email;
	}

	public void setEmail(EditText email) {
		this.email = email;
	}


	 public void onClickStart(View v) {
	        if (v.getId() == R.id.register1) {
	            user.setError(null);
	            password.setError(null);
	            email.setError(null);
	            final String username = user.getText().toString().trim();
	            final String pass = password.getText().toString().trim();
	            final String emailA = email.getText().toString().trim();
	            
	            if (TextUtils.isEmpty(username)) {
	                user.requestFocus();
	                user.setError(getString(R.string.login_username_empty));
	            } else if (TextUtils.isEmpty(pass)) {
	                password.requestFocus();
	                password.setError(getString(R.string.login_password_empty));
	            }  else if (TextUtils.isEmpty(emailA)) {
	                email.requestFocus();
	                email.setError(getString(R.string.login_email_empty));
	            }  else {
					Intent intent = new Intent(RegistrerActivity.this,
							MainActivity.class);
					RegistrerActivity.this.startActivity(intent);

				}

	        }
	     
	    }
}
