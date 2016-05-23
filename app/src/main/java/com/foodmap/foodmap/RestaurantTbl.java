package com.foodmap.foodmap;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

import java.io.Serializable;

/**
 * Created by guoecho on 2016/4/26.
 */
public class RestaurantTbl implements Serializable, ClusterItem {

    private String name;
    private String address;
    private String postal;
    private String telephone;
    private String imageUrl;
    private String description;
    private String resKind;
    private String latitude;
    private String longitude;


    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public String getImageUrl() {

        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {

        this.imageUrl = imageUrl;
    }

    public String getPostal() {

        return postal;
    }

    public void setPostal(String postal) {

        this.postal = postal;
    }

    public String getTelephone() {

        return telephone;
    }

    public void setTelephone(String telephone) {

        this.telephone = telephone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResKind() {
        return resKind;
    }

    public void setResKind(String resKind) {
        this.resKind = resKind;
    }

    @Override
    public String toString() {
        return "RestaurantTbl{}";
    }

    public RestaurantTbl(String NAME, String telephone, String address, String imageUrl, String postal, String description, String resKind, String latitude, String longitude) {
        this.name = NAME;
        this.telephone = telephone;
        this.address = address;
        this.imageUrl = imageUrl;
        this.postal = postal;
        this.description = description;
        this.resKind = resKind;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public LatLng getPosition() {
        return null;
    }
}
