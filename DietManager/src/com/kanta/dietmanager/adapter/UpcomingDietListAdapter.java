package com.kanta.dietmanager.adapter;

import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.kanta.dietmanager.R;


public class UpcomingDietListAdapter extends ArrayAdapter<String>{
	Activity context;
	String mDate;
	ArrayList<String> dateList, dayList;  

	public UpcomingDietListAdapter(Activity context, ArrayList<String> nList,ArrayList<String>mList ) {
		super(context,R.layout.upcoming_diet_chart_row,nList);
		this.context = context;
		this.dateList = nList;
		this.dayList = mList;
		// TODO Auto-generated constructor stub
	}
	
	public View getView(int position, View convertView, ViewGroup parent){
		LayoutInflater inf = context.getLayoutInflater();
		View rowView = inf.inflate(R.layout.upcoming_diet_chart_row,null,true);
		TextView date = (TextView) rowView.findViewById(R.id.tvUpcomingDate);
		TextView day = (TextView) rowView.findViewById(R.id.tvUpcomingDay);
		date.setText(dateList.get(position));
		day.setText(dayList.get(position));
		return rowView;
		
	}

}
