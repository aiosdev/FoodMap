package com.foodmap.foodmap.model;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

/**
 * Created by Administrator on 2016/6/2 0002.
 */
public class GDRoute {

    String summary;

    /**
     * A GDirection is a list of GDLegs
     */
    List<GDLegs> mLegsList;
    /**
     * The North East corner of the square enclosing the road
     */
    LatLng mNorthEastBound;
    /**
     * The South West corner of the square enclosing the road
     */
    LatLng mSouthWestBound;
    /**
     * Copyrights
     */
    String copyrights;

    public GDRoute(List<GDLegs> legsList) {
        super();
        this.mLegsList = legsList;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public final List<GDLegs> getLegsList() {
        return mLegsList;
    }

    public final void setPathsList(List<GDLegs> mLegsList) {
        this.mLegsList = mLegsList;
    }

    public final LatLng getmNorthEastBound() {
        return mNorthEastBound;
    }

    public final void setmNorthEastBound(LatLng mNorthEastBound) {
        this.mNorthEastBound = mNorthEastBound;
    }

    public final LatLng getmSouthWestBound() {
        return mSouthWestBound;
    }

    public final void setmSouthWestBound(LatLng mSouthWestBound) {
        this.mSouthWestBound = mSouthWestBound;
    }

    public final String getCopyrights() {
        return copyrights;
    }

    public final void setCopyrights(String copyrights) {
        this.copyrights = copyrights;
    }

    @Override
    public String toString() {
        StringBuilder strB = new StringBuilder("GDRoutes\r\n");
        for (GDLegs path : mLegsList) {
            strB.append(path.toString());
            strB.append("\r\n");
        }
        return strB.toString();
    }

}
