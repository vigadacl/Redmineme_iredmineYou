package com.tes.modulSystem.activity;

import com.tes.modulSystem.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splashscreen extends Activity {

	private static int SPLASH_DURATION = 1000;
	private Handler startm;
	private boolean isBackButtonPressed;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splashscreen);
		startm = new Handler();

		startm.postDelayed(new Runnable() {

			@Override
			public void run() {
				finish();
				if (!isBackButtonPressed) {
					Intent intent = new Intent(Splashscreen.this,
							MainActivity.class);
					Splashscreen.this.startActivity(intent);
				}
			}
		}, SPLASH_DURATION);
	}

	@Override
	public void onBackPressed() {
		isBackButtonPressed = true;
		super.onBackPressed();
	}
}
