package com.tes.modulSystem.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.tes.modulSystem.R;
import com.tes.modulSystem.adapter.MenuAdapter;

public class ServiceActivity extends Activity   {

	private String[] titles;
	private String[] description;
	private ListView listView;

	//list of all image,which represent the menu of service
	private int[] images = new int[] { R.drawable.ic_remine,
			R.drawable.ic_chatroom};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service);
	    setTitle(R.string.service);
        getActionBar().setIcon(R.drawable.ic_services);
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setDisplayShowHomeEnabled(true);

		Resources res = getResources();
		//take all titles from serviceMenu
		titles = res.getStringArray(R.array.serviceMenu);
		//take description for each item
		description = res.getStringArray(R.array.serviceMenudescription);
		listView = (ListView) findViewById(R.id.listview1);
		MenuAdapter mAdapter = new MenuAdapter(ServiceActivity.this, titles,
				images, description);
		listView.setAdapter(mAdapter);

		//get a smallest feedback when user click on one item
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
	
	public boolean onOptionsItemSelected(MenuItem menuItem) {
	    switch (menuItem.getItemId()) {
	        //return to nextActivity
	        case android.R.id.home:
	        	  Intent intent = new Intent(getApplicationContext(), NextActivity.class);
	        	    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	        	    startActivity(intent);
	            return true;
	    }
	    return (super.onOptionsItemSelected(menuItem));
	}
}
