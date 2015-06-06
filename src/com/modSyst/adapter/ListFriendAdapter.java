package com.modSyst.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tes.modulSystem.R;

public class ListFriendAdapter extends ArrayAdapter<String>{
	Activity context;
	int[] imageId;
	String[] titleArray;

	public ListFriendAdapter(Activity context, String[] titles, int[] img) {
		super(context, R.layout.singlerow, titles);
		this.imageId = img;
		this.context = context;
		this.titleArray = titles;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater infalter = context.getLayoutInflater();
		View row = infalter.inflate(R.layout.singlerowfriendlist, null, true);

		ImageView myImage = (ImageView) row.findViewById(R.id.img1);
		TextView myTitle = (TextView) row.findViewById(R.id.txt1);

		myImage.setImageResource(imageId[position]);
		myTitle.setText(titleArray[position]);
		return row;
	}

}
