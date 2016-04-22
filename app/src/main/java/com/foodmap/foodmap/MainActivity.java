package com.foodmap.foodmap;

import android.app.TabActivity;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import android.widget.Button;

import com.foodmap.provider.DBHelper;
import com.foodmap.provider.Global;

import android.widget.RadioButton;
import android.widget.TabHost;
import android.content.Intent;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;

public class MainActivity extends TabActivity {
    private Button bt1;
    private Global globalInstant;
    DBHelper dbHelper;

    public final static String TAB_TAG_HOME = "tab_1";
    public final static String TAB_TAG_LIVE = "tab_2";
    public final static String TAB_TAG_FORUM = "tab_3";
    public final static String TAB_TAG_INFO = "tab_4";
    public final static String TAB_TAG_MORE = "tab_5";

    private TabHost tabHost;

    /**
     * 启动每个操作项的Intent
     */
    private Intent tabIntent_1;
    private Intent tabIntent_2;
    private Intent tabIntent_3;
    private Intent tabIntent_4;
    private Intent tabIntent_5;

    /**
     * 界面上的各个单选按钮
     */
    private RadioButton btn_1;
    private RadioButton btn_2;
    private RadioButton btn_3;
    private RadioButton btn_4;
    private RadioButton btn_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_main);
        // bt1 = (Button) findViewById(R.id.bt1);
        globalInstant = new Global();

        // 创建DBHelper对象，指定数据库版本为1，此处使用相对路径即可，
        // 数据库文件自动会保存在程序的数据文件夹的databases目录下。
        dbHelper = new DBHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // //////////////////init ///////////////////////////

        tabIntent_1 = new Intent(this, TabActivity1.class);
        tabIntent_2 = new Intent(this, TabActivity2.class);
        tabIntent_3 = new Intent(this, TabActivity3.class);
        tabIntent_4 = new Intent(this, TabActivity4.class);
        tabIntent_5 = new Intent(this, TabActivity5.class);

        tabHost = this.getTabHost();
        tabHost.addTab(tabHost.newTabSpec(TAB_TAG_HOME)
                .setIndicator(TAB_TAG_HOME).setContent(tabIntent_1));
        tabHost.addTab(tabHost.newTabSpec(TAB_TAG_LIVE)
                .setIndicator(TAB_TAG_LIVE).setContent(tabIntent_2));
        tabHost.addTab(tabHost.newTabSpec(TAB_TAG_FORUM)
                .setIndicator(TAB_TAG_FORUM).setContent(tabIntent_3));
        tabHost.addTab(tabHost.newTabSpec(TAB_TAG_INFO)
                .setIndicator(TAB_TAG_INFO).setContent(tabIntent_4));
        tabHost.addTab(tabHost.newTabSpec(TAB_TAG_MORE)
                .setIndicator(TAB_TAG_MORE).setContent(tabIntent_5));

        // //////////////////// find View ////////////////////////////
        btn_1 = (RadioButton) this.findViewById(R.id.main_tab_1);
        btn_2 = (RadioButton) this.findViewById(R.id.main_tab_2);
        btn_3 = (RadioButton) this.findViewById(R.id.main_tab_3);
        btn_4 = (RadioButton) this.findViewById(R.id.main_tab_4);
        btn_5 = (RadioButton) this.findViewById(R.id.main_tab_5);

        MyRadioButtonClickListener listener = new MyRadioButtonClickListener();
        btn_1.setOnClickListener(listener);
        btn_2.setOnClickListener(listener);
        btn_3.setOnClickListener(listener);
        btn_4.setOnClickListener(listener);
        btn_5.setOnClickListener(listener);



 /*
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


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


                //bt1.setText(getString(R.string.en_buttonTest1));
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
        */
    }

    class MyRadioButtonClickListener implements View.OnClickListener {
        public void onClick(View v) {
            RadioButton btn = (RadioButton) v;
            switch (btn.getId()) {
                case R.id.main_tab_1:
                    tabHost.setCurrentTabByTag(TAB_TAG_HOME);
                    break;
                case R.id.main_tab_2:
                    tabHost.setCurrentTabByTag(TAB_TAG_LIVE);
                    break;
                case R.id.main_tab_3:
                    tabHost.setCurrentTabByTag(TAB_TAG_FORUM);
                    break;
                case R.id.main_tab_4:
                    tabHost.setCurrentTabByTag(TAB_TAG_INFO);
                    break;
                case R.id.main_tab_5:
                    tabHost.setCurrentTabByTag(TAB_TAG_MORE);
                    break;
            }
        }
    }
}
