package com.foodmap.foodmap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TabActivity1ResDetail extends AppCompatActivity {
    private RestaurantTbl restaurant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_1_res_detail);

        Intent intent = this.getIntent();
        restaurant=(RestaurantTbl)intent.getSerializableExtra("res");

        TextView tv_title = (TextView) findViewById(R.id.detail_title);
        tv_title.setText(restaurant.getName());
    }
}
