package com.foodmap.foodmap.model;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

/**
 * Created by Administrator on 2016/5/21 0021.
 */
public class ClusterRestTbl implements ClusterItem {
    private double latitude;
    private double longtitude;
    private String name;

    public ClusterRestTbl(double latitude, double longtitude, String name) {
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.name = name;
    }

    @Override
    public LatLng getPosition() {
        LatLng latlng = new LatLng(this.latitude,this.longtitude);
        return latlng;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
