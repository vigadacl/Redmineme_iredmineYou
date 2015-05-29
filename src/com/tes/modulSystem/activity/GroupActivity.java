package com.tes.modulSystem.activity;

import com.tes.modulSystem.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class GroupActivity extends Activity {

	/*final Context context = this;

	private EditText inputNewGroup;

	private EditText inputNewDescription;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profil);
		inputNewDescription = (EditText) findViewById(R.id.description);
		inputNewGroup = (EditText) findViewById(R.id.newgroup);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_group, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_inviteAFriend) {
			return true;
		}
		if (id == R.id.action_newGroup) {
			createNewGroupDialog();
		}
		if (id == R.id.friendList) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@SuppressLint("InflateParams")
	public void createNewGroupDialog() {

		// get prompts.xml view
		LayoutInflater li = LayoutInflater.from(context);
		View promptsView = li.inflate(R.layout.remineme, null);

		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				context);

		// set prompts.xml to alertdialog builder
		alertDialogBuilder.setView(promptsView);
		// set dialog message
		alertDialogBuilder
				.setCancelable(false)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {

					}
				})
				.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
							}
						});

		// create alert dialog
		AlertDialog alertDialog = alertDialogBuilder.create();

		// show it
		alertDialog.show();

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

	public EditText getInputNewGroup() {
		return inputNewGroup;
	}

	public void setInputNewGroup(EditText inputNewGroup) {
		this.inputNewGroup = inputNewGroup;
	}

	public EditText getInputNewDescription() {
		return inputNewDescription;
	}

	public void setInputNewDescription(EditText inputNewDescription) {
		this.inputNewDescription = inputNewDescription;
	}*/
}
