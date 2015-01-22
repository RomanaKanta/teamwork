package com.kanta.dietmanager;

import java.util.ArrayList;
import java.util.Arrays;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.kanta.dietmanager.adapter.TodayDietListAdapter;

public class OneDayDietActivity extends ActionBarActivity{
	
	ListView onedayList;
	ArrayAdapter<String> listAdapter; 
	TodayDietListAdapter onedayAdapter;
	
	Button addmore,updateChart,deleteChart;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_day_diet);
        //today diet chart list
        onedayList = (ListView)findViewById(R.id.onedaychart);
        addmore = (Button) findViewById(R.id.bAddMore);
        updateChart = (Button) findViewById(R.id.bUpdateChart);
        deleteChart = (Button) findViewById(R.id.bDeleteChart);
		
		String[] name = {"name1","name2","name3","name4","name5"};
		
		ArrayList<String> nameList = new ArrayList<String>();
		nameList.addAll(Arrays.asList(name));
		
		onedayAdapter = new TodayDietListAdapter(this,nameList);
		onedayList.setAdapter(onedayAdapter);
        
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	
		// Take appropriate action for each action item click
        switch (item.getItemId()) {
        case R.id.home:
            // profile  found
        	home();
            return true;	
        
        case R.id.viewProfile:
            // profile  found
            profileView();
            return true;	
      
        case R.id.addDiet:
            // adding diet chart
            addDiet();
            return true;
            
        case R.id.viewAllChart:
            // profile  found
        	viewChart();
            return true;	
        default:
            return super.onOptionsItemSelected(item);
        }
	}

	private void addDiet() {
		Intent i = new Intent(getBaseContext(), CreateDietChartActivity.class);
        startActivity(i);
		
	}


	private void home() {
		Intent i = new Intent(getBaseContext(), HomeActivity.class);
        startActivity(i);
		
	}   
	
	private void profileView() {
		Intent i = new Intent(getBaseContext(), ProfileViewActivity.class);
        startActivity(i);
		
	}   
	
	private void viewChart() {
		Intent i = new Intent(getBaseContext(), ViewAllChartActivity.class);
        startActivity(i);
		
	}  
        
}


