package com.foodmap.foodmap;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
			String PICTURE = cursor.getColumnName(5);
			String TELEPHONE = cursor.getColumnName(4);

			RestaurantTbl restaurant = new RestaurantTbl(NAME, ADDRESS, POSTAL, PICTURE, TELEPHONE);
			restaurantsList.add(restaurant);
		}

		listView = (ListView) findViewById(R.id.lv);
		listView.setAdapter(new MyAdapter());

	}

	class MyAdapter extends BaseAdapter {
		@Override
		public int getCount() {
			return restaurantsList.size();
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			RestaurantTbl restaurant = restaurantsList.get(position);

			View view = null;
			view = View.inflate(TabActivity1.this, R.layout.item_listview, null);
//			ImageView iv = (TextView) view.findViewById(R.id.iv);
//            iv.setText(restaurant.getPICTURE());
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
