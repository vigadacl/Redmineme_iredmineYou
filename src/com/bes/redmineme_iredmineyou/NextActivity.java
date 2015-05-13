package com.bes.redmineme_iredmineyou;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class NextActivity extends Activity implements OnClickListener {

	
	private ImageButton settingimage;
	private TextView settingtt;
	
	private ImageButton profilimage;
	private TextView profiltt;
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_next);
		
		settingimage = (ImageButton) findViewById(R.id.settingId);
		settingtt = (TextView) findViewById(R.id.settingname);
		
		settingimage.setOnClickListener(this);
		settingtt.setOnClickListener(this);
		
		profilimage = (ImageButton) findViewById(R.id.profilId);
		profiltt = (TextView) findViewById(R.id.profilname);
		
		profilimage.setOnClickListener(this);
		profiltt.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.settingId:
			Intent intent = new Intent(NextActivity.this, SettingActivity.class);
			NextActivity.this.startActivity(intent);
			break;

		case R.id.settingname:
			Intent intent1 = new Intent(NextActivity.this, SettingActivity.class);
			NextActivity.this.startActivity(intent1);
			break;
			
		case R.id.profilId:
			Intent intent2 = new Intent(NextActivity.this, ProfilActivity.class);
			NextActivity.this.startActivity(intent2);
			break;

		case R.id.profilname:
			Intent intent3 = new Intent(NextActivity.this, ProfilActivity.class);
			NextActivity.this.startActivity(intent3);
			break;

		default:
			break;
		}
	}

}
