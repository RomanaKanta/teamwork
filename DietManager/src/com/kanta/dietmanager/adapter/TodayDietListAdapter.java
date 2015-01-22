package com.kanta.dietmanager.adapter;

import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.kanta.dietmanager.R;


public class TodayDietListAdapter extends ArrayAdapter<String>{
	Activity context;
	String mName;
	ArrayList<String> nameList;  

	public TodayDietListAdapter(Activity context, ArrayList<String> nList ) {
		super(context,R.layout.today_diet_chart_row,nList);
		this.context = context;
		this.nameList = nList;
		// TODO Auto-generated constructor stub
	}
	
	public View getView(int position, View convertView, ViewGroup parent){
		LayoutInflater inf = context.getLayoutInflater();
		View rowView = inf.inflate(R.layout.today_diet_chart_row,null,true);
		TextView feast = (TextView) rowView.findViewById(R.id.tvFeast);
		feast.setText(nameList.get(position));
		return rowView;
		
	}

}
