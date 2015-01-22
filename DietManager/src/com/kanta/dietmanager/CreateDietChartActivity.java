package com.kanta.dietmanager;

import java.text.DecimalFormat;
import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.kanta.dietmanager.datasource.DietChartDataSource;
import com.kanta.dietmanager.modelclass.DietModel;

public class CreateDietChartActivity extends ActionBarActivity implements
		OnTimeSetListener {

	static final int DATE_DIALOG_ID = 9999;
	EditText etFeast, etMenu, setDate, setTime = null;
	String feast, menu, date, time = "";
	Button saveBtn;
	DietChartDataSource dietChartDataSource = null;
	DietModel diet;
	int id_To_Update = 0;
	Integer mSetHour = 0;
	Integer mSetMinute = 0;
	int mHour = 0;
	int mMinute = 0;
	final Calendar mCalendar = Calendar.getInstance();
	TimePickerDialog tpd;
	int mYear;
	int mMonth;
	int mDay;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_chart);
		dietChartDataSource = new DietChartDataSource(this);
		// Initialization
		etFeast = (EditText) findViewById(R.id.feast);
		etMenu = (EditText) findViewById(R.id.menu);
		setDate = (EditText) findViewById(R.id.setDate);
		setTime = (EditText) findViewById(R.id.setTime);

		// Process to get Current Time
		mHour = mCalendar.get(Calendar.HOUR_OF_DAY);
		mMinute = mCalendar.get(Calendar.MINUTE);

		// Launch Time Picker Dialog
		tpd = new TimePickerDialog(CreateDietChartActivity.this, this, mHour,
				mMinute, false);
		tpd.show();
		setDate.setOnClickListener(new OnClickListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				showDialog(DATE_DIALOG_ID);

			}
		});

		saveBtn = (Button) findViewById(R.id.bSave);
		saveBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				feast = etFeast.getText().toString();
				menu = etMenu.getText().toString();
				date = setDate.getText().toString();
				time = setTime.getText().toString();

				diet = new DietModel(feast, menu, date, time);

				Intent alarmIntent = new Intent(AlarmClock.ACTION_SET_ALARM);
				alarmIntent.putExtra(AlarmClock.EXTRA_HOUR, mSetHour);
				alarmIntent.putExtra(AlarmClock.EXTRA_MINUTES, mSetMinute);
				alarmIntent.putExtra(AlarmClock.EXTRA_SKIP_UI, true);
				alarmIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(alarmIntent);

				long inserted = dietChartDataSource.addDiet(diet);
				if (inserted >= 0) {
					Toast.makeText(getApplicationContext(), getString(R.string.DATA_INSERTED),
							Toast.LENGTH_LONG).show();

					Intent i = new Intent(getApplicationContext(),
							HomeActivity.class);
					startActivity(i);
					finish();
				} else {
					Toast.makeText(getApplicationContext(),
							"Data insertion failed...", Toast.LENGTH_LONG)
							.show();
				}

			}
		});
	}

	// datepicker in dialogbox
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DATE_DIALOG_ID:
			return new DatePickerDialog(this, mDateSetListener, mDay, mMonth,
					mYear);
		}
		return null;
	}

	private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {

		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			mYear = year;
			mMonth = monthOfYear;
			mDay = dayOfMonth;
			setDate.setText(new StringBuilder()
					.append(new DecimalFormat("00").format(mDay)).append("-")
					.append(new DecimalFormat("00").format(mMonth + 1))
					.append("-").append(mYear));
		}
	};

	public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
		// TODO Auto-generated method stub

		mSetHour = hourOfDay;
		mSetMinute = minute;
		int hour = 0;
		String st = "";
		if (hourOfDay > 12) {
			hour = hourOfDay - 12;
			st = "PM";
		}

		else if (hourOfDay == 12) {
			hour = hourOfDay;
			st = "PM";
		}

		else if (hourOfDay == 0) {
			hour = hourOfDay + 12;
			st = "AM";
		} else {
			hour = hourOfDay;
			st = "AM";
		}
		setTime.setText(new StringBuilder().append(hour).append(" : ")
				.append(minute).append(" ").append(st));
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
