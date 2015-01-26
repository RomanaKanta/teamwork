package com.example.customeview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;

public class LayoutMain extends Activity implements OnTouchListener {
	
	private ImageView m_imageView;
	private ViewGroup m_rootLayout;
	private int m_X;
	private int m_Y;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_main);
		
		m_rootLayout = (ViewGroup) findViewById(R.id.root);
		m_imageView = (ImageView)m_rootLayout.findViewById(R.id.imageView);
		
		RelativeLayout.LayoutParams layoutParams = new LayoutParams(150, 150);
		
		m_imageView.setLayoutParams(layoutParams);
		m_imageView.setOnTouchListener(this);

//		RelativeLayout layout = (RelativeLayout) findViewById(R.id.relative);
//		layout.setOnTouchListener(this);
		// //create new
		// FTFLTextView tvName = new FTFLTextView(this);
		// layout.addView(tvName);
		//

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.layout_main, menu);
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

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		int x = (int) event.getRawX();
		int y = (int) event.getRawY();

		switch (event.getAction() & MotionEvent.ACTION_MASK) {

		case MotionEvent.ACTION_DOWN:
			
			RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) v
					.getLayoutParams();
			
			m_X = x - lParams.leftMargin;
			m_Y = y - lParams.topMargin;
			
			break;

		case MotionEvent.ACTION_UP:
			break;

		case MotionEvent.ACTION_MOVE:
			
			RelativeLayout.LayoutParams layoutParam = (RelativeLayout.LayoutParams) v
			.getLayoutParams();
			
			layoutParam.leftMargin = x - m_X;
			layoutParam.topMargin = y - m_Y;
			layoutParam.rightMargin = -250;
			layoutParam.bottomMargin = -250;
			
			v.setLayoutParams(layoutParam);
			break;
		}
		
		m_rootLayout.invalidate();

		// if ((event.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_UP) {
//			
//			Toast.makeText(this, "UP  X: " + x + "  Y : " + y, 100).show();
//			
//		} else if ((event.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_DOWN) {
//		
//			Toast.makeText(this, "DOWN  X: " + x + "  Y : " + y, 100).show();
//			
//		} else if ((event.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_MOVE) {
//			
//			Toast.makeText(this, "MOVE  X: " + x + "  Y : " + y, 100).show();
//			
//		}
		return true;
	}
}
