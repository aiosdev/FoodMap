package com.foodmap.provider;

import android.net.Uri;
import android.provider.BaseColumns;

public class Restaurant implements BaseColumns {
    // 授权常量
    public static final String AUTHORITY = "com.foodmap.provider.Restaurant";
    // 访问Uri
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/restaurant");
    // 默认排序常量
    public static final String DEFAULT_SORT_ORDER = "name DESC";// 按餐馆名称排序
    // 表字段常量
    public static final String NAME = "name";					//餐馆名称
    public static final String ADDRESS = "addr";				//地址
    public static final String POSTAL = "postal";				//邮编
    public static final String TELEPHONE = "tel";				//电话
    public static final String PICTURE = "pic";					//门脸图片
    public static final String DESCRIPTION= "desc";	        // 描述

    public static String getNAME() {
        return NAME;
    }

    public static String getADDRESS() {
        return ADDRESS;
    }

    public static String getPOSTAL() {
        return POSTAL;
    }

    public static String getTELEPHONE() {
        return TELEPHONE;
    }

    public static String getPICTURE() {
        return PICTURE;
    }

    public static String getDESCRIPTION() {
        return DESCRIPTION;
    }

    @Override
    public String toString() {
        return "Restaurant{}";
    }

    public Restaurant(String NAME, String ADDRESS, String POSTAL, String PICTURE, String TELEPHONE) {


    }
}
