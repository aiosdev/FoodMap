package com.foodmap.foodmap;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        final TextView detail_number = (TextView) findViewById(R.id.detail_number);
        TextView detail_postal = (TextView) findViewById(R.id.detail_postal);
        TextView detail_desc = (TextView) findViewById(R.id.detail_desc);

        Button bt_map = (Button) findViewById(R.id.bt_map);
        bt_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent();

                Bundle bundle = new Bundle();
                bundle.putSerializable("resDetail", restaurant);
                intent2.putExtras(bundle);

                intent2.setClass(TabActivity1ResDetail.this,BasicMapDemoActivity.class);
                startActivity(intent2);
            }
        });

        //点击按钮直接拨号
        final Button bt_call = (Button) findViewById(R.id.bt_call);
        assert bt_call != null;
        bt_call.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String number = (detail_number).getText().toString();
                Intent intent3 = new Intent();
                intent3.setAction(Intent.ACTION_CALL);
                intent3.setData(Uri.parse("tel:" + number));
                System.out.println("电话号码提取"+number);
                startActivity(intent3);
            }
        });

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
