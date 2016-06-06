package com.foodmap.provider;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.foodmap.foodmap.RestaurantTbl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guoecho on 2016/6/5.
 */
public class SingletonList {


    private volatile static SingletonList oneInstance;

    private Context context;

    public SingletonList(){
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

            RestaurantTbl restaurant = new RestaurantTbl(NAME, ADDRESS, POSTAL, PICTURE, TELEPHONE, DESCRIPTION, RESKIND, LATITUDE,LONGITUDE);
            stList.add(restaurant);
        }
    }

    public static SingletonList getOneInstance(){
        if(oneInstance == null){
            oneInstance = new SingletonList();
        }

        return oneInstance;
    }

}
