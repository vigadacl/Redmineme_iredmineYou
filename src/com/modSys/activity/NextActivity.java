package com.modSys.activity;

import java.util.ArrayList;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.modSyst.adapter.MenuAdapter;
import com.tes.modulSystem.R;

public class NextActivity extends ListAdapterActivity {

	
	private EditText txt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_next);
		
		txt = (EditText) findViewById(R.id.addFriendToMyList);
		images = new int[] { R.drawable.imageprofil,
				R.drawable.group, R.drawable.ic_services, R.drawable.imagesettings };

		Resources res = getResources();
		//main menu
		titles = res.getStringArray(R.array.mainMenu);
		//description of each item menu
		description = res.getStringArray(R.array.mainMenudescription);
		listview = (ListView) findViewById(R.id.listview);
		//adapter for the listview
		MenuAdapter mAdapter = new MenuAdapter(NextActivity.this, titles,
				images, description);
		listview.setAdapter(mAdapter);

		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(NextActivity.this,
						"You Clicked at " + titles[+position],
						Toast.LENGTH_SHORT).show();

				if (position == 0) {
					Intent intent = new Intent(NextActivity.this,
							ProfilActivity.class);
					startActivity(intent);
				}else if (position == 1) {
					Intent intent = new Intent(NextActivity.this,
							FriendListActivity.class);
					startActivity(intent);
				}else if (position == 2) {
					Intent intent = new Intent(NextActivity.this,
							ServiceActivity.class);
					startActivity(intent);
				} else if (position == 3) {
					Intent intent = new Intent(NextActivity.this,
							SettingActivity.class);
					startActivity(intent);
				}
			}
		});
	
	}

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.next, menu);
		return super.onCreateOptionsMenu(menu);
	}
    
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_logout) {
			Intent i = new Intent(NextActivity.this,MainActivity.class);
			this.startActivity(i);
			Toast.makeText(NextActivity.this,
					"You are disconnect ",
					Toast.LENGTH_SHORT).show();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void onBackPressed() {
		//do nothing
	}
	
	
	
}

