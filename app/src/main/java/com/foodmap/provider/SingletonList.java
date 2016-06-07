package com.foodmap.provider;

import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.foodmap.foodmap.RestaurantTbl;

import java.util.ArrayList;
import java.util.List;

public class SingletonList {

    private static SingletonList oneInstance;
    private List<RestaurantTbl> restaurantTblList;

    private SingletonList(){    }

    public static synchronized SingletonList getOneInstance(){
        if(oneInstance == null){
            oneInstance = new SingletonList();
        }
        return oneInstance;
    }

    public List<RestaurantTbl> getRestaurantTblList(Context context) {

        if(restaurantTblList == null) {
            List<RestaurantTbl> stList = new ArrayList<RestaurantTbl>();
            DBHelper dbHelper;
            dbHelper = new DBHelper(context);
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

                RestaurantTbl restaurant = new RestaurantTbl(NAME, ADDRESS, POSTAL, PICTURE, TELEPHONE, DESCRIPTION, RESKIND, LATITUDE, LONGITUDE);
                stList.add(restaurant);
            }

            restaurantTblList = stList;
        }
        return restaurantTblList;
    }

    public List<RestaurantTbl> getRestaurantTblList(String kind){
        List<RestaurantTbl> stList = new ArrayList<RestaurantTbl>();
        for (RestaurantTbl resTemp:restaurantTblList) {
            if(kind.equals(resTemp.getResKind())){
                stList.add(resTemp);
            }
        }
        return stList;
    }

}
