package com.foodmap.foodmap;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.foodmap.provider.DBHelper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TabActivity1 extends ActionBarActivity  {

    private ListView listView = null;
    private ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    //List<RestaurantTbl> restaurantsList;
    DBHelper dbHelper;
    MyAdapter myAdapter;

    //声明滑动菜单相关变量
    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ListView lvLeftMenu;  //显示restaurant的listview控件
    private String[] lvs ;  //菜单分类列表
    private ArrayAdapter arrayAdapter;
    private ImageView ivRunningMan;
    private AnimationDrawable mAnimationDrawable;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_1);

        /*  处理滑动菜单开始     */

        findViews(); //获取控件
        //京东RunningMan动画效果，和本次Toolbar无关
        //mAnimationDrawable = (AnimationDrawable) ivRunningMan.getBackground();
        //mAnimationDrawable.start();
        toolbar.setTitle("Toolbar");//设置Toolbar标题
        toolbar.setTitleTextColor(Color.parseColor("#ffffff")); //设置标题颜色
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //创建返回键，并实现打开关/闭监听
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name, R.string.app_name) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                //mAnimationDrawable.stop();
            }
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                //mAnimationDrawable.start();
                //invalidateOptionsMenu();// 重新绘制actionBar上边的菜单项
            }
        };
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        //设置菜单列表
        lvs = this.getResources().getStringArray(R.array.res_kind);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lvs);
        lvLeftMenu.setAdapter(arrayAdapter);

        /*  处理滑动菜单结束     */

        List<RestaurantTbl> restaurantsListTemp = new ArrayList<RestaurantTbl>();
        dbHelper = new DBHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor cursor = db.query("RestaurantTbl", null, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            String NAME = cursor.getString(1);
            String ADDRESS = cursor.getString(4);
            String POSTAL = cursor.getString(2);
            String PICTURE = cursor.getString(5);
            String TELEPHONE = cursor.getString(3);
            String DESCRIPTION = cursor.getString(6);
            String RESKIND = cursor.getString(7);

            System.out.println("display class RestaurantTbl:----> " + NAME + ", " + ADDRESS + ", " + PICTURE);

            RestaurantTbl restaurant = new RestaurantTbl(NAME, ADDRESS, POSTAL, PICTURE, TELEPHONE, DESCRIPTION, RESKIND);
            restaurantsListTemp.add(restaurant);
        }

        listView = (ListView) findViewById(R.id.lv);
        myAdapter = new MyAdapter(restaurantsListTemp, this);

        listView.setAdapter(myAdapter);


        lvLeftMenu.setOnItemClickListener(new itemClickEvent());


    }

    private final class itemClickEvent implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //通过单击事件，获得单击选项的内容
            //String text = lvLeftMenu.getItemAtPosition(position).toString();
            List<RestaurantTbl> listTemp = new ArrayList<RestaurantTbl>();




            String s = Integer.toString(position);
            SQLiteDatabase db_query = dbHelper.getWritableDatabase();
            Cursor cursor;
            if("0".equals(s)){
                cursor = db_query.query("RestaurantTbl", null, null, null, null, null, null,null);
            }else{
                cursor = db_query.query("RestaurantTbl where kind="+position, null, null, null, null, null, null,null);
            }


            while (cursor.moveToNext()) {
                String NAME = cursor.getString(1);
                String ADDRESS = cursor.getString(4);
                String POSTAL = cursor.getString(2);
                String PICTURE = cursor.getString(5);
                String TELEPHONE = cursor.getString(3);
                String DESCRIPTION = cursor.getString(6);
                String RESKIND = cursor.getString(7);

                //System.out.println("display class RestaurantTbl:----> " + NAME + ", " + ADDRESS + ", " + PICTURE);

                RestaurantTbl restaurant = new RestaurantTbl(NAME, ADDRESS, POSTAL, PICTURE, TELEPHONE, DESCRIPTION, RESKIND);
                listTemp.add(restaurant);
            }
            myAdapter.refresh(listTemp);
            listView.setAdapter(myAdapter);



            //通过吐丝对象显示出来。
            //Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();

            mDrawerLayout.closeDrawer(lvLeftMenu);
        }
    }

    class MyAdapter extends BaseAdapter {
        AssetManager assetManager = null;
        private Context context;
        List<RestaurantTbl> restaurantsList;

        public MyAdapter(List<RestaurantTbl> list, Context context) {
            this.restaurantsList = list;
            this.context = context;
        }

        @Override
        public int getCount() {
            return restaurantsList.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            RestaurantTbl restaurant = restaurantsList.get(position);
            System.out.println(restaurant.getName());
            System.out.println(restaurant.getAddress());
            System.out.println(restaurant.getPostal());
            System.out.println(restaurant.getTelephone());
            System.out.println(restaurant.getImageUrl());
            System.out.println(restaurant.getDescription());
            System.out.println(restaurant.getResKind());
            System.out.println(restaurant.getPostal());

            View view = null;
            view = View.inflate(TabActivity1.this, R.layout.item_listview, null);

            ImageView iv = (ImageView) view.findViewById(R.id.iv);

            assetManager = context.getAssets();
            try {
                InputStream in = assetManager.open("pic/" + restaurant.getImageUrl().toString());
                Bitmap bmp = BitmapFactory.decodeStream(in);
                iv.setImageBitmap(bmp);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //iv.setImageURI(Uri.parse("pic/"+restaurant.getImageUrl().toString()));
            System.out.println("pic/" + restaurant.getImageUrl().toString());
            TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
            tv_title.setText(restaurant.getName());
            TextView tv_number = (TextView) view.findViewById(R.id.tv_number);
            tv_number.setText(restaurant.getTelephone());
            TextView tv_address = (TextView) view.findViewById(R.id.tv_address);
            tv_address.setText(restaurant.getAddress());
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

        public void refresh(List<RestaurantTbl> list){
            restaurantsList = list;
            notifyDataSetChanged();
        }


    }

    private void findViews() {
        ivRunningMan = (ImageView) findViewById(R.id.iv_main);
        toolbar = (Toolbar) findViewById(R.id.tl_custom);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_left);
        lvLeftMenu = (ListView) findViewById(R.id.lv_left_menu);
    }
}
