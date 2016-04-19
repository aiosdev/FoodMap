package com.foodmap.foodmap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import android.widget.Button;

import com.foodmap.provider.Global;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private Button bt1;
    private Global globalInstant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1 = (Button) findViewById(R.id.bt1);
        globalInstant = new Global();

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //bt1.setText(getString(R.string.cn_buttonTest1));

                //获取天气信息xml文件
                InputStream is = getClassLoader().getResourceAsStream("assets/init.xml");//方法1：读取assets文件夹中的xml文件
                //InputStream is = getClassLoader().getResourceAsStream("/app/src/weather.xml");

                //获取xmlpull解析器
                XmlPullParser xp = Xml.newPullParser();

                try {
                    //InputStream is = getClassLoader().getResourceAsStream("weather.xml");
                    //InputStream is = getResources().getAssets().open("weather.xml");//方法2：读取assets文件夹中的xml文件
                    //初始化
                    xp.setInput(is, "utf-8");

                    //获取当前节点的事件类型
                    int type = xp.getEventType();
                    while (type != XmlPullParser.END_DOCUMENT) {
                        switch (type) {
                            case XmlPullParser.START_TAG:
                                //获取当前节点的名字
                                if ("language".equals(xp.getName())) {
                                    globalInstant.setLanguage(xp.nextText());
                                }
                                break;
                            case XmlPullParser.END_TAG:

                                break;

                        }
                        //把指针移动至下一个节点，并返回该节点的事件类型
                        type = xp.next();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if("en".equals(globalInstant.getLanguage())){
                    bt1.setText(getString(R.string.en_buttonTest1));
                }
                if("cn".equals(globalInstant.getLanguage())){
                    bt1.setText(getString(R.string.cn_buttonTest1));
                }
                if("fr".equals(globalInstant.getLanguage())){
                    bt1.setText(getString(R.string.fr_buttonTest1));
                }

            }

        });
    }
}
