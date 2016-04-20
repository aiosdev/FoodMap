package com.foodmap.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 本地数据库工具类SQLite
 */

public class DBHelper extends SQLiteOpenHelper {
    // 数据库名称常量
    private static final String DATABASE_NAME = "Foodmap.db";
    // 数据库版本常量
    private static final int DATABASE_VERSION = 1;
    // 表名称常量
    public static final String TABLES_TABLE_NAME = "RestaurantTbl";
    //public static final String TABLES_TABLE_NAME2 = "MenuTbl";
    // 构造方法
    public DBHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // 创建时调用,第一个使用数据库时自动建表
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLES_TABLE_NAME + " ("
                + Restaurant._ID + " INTEGER PRIMARY KEY,"
                + Restaurant.NAME + " TEXT,"
                + Restaurant.ADDRESS + " TEXT,"
                + Restaurant.POSTAL + " TEXT,"
                + Restaurant.TELEPHONE + " TEXT,"
                + Restaurant.PICTURE + " TEXT,"
                + Restaurant.DESCRIPTION + " TEXT"
                + ");");

        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ?)"
                , new String[]{"chinese food" , "3398 sherbrook montreal", "H4G 1U3", "123456789", "cn.pnp", "this is a chinese restaurant"});
        System.out.println("create RestaurantTbl sucess !");
        /*
        db.execSQL("CREATE TABLE " + TABLES_TABLE_NAME2 + " ("
                + Menus._ID + " INTEGER PRIMARY KEY,"
                + Menus.TYPE_ID + " INTEGER,"
                + Menus.NAME + " TEXT,"
                + Menus.PRICE + " INTEGER,"
                + Menus.PIC + " TEXT,"
                + Menus.REMARK + " TEXT"
                + ");");

        System.out.println("create MenuTbl sucess !");
        */
    }

    // 版本更新时调用
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS RestaurantTbl");
        //db.execSQL("DROP TABLE IF EXISTS MenuTbl");
        System.out.println("delete tables sucess !");
        onCreate(db);
    }

}
