package com.bes.redmineme_iredmineyou;

import com.bes.redmineme_iredmineyou.NextActivity;
import com.bes.redmineme_iredmineyou.R;
import com.bes.redmineme_iredmineyou.RegistrerActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	private Button login;
	private Button register;
	private TextView user;

	private TextView password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		user = (TextView) findViewById(R.id.userId);
		password = (TextView) findViewById(R.id.passId);

		login = (Button) findViewById(R.id.login);
		login.setOnClickListener(this);

		register = (Button) findViewById(R.id.register);
		register.setOnClickListener(this);
	}

	public TextView getUser() {
		return user;
	}

	public void setUser(TextView user) {
		this.user = user;
	}

	public TextView getPassword() {
		return password;
	}

	public void setPassword(TextView password) {
		this.password = password;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.register:
			Intent intent = new Intent(MainActivity.this,
					RegistrerActivity.class);
			MainActivity.this.startActivity(intent);
			break;

		case R.id.login:
			Intent intent1 = new Intent(MainActivity.this, NextActivity.class);
			MainActivity.this.startActivity(intent1);
			break;

		default:
			break;
		}

	}
}
