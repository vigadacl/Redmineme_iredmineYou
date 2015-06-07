package com.modSys.activity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.CompoundButton.OnCheckedChangeListener;

public abstract class UserActivity extends Activity {

	// user name
	protected EditText username;

	// user pass
	protected EditText password;

	// user email
	protected EditText email;

	// show password
	protected CheckBox showPwd;

	/**
	 * when user clicks on this checkbox, then show password
	 * 
	 * @param showPwd2
	 * @param password2
	 */
	public void setPasswortCheckBoxListener(CheckBox showPwd2,
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

	public EditText getUsername() {
		return username;
	}

	public void setUsername(EditText username) {
		this.username = username;
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

	public CheckBox getShowPwd() {
		return showPwd;
	}

	public void setShowPwd(CheckBox showPwd) {
		this.showPwd = showPwd;
	}
	
	/**
	 * method is used for checking valid email id format.
	 * 
	 * @param email
	 * @return boolean true for valid false for invalid
	 */
	public static boolean isEmailValid(String email) {
	    boolean isValid = false;

	    String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
	    CharSequence inputStr = email;

	    Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(inputStr);
	    if (matcher.matches()) {
	        isValid = true;
	    }
	    return isValid;
	}

}
