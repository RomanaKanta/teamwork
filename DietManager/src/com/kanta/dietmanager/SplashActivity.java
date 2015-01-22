package com.kanta.dietmanager;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


public class SplashActivity extends ActionBarActivity {
	 SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        prefs = this.getSharedPreferences("settings", Context.MODE_PRIVATE);
        
        
        /****** Create Thread that will sleep for 2 seconds *************/        
        Thread background = new Thread() {
            public void run() {
                 
                try {
                    // Thread will sleep for 2 seconds
                    sleep(2*1000);
                   String check = prefs.getString("Profile","");
                    
                     if(!check.equals("")){ 
                    	// After 2 seconds redirect to another intent
                         Intent i=new Intent(getBaseContext(), HomeActivity.class);
                         startActivity(i);
                         
                    	 } else {
                    		 // After 2 seconds redirect to another intent
                             Intent i=new Intent(getBaseContext(), ProfileCreateActivity.class);
                             startActivity(i);
                    	 }
                                                       
                    //Remove activity
                    finish();
                     
                } catch (Exception e) {
                 
                }
            }
        };
         
        // start thread
        background.start();
 }
    
}
