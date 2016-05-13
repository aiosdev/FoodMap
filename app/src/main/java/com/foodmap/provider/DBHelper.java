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
                + Restaurant.DESCRIPTION + " TEXT,"
                + Restaurant.RESKIND + " TEXT"
                + Restaurant.LATITUDE + " DOUBLE"
                + Restaurant.LONGITUDE + " DOUBLE"
                + ");");

        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?)"
                , new String[]{"UCAN有间茶餐厅" , "1832 Saint-Catherine Ouest Montreal,QC", "H3H 1M1", "5143122938", "ucan.jpg", "茶餐厅，粤菜", "1"});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?)"
                , new String[]{"Lina Restaurant（西安名吃）" , "1051 Boul St.-Laurent Montréal, QC", "H2Z 1J6", "5145689599", "lina.jpg", "西安名吃", "2"});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?)"
                , new String[]{"福园祥" , "1618 Lincoln avenue Montreal QC", "H3H 2L8", "514-933-6888", "fuyuanxiang.jpg", "市中心第一家正宗东北美食，川菜", "1"});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?)"
                , new String[]{"川味香" , "2350 rue Guy Montréal, QC", "H3H 2M2", "5149335041", "chuanweixiang.jpg", "水煮鱼,孜然鸡,香辣虾,脆皮牛肉,脆皮茄子", "3"});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?)"
                , new String[]{"高老庄 Mr.Gao Restaurant" , "1550 Maisonneure O, GM001， Montreal QC", "H3G", "514-989-8887", "gao.jpg", "东北菜，川菜", "2"});
       db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?)"
                , new String[]{"大唐火锅" , "2070 de maisonneuve west, montreal, QC", "H3H 1K8", "514-935-977", "datang.jpg", "正宗重庆麻辣火锅，自助任吃。麻辣香锅，重庆小面，精品川菜", "1"});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?)"
                , new String[]{"忘利园烤鸭" , "1620B Av Lincoln ,montreal, QC", "H3H 1G9", "514-447-2165", "wangliyuan.jpg", "烤鸭", "4"});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?)"
                , new String[]{"喜洋洋" , "1448 Rue Saint Mathieu montreal, QC", "H3H 2H9", "514-935-1067", "xiyangyang.jpg", "最早的川菜店", "5"});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?)"
                , new String[]{"天霞韩式自助" , "2065B Bishop, Montreal, QC", "H3G 2E8", "5142882065", "tianxia.jpg", "韩式自助烧烤店", "3"});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?)"
                , new String[]{"富家庄" , "937 Boul. Decarie, St-Laurent, QC", "H4L 3M3", "438-800-0300", "fujiazhuang.jpg", "地道东北美食，正宗大连老菜", "4"});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?)"
                , new String[]{"小伙伴食堂" , "1439 st-Mathieu Montreal,QC", "H3H 2M4", "514-507-6688", "xiaohuoban.jpg", "各类面食", "5"});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?)"
                , new String[]{"小肥羊火锅" , "50 De La Gauchetiere Ouest, Montreal, QC", "H2Z 1C1", "514-393-0888", "xiaofeiyang.jpg", "国内正宗的分店", "3"});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?)"
                , new String[]{"Ichifuku 一福拉面" , "31925 Rue Ste-Catherine O, Montréal, QC", "H3H 1M3", "514-932-7227", "ichifuku.jpg", "从日本空运回来一台专业制面机，摆在店铺显眼的入口位置。顾客可以观赏整个制面过程。", "1"});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?)"
                , new String[]{"红翻天" , "1110 clark Montréal, QC", "H2Z 1K3", "514-871-8778", "hongfantian.jpg", "湘菜-水煮鱼，干锅雪笋 蒙特利尔最正宗的湘菜馆之一", "2"});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?)"
                , new String[]{"梅园" , "1425 Mackay Street montreal", "H3G 2H6", "123456789", "meiyuan.jpg", "蒙特利尔第一家正宗灌汤包", "1"});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?)"
                , new String[]{"Kabocha居酒屋" , "3627 Boul. Saint-Laurent, Montréal, QC", "H2X 2V5", "514-845-0727", "kabocha.jpg", "Kabocha居酒屋的蒙特利尔分店是北美的第一家", "1"});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?)"
                , new String[]{"将太Sushi Crystal" , "4075 Saint Catherine St W Montreal, QC", "H3Z 3J3", "438-383-6839", "jiangtai.jpg", "日式自助", "6"});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?)"
                , new String[]{"KINOYA居酒屋" , "4250 Rue Saint-Denis Montréal, QC", "H2J 2K8", "514-508-5200", "kinoya.jpg", "地道的日本居酒屋，Japanese Pub", "4"});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?)"
                , new String[]{"水天一色" , "998 Boulevard St Laurent 6th Floor Montréal, QC", "H", "514-876-8778", "shuitianyise.jpg", "满市唐人街第一家高级粤菜餐馆!精美点心，鲍参翅肚，生猛海鲜", "1"});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?)"
                , new String[]{"麦香园康大分店" , "1929 Sainte-Catherine Ouest Montréal, QC", "H3H 1M3", "514-931-8880", "maixiangyuan.jpg", "各类饺子:煎饺、水饺、素馅、肉馅", "6"});
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
