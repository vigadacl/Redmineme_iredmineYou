package com.modSys.activity;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.modSys.database.Database;
import com.modSys.model.Remidne;
import com.modSyst.adapter.RemidneAdapter;
import com.tes.modulSystem.R;

public class ReminemePage3 extends Activity {

	Database db = new Database(this);

	private String[] activityName;

	private String[] start;
	private String[] end;
	private String[] delay;
	private ListView listview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page_item3);
		
        activityName = extractRemidneName(db.getAllRemidne());
        start = extractStartDate(db.getAllRemidne());
        end = extractEnd(db.getAllRemidne());
        delay = extractDelay(db.getAllRemidne());
        
        listview = (ListView)findViewById(R.id.listview4);
        RemidneAdapter adapter = new RemidneAdapter(ReminemePage3.this, activityName, start, end, delay);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				
			}
		});
        db.close();
	}

	public String[] extractRemidneName(List<Remidne> remidne) {

		activityName = new String[remidne.size()];
		for (int i = 0; i < activityName.length; i++) {
			activityName[i] = remidne.get(i).getName();
		}

		return activityName;
	}

	public String[] extractStartDate(List<Remidne> remidne) {

		start = new String[remidne.size()];
		for (int i = 0; i < start.length; i++) {
			start[i] = remidne.get(i).getStart();
		}

		return start;
	}

	public String[] extractEnd(List<Remidne> remidne) {

		end = new String[remidne.size()];
		for (int i = 0; i < end.length; i++) {
			end[i] = remidne.get(i).getEnd();
		}

		return end;
	}

	public String[] extractDelay(List<Remidne> remidne) {

		delay = new String[remidne.size()];
		for (int i = 0; i < delay.length; i++) {
			delay[i] = remidne.get(i).getName();
		}

		return delay;
	}

	public String[] getActivityName() {
		return activityName;
	}

	public void setActivityName(String[] activityName) {
		this.activityName = activityName;
	}

	public String[] getStart() {
		return start;
	}

	public void setStart(String[] start) {
		this.start = start;
	}

	public String[] getEnd() {
		return end;
	}

	public void setEnd(String[] end) {
		this.end = end;
	}

	public String[] getDelay() {
		return delay;
	}

	public void setDelay(String[] delay) {
		this.delay = delay;
	}

}
