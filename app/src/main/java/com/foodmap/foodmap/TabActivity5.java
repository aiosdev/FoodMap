package com.foodmap.foodmap;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TabActivity5 extends Activity {

	public TextView textView;


	private static Method sGetOpenSourceSoftwareLicenseInfo;
	private static final String THIS_CLASS_PACKAGE = "com.google.android.gms.common.GooglePlayServicesUtil";

	static {

		Class<?> googlePlayServicesUtilClass = null;
		try {
			googlePlayServicesUtilClass = Class.forName(THIS_CLASS_PACKAGE);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			sGetOpenSourceSoftwareLicenseInfo = googlePlayServicesUtilClass.getMethod(
					"getOpenSourceSoftwareLicenseInfo", Context.class);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}

	}

		/**
		 * Returns the open source software license information for the Google Play services application, or null if
		 * Google Play services is not available on this device.
		 *
		 * @param context
		 * @return
		 * @throws InvocationTargetException
		 * @throws IllegalAccessException
		 */
	public static String getOpenSourceSoftwareLicenseInfo(Context context)
			throws InvocationTargetException, IllegalAccessException {
		if (sGetOpenSourceSoftwareLicenseInfo == null) {
			return null;
		}

		return (String) sGetOpenSourceSoftwareLicenseInfo.invoke(null, context);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab_5);

		textView = (TextView) findViewById(R.id.tv_5);
		try {
			textView.setText((String)sGetOpenSourceSoftwareLicenseInfo.invoke(null, this));
			String test = (String)sGetOpenSourceSoftwareLicenseInfo.invoke(null, this);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}

