package com.foodmap.foodmap.model;

import java.util.List;

public class GDirectionRoutes {
    /**
     * A GDirection is a list of GDRoutes
     */
    List<GDRoute> mRoutesList;

    public GDirectionRoutes(List<GDRoute> routesList) {
        super();
        this.mRoutesList = routesList;
    }

    public final List<GDRoute> getRoutesList() {
        return mRoutesList;
    }

    public final void setRoutesList(List<GDRoute> mRoutesList) {
        this.mRoutesList = mRoutesList;
    }

    @Override
    public String toString() {
        return "GDirectionRoutes{" +
                "mRoutesList=" + mRoutesList +
                '}';
    }
}
