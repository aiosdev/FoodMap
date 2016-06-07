package com.foodmap.foodmap.utils;

import android.util.Log;

import com.foodmap.foodmap.model.GDLegs;
import com.foodmap.foodmap.model.GDPath;
import com.foodmap.foodmap.model.GDPoint;
import com.foodmap.foodmap.model.GDRoute;
import com.foodmap.foodmap.model.GDirectionRoutes;
import com.google.android.gms.maps.model.LatLng;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DirectionRoutesJSONParser {
    String tag = "DirectionsRoutesJSONParser";

    public GDirectionRoutes parse(JSONObject jObject) {

        // The current GDirection
        GDirectionRoutes currentGDirection = null;
        //The routes
        List<GDRoute> routes = null;
        //The current route
        GDRoute currentRoute = null;
        // The legs
        List<GDLegs> legs = null;
        // The current leg
        GDLegs currentLeg = null;
        // The paths
        List<GDPath> paths = null;
        // The current path
        GDPath currentPath = null;
        // JSON Array representing Routes
        JSONArray jRoutes = null;
        JSONObject jRoute;
        JSONObject jBound;
        // JSON Array representing Legs
        JSONArray jLegs = null;
        JSONObject jLeg;
        // JSON Array representing Step
        JSONArray jSteps = null;
        JSONObject jStep;
        String polyline = "";
        try {
            jRoutes = jObject.getJSONArray("routes");
            Log.v(tag, "routes found : " + jRoutes.length());
            routes = new ArrayList<GDRoute>();
            /** Traversing all routes */
            for (int i = 0; i < jRoutes.length(); i++) {
                jRoute=(JSONObject) jRoutes.get(i);

                //currentRoute.setSummary(jRoute.getString("summary"));
                jLegs = jRoute.getJSONArray("legs");
                Log.v(tag, "routes[" + i + "]contains jLegs found : " + jLegs.length());
                /** Traversing all legs */
                legs = new ArrayList<GDLegs>();
                for (int j = 0; j < jLegs.length(); j++) {
                    jLeg=(JSONObject) jLegs.get(j);
                    jSteps = jLeg.getJSONArray("steps");
                    Log.v(tag, "routes[" + i + "]:legs[" + j + "] contains jSteps found : " + jSteps.length());
                    /** Traversing all steps */
                    paths = new ArrayList<GDPath>();
                    for (int k = 0; k < jSteps.length(); k++) {
                        jStep = (JSONObject) jSteps.get(k);
                        polyline = (String) ((JSONObject) (jStep).get("polyline")).get("points");
                        // Build the List of GDPoint that define the path
                        List<GDPoint> list = decodePoly(polyline);
                        // Create the GDPath
                        currentPath = new GDPath(list);
                        currentPath.setDistance(((JSONObject)jStep.get("distance")).getString("text"));
                        currentPath.setDuration(((JSONObject)jStep.get("duration")).getString("text"));
                        currentPath.setHtmlText(jStep.getString("html_instructions"));
                        currentPath.setTravelMode(jStep.getString("travel_mode"));
                        Log.v(tag,
                                "routes[" + i + "]:legs[" + j + "]:Step[" + k + "] contains Points found : "
                                        + list.size());
                        // Add it to the list of Path of the Direction
                        paths.add(currentPath);
                    }
                    //
                    currentLeg = new GDLegs(paths);
                    currentLeg.setmDistance(((JSONObject)jLeg.get("distance")).getString("text"));
                    currentLeg.setmDuration(((JSONObject)jLeg.get("duration")).getString("text"));
                    currentLeg.setmEndAddress(jLeg.getString("end_address"));
                    currentLeg.setmStartAddress(jLeg.getString("start_address"));
                    legs.add(currentLeg);

                    Log.v(tag, "Added a new Path and paths size is : " + paths.size());
                }
                // Build the GDirection using the paths found

                currentRoute = new GDRoute(legs);

                currentRoute.setSummary(jRoute.getString("summary"));

                jBound=(JSONObject)jRoute.get("bounds");
                currentRoute.setmNorthEastBound(new LatLng(
                        ((JSONObject)jBound.get("northeast")).getDouble("lat"),
                        ((JSONObject)jBound.get("northeast")).getDouble("lng")));
                currentRoute.setmSouthWestBound(new LatLng(
                        ((JSONObject)jBound.get("southwest")).getDouble("lat"),
                        ((JSONObject)jBound.get("southwest")).getDouble("lng")));
                currentRoute.setCopyrights(jRoute.getString("copyrights"));

                routes.add(currentRoute);

            }
            currentGDirection = new GDirectionRoutes(routes);

        } catch (JSONException e) {
            Log.e(tag, "Parsing JSon from GoogleDirection Api failed, see stack trace below:", e);
        } catch (Exception e) {
            Log.e(tag, "Parsing JSon from GoogleDirection Api failed, see stack trace below:", e);
        }
        return currentGDirection;
    }

    /**
     * Method to decode polyline points
     * Courtesy :
     * http://jeffreysambells.com/2010/05/27/decoding-polylines-from-google-maps-direction
     * -api-with-java
     */
    private List<GDPoint> decodePoly(String encoded) {

        List<GDPoint> poly = new ArrayList<GDPoint>();
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
            poly.add(new GDPoint((double) lat / 1E5, (double) lng / 1E5));
        }

        return poly;
    }
}