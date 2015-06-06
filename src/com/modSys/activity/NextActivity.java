package com.tes.modulSystem.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.tes.modulSystem.R;
import com.tes.modulSystem.adapter.MenuAdapter;

public class NextActivity extends Activity implements OnClickListener {

	private String[] titles;
	private String[] description;
	private ListView listView;

	private int[] images = new int[] { R.drawable.imageprofil,
			R.drawable.group, R.drawable.ic_services, R.drawable.imagesettings };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_next);

		Resources res = getResources();
		titles = res.getStringArray(R.array.mainMenu);
		description = res.getStringArray(R.array.mainMenudescription);
		listView = (ListView) findViewById(R.id.listview);
		MenuAdapter mAdapter = new MenuAdapter(NextActivity.this, titles,
				images, description);
		listView.setAdapter(mAdapter);

		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
				} else if (position == 2) {
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
	public void onClick(View v) {

	}

	public ListView getListView() {
		return listView;
	}

	public String[] getTitles() {
		return titles;
	}

	public void setTitles(String[] titles) {
		this.titles = titles;
	}

	public String[] getDescription() {
		return description;
	}

	public void setDescription(String[] description) {
		this.description = description;
	}

	public int[] getImages() {
		return images;
	}

	public void setImages(int[] images) {
		this.images = images;
	}
	

}

