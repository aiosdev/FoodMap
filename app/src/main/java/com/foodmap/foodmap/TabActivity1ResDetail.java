package com.foodmap.foodmap;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;

public class TabActivity1ResDetail extends AppCompatActivity {
    private RestaurantTbl restaurant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_1_res_detail);

        Intent intent = this.getIntent();
        restaurant=(RestaurantTbl)intent.getSerializableExtra("res");

        ImageView detail_pic = (ImageView) findViewById(R.id.detail_pic);
        TextView detail_title = (TextView) findViewById(R.id.detail_title);
        TextView detail_address = (TextView) findViewById(R.id.detail_address);
        TextView detail_number = (TextView) findViewById(R.id.detail_number);
        TextView detail_postal = (TextView) findViewById(R.id.detail_postal);
        TextView detail_desc = (TextView) findViewById(R.id.detail_desc);

        AssetManager assetManager = this.getAssets();
        try {
            InputStream in = assetManager.open("pic/" + restaurant.getImageUrl().toString());
            Bitmap bmp = BitmapFactory.decodeStream(in);
            detail_pic.setImageBitmap(bmp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        detail_title.setText(restaurant.getName());
        detail_address.setText(restaurant.getAddress());
        detail_number.setText(restaurant.getTelephone());
        detail_postal.setText(restaurant.getPostal());
        detail_desc.setText(restaurant.getDescription());
    }
}
