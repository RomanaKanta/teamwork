package com.kanta.dietmanager;

import java.lang.reflect.Type;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kanta.dietmanager.modelclass.ProfileModel;

public class ProfileUpdateActivity extends ActionBarActivity {

	public EditText name = null;
	public EditText fname = null;
	public EditText mname = null;
	public EditText birth = null;
	public EditText weight = null;
	public EditText height = null;
	public EditText location = null;
	public EditText bloodGroup = null;
	public EditText comment = null;

	public String mName = "";
	public String mFname = "";
	public String mMname = "";
	public String mBirthDate = "";
	public String mWeight = "";
	public String mHeight = "";
	public String mLocation = "";
	public String mBloodGroup = "";
	public String mComment = "";

	Button update;

	Gson gson;
	ProfileModel profileObject;
	Editor prefsEditor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update_profile);

		SharedPreferences prefs = this.getSharedPreferences("settings",
				Context.MODE_PRIVATE);
		prefsEditor = prefs.edit();
		
		// initialize TextViews
		initiatize();
		
		// get object
		Gson gson = new Gson();
		String jsonProfile = prefs.getString("Profile", null);
		Type type = new TypeToken<ProfileModel>() {
		}.getType();
		profileObject = gson.fromJson(jsonProfile, type);

		//setText
		setText();

		// Update Button Listener
		update.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				getDataFromForm();
				profileObject = new ProfileModel(mName, mFname, mMname,
						mBirthDate, mWeight, mHeight, mBloodGroup, mLocation,
						mComment);

				// object passing
				saveObject(profileObject);

				Intent i = new Intent(getBaseContext(),
						ProfileViewActivity.class);
				startActivity(i);
			}
		});
	}

	public void initiatize() {
		name = (EditText) findViewById(R.id.etUpdateName);
		fname = (EditText) findViewById(R.id.etUpdateFname);
		mname = (EditText) findViewById(R.id.etUpdateMname);
		birth = (EditText) findViewById(R.id.etUpdateDob);
		weight = (EditText) findViewById(R.id.etUpdateWeight);
		height = (EditText) findViewById(R.id.etUpdateHeight);
		location = (EditText) findViewById(R.id.etUpdateLocation);
		bloodGroup = (EditText) findViewById(R.id.etUpdateBloodGroup);
		comment = (EditText) findViewById(R.id.etUpdateSpComment);
		update = (Button) findViewById(R.id.btnUpdate);
	}

	public void getDataFromForm() {
		mName = name.getText().toString();
		mFname = fname.getText().toString();
		mMname = mname.getText().toString();
		mBirthDate = birth.getText().toString();
		mWeight = weight.getText().toString();
		mHeight = height.getText().toString();
		mLocation = location.getText().toString();
		mBloodGroup = bloodGroup.getText().toString();
		mComment = comment.getText().toString();
	}

	public void saveObject(ProfileModel object) {
		gson = new Gson();
		String json = gson.toJson(object);
		prefsEditor.putString("Profile", json);
		prefsEditor.commit();
	}

	public void setText() {
		name.setText(profileObject.getName());
		fname.setText(profileObject.getFName());
		mname.setText(profileObject.getMName());
		birth.setText(profileObject.getBd());
		weight.setText(profileObject.getWt());
		height.setText(profileObject.getHt());
		location.setText(profileObject.getLocation());
		bloodGroup.setText(profileObject.getBloodGroup());
		comment.setText(profileObject.getComment());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}