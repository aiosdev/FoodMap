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
                + Restaurant.RESKIND + " TEXT,"
                + Restaurant.LATITUDE + " REAL,"
                + Restaurant.LONGITUDE + "REAL"
                + ");");


        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"UCAN有间茶餐厅" , "1832 Saint-Catherine Ouest Montreal,QC", "H3H 1M1", "514-312-2938", "ucan.jpg", "茶餐厅，粤菜", "1", String.valueOf(45.49325511), String.valueOf(-73.581891)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"Lina Restaurant（西安名吃）" , "1051 Boul St.-Laurent Montréal, QC", "H2Z 1J6", "514-568-9599", "lina.jpg", "西安名吃", "2", String.valueOf(45.5082523), String.valueOf(-73.5621319)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"福园祥" , "1618 Lincoln avenue Montreal QC", "H3H 2L8", "514-933-6888", "fuyuanxiang.jpg", "市中心第一家正宗东北美食，川菜", "1", String.valueOf(45.4958735), String.valueOf(-73.5826002)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"川味香" , "2350 rue Guy Montréal, QC", "H3H 2M2", "514-933-5041", "chuanweixiang.jpg", "水煮鱼,孜然鸡,香辣虾,脆皮牛肉,脆皮茄子", "3", String.valueOf(45.4963595), String.valueOf(-73.5836337)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"高老庄 Mr.Gao Restaurant" , "1550 Maisonneure O, GM001， Montreal QC", "H3G", "514-989-8887", "gao.jpg", "东北菜，川菜", "2", String.valueOf(45.495887), String.valueOf(-73.5814591)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"大唐火锅" , "2070 de maisonneuve west, montreal, QC", "H3H 1K8", "514-935-977", "datang.jpg", "正宗重庆麻辣火锅，自助任吃。麻辣香锅，重庆小面，精品川菜", "1", String.valueOf(45.4924084), String.valueOf(-73.5853052)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"忘利园烤鸭" , "1620B Av Lincoln ,montreal, QC", "H3H 1G9", "514-447-2165", "wangliyuan.jpg", "烤鸭", "4", String.valueOf(45.4957443), String.valueOf(-73.5826604)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"喜洋洋" , "1448 Rue Saint Mathieu montreal, QC", "H3H 2H9", "514-935-1067", "xiyangyang.jpg", "最早的川菜店", "5", String.valueOf(45.4943527), String.valueOf(-73.5825463)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"天霞韩式自助" , "2065B Bishop, Montreal, QC", "H3G 2E8", "514-288-2065", "tianxia.jpg", "韩式自助烧烤店", "3", String.valueOf(45.4977751), String.valueOf(-73.5806776)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"富家庄" , "937 Boul. Decarie, St-Laurent, QC", "H4L 3M3", "438-800-0300", "fujiazhuang.jpg", "地道东北美食，正宗大连老菜", "4", String.valueOf(45.5135001), String.valueOf(-73.6834082)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"小伙伴食堂" , "1439 st-Mathieu Montreal,QC", "H3H 2M4", "514-507-6688", "xiaohuoban.jpg", "各类面食", "5", String.valueOf(45.4945175), String.valueOf(-73.5820716)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"小肥羊火锅" , "50 De La Gauchetiere Ouest, Montreal, QC", "H2Z 1C1", "514-393-0888", "xiaofeiyang.jpg", "国内正宗的分店", "3", String.valueOf(45.5076576), String.valueOf(-73.5624593)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"Ichifuku 一福拉面" , "1925 Rue Ste-Catherine Ouest, Montréal, QC", "H3H 1M3", "514-932-7227", "ichifuku.jpg", "从日本空运回来一台专业制面机，摆在店铺显眼的入口位置。顾客可以观赏整个制面过程。", "1", String.valueOf(45.4926135), String.valueOf(-73.5831424)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"红翻天" , "1110 clark Montréal, QC", "H2Z 1K3", "514-871-8778", "hongfantian.jpg", "湘菜-水煮鱼，干锅雪笋 蒙特利尔最正宗的湘菜馆之一", "2", String.valueOf(45.5080677), String.valueOf(-73.5637187)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"梅园" , "1425 Mackay Street montreal", "H3G 2H6", "514-288-1314", "meiyuan.jpg", "蒙特利尔第一家正宗灌汤包", "1", String.valueOf(45.4962569), String.valueOf(-73.5796494)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"Kabocha居酒屋" , "3627 Boul. Saint-Laurent, Montréal, QC", "H2X 2V5", "514-845-0727", "kabocha.jpg", "Kabocha居酒屋的蒙特利尔分店是北美的第一家", "1", String.valueOf(45.5142839), String.valueOf(-73.5752954)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"将太Sushi Crystal" , "4075 Saint Catherine St W Montreal, QC", "H3Z 3J3", "438-383-6839", "jiangtai.jpg", "日式自助", "6", String.valueOf(45.4877843), String.valueOf(-73.588857)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"KINOYA居酒屋" , "4250 Rue Saint-Denis Montréal, QC", "H2J 2K8", "514-508-5200", "kinoya.jpg", "地道的日本居酒屋，Japanese Pub", "4", String.valueOf(45.522037), String.valueOf(-73.5813013)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"水天一色" , "998 Boulevard St Laurent 6th Floor Montréal, QC", "H2Z 9Y9", "514-876-8778", "shuitianyise.jpg", "满市唐人街第一家高级粤菜餐馆!精美点心，鲍参翅肚，生猛海鲜", "1", String.valueOf(45.5077188), String.valueOf(-73.5615678)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"麦香园康大分店" , "1929 Rue Ste-Catherine Ouest Montréal, QC", "H3H 1M3", "514-931-8880", "maixiangyuan.jpg", "各类饺子:煎饺、水饺、素馅、肉馅", "6", String.valueOf(45.4925231), String.valueOf(-73.5831124)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"Chatime 日出茶太(唐人街店）" , "52-C De La Gauchetiere Ouest Montréal, QC", "H2Z 1C1", "514-431-8388", "chatime.jpg", "日出茶太在全球享有知名度最高的珍珠奶茶店，我们从台湾出发，遍布全球世界各地，日出茶太是从2004年开始成立，到现在已经有10周年", "6", String.valueOf(45.507613), String.valueOf(-73.562488)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"黄鹤楼" , "1858 St.Catherine West, Montréal, QC", "H3H 1M1", "514-564-8999", "huanghelou.jpg", "川菜湘菜-铁板羊肉，香辣鸡丁，玉子豆腐 位于市中心的一家川菜馆，味道正宗，环境干净，价钱也不贵", "6", String.valueOf(45.492959), String.valueOf(-73.5823071)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"天津包子铺" , "30 de Gauchetiere Ouest 2nd Floor Montréal, QC", "H2Z 1B9", "514-868-0657", "tianjinbaozipu.jpg", "开在蒙特利尔唐人街的一家以北方包子为主打的餐馆", "6", String.valueOf(45.5077196), String.valueOf(-73.5624155)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"天后烘焙" , "12210 Laurentien Blvd. Montréal, QC", "H4K 1M9", "514-745-6888", "tianhouhongpei.jpg", "各式面包，各式（卡通）生日蛋糕，蛋糕卷，酥饼，各式珍珠奶茶等", "6", String.valueOf(45.5277456), String.valueOf(-73.7220062)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"水天一色烧腊餐厅" , "12230 Boul Laurentien, St Laurent, QC", "H4K 1M9", "514-332-3888", "shuitianyiseshaola.jpg", "水天一色烧腊餐厅", "6", String.valueOf(45.5280479), String.valueOf(-73.7227078)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"kosa蒙城首家韩式居酒屋" , "6710 rue saint Jacques Montréal, QC", "H4B, 1V8", "514-508-5672", "kosa.jpg", "特色的铁板烧和各式的烧烤、韩式特色小吃", "6", String.valueOf(45.4585087), String.valueOf(-73.6283017)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"满堂红（川湘菜）" , "8200 TASHEREAU #1270, BROSSARD, QC", "J4X 2S6", " 450-904-0660", "mantanghong.jpg", "毛式红烧肉、水煮肉片、干锅茶树菇等等川湘菜都是他家的拿手好菜", "6", String.valueOf(45.4490796), String.valueOf(-73.4726958)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"香妈妈 （东北菜）" , "3795 Rue Welington Montréal, QC", "H4G 1V1", "514-508-6418", "xiangmama.jpg", "味道非常正宗的东北菜，孜然牛肉，尖椒肥肠，地三鲜，酸菜白肉，黑白菜", "6", String.valueOf(45.46591), String.valueOf(-73.5690354)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"美食坊（外卖）" , "1809 Rue Ste-Catherine Ouest Montréal, QC", "H3H 1M2", "514-931-8889", "meishifang.jpg", "是一家传统的中式炒菜馆", "6", String.valueOf(45.4937474), String.valueOf(-73.5818186)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"Sumi Dojo居酒屋" , "3479 Boul. St-Laurent Montréal, QC", "H2X 2T6", "514-507-7864", "sumidojo.jpg", "蒙城市中心的日式居酒屋", "6", String.valueOf(45.5131766), String.valueOf(-73.572828)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"福香缘（Downtown）" , "1629 Rue Ste-Catherine Ouest Montréal, QC", "H3H 1L8", "514-815-8998", "fuxiangyuan.jpg", "各式饺子， 煎饼果子，炸酱面，海鲜打卤面，各式小凉菜等，珍珠奶茶", "6", String.valueOf(45.494762), String.valueOf(-73.5807412)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"嘉乐轩" , "1240 rue Stanley Montréal, QC", "H3B 2S7", "514-871-8099", "jialexuan.jpg", "中式自助 在西人中比较出名，川菜,泰国,加拿大菜", "6", String.valueOf(45.4988107), String.valueOf(-73.574846)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"Tokyo东京将太寿司" , "1805 Rue Sainte-Catherine Ouest Montréal, QC", "H3H 2H9", "514-670-0068", "tokyodongjingjiangtaishousi.jpg", "Tokyo Sushi 东京将太寿司是蒙特利尔寿司店的后起之秀", "6", String.valueOf(45.4938241), String.valueOf(-73.5818324)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"神户寿司(Place Longueuil店)" , "825 rue St-Laurent Ouest Longueuil, QC", "J4K 2V1", "450-646-1188", "shenhushousi.jpg", "中餐+泰餐+日餐的综合类餐馆", "6", String.valueOf(45.5288018), String.valueOf(-73.5176516)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"鹏牛肉粉(Chinatown)(外卖)" , "1001 Boulevard Saint-Laurent Montréal, QC", "H2Z 1J4", "514-954-2032", "pengniuroufen.jpg", "越南河粉 蒙城比较受好评的几家越南河粉店之一，分量超大，价格便宜", "6", String.valueOf(45.5080241), String.valueOf(-73.5614169)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"强记菜馆" , "70 Rue De La Gauchetiere O Montréal, QC", "H2Z 1C1", "514-396-4643", "qiangjicaiguan.jpg", "蒙特利尔的老牌粤菜馆，是金牌之一。里面诸如金菇虎皮卷 ，各式煲，姜葱牛肉，清蒸鱼等都是招牌菜", "6", String.valueOf(45.5072427), String.valueOf(-73.5625407)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"Chez Mein 炒面" , "3754 Boul Saint-Laurent Montréal, QC", "H2W 1X6", "514-842-8880", "chezmien.jpg", "曾连续4次进入蒙特利尔5佳饭店。此店的特色是各类炒面，尤其2刀一碗的麻酱面，分量很足", "6", String.valueOf(45.5151246), String.valueOf(-73.5774534)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"喜胜人家（道口烧鸡）" , "4847 rue de Verdun Montréal, QC", "H4G 1N2", "514-691-3519", "xishengrenjia.jpg", "蒙特利尔比较少见的河南风味的餐馆", "6", String.valueOf(45.4570183), String.valueOf(-73.5742982)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"GIA BA RESTAURANT麻辣小龙虾" , "5766 MONKLAND AVENUE Montréal, QC", "H4A 1E9", "514-564-7698", "GIA.jpg", "麻辣小龙小是从温哥华渔场空运来的 鲜活干净 蒙城独一份", "6", String.valueOf(45.4736882), String.valueOf(-73.626739)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"福满楼(Monk) (外卖)" , "16222 Boul. Monk Montréal, QC", "H4E 3H7", "514-954-2032", "fumanlou.jpg", "虾迎面，虾饺，烤乳猪，黏米都受到网友很高评价。尤其是猪肉，香肠，虾皮等做成的黏米饭，非常受欢", "6", String.valueOf(45.4565415), String.valueOf(-73.5972931)});


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
