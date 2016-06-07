/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.foodmap.foodmap;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.foodmap.foodmap.model.GDPath;
import com.foodmap.foodmap.model.GDRoute;
import com.foodmap.foodmap.model.GDirectionRoutes;
import com.foodmap.foodmap.utils.DirectionRoutesJSONParser;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.SphericalUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * This shows how to create a simple activity with a map and a marker on the map.
 */
public class BasicMapDemoActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Location location;

    private RestaurantTbl restaurantTemp;

    private double fromLatitude;
    private double fromLongitude;
    private double toLatitude;
    private double toLongitude;
    //private LinearLayout lv;
    //private Animation animation1;
    //private Animation animation2;

    private DrawerLayout mDrawerLayout;
    private ExpandableListView mDrawerList;

    private List<GDRoute> groupArray;//组列表
    private  List<List<String>> childArray;//子列表

    private GDirectionRoutes directionListTemp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_demo);

        Intent intent3 = this.getIntent();
        restaurantTemp = (RestaurantTbl) intent3.getSerializableExtra("resDetail");
        System.out.println("22222222222222" + restaurantTemp.getName());
        System.out.println("22222222222222" + restaurantTemp.getLatitude());
        System.out.println("22222222222222" + restaurantTemp.getLongtitude());

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_expandable_listview);
        mDrawerList = (ExpandableListView) findViewById(R.id.left_drawer);
        groupArray =new ArrayList<GDRoute>();
        childArray = new ArrayList<List<String>>();

        /*
        lv = (LinearLayout) findViewById(R.id.ll_popupLayout);
        animation1 = AnimationUtils.loadAnimation(this,
                R.anim.activity_open);
        animation2 = AnimationUtils.loadAnimation(this,
                R.anim.activity_close);
        */



        toLatitude = Double.parseDouble(restaurantTemp.getLatitude());
        toLongitude = Double.parseDouble(restaurantTemp.getLongtitude());

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we
     * just add a marker near Africa.
     */
    @Override
    public void onMapReady(GoogleMap map) {
        //map.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));

        mMap = map;
        LocationManager service = (LocationManager) getSystemService(LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String provider = service.getBestProvider(criteria, false);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        }
        location = service.getLastKnownLocation(provider);

        fromLatitude = location.getLatitude();
        fromLongitude = location.getLongitude();

        //fromLatitude = 45.4715234;
        //fromLongitude = -73.570739;



        final LatLng sydney = new LatLng(fromLatitude, fromLongitude);
        LatLng target = new LatLng(toLatitude, toLongitude);
        map.addMarker(new MarkerOptions().position(sydney).title(this.getString(R.string.current_loc)));
        map.addMarker(new MarkerOptions().position(target).title(restaurantTemp.getName()));
        //map.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        /*
        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                lv.setVisibility(View.VISIBLE);
                lv.setAnimation(animation1);

                TextView updown_des = (TextView) findViewById(R.id.updown_des);
                TextView updown_address = (TextView) findViewById(R.id.updown_address);
                TextView updown_number = (TextView) findViewById(R.id.updown_number);
                ImageView updown_iv = (ImageView) findViewById(R.id.updown_iv);

                updown_des .setText(restaurantTemp.getDescription());
                updown_address.setText(restaurantTemp.getAddress());
                updown_number.setText(restaurantTemp.getTelephone());
                AssetManager assetManager = getApplicationContext().getAssets();
                try {
                    InputStream in = assetManager.open("pic/" + restaurantTemp.getImageUrl().toString());
                    Bitmap bmp = BitmapFactory.decodeStream(in);
                    updown_iv.setImageBitmap(bmp);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return false;
            }
        });


        map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {

                CameraPosition camPosition = new CameraPosition.Builder().target(sydney).zoom(14).build();
                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(camPosition));
                lv.setVisibility(View.GONE);
                lv.setAnimation(animation2);
            }
        });
        */


        String url = "http://maps.google.com/maps/api/directions/json?origin=" + fromLatitude + "," + fromLongitude + "&destination=" + toLatitude + "," + toLongitude + "&alternatives=true&sensor=false&mode=driving";
        //Creating a string request
        StringRequest stringRequest = new StringRequest(url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        //loading.dismiss();
                        //Calling the method drawPath to draw the path
                        drawPath(response);

                        DirectionRoutesJSONParser directionRoutesJSONParser = new DirectionRoutesJSONParser();
                        JSONObject jsonObject = null;
                        //JSONArray jsonArray =
                        try {
                            jsonObject = new JSONObject(response);
                            System.out.println("dddddddddddddddd" + jsonObject.toString());
                            directionListTemp1 =  directionRoutesJSONParser.parse(jsonObject);
                            System.out.println("eeeeeeeeeeeeeeeeeee" + directionListTemp1.getRoutesList().size());

                            initdate();
                            //expandableListView_one.setAdapter(new ExpandableListViewaAdapter(ExpandableListDemo.this));
                            mDrawerList.setAdapter(new ExpandableListViewaAdapter(BasicMapDemoActivity.this));

                            //侧滑菜单初始为打开设置
                            mDrawerLayout.openDrawer(GravityCompat.START);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //loading.dismiss();
                    }
                });

        //Adding the request to request queue
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
        //MarkerOptions myMarkerOptions = new MarkerOptions();
        CameraPosition camPosition = new CameraPosition.Builder().target(sydney).zoom(14).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(camPosition));
    }

    public void onMyLocationToggled(View view) {
        updateMyLocation();
    }

    private void updateMyLocation() {

        // Enable the location layer. Request the location permission if needed.
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        }

    }

    //The parameter is the server response
    public void drawPath(String result) {
        //Getting both the coordinates
        LatLng from = new LatLng(fromLatitude, fromLongitude);
        LatLng to = new LatLng(toLatitude, toLongitude);

        //Calculating the distance in meters
        Double distance = SphericalUtil.computeDistanceBetween(from, to);

        DecimalFormat df = new DecimalFormat("#.00");
        String res = df.format(distance);

        //Displaying the distance
        Toast.makeText(this, String.valueOf(res + "Meters"), Toast.LENGTH_LONG).show();

        try {
            //Parsing json
            final JSONObject json = new JSONObject(result);
            JSONArray routeArray = json.getJSONArray("routes");
            JSONObject routes = routeArray.getJSONObject(0);
            JSONObject overviewPolylines = routes.getJSONObject("overview_polyline");
            String encodedString = overviewPolylines.getString("points");
            List<LatLng> list = decodePoly(encodedString);
            Polyline line = mMap.addPolyline(new PolylineOptions()
                    .addAll(list)
                    .width(9)
                    .color(Color.RED)
                    .geodesic(true)
            );
        } catch (JSONException e) {

        }
    }

    private List<LatLng> decodePoly(String encoded) {
        List<LatLng> poly = new ArrayList<LatLng>();
        int index = 0, len = encoded.length();
        int lat = 0, lng = 0;

        while (index < len) {
            int b, shift = 0, result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lat += dlat;

            shift = 0;
            result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lng += dlng;

            LatLng p = new LatLng((((double) lat / 1E5)),
                    (((double) lng / 1E5)));
            poly.add(p);

        }
        return poly;
    }

    class ExpandableListViewaAdapter extends BaseExpandableListAdapter {
        Activity activity;
        public  ExpandableListViewaAdapter(Activity a)
        {
            activity = a;
        }
        /*-----------------Child */
        @Override
        public Object getChild(int groupPosition, int childPosition) {
            // TODO Auto-generated method stub
            return childArray.get(groupPosition).get(childPosition);
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            // TODO Auto-generated method stub
            return childPosition;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition,
                                 boolean isLastChild, View convertView, ViewGroup parent) {

            String string =childArray.get(groupPosition).get(childPosition).toString();
            //return getGenericView(string);

            View view = convertView;

            if(view == null) {
                //另外一种解析XML布局文件的方式
                LayoutInflater mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = mInflater.inflate(R.layout.content_expandable_child_view, null);
            }

            TextView childTextView1 = (TextView) view.findViewById(R.id.child_text1);
            childTextView1.setText(String.valueOf(childPosition + 1) + " ");

            TextView childTextView2 = (TextView) view.findViewById(R.id.child_text2);
            childTextView2.setText(Html.fromHtml(string));

            return view;

        }

        @Override
        public int getChildrenCount(int groupPosition) {
            // TODO Auto-generated method stub
            return childArray.get(groupPosition).size();
        }
        /* ----------------------------Group */
        @Override
        public Object getGroup(int groupPosition) {
            // TODO Auto-generated method stub
            return getGroup(groupPosition);
        }

        @Override
        public int getGroupCount() {
            // TODO Auto-generated method stub
            return groupArray.size();
        }

        @Override
        public long getGroupId(int groupPosition) {
            // TODO Auto-generated method stub
            return groupPosition;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded,
                                 View convertView, ViewGroup parent) {

            String summary =groupArray.get(groupPosition).getSummary().toString();
            String durantion = String.valueOf(groupArray.get(groupPosition).getLegsList().get(0).getmDuration());
            String distance = String.valueOf(groupArray.get(groupPosition).getLegsList().get(0).getmDistance());
            //return getGenericView(string);

            View view = convertView;

            if(view == null) {
                //另外一种解析XML布局文件的方式
                LayoutInflater mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = mInflater.inflate(R.layout.content_expandable_group_view, null);
            }

            TextView GroupTextView1 = (TextView) view.findViewById(R.id.group_text1);
            GroupTextView1.setText("         " + summary + " ");

            TextView GroupTextView2 = (TextView) view.findViewById(R.id.group_text2);
            GroupTextView2.setText("   " + durantion + " ");

            TextView GroupTextView3 = (TextView) view.findViewById(R.id.group_text3);
            GroupTextView3.setText("   " + distance + " ");

            return view;
        }

        @Override
        public boolean hasStableIds() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition)
        {
            // TODO Auto-generated method stub
            return true;
        }

        private TextView getGenericView(String string )
        {
            AbsListView.LayoutParams  layoutParams =new AbsListView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);

            TextView  textView =new TextView(activity);
            textView.setLayoutParams(layoutParams);

            textView.setGravity(Gravity.CENTER_VERTICAL |Gravity.LEFT);

            textView.setPadding(40, 0, 0, 0);
            textView.setText(string);
            return textView;
        }
    }

    private void initdate()
    {
        //addInfo("  driving", new String[]{"Oracle","Java","Linux","Jquery"});
        //addInfo("  walking", new String[]{"金钱","事业","权力","女人","房子","车","球"});
        //addInfo("  bicycling", new String[]{"Oracle","Java","Linux","Jquery"});
        //addInfo("  transit", new String[]{"Oracle","Java","Linux","Jquery"});
        List<GDRoute> routes = directionListTemp1.getRoutesList();
        for(int x=0;x<routes.size();x++) {
            String currentSummary = routes.get(x).getSummary();
            GDRoute currentRoute = routes.get(x);
            addInfo(currentRoute);

        }
    }
    private void addInfo(GDRoute child) {

        //load data to group listView
        groupArray.add(child);

        //load data to child listView
        List<String>  childItem =new ArrayList<String>();

        List<GDPath> listPath = child.getLegsList().get(0).getPathsList();
        for(int index=0;index<listPath.size();index++)
        {
            childItem.add(listPath.get(index).getHtmlText().toString());
        }
        childArray.add(childItem);
    }

}
