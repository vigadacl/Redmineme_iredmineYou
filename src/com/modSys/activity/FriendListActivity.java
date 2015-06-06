package com.modSys.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.modSys.database.Database;
import com.modSys.model.User;
import com.modSyst.adapter.ListFriendAdapter;
import com.tes.modulSystem.R;

public class FriendListActivity extends ListAdapterActivity {

	private EditText searchFriend;

	Database db = new Database(this);


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_friendlist);

		searchFriend = (EditText) findViewById(R.id.searchInMyFriendlist);

		setTitle(R.string.myfriendlist);
		getActionBar().setIcon(R.drawable.imageprofil);
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setDisplayShowHomeEnabled(true);

		titles = getUsers(db.getAllUserByName());
		int imgs [] = new int [titles.length];
		for(int i = 0; i < titles.length ; i++) {
			imgs[i] = R.drawable.imageprofil;
		}
		
		listview = (ListView) findViewById(R.id.listview1);
		ListFriendAdapter mAdapter = new ListFriendAdapter(
				FriendListActivity.this, titles, imgs);
		listview.setAdapter(mAdapter);

		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				/*
				 * Toast.makeText(FriendListActivity.this, "You Clicked at " +
				 * titles[(int) +id], Toast.LENGTH_SHORT).show();
				 */
			}
		});

		

		searchFriend.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				ArrayList<String> tmp = new ArrayList<String>();
				int textlength = searchFriend.getText().length();
				tmp.clear();
				for (int i = 0; i < titles.length; i++) {

					if (textlength <= titles[i].length()) {
						if (searchFriend
								.getText()
								.toString()
								.equalsIgnoreCase(
										(String) titles[i].subSequence(0,
												textlength))) {
							tmp.add(titles[i]);
						}
					}
				}
				listview.setAdapter(new ArrayAdapter<String>(
						FriendListActivity.this,
						android.R.layout.simple_list_item_1, tmp));
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {

			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});

	}

	public String[] getUsers(List<User> users) {
		Database db = new Database(this);

		String[] usern = new String[users.size()];

		for (int i = 0; i < users.size(); i++) {
			usern[i] = users.get(i).getName();
		}

		db.close();
		return usern;
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

	

	public String[] getTitles() {
		return titles;
	}

	public void setTitles(String[] titles) {
		this.titles = titles;
	}

	public EditText getSearchFriend() {
		return searchFriend;
	}

	public void setSearchFriend(EditText searchFriend) {
		this.searchFriend = searchFriend;
	}

}
