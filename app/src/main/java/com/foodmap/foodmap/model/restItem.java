package com.foodmap.foodmap.model;

import com.foodmap.foodmap.RestaurantTbl;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

/**
 * Created by guoecho on 2016/5/20.
 */
public class RestItem implements ClusterItem {
    private final LatLng mPosition;
    public RestaurantTbl restItem;
    public String name = restItem.getName();

    public RestItem(String name, LatLng position){
        this.name = name;
        this.mPosition = position;
    }

    @Override
    public LatLng getPosition() {
        return mPosition;
    }
}