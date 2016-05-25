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
    private String telephone;
    private String imageUrl;
    private String description;
    private String address;

    public ClusterRestTbl(double latitude, double longtitude, String name, String telephone, String imageUrl, String description, String address) {
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.name = name;
        this.telephone = telephone;
        this.imageUrl = imageUrl;
        this.description = description;
        this.address = address;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
