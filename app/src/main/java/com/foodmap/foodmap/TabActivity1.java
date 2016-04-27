package com.foodmap.foodmap;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.foodmap.provider.DBHelper;
import com.foodmap.provider.Restaurant;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TabActivity1 extends Activity {

	private ListView listView = null;
	private ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	List<RestaurantTbl> restaurantsList;
	DBHelper dbHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab_1);

		restaurantsList = new ArrayList<RestaurantTbl>();
		dbHelper = new DBHelper(this);
		SQLiteDatabase db = dbHelper.getWritableDatabase();

		Cursor cursor = db.query("RestaurantTbl", null, null, null, null, null, null, null);

		while(cursor.moveToNext()){
			String NAME = cursor.getString(1);
			String ADDRESS = cursor.getString(2);
			String POSTAL = cursor.getString(3);
			String PICTURE = cursor.getString(5);
			String TELEPHONE = cursor.getString(4);

			System.out.println("display class RestaurantTbl:----> "+ NAME + ", " +  ADDRESS + ", " + PICTURE);

			RestaurantTbl restaurant = new RestaurantTbl(NAME, ADDRESS, POSTAL, PICTURE, TELEPHONE);
			restaurantsList.add(restaurant);
		}

		listView = (ListView) findViewById(R.id.lv);
		listView.setAdapter(new MyAdapter(this));

	}

	class MyAdapter extends BaseAdapter {
		AssetManager assetManager =null;
		private Context context;

		public MyAdapter(Context context) {
			this.context=context;
		}

		@Override
		public int getCount() {
			return restaurantsList.size();
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			RestaurantTbl restaurant = restaurantsList.get(position);
			System.out.println(restaurant.getADDRESS());
			System.out.println(restaurant.getNAME());
			System.out.println(restaurant.getPOSTAL());
			System.out.println(restaurant.getImageUrl());

			View view = null;
			view = View.inflate(TabActivity1.this, R.layout.item_listview, null);

			ImageView iv = (ImageView) view.findViewById(R.id.iv);

			assetManager=context.getAssets();
			try {
				InputStream in=assetManager.open("pic/"+restaurant.getImageUrl().toString());
				Bitmap bmp= BitmapFactory.decodeStream(in);
				iv.setImageBitmap(bmp);
			} catch (Exception e) {
				e.printStackTrace();
			}

			//iv.setImageURI(Uri.parse("pic/"+restaurant.getImageUrl().toString()));
			System.out.println("pic/"+restaurant.getImageUrl().toString());
			TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
			tv_title.setText(restaurant.getNAME());
			TextView tv_number = (TextView) view.findViewById(R.id.tv_number);
			tv_number.setText(restaurant.getTELEPHONE());
			TextView tv_address = (TextView) view.findViewById(R.id.tv_address);
			tv_address.setText(restaurant.getADDRESS());
			return view;
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}
	}
}
