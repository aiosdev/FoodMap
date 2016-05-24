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
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"Kazu（日本居酒屋）" , "1862 rue Sainte-Catherine O Montréal, QC", "H3H 1M1", "514-937-2333", "kazu.jpg", "日式料理", "6", String.valueOf(45.4928147), String.valueOf(-73.5821504)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"西关名食（外卖）" , "14 La Gauchetiere East Montréal, QC", "H2X 1P3", "514-227-2868", "xiguanmingshi.jpg", "鸡蛋面+各式调和", "6", String.valueOf(45.5084653), String.valueOf(-73.5620247)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"青花苑（Downtown）" , "1676 Ave Lincoln Montréal, QC", "H3H 2T5", "438-288-5366", "qinghuayuanDT.jpg", "各种蒸煎饺子-（必点）牛肉香菜，咖喱鸡肉，鸡肉香菇", "6", String.valueOf(45.4953868), String.valueOf(-73.5832928)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"富临自助美食Laval店" , "1600 Boulevard le Corbusier, Laval, QC", "H7S 1Z2", "450-682-6668", "fulinzizhulaval.jpg", "各式自助海鲜,螃蟹,寿司,生鱼片,左公鸡陈皮牛,烧卖虾饺,生菜沙拉土豆沙拉,冰淇淋,各式炸鸡薯条洋葱圈", "6", String.valueOf(45.5603748), String.valueOf(-73.7321843)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"Mr.Thai 蒙村新盒饭" , "1618 Lincoln AV Montréal, QC", "H3H 1G9", "514-553-0899", "mrthai.jpg", "盒饭快餐", "6", String.valueOf(45.4958735), String.valueOf(-73.5826002)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"相扑手拉面屋" , "1007, Boul.Saint-Laurent Montréal, QC", "H2Z 1J4", "514-940-3668", "xiangpushoulamianwu.jpg", "日式拉面馆，相扑手提供样式繁多的各类拉面，而且可以任由顾客自选topping", "6", String.valueOf(45.5080057), String.valueOf(-73.5615517)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"Seoul Chako B.B.Q.(自助韩式烧烤）" , "1824, rue Ste-Catherine O Montréal, QC", "H3H 1M1", "514-989-8886", "seoulchakobbq.jpg", "自助式韩国烧烤店，店面宽敞，烧烤肉类品种也很丰富，还提供寿司卷物等日式美食", "6", String.valueOf(45.4933707), String.valueOf(-73.5818257)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"金凤凰 PHENIX D'OR" , "942 boul decarie Montréal, QC", "H4L 3M4", "514-439 4388", "jinfenghuang.jpg", "以海鲜 烧腊 粤菜为主的香港名厨主理的好饭店 可自带红酒 啤酒", "6", String.valueOf(45.5130747), String.valueOf(-73.6833989)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"一品湘（川湘情酒家）" , "1050 Rue Clark Montréal, QC", "H2Z 1K3", "514-9041767", "yipinxiang.jpg", "正宗的川菜馆,坐落于蒙特利尔唐人街上", "6", String.valueOf(45.5077427), String.valueOf(-73.5626812)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"面包蜜语" , "85 La Gauchetiere Ouest Montréal, QC", "H2Z 1C2", "514-875-1328", "mianbaomiyu.jpg", "各种面包,蛋挞,珍珠奶茶,定制生日蛋糕等 ", "6", String.valueOf(45.5071137), String.valueOf(-73.5630926)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"老友记168（潮州菜）" , "1027 Boul St Laurent Montréal, QC", "H2Z 1J4", "514-393-8998", "laoyouji168.jpg", "适合聚餐的餐厅,主要是以潮州菜为主,价格偏低,海鲜杂烩,鱿鱼豆腐,粟米羹都不错", "6", String.valueOf(45.508153), String.valueOf(-73.5619642)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"为食坊" , "72 Rue de la Gauchetière Ouest, Montréal, QC", "H2Z 1C1", "514-861-0815", "weishifang.jpg", "广东小炒-小笼包，炒面，肠粉。 为食坊也是典型的广东小炒饭店", "6", String.valueOf(45.5072427), String.valueOf(-73.5625407)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"丽晶饼屋" , "68 La Gauchetiere West, Montréal, QC", "H2Z 1C2", "514-866-1628", "lijingbingwu.jpg", "除了卖面包之外还可以点菜的", "6", String.valueOf(45.5073517), String.valueOf(-73.5624527)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"欣楼" , "2230 Blvd. Lapiniere #110, Brossard, QC", "J4W 1M3", "4509268338", "xinlou.jpg", "蒙特利尔少有的正宗中餐馆之一，精美的虾肉馄饨，福建豆腐，蒸班头腩，煲仔饭，北京片皮烤鸭等等 都是大受欢迎的热门", "6", String.valueOf(45.4733557), String.valueOf(-73.4713647)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"Nos Thés Cafés(特色台湾奶茶）" , "2160 Saint-Mathieu,Montréal, QC", "H3H 2J4", "514-931-4074", "nosthescafes.jpg", "非常有特点的台湾奶茶店 很受喜欢 店里的气氛和装饰都比较不错 店里还提供各种小吃和甜品 被很多人认为是mtl最棒的奶茶店", "6", String.valueOf(45.494832), String.valueOf(-73.5835889)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"友好韩式美食" , "2077 University, Montréal, QC", "H3A 2L1", "514-842-8282", "youhaohanshimeishi.jpg", "近Mcgill的韩式料理店，受到网友如潮好评，尤其是各式泡菜和烤肉", "6", String.valueOf(45.5047565), String.valueOf(-73.5747753)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"南苑港式美食" , "8080 Boulevard Taschereau, Brossard, QC", "J4X 1C2", "450-923-9233", "nanyuangangshimeishi.jpg", "Chinese yellow curry, beef curry, chicken curry, and seafood curry", "6", String.valueOf(45.4508285), String.valueOf(-73.4715133)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"神田寿司（Bishop）" , "2045 Bishop, Montréal, QC", "H3G 2E8", "514-845-8868", "shentianbishop.jpg", "日本料理，神田在蒙城比较出名，有很多家分店", "6", String.valueOf(45.4976821), String.valueOf(-73.5805946)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"可爱家餐馆" , "1440 RUE DE I'EGLISE, Montréal, QC", "H4L 2H3", "514-875-1328", "keaijia.jpg", "日式姜烧猪肉 日式鱼排饭 台式炸鸡腿饭 凤梨酥 车轮饼 台湾卤肉饭 咸酥鸡饭 还有12生肖鸡蛋糕，车轮饼（红豆，香芋和奶油3种馅）等特色小吃 ", "6", String.valueOf(45.5121474), String.valueOf(-73.6795692)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"小Q粽子" , "1408 rue St-Louis, Montréal, QC", "H4L 2P3", "514-755-1024", "xiaoqzongzi.jpg", "今年小Q继续为大家提供美味的传统点心，物美价廉，好吃依旧~品种多多，欢迎选购！", "6", String.valueOf(45.5090903), String.valueOf(-73.6734184)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"红宝石酒楼" , "1008 Rue Clark, Montréal, QC", "H2Z 1J9", "514-3908828", "hongbaoshi.jpg", "广式炒菜,老字号 — 皮蛋瘦肉粥,牛肉肠粉,鱼翅饺,豉汁蒸排骨,炸明虾饺,奶黄包 蒙城著名的老牌茶餐厅。供应早茶以及午餐。人均消费相当低并且食物味", "6", String.valueOf(45.5075837), String.valueOf(-73.5622857)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"青花苑（Chinatown）" , "1019 St Laurent Boulevard Montréal, QC", "H2Z 1J4", "514-903-9887", "qinghuayuanchinatown.jpg", "各种馅料的蒸煎饺子，其中牛肉香菜，咖喱鸡肉以及鸡肉香菇可以说是招牌菜，还有一些小吃，味道相当地", "6", String.valueOf(45.5081467), String.valueOf(-73.5617617)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"嘉莉面包西饼茶餐厅" , "Montréal, QC", "H2Z 1C1", "514-875-1328", "jialimianbaoxibingchacanting.jpg", "日本草莓芝士蛋糕,芒果冰沙,榴蓮冰沙,定制生日蛋糕等", "6", String.valueOf(45.5071397), String.valueOf(-73.5627687)});
db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"Maiko Sushi(纯正日式)" , "387 Bernard Street West, Montréal, QC", "H2V 1T6", "514-490-1225", "maikosushi.jpg", "一家正宗的日本寿司餐厅 真的是日本人开的哟 定价较高 但充满艺术气息的搭配方式绝对可以让你体验与众不同的日本料理", "6", String.valueOf(45.5232389), String.valueOf(-73.6083345)});


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
