package com.modSys.activity;

import android.app.Activity;
import android.widget.ListView;


public abstract class ListAdapterActivity extends Activity{

	protected String[] titles;
	protected String[] description;
	protected int [] images;
	protected ListView listview;
	
	
	
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
	public ListView getListview() {
		return listview;
	}
	public void setListview(ListView listview) {
		this.listview = listview;
	}
}
