package com.foodmap.foodmap;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.foodmap.foodmap.model.ClusterRestTbl;
import com.foodmap.provider.DBHelper;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
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
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TabActivity3 extends FragmentActivity implements
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

    //From -> the first coordinate from where we need to calculate the distance
    private double fromLongitude;
    private double fromLatitude;

    //To -> the second coordinate to where we need to calculate the distance
    private double toLongitude;
    private double toLatitude;

    //Google ApiClient
    private GoogleApiClient googleApiClient;

    private List<RestaurantTbl> restaurantList;

    private ClusterManager<ClusterRestTbl> mClusterManager;
    private Random mRandom = new Random(1984);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_3);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
        SupportMapFragment mapFragment = ((SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map));
        mapFragment.getMapAsync(this);

        //Initializing googleapi client
        // ATTENTION: This "addApi(AppIndex.API)"was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        googleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .addApi(AppIndex.API)
                .build();

        restaurantList = new ArrayList<RestaurantTbl>();
        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor cursor = db.query("RestaurantTbl", null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            String NAME = cursor.getString(1);
            String ADDRESS = cursor.getString(4);
            String POSTAL = cursor.getString(2);
            String PICTURE = cursor.getString(5);
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
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        /*
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, //TODO: choose an action type.
                "Maps Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.foodmap.foodmap/http/host/path")
        );
        AppIndex.AppIndexApi.start(googleApiClient, viewAction);
        */
    }

    @Override
    protected void onStop() {
        //googleApiClient.disconnect();
        super.onStop();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        /*
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, //TODO: choose an action type.
                "Maps Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.foodmap.foodmap/http/host/path")
        );
        AppIndex.AppIndexApi.end(googleApiClient, viewAction);
        */
    }




    //Getting current location
    private void getcurrentLocation() {
        //mMap.clear();

        //Creating a location object
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
        if (location != null) {
            //Getting longitude and latitude
            longitude = location.getLongitude();
            latitude = location.getLatitude();

            //Moving the map to location
            moveMap();
        }
    }

    //Function to move the map
    private void moveMap() {
        //Creating a Latlng Object to store Corrdinates
        LatLng latlng = new LatLng(latitude, longitude);

        //Adding marker to map
        mMap.addMarker(new MarkerOptions()
                .position(latlng) //setting position
                .draggable(true)); //Making the marker draggable
//                .title("Current Location")); //Adding a title

        //Moving the camera
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latlng));

        //Animating the camera
        mMap.animateCamera(CameraUpdateFactory.zoomTo(10));
    }

    public String makeURL(double sourcelat, double sourcelog, double destlat, double destlog) {
        StringBuilder urlString = new StringBuilder();
        urlString.append("https://maps.googleapis.com/maps/api/directions/json");
        urlString.append("?origin="); //from
        urlString.append(Double.toString(sourcelat));
        urlString.append(",");
        urlString.append(Double.toString(sourcelog));
        urlString.append("&destination=");// to
        urlString.append(Double.toString(destlat));
        urlString.append(",");
        urlString.append(Double.toString(destlog));
        urlString.append("&sensor=false&mode=driving&alternatives=true");
        urlString.append("&key=SERVER-KEY");
        return urlString.toString();
    }

    private void getDirection() {
        //Getting the URL
        String url = makeURL(fromLatitude, fromLongitude, toLatitude, toLongitude);

        //Showing a dialog till we get the route
        final ProgressDialog loading = ProgressDialog.show(this, "Getting Route", "Please wait", false, false);

        //Creating a string request
        StringRequest stringRequest = new StringRequest(url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        loading.dismiss();
                        //Calling the method drawPath to draw the path
                        drawPath(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        loading.dismiss();
                    }
                });

        //Adding the request to request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    //The parameter is the server response
    public void drawPath(String result) {
        //Getting both the coordinates
        LatLng from = new LatLng(fromLatitude, fromLongitude);
        LatLng to = new LatLng(toLatitude, toLongitude);

        //Calculating the distance in meters
        Double distance = SphericalUtil.computeDistanceBetween(from, to);

        //Displaying the distance
        Toast.makeText(this, String.valueOf(distance + "Meters"), Toast.LENGTH_SHORT).show();

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
                    .width(20)
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

    //Convert address to lng lat and add markers to map
    public void addMarkersToMap(){
        //mMap.clear();
        restaurantList = new ArrayList<RestaurantTbl>();
        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("RestaurantTbl", null, null, null, null, null, null);


        while (cursor.moveToNext()) {
            String NAME = cursor.getString(1);
            String ADDRESS = cursor.getString(4);
            String POSTAL = cursor.getString(2);
            String PICTURE = cursor.getString(5);
            String TELEPHONE = cursor.getString(3);
            String DESCRIPTION = cursor.getString(6);
            String RESKIND = cursor.getString(7);
            String LATITUDE = cursor.getString(8);
            String LONGITUDE = cursor.getString(9);


            RestaurantTbl restaurant = new RestaurantTbl(NAME, ADDRESS, POSTAL, PICTURE, TELEPHONE, DESCRIPTION, RESKIND, LATITUDE,LONGITUDE);
            restaurantList.add(restaurant);

            System.out.println("数据库已加载");

            //把数据库中坐标取出
            /*
            for(int i = 0; i< restaurantList.size(); i++){
                //createMarker(Double.parseDouble(restaurantList.get(i).getLatitude()), Double.parseDouble(restaurantList.get(i).getLongitude()));
                mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(Double.parseDouble(restaurantList.get(i).getLatitude()),Double.parseDouble(restaurantList.get(i).getLongitude())))
                        .draggable(true).title(restaurantList.get(i).getName()));
                System.out.println("横坐标"+ Double.parseDouble(restaurantList.get(i).getLatitude()));
            }
            */
        }
    }

    //在地图上显示出markers
    private Marker createMarker(Double latitude, Double longitude) {

            return mMap.addMarker(new MarkerOptions()
                   .position(new LatLng(latitude,longitude))
                   .draggable(true));

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onConnected(@Nullable Bundle bundle) {
        getcurrentLocation();
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

        // Add a marker in Montreal and move the camera
        LatLng latlng = new LatLng(location.getLatitude(), location.getLongitude());
        //LatLng latlng = new LatLng(45.4715234, -73.570739);
        mMap.addMarker(new MarkerOptions().position(latlng).draggable(true));

        //addMarkersToMap();

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


        //mMap.moveCamera(CameraUpdateFactory.newLatLng(latlng));
        //mMap.setOnMarkerDragListener(this);
        //mMap.setOnMapLongClickListener(this);

        //enable currentLocation of default googleMap
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
        //Animating the camera
        //mMap.animateCamera(CameraUpdateFactory.zoomTo(15));

        //addMarkersToMap();
        CameraPosition camPosition = new CameraPosition.Builder().target(latlng).zoom(11).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(camPosition));
    }

	@Override
	public void onMarkerDragStart(Marker marker) {

	}

	@Override
	public void onMarkerDrag(Marker marker) {

	}

	@Override
	public void onMarkerDragEnd(Marker marker) {
        //Getting the coordinates
        //latitude = marker.getPosition().latitude;
       // longitude = marker.getPosition().longitude;

        //Moving the map
        //moveMap();

	}

    private void readItems()  {

        //for (int i = 0; i < 10; i++) {
        //    double offset = i / 60d;
            for (RestaurantTbl resTemp : restaurantList) {
                double lat = Double.parseDouble(resTemp.getLatitude());
                double lng = Double.parseDouble(resTemp.getLongitude());
                String name = resTemp.getName();

                //MyItem offsetItem = new MyItem(lat, lng);
                ClusterRestTbl clusterRestTbl = new ClusterRestTbl(lat, lng, name);
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
        String firstName = String.valueOf(cluster.getItems().iterator().next().getLatitude()) + "," + cluster.getItems().iterator().next().getLongtitude();
        Toast.makeText(this, cluster.getSize() + " (including " + firstName + ")", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public void onClusterInfoWindowClick(Cluster<ClusterRestTbl> cluster) {

    }

    @Override
    public boolean onClusterItemClick(ClusterRestTbl clusterRestTbl) {
        // Does nothing, but you could go into the user's profile page, for example.
        Toast.makeText(this, clusterRestTbl.getName(), Toast.LENGTH_SHORT).show();
        //.实现上拉窗口显示信息
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
