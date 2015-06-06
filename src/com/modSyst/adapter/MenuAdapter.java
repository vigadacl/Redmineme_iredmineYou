package com.tes.modulSystem.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tes.modulSystem.R;

public class MenuAdapter extends ArrayAdapter<String> {

	Activity context;
	int[] imageId;
	String[] titleArray;
	String[] descriptionArray;

	public MenuAdapter(Activity context, String[] titles, int[] img,
			String[] desc) {
		super(context, R.layout.singlerow, titles);
		this.imageId = img;
		this.context = context;
		this.titleArray = titles;
		this.descriptionArray = desc;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater infalter = context.getLayoutInflater();
		View row = infalter.inflate(R.layout.singlerow, null, true);

		ImageView myImage = (ImageView) row.findViewById(R.id.img);
		TextView myTitle = (TextView) row.findViewById(R.id.txt);
		TextView myDescription = (TextView) row.findViewById(R.id.desc);

		myImage.setImageResource(imageId[position]);
		myTitle.setText(titleArray[position]);
		myDescription.setText(descriptionArray[position]);
		return row;
	}
}