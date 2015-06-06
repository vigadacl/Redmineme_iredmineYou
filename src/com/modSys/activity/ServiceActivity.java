package com.modSys.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.modSyst.adapter.MenuAdapter;
import com.tes.modulSystem.R;

public class ServiceActivity extends ListAdapterActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service);
		setTitle(R.string.service);
		getActionBar().setIcon(R.drawable.ic_services);
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setDisplayShowHomeEnabled(true);

		Resources res = getResources();
		// imageView of each menu item
		images = new int[] { R.drawable.ic_remine, R.drawable.ic_chatroom };
		// menu item service
		titles = res.getStringArray(R.array.serviceMenu);
		// description for each item service
		description = res.getStringArray(R.array.serviceMenudescription);
		listview = (ListView) findViewById(R.id.listview1);
		MenuAdapter mAdapter = new MenuAdapter(ServiceActivity.this, titles,
				images, description);
		listview.setAdapter(mAdapter);

		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(ServiceActivity.this,
						"You Clicked at " + titles[+position],
						Toast.LENGTH_SHORT).show();

				if (position == 0) {
					Intent intent = new Intent(ServiceActivity.this,
							ReminemeActivity.class);
					startActivity(intent);
				}
			}
		});
	}

	public boolean onOptionsItemSelected(MenuItem menuItem) {
		switch (menuItem.getItemId()) {
		// return to nextActivity
		case android.R.id.home:
			Intent intent = new Intent(getApplicationContext(),
					NextActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			return true;
		}
		return (super.onOptionsItemSelected(menuItem));
	}
}
