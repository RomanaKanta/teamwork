package com.kanta.dietmanager;

import java.util.ArrayList;
import java.util.Arrays;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.kanta.dietmanager.adapter.UpcomingDietListAdapter;

public class ViewAllChartActivity extends ActionBarActivity {
	ListView allList;
	ArrayAdapter<String> listAdapter; 
	UpcomingDietListAdapter allchartAdapter;
		
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_view_all_chart);
	        
	        allList = (ListView)findViewById(R.id.alldaychart);
			
	        String[] date = {"22-01-2015",
	        		         "23-01-2015",
	        		         "24-02-2015",
	        		         "25-02-2015",
	        		         "29-03-2015"};
	        
	        ArrayList<String> dateList = new ArrayList<String>();
			dateList.addAll(Arrays.asList(date));
			
	        String[] day = {"sat day",
			                "sun day",
			                "mon day",
			                "tue day",
			                "wed day"};
			
			ArrayList<String> dayList = new ArrayList<String>();
			dayList.addAll(Arrays.asList(day));
			
			allchartAdapter = new UpcomingDietListAdapter(this,dateList,dayList);
			allList.setAdapter(allchartAdapter);
			allList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	             @Override
	             public void onItemClick(AdapterView<?> parent, View view,
	                                     int position, long id) {
	            	 Intent i=new Intent(getBaseContext(), OneDayDietActivity.class);
	                 startActivity(i);
	                 }
	         });
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
