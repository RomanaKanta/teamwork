package com.example.customeview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class FTFLTextView extends TextView{
	
	String m_text = "Type name here";

	public FTFLTextView(Context context) {
		super(context);
		init();
	}

	public FTFLTextView(Context context, AttributeSet as){
		super(context,as);	
		init();
	}
	
	public FTFLTextView(Context context, AttributeSet as, int id){
		super(context,as,id);
		init();
	}
	
	public void init(){
		this.setText(m_text);
	}
}
