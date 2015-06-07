package com.modSyst.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.tes.modulSystem.R;

public class RemidneAdapter extends ArrayAdapter<String> {

	Activity context;
	String[] titles;
	String [] end;
	String [] start;
	String [] delay;
	

	public RemidneAdapter(Activity context, String[] titles, String[] start,
			String[] end,String[] delay) {
		super(context, R.layout.singlerowremidne, titles);
		this.titles = titles;
		this.context = context;
		this.start = start;
		this.end = end;
		this.delay = delay;
	}

	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater infalter = context.getLayoutInflater();
		View row = infalter.inflate(R.layout.singlerowremidne, null, true);

		TextView myTitle = (TextView) row.findViewById(R.id.remidnename);
		TextView startd = (TextView) row.findViewById(R.id.startdate);
		TextView endd = (TextView) row.findViewById(R.id.enddate);
		TextView delayd = (TextView) row.findViewById(R.id.delaydate);

		myTitle.setText(titles[position]);
	    startd.setText(start[position]);
	    endd.setText(end[position]);
	    delayd.setText(delay[position]);
	
		return row;
	}
}
