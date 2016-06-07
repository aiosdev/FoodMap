package com.foodmap.foodmap;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.foodmap.foodmap.model.ClusterRestTbl;
import com.foodmap.provider.DBHelper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TabActivity3 extends AppCompatActivity implements
        OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        GoogleMap.OnMarkerDragListener,
        GoogleMap.OnMapLongClickListener,
        View.OnClickListener,
        ClusterManager.OnClusterClickListener<ClusterRestTbl>,
        ClusterManager.OnClusterInfoWindowClickListener<ClusterRestTbl>,
        ClusterManager.OnClusterItemClickListener<ClusterRestTbl>,
        ClusterManager.OnClusterItemInfoWindowClickListener<ClusterRestTbl> {

    private GoogleMap mMap;
    private Location location;

    //To store longitude and latitude from map
    private double longitude;
    private double latitude;

    //Google ApiClient
    private GoogleApiClient googleApiClient;

    private List<RestaurantTbl> restaurantList;

    private ClusterManager<ClusterRestTbl> mClusterManager;
    private Random mRandom = new Random(1984);

    private LinearLayout lv;
    private Animation animation1;
    private Animation animation2;


    private Handler handler = new Handler() {
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            RestaurantTbl resTemp = (RestaurantTbl) (msg.obj);
            System.out.println("qqqqqqqqqqqqqqqqqqqq= " + resTemp.getName());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_3);

        lv = (LinearLayout) findViewById(R.id.cluster_popupLayout);
        animation1 = AnimationUtils.loadAnimation(this,
                R.anim.activity_open);
        animation2 = AnimationUtils.loadAnimation(this,
                R.anim.activity_close);

        //判断是否有网络
        ConnectivityManager cManager = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo nInfo = cManager.getActiveNetworkInfo();
        if(nInfo!=null && nInfo.isConnected()) {
//            Toast.makeText(this, "Network is available", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Network is not available, please connect to network to use map", Toast.LENGTH_LONG).show();
        }

        SupportMapFragment mapFragment = ((SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.clusterMap));
        mapFragment.getMapAsync(this);

        restaurantList = new ArrayList<RestaurantTbl>();
        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor cursor = db.query("RestaurantTbl", null, null, null, null, null, null);


            while (cursor.moveToNext()) {
                String NAME = cursor.getString(1);
                String ADDRESS = cursor.getString(5);
                String POSTAL = cursor.getString(4);
                String PICTURE = cursor.getString(2);
                String TELEPHONE = cursor.getString(3);
                String DESCRIPTION = cursor.getString(6);
                String RESKIND = cursor.getString(7);
                String LATITUDE = cursor.getString(8);
                String LONGITUDE = cursor.getString(9);

                //System.out.println("display class RestaurantTbl:----> " + NAME + ", " + ADDRESS + ", " + POSTAL + ", " + PICTURE + ", " + TELEPHONE + ", " + DESCRIPTION + ", " + RESKIND + ", " + LATITUDE + ", " + LONGITUDE);

                RestaurantTbl restaurant = new RestaurantTbl(NAME, ADDRESS, POSTAL, PICTURE, TELEPHONE, DESCRIPTION, RESKIND, LATITUDE, LONGITUDE);
                restaurantList.add(restaurant);
            }
    }

    @Override
    protected void onStart() {
        //googleApiClient.connect();
        super.onStart();
    }

    @Override
    protected void onStop() {
        //googleApiClient.disconnect();
        super.onStop();
    }


    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onMapLongClick(LatLng latLng) {
        //Clearing all the markers
        mMap.clear();
        //Adding a new marker to the current pressed position
        mMap.addMarker(new MarkerOptions()
                .position(latLng)
                .draggable(true));

        latitude = latLng.latitude;
        longitude = latLng.longitude;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //get current location
        LocationManager service = (LocationManager) getSystemService(LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String provider = service.getBestProvider(criteria, false);
        Location location = service.getLastKnownLocation(provider);
        if (location != null) {
            // Add a marker in Montreal and move the camera
            LatLng latlng = new LatLng(location.getLatitude(), location.getLongitude());
            mMap.addMarker(new MarkerOptions().position(latlng).title("My Position").draggable(true));

            //enable currentLocation of default googleMap
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }



            //addMarkersToMap();
            CameraPosition camPosition = new CameraPosition.Builder().target(latlng).zoom(11).build();
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(camPosition));

        }else{
            LatLng latlngoff = new LatLng(45.4626013, -73.6366949);

            CameraPosition camPosition = new CameraPosition.Builder().target(latlngoff).zoom(11).build();
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(camPosition));
            Toast.makeText(this,"Cannot locate your position to use the navigation, please setup the configuration or network connection"
                    ,Toast.LENGTH_LONG).show();
        }

        mMap.setMyLocationEnabled(true);

        mClusterManager = new ClusterManager<ClusterRestTbl>(this, mMap);
        mClusterManager.setRenderer(new PersonRenderer());
        mMap.setOnCameraChangeListener(mClusterManager);
        mMap.setOnMarkerClickListener(mClusterManager);
        mMap.setOnInfoWindowClickListener(mClusterManager);
        mClusterManager.setOnClusterClickListener(this);
        mClusterManager.setOnClusterInfoWindowClickListener(this);
        mClusterManager.setOnClusterItemClickListener(this);
        mClusterManager.setOnClusterItemInfoWindowClickListener(this);

        readItems();
        mClusterManager.cluster();

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                lv.setVisibility(View.GONE);
                lv.setAnimation(animation2);
            }
        });
    }

	@Override
	public void onMarkerDragStart(Marker marker) {

	}

	@Override
	public void onMarkerDrag(Marker marker) {

	}

	@Override
	public void onMarkerDragEnd(Marker marker) {

	}

    private void readItems()  {

        //for (int i = 0; i < 10; i++) {
        //    double offset = i / 60d;
            for (RestaurantTbl resTemp : restaurantList) {
                String lat = resTemp.getLatitude();
                String lng = resTemp.getLongtitude();
                String name = resTemp.getName();
                String address = resTemp.getAddress();
                String phone = resTemp.getTelephone();
                String des = resTemp.getDescription();
                String photo = resTemp.getImageUrl();

                //MyItem offsetItem = new MyItem(lat, lng);
                ClusterRestTbl clusterRestTbl = new ClusterRestTbl(lat, lng, name, address, phone, des, photo);
                mClusterManager.addItem(clusterRestTbl);
            }
       // }
    }

    /**
     * Draws profile photos inside markers (using IconGenerator).
     * When there are multiple people in the cluster, draw multiple photos (using MultiDrawable).
     */
    private class PersonRenderer extends DefaultClusterRenderer<ClusterRestTbl> {
        //private final IconGenerator mIconGenerator = new IconGenerator(get);
        //private final IconGenerator mClusterIconGenerator = new IconGenerator(getApplicationContext());
        //private final ImageView mImageView;
        //private final ImageView mClusterImageView;
        //private final int mDimension;

        public PersonRenderer() {
            super(getApplicationContext(), mMap, mClusterManager);

            //View multiProfile = getLayoutInflater().inflate(R.layout.multi_profile, null);
            //mClusterIconGenerator.setContentView(multiProfile);
            //mClusterImageView = (ImageView) multiProfile.findViewById(R.id.image);

            //mImageView = new ImageView(getApplicationContext());
            //mDimension = (int) getResources().getDimension(R.dimen.custom_profile_image);
            //mImageView.setLayoutParams(new ViewGroup.LayoutParams(mDimension, mDimension));
            //int padding = (int) getResources().getDimension(R.dimen.custom_profile_padding);
            //mImageView.setPadding(padding, padding, padding, padding);
            //mIconGenerator.setContentView(mImageView);
        }

        @Override
        protected void onBeforeClusterItemRendered(ClusterRestTbl resTbl, MarkerOptions markerOptions) {
            // Draw a single person.
            // Set the info window to show their name.
            //mImageView.setImageResource(person.profilePhoto);
            //Bitmap icon = mIconGenerator.makeIcon();
            markerOptions.title(resTbl.getName());
        }

        @Override
        protected boolean shouldRenderAsCluster(Cluster cluster) {
            // Always render clusters.
            return cluster.getSize() > 1;
        }
    }


    @Override
    public boolean onClusterClick(Cluster<ClusterRestTbl> cluster) {
        // Show a toast with some info when the cluster is clicked.
        //String firstName = String.valueOf(cluster.getItems().iterator().next().getLatitude()) + "," + cluster.getItems().iterator().next().getLongtitude();
        Toast.makeText(this, cluster.getSize() + " restaurants", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public void onClusterInfoWindowClick(Cluster<ClusterRestTbl> cluster) {

    }

    @Override
    public boolean onClusterItemClick(final ClusterRestTbl clusterRestTbl) {
        // Does nothing, but you could go into the user's profile page, for example.
//        Toast.makeText(this, clusterRestTbl.getLatitude()+","+clusterRestTbl.getLongtitude(), Toast.LENGTH_SHORT).show();
        //System.out.println("bbbbbbbbbbbbbbaaaaaaaaaaaaa= " + clusterRestTbl.getName().toString());
        //.实现上拉窗口显示信息

        lv.setVisibility(View.VISIBLE);
        lv.setAnimation(animation1);

        TextView updown_des = (TextView) findViewById(R.id.updown_des);
        TextView updown_address = (TextView) findViewById(R.id.updown_address);
        TextView updown_number = (TextView) findViewById(R.id.updown_number);
        ImageView updown_iv = (ImageView) findViewById(R.id.updown_iv);
        Button updown_bt = (Button) findViewById(R.id.updown_bt);

        updown_des .setText(clusterRestTbl.getDescription());
        updown_address.setText(clusterRestTbl.getAddress());
        updown_number.setText(clusterRestTbl.getTelephone());
        AssetManager assetManager = getApplicationContext().getAssets();
        try {
            InputStream in = assetManager.open("pic/" + clusterRestTbl.getImageUrl());
            Bitmap bmp = BitmapFactory.decodeStream(in);
            updown_iv.setImageBitmap(bmp);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assert updown_bt != null;
        updown_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), clusterRestTbl.getName(), Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent();

                Bundle bundle = new Bundle();
                bundle.putSerializable("resDetail", clusterRestTbl);
                intent2.putExtras(bundle);

                intent2.setClass(TabActivity3.this,BasicMapDemoActivity.class);
                startActivity(intent2);
            }
        });

        /*
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = Message.obtain();
                message.what = 1;
                String ss = clusterRestTbl.toString();
                message.obj = ss;
                System.out.println("aaaaaaaaaaaaa= " + ss);
                handler.sendMessage(message);
            }
        });
        */
        return false;
    }

    @Override
    public void onClusterItemInfoWindowClick(ClusterRestTbl clusterRestTbl) {

    }
    private LatLng position() {
        return new LatLng(random(51.6723432, 51.38494009999999), random(0.148271, -0.3514683));
    }

    private double random(double min, double max) {
        return mRandom.nextDouble() * (max - min) + min;
    }
}
