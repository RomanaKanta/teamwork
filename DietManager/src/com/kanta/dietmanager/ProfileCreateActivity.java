package com.kanta.dietmanager;

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
import com.kanta.dietmanager.modelclass.ProfileModel;

public class ProfileCreateActivity extends ActionBarActivity {

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

	Button save;

	Gson gson;
	ProfileModel profileObject;
	Editor prefsEditor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_profile);
		SharedPreferences prefs = this.getSharedPreferences("settings",
				Context.MODE_PRIVATE);
		prefsEditor = prefs.edit();
		initiatize();

		// Save Button OPeration
		save.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				getDataFromForm();
				profileObject = new ProfileModel(mName, mFname, mMname,
						mBirthDate, mWeight, mHeight, mBloodGroup, mLocation,
						mComment);

				// object Insert
				saveObject(profileObject);

				Intent i = new Intent(getBaseContext(),
						ProfileViewActivity.class);
				startActivity(i);

			}
		});
	}

	public void initiatize() {
		name = (EditText) findViewById(R.id.etName);
		fname = (EditText) findViewById(R.id.etFname);
		mname = (EditText) findViewById(R.id.etMname);
		birth = (EditText) findViewById(R.id.etDob);
		weight = (EditText) findViewById(R.id.etWeight);
		height = (EditText) findViewById(R.id.etHeight);
		location = (EditText) findViewById(R.id.etLocation);
		bloodGroup = (EditText) findViewById(R.id.etBloodGroup);
		comment = (EditText) findViewById(R.id.etSpComment);
		save = (Button) findViewById(R.id.bSaveCP);

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
