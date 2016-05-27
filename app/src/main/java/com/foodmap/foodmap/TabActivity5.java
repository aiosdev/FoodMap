package com.foodmap.foodmap;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.google.android.gms.common.GoogleApiAvailability;

public class TabActivity5 extends Activity {

	public TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab_5);

		textView = (TextView) findViewById(R.id.tv_5);
		textView.setMovementMethod(ScrollingMovementMethod.getInstance());
		GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
		int resultCode = apiAvailability.isGooglePlayServicesAvailable(this);
		String info = GoogleApiAvailability.getInstance().getOpenSourceSoftwareLicenseInfo(getApplicationContext());
		System.out.println("wwwwwwwwwwwww"+resultCode+","+GoogleApiAvailability.getInstance());

		/*
		if (resultCode == ConnectionResult.SUCCESS) {
			//AlertDialog.Builder builder = new AlertDialog.Builder(TabActivity5.this);
			//builder.setTitle("About");
			//builder.setMessage(apiAvailability.getOpenSourceSoftwareLicenseInfo(this));
			//builder.setPositiveButton("OK", null);
			//builder.show();
			//info = apiAvailability.getOpenSourceSoftwareLicenseInfo(this);
			textView.setText(info);

		}
		*/
	}

}

