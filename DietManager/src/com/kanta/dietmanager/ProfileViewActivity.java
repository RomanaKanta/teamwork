package com.kanta.dietmanager;

import java.lang.reflect.Type;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kanta.dietmanager.modelclass.ProfileModel;

public class ProfileViewActivity extends ActionBarActivity {
	TextView showName = null;
	TextView showFname = null;
	TextView showMname = null;
	TextView showBirth = null;
	TextView showWeight = null;
	TextView showHeight = null;
	TextView showLocation = null;
	TextView showBloodGroup = null;
	TextView showComment = null;
	Button update, ok;
	Gson gson;
	ProfileModel profileObject;
	Editor prefsEditor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_profile);
		SharedPreferences prefs = this.getSharedPreferences("settings",
				Context.MODE_PRIVATE);
		prefsEditor = prefs.edit();

		// initialize TextViews
		initializeViews();

		// get object
		Gson gson = new Gson();
		String jsonProfile = prefs.getString("Profile", null);
		Type type = new TypeToken<ProfileModel>() {
		}.getType();
		profileObject = gson.fromJson(jsonProfile, type);

		// Set Text
		setTextView();

		// Update Button OnClick Operation
		update.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getBaseContext(),
						ProfileUpdateActivity.class);
				startActivity(i);
			}
		});

		// OK Button OnClick Operation
		ok.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getBaseContext(), HomeActivity.class);
				startActivity(i);
			}
		});
	}

	public void initializeViews() {
		showName = (TextView) findViewById(R.id.TextViewName);
		showFname = (TextView) findViewById(R.id.TextViewFname);
		showMname = (TextView) findViewById(R.id.TextViewMname);
		showBirth = (TextView) findViewById(R.id.TextViewDob);
		showWeight = (TextView) findViewById(R.id.TextViewWeight);
		showHeight = (TextView) findViewById(R.id.TextViewHeight);
		showLocation = (TextView) findViewById(R.id.TextViewLocation);
		showBloodGroup = (TextView) findViewById(R.id.TextViewBloodGroup);
		showComment = (TextView) findViewById(R.id.TextViewSpComment);
		update = (Button) findViewById(R.id.update);
		ok = (Button) findViewById(R.id.ok);
	}

	public void setTextView() {
		showName.setText(profileObject.getName());
		showFname.setText(profileObject.getFName());
		showMname.setText(profileObject.getMName());
		showBirth.setText(profileObject.getBd());
		showWeight.setText(profileObject.getWt());
		showHeight.setText(profileObject.getHt());
		showLocation.setText(profileObject.getLocation());
		showBloodGroup.setText(profileObject.getBloodGroup());
		showComment.setText(profileObject.getComment());
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
			// profile found
			home();
			return true;

		case R.id.viewProfile:
			// profile found
			profileView();
			return true;

		case R.id.addDiet:
			// adding diet chart
			addDiet();
			return true;

		case R.id.viewAllChart:
			// profile found
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
