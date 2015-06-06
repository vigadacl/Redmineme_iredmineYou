package com.modSys.activity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import com.tes.modulSystem.R;

@SuppressWarnings("deprecation")
public class ReminemeActivity extends TabActivity {

	TabHost tabhost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.tool_bar);
		setTitle(R.string.reminemeIremieyou);
		getActionBar().setIcon(R.drawable.ic_remine);
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setDisplayShowHomeEnabled(true);

		tabhost = getTabHost();
		TabSpec ts1 = tabhost.newTabSpec("Create remine me");
		ts1.setIndicator("Create remine me");
		ts1.setContent(new Intent(this, ReminemePage1.class));
		TabSpec ts2 = tabhost.newTabSpec("Create remine group");
		ts2.setIndicator("Create remine group");
		ts2.setContent(new Intent(this, ReminemePage2.class));
		TabSpec ts3 = tabhost.newTabSpec("See all my remine");
		ts3.setIndicator("See all my remine");
		ts3.setContent(new Intent(this, ReminemePage3.class));
		tabhost.addTab(ts1);
		tabhost.addTab(ts2);
		tabhost.addTab(ts3);
	}

	public boolean onOptionsItemSelected(MenuItem menuItem) {
		switch (menuItem.getItemId()) {
		// return to nextActivity
		case android.R.id.home:
			Intent intent = new Intent(getApplicationContext(),
					ServiceActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			return true;
		}
		return (super.onOptionsItemSelected(menuItem));
	}
}