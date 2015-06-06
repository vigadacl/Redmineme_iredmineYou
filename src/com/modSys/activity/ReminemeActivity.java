package com.tes.modulSystem.activity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TabActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

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
		ts2.setContent(new Intent(this, RemineGroupPage2.class));
		TabSpec ts3 = tabhost.newTabSpec("See all my remine");
		ts3.setIndicator("See all my remine");
		ts3.setContent(new Intent(this, ReminePage3.class));

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
/*
 * // UI References private EditText fromDateEtxt; private EditText toDateEtxt;
 * 
 * private DatePickerDialog fromDatePickerDialog; private DatePickerDialog
 * toDatePickerDialog; private DatePickerDialog rememberDatePickerDialog;
 * 
 * private SimpleDateFormat dateFormatter; private TextView rememberDateEtxt;
 * private Context context=this;
 * 
 * @Override protected void onCreate(Bundle savedInstanceState) { // TODO
 * Auto-generated method stub super.onCreate(savedInstanceState);
 * setContentView(R.layout.activity_remineme);
 * 
 * dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
 * 
 * fromDateEtxt = (EditText) findViewById(R.id.fromdate);
 * fromDateEtxt.setInputType(InputType.TYPE_NULL); fromDateEtxt.requestFocus();
 * 
 * toDateEtxt = (EditText) findViewById(R.id.todate);
 * toDateEtxt.setInputType(InputType.TYPE_NULL);
 * 
 * rememberDateEtxt = (EditText) findViewById(R.id.rememberdate);
 * rememberDateEtxt.setInputType(InputType.TYPE_NULL);
 * 
 * setDateTimeField(); }
 * 
 * private void setDateTimeField() { fromDateEtxt.setOnClickListener(this);
 * toDateEtxt.setOnClickListener(this);
 * rememberDateEtxt.setOnClickListener(this);
 * 
 * Calendar newCalendar = Calendar.getInstance(); fromDatePickerDialog = new
 * DatePickerDialog(this, new OnDateSetListener() {
 * 
 * public void onDateSet(DatePicker view, int year, int monthOfYear, int
 * dayOfMonth) { Calendar newDate = Calendar.getInstance(); newDate.set(year,
 * monthOfYear, dayOfMonth); fromDateEtxt.setText(dateFormatter.format(newDate
 * .getTime())); } }, newCalendar.get(Calendar.YEAR),
 * newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
 * 
 * toDatePickerDialog = new DatePickerDialog(this, new OnDateSetListener() {
 * 
 * public void onDateSet(DatePicker view, int year, int monthOfYear, int
 * dayOfMonth) { Calendar newDate = Calendar.getInstance(); newDate.set(year,
 * monthOfYear, dayOfMonth); toDateEtxt.setText(dateFormatter.format(newDate
 * .getTime())); rememberDateEtxt.setText(dateFormatter.format(newDate
 * .getTime())); }
 * 
 * }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH),
 * newCalendar.get(Calendar.DAY_OF_MONTH));
 * 
 * rememberDatePickerDialog = new DatePickerDialog(this, new OnDateSetListener()
 * {
 * 
 * public void onDateSet(DatePicker view, int year, int monthOfYear, int
 * dayOfMonth) { Calendar newDate = Calendar.getInstance(); newDate.set(year,
 * monthOfYear, dayOfMonth);
 * rememberDateEtxt.setText(dateFormatter.format(newDate .getTime())); }
 * 
 * }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH),
 * newCalendar.get(Calendar.DAY_OF_MONTH)); }
 * 
 * @Override public boolean onCreateOptionsMenu(Menu menu) { // Inflate the
 * menu; this adds items to the action bar if it is present.
 * getMenuInflater().inflate(R.menu.menu_redmineme, menu); return true; }
 * 
 * @Override public boolean onOptionsItemSelected(MenuItem item) { // Handle
 * action bar item clicks here. The action bar will // automatically handle
 * clicks on the Home/Up button, so long // as you specify a parent activity in
 * AndroidManifest.xml. int id = item.getItemId(); if (id ==
 * R.id.action_remineMe) { createNewGroupDialog(); setDateTimeField(); } if (id
 * == R.id.action_remineGroup) { return true; } return
 * super.onOptionsItemSelected(item); }
 * 
 * @Override public void onClick(View view) { if (view == fromDateEtxt) {
 * fromDatePickerDialog.show(); } else if (view == toDateEtxt) {
 * toDatePickerDialog.show(); } else { rememberDatePickerDialog.show(); } }
 * 
 * 
 * 
 * public void createNewGroupDialog() {
 * 
 * // get prompts.xml view LayoutInflater li = LayoutInflater.from(context);
 * View promptsView = li.inflate(R.layout.activity_remineme, null);
 * 
 * AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder( context);
 * 
 * // set prompts.xml to alertdialog builder
 * alertDialogBuilder.setView(promptsView); // set dialog message
 * alertDialogBuilder .setCancelable(false) .setPositiveButton("OK", new
 * DialogInterface.OnClickListener() { public void onClick(DialogInterface
 * dialog, int id) {
 * 
 * } }) .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
 * public void onClick(DialogInterface dialog, int id) { dialog.cancel(); } });
 * 
 * // create alert dialog AlertDialog alertDialog = alertDialogBuilder.create();
 * 
 * // show it alertDialog.show();
 * 
 * }
 */

