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
                , new String[]{"UCAN(有间茶餐厅)" , "1832 Saint-Catherine Ouest Montreal,QC", "H3H 1M1", "514-312-2938", "ucan1.jpg", "茶餐厅，粤菜", "1", String.valueOf(45.49325511), String.valueOf(-73.581891)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"Lina Restaurant（西安名吃）" , "1051 Boul St.-Laurent Montréal, QC", "H2Z 1J6", "514-568-9599", "lina.jpg", "西安名吃", "2", String.valueOf(45.5082523), String.valueOf(-73.5621319)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"Chez Chen(福园祥)" , "1618 Lincoln avenue Montreal QC", "H3H 2L8", "514-933-6888", "fuyuanxiang.jpg", "市中心第一家正宗东北美食，川菜", "1", String.valueOf(45.4958735), String.valueOf(-73.5826002)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"Cuisine Szechuan(川味香)" , "2350 rue Guy Montréal, QC", "H3H 2M2", "514-933-5041", "chuanweixiang.jpg", "水煮鱼,孜然鸡,香辣虾,脆皮牛肉,脆皮茄子", "4", String.valueOf(45.4963595), String.valueOf(-73.5836337)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"Mr.Gao Restaurant(高老庄)" , "1550 Maisonneure O, GM001， Montreal QC", "H3G", "514-989-8887", "gao.jpg", "东北菜，川菜", "2", String.valueOf(45.495887), String.valueOf(-73.5814591)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"大唐火锅" , "2070 de maisonneuve west, montreal, QC", "H3H 1K8", "514-935-977", "datang.jpg", "正宗重庆麻辣火锅，麻辣香锅，精品川菜", "1", String.valueOf(45.4924084), String.valueOf(-73.5853052)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"忘利园烤鸭" , "1620B Av Lincoln ,montreal, QC", "H3H 1G9", "514-447-2165", "wangliyuan.jpg", "正宗北京烤鸭，学生快餐", "2", String.valueOf(45.4957443), String.valueOf(-73.5826604)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"sorgho Rouge(喜洋洋)" , "1448 Rue Saint Mathieu montreal, QC", "H3H 2H9", "514-935-1067", "xiyangyang.jpg", "火锅自助 烤肉串 川菜", "4", String.valueOf(45.4943527), String.valueOf(-73.5825463)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"Tianxia Restaurant Coreen(天霞韩式自助)" , "2065B Bishop, Montreal, QC", "H3G 2E8", "514-288-2065", "tianxia.jpg", "韩式全餐Buffet，正宗无烟烧烤", "8", String.valueOf(45.4977751), String.valueOf(-73.5806776)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"Fu Jia(富家庄)" , "937 Boul. Decarie, St-Laurent, QC", "H4L 3M3", "438-800-0300", "fujiazhuang.jpg", "地道东北美食，正宗大连老菜", "4", String.valueOf(45.5135001), String.valueOf(-73.6834082)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"Delicieux Express(小伙伴食堂)" , "1439 st-Mathieu Montreal,QC", "H3H 2M4", "514-507-6688", "xiaohuoban.jpg", "各类面食", "5", String.valueOf(45.4945175), String.valueOf(-73.5820716)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"Little Sheep Mongolian Hot Pot(小肥羊火锅)" , "50 De La Gauchetiere Ouest, Montreal, QC", "H2Z 1C1", "514-393-0888", "xiaofeiyang.jpg", "国内正宗的分店", "1", String.valueOf(45.5076576), String.valueOf(-73.5624593)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"Ichifuku(一福拉面)" , "1925 Rue Ste-Catherine Ouest, Montréal, QC", "H3H 1M3", "514-932-7227", "ichifuku.jpg", "从日本空运回来一台专业制面机，摆在店铺显眼的入口位置。顾客可以观赏整个制面过程。", "1", String.valueOf(45.4926135), String.valueOf(-73.5831424)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"KanBai(红翻天)" , "1110 clark Montréal, QC", "H2Z 1K3", "514-871-8778", "hongfantian.jpg", "川菜，粤菜，湘菜", "4", String.valueOf(45.5080677), String.valueOf(-73.5637187)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"Mei(梅园)" , "1425 Mackay Street montreal", "H3G 2H6", "514-288-1314", "meiyuan.jpg", "以中式小吃为主的餐馆。灌汤包是此次的主打产品", "7", String.valueOf(45.4962569), String.valueOf(-73.5796494)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"Kabocha居酒屋" , "3627 Boul. Saint-Laurent, Montréal, QC", "H2X 2V5", "514-845-0727", "kabocha.jpg", "Kabocha居酒屋的蒙特利尔分店是北美的第一家", "1", String.valueOf(45.5142839), String.valueOf(-73.5752954)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"Sushi Crystal(将太寿司)" , "4075 Saint Catherine St W Montreal, QC", "H3Z 3J3", "438-383-6839", "jiangtai.jpg", "日式自助", "8", String.valueOf(45.4877843), String.valueOf(-73.588857)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"KINOYA居酒屋" , "4250 Rue Saint-Denis Montréal, QC", "H2J 2K8", "514-508-5200", "kinoya.jpg", "地道的日本居酒屋，Japanese Pub", "6", String.valueOf(45.522037), String.valueOf(-73.5813013)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"Le Cristal Chinois(水天一色)" , "998 Boulevard St Laurent 6th Floor Montréal, QC", "H2Z 9Y9", "514-876-8778", "shuitianyise.jpg", "满市唐人街第一家高级粤菜餐馆!精美点心，鲍参翅肚，生猛海鲜", "5", String.valueOf(45.5077188), String.valueOf(-73.5615678)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                , new String[]{"Mai Xiang Yuan(麦香园康大分店)" , "1929 Rue Ste-Catherine Ouest Montréal, QC", "H3H 1M3", "514-931-8880", "maixiangyuan.jpg", "各类饺子:煎饺、水饺、素馅、肉馅", "7", String.valueOf(45.4925231), String.valueOf(-73.5831124)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Chatime(日出茶太(唐人街店))" , "52-C De La Gauchetiere Ouest Montréal, QC", "H2Z 1C1", "514-431-8388", "chatime.jpg", "日出茶太在全球享有知名度最高的珍珠奶茶店，我们从台湾出发，遍布全球世界各地，日出茶太是从2004年开始成立，到现在已经有10周年", "3", String.valueOf(45.507613), String.valueOf(-73.562488)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Délice Oriental(黄鹤楼)" , "1858 St.Catherine West, Montréal, QC", "H3H 1M1", "514-564-8999", "huanghelou.jpg", "川菜湘菜-铁板羊肉，香辣鸡丁，玉子豆腐 位于市中心的一家川菜馆，味道正宗，环境干净，价钱也不贵", "4", String.valueOf(45.492959), String.valueOf(-73.5823071)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Pain Farci(天津包子铺)" , "30 de Gauchetiere Ouest 2nd Floor Montréal, QC", "H2Z 1B9", "514-868-0657", "tianjinbaozipu1.jpg", "开在蒙特利尔唐人街的一家以北方包子为主打的餐馆", "7", String.valueOf(45.5077196), String.valueOf(-73.5624155)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Le Reine Patisserie(天后烘焙)" , "12210 Laurentien Blvd. Montréal, QC", "H4K 1M9", "514-745-6888", "tianhouhongpei.jpg", "各式面包，各式（卡通）生日蛋糕，蛋糕卷，酥饼，各式珍珠奶茶等", "7", String.valueOf(45.5277456), String.valueOf(-73.7220062)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"水天一色烧腊餐厅" , "12230 Boul Laurentien, St Laurent, QC", "H4K 1M9", "514-332-3888", "shuitianyiseshaola.jpg", "水天一色烧腊餐厅", "5", String.valueOf(45.5280479), String.valueOf(-73.7227078)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"kosa(韩式居酒屋)" , "6710 rue saint Jacques Montréal, QC", "H4B, 1V8", "514-508-5672", "kosa.jpg", "特色的铁板烧和各式的烧烤、韩式特色小吃", "6", String.valueOf(45.4585087), String.valueOf(-73.6283017)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"满堂红（川湘菜）" , "8200 TASHEREAU #1270, BROSSARD, QC", "J4X 2S6", " 450-904-0660", "mantanghong.jpg", "毛式红烧肉、水煮肉片、干锅茶树菇等等川湘菜都是他家的拿手好菜", "4", String.valueOf(45.4490796), String.valueOf(-73.4726958)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Hong Mere(香妈妈)" , "3795 Rue Welington Montréal, QC", "H4G 1V1", "514-508-6418", "xiangmama.jpg", "味道非常正宗的东北菜，孜然牛肉，尖椒肥肠，地三鲜，酸菜白肉，黑白菜", "2", String.valueOf(45.46591), String.valueOf(-73.5690354)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Pret a Manger Restaurant(美食坊)" , "1809 Rue Ste-Catherine Ouest Montréal, QC", "H3H 1M2", "514-931-8889", "meishifang.jpg", "是一家传统的中式炒菜馆", "2", String.valueOf(45.4937474), String.valueOf(-73.5818186)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Sumi Dojo居酒屋" , "3479 Boul. St-Laurent Montréal, QC", "H2X 2T6", "514-507-7864", "sumidojo.jpg", "蒙城市中心的日式居酒屋", "6", String.valueOf(45.5131766), String.valueOf(-73.572828)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Fortune Dumpling & Bubble Tea(福香缘)" , "1629 Rue Ste-Catherine Ouest Montréal, QC", "H3H 1L8", "514-815-8998", "fuxiangyuan.jpg", "各式饺子， 煎饼果子，炸酱面，海鲜打卤面，各式小凉菜等，珍珠奶茶", "7", String.valueOf(45.494762), String.valueOf(-73.5807412)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Ka Lo Hin(嘉乐轩)" , "1240 rue Stanley Montréal, QC", "H3B 2S7", "514-871-8099", "jialexuan.jpg", "中式自助 在西人中比较出名，川菜,泰国,加拿大菜", "8", String.valueOf(45.4988107), String.valueOf(-73.574846)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Tokyo Sushi(东京将太寿司)" , "1805 Rue Sainte-Catherine Ouest Montréal, QC", "H3H 2H9", "514-670-0068", "tokyosushi.jpg", "Tokyo Sushi 东京将太寿司是蒙特利尔寿司店的后起之秀", "8", String.valueOf(45.4938241), String.valueOf(-73.5818324)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Sushi Palace(神户寿司)" , "825 rue St-Laurent Ouest Longueuil, QC", "J4K 2V1", "450-646-1188", "shenhushousi.jpg", "中餐+泰餐+日餐的综合类餐馆", "8", String.valueOf(45.5288018), String.valueOf(-73.5176516)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Pho Bang New York(鹏牛肉粉)" , "1001 Boulevard Saint-Laurent Montréal, QC", "H2Z 1J4", "514-954-2032", "pengniuroufen.jpg", "比较受好评的几家越南河粉店之一，分量超大，价格便宜", "3", String.valueOf(45.5080241), String.valueOf(-73.5614169)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Restaurant Keung Kee(强记菜馆)" , "70 Rue De La Gauchetiere O Montréal, QC", "H2Z 1C1", "514-396-4643", "qiangjicaiguan.jpg", "金菇虎皮卷 ，各式煲，姜葱牛肉，清蒸鱼等都是招牌菜", "5", String.valueOf(45.5072427), String.valueOf(-73.5625407)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Chez Mein(炒面)" , "3754 Boul Saint-Laurent Montréal, QC", "H2W 1X6", "514-842-8880", "chezmein.jpg", "曾连续4次进入蒙特利尔5佳饭店。此店的特色是各类炒面，尤其2刀一碗的麻酱面，分量很足", "7", String.valueOf(45.5151246), String.valueOf(-73.5774534)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Lotus Bleu Restaurant(喜胜人家)" , "4847 rue de Verdun Montréal, QC", "H4G 1N2", "514-691-3519", "xishengrenjia.jpg", "蒙特利尔比较少见的河南风味的餐馆", "2", String.valueOf(45.4570183), String.valueOf(-73.5742982)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"GIA BA RESTAURANT(麻辣小龙虾)" , "5766 MONKLAND AVENUE Montréal, QC", "H4A 1E9", "514-564-7698", "GIA.jpg", "麻辣小龙小是从温哥华渔场空运来的 鲜活干净 蒙城独一份", "2", String.valueOf(45.4736882), String.valueOf(-73.626739)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Chez Ping Restaurant(福满楼)" , "16222 Boul. Monk Montréal, QC", "H4E 3H7", "514-954-2032", "fumanlou.jpg", "虾迎面，虾饺，烤乳猪，黏米都受到网友很高评价。尤其是猪肉，香肠，虾皮等做成的黏米饭，非常受欢.虾迎面，虾饺，烤乳猪，黏米都受到网友很高评价。尤其是猪肉，香肠，虾皮等做成的黏米饭，非常受欢虾迎面，虾饺，烤乳猪，黏米都受到网友很高评价。尤其是猪肉，香肠，虾皮等做成的黏米饭，非常受欢虾迎面，虾饺，烤乳猪，黏米都受到网友很高评价。尤其是猪肉，香肠，虾皮等做成的黏米饭，非常受欢虾迎面，虾饺，烤乳猪，黏米都受到网友很高评价。尤其是猪肉，香肠，虾皮等做成的黏米饭，非常受欢虾迎面，虾饺，烤乳猪，黏米都受到网友很高评价。尤其是猪肉，香肠，虾皮等做成的黏米饭，非常受欢虾迎面，虾饺，烤乳猪，黏米都受到网友很高评价。尤其是猪肉，香肠，虾皮等做成的黏米饭，非常受欢虾迎面，虾饺，烤乳猪，黏米都受到网友很高评价。尤其是猪肉，香肠，虾皮等做成的黏米饭，非常受欢", "5", String.valueOf(45.4565415), String.valueOf(-73.5972931)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Kazu（日本居酒屋）" , "1862 rue Sainte-Catherine O Montréal, QC", "H3H 1M1", "514-937-2333", "kazu.jpg", "日式料理", "6", String.valueOf(45.4928147), String.valueOf(-73.5821504)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Restaurant Sai Gwan(西关名食)" , "14 La Gauchetiere East Montréal, QC", "H2X 1P3", "514-227-2868", "xiguanmingshi.jpg", "中餐,川粤菜", "5", String.valueOf(45.5084653), String.valueOf(-73.5620247)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Qing Hua Dumpling(青花苑)" , "1676 Ave Lincoln Montréal, QC", "H3H 2T5", "438-288-5366", "qinghuayuanDT.jpg", "提供饺子以及凉菜", "7", String.valueOf(45.4953868), String.valueOf(-73.5832928)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Buffet Fu Lam(富临自助美食Laval店)" , "1600 Boulevard le Corbusier, Laval, QC", "H7S 1Z2", "450-682-6668", "fulinzizhulaval.jpg", "各式自助海鲜,螃蟹,寿司", "8", String.valueOf(45.5603748), String.valueOf(-73.7321843)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Mr.Thai(蒙村新盒饭)" , "1618 Lincoln AV Montréal, QC", "H3H 1G9", "514-553-0899", "mrthai.jpg", "盒饭快餐", "3", String.valueOf(45.4958735), String.valueOf(-73.5826002)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Sumo Ramen(相扑手拉面屋)" , "1007, Boul.Saint-Laurent Montréal, QC", "H2Z 1J4", "514-940-3668", "xiangpushoulamianwu.jpg", "日式拉面馆，相扑手提供样式繁多的各类拉面，而且可以任由顾客自选topping", "6", String.valueOf(45.5080057), String.valueOf(-73.5615517)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Seoul Chako B.B.Q.(自助韩式烧烤）" , "1824, rue Ste-Catherine O Montréal, QC", "H3H 1M1", "514-989-8886", "seoulchakobbq.jpg", "自助式韩国烧烤店，店面宽敞，烧烤肉类品种也很丰富，还提供寿司卷物等日式美食", "8", String.valueOf(45.4933707), String.valueOf(-73.5818257)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"PHENIX D'OR(金凤凰)" , "942 boul decarie Montréal, QC", "H4L 3M4", "514-439 4388", "jinfenghuang.jpg", "以海鲜,烧腊,粤菜为主的香港名厨主理的好饭店", "5", String.valueOf(45.5130747), String.valueOf(-73.6833989)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Chez Chili(一品湘)" , "1050 Rue Clark Montréal, QC", "H2Z 1K3", "514-9041767", "yipinxiang.jpg", "正宗的川菜馆,坐落于蒙特利尔唐人街上", "4", String.valueOf(45.5077427), String.valueOf(-73.5626812)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Patisserie Harmonie(面包蜜语)" , "85 La Gauchetiere Ouest Montréal, QC", "H2Z 1C2", "514-875-1328", "mianbaomiyu.jpg", "各种面包,蛋挞,珍珠奶茶,定制生日蛋糕等 ", "3", String.valueOf(45.5071137), String.valueOf(-73.5630926)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Restaurant Amigo(老友记168（潮州菜）)" , "1027 Boul St Laurent Montréal, QC", "H2Z 1J4", "514-393-8998", "laoyouji168.jpg", "适合聚餐的餐厅,主要是以潮州菜为主,价格偏低", "5", String.valueOf(45.508153), String.valueOf(-73.5619642)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Restaurant Ethan(为食坊)" , "72 Rue de la Gauchetière Ouest, Montréal, QC", "H2Z 1C1", "514-861-0815", "weishifang.jpg", "为食坊也是典型的广东小炒饭店", "5", String.valueOf(45.5072427), String.valueOf(-73.5625407)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Patisserie La Legende(丽晶饼屋)" , "68 La Gauchetiere West, Montréal, QC", "H2Z 1C2", "514-866-1628", "lijingbingwu.jpg", "除了卖面包之外还可以点菜的", "7", String.valueOf(45.5073517), String.valueOf(-73.5624527)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Maison Sai Yan(欣楼)" , "2230 Blvd. Lapiniere #110, Brossard, QC", "J4W 1M3", "4509268338", "xinlou.jpg", "蒙特利尔少有的正宗中餐馆之一，精美的虾肉馄饨，福建豆腐，蒸班头腩，煲仔饭等", "5", String.valueOf(45.4733557), String.valueOf(-73.4713647)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Nos Thés Cafés(特色台湾奶茶）" , "2160 Saint-Mathieu,Montréal, QC", "H3H 2J4", "514-931-4074", "nosthescafes.jpg", "非常有特点的台湾奶茶店,很受喜欢,店里还提供各种小吃和甜品", "3", String.valueOf(45.494832), String.valueOf(-73.5835889)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"友好韩式美食" , "2077 University, Montréal, QC", "H3A 2L1", "514-842-8282", "youhaohanshimeishi.jpg", "近Mcgill的韩式料理店，受到网友如潮好评，尤其是各式泡菜和烤肉", "6", String.valueOf(45.5047565), String.valueOf(-73.5747753)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Jardin du Sud(南苑港式美食)" , "8080 Boulevard Taschereau, Brossard, QC", "J4X 1C2", "450-923-9233", "nanyuangangshimeishi.jpg", "Chinese yellow curry, beef curry, chicken curry, and seafood curry", "5", String.valueOf(45.4508285), String.valueOf(-73.4715133)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Kanda Sushi Bar(神田寿司)" , "2045 Bishop, Montréal, QC", "H3G 2E8", "514-845-8868", "shentianbishop.jpg", "日本料理，神田在蒙城比较出名，有很多家分店", "8", String.valueOf(45.4976821), String.valueOf(-73.5805946)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Food & Restaurant(可爱家餐馆)" , "1440 RUE DE I'EGLISE, Montréal, QC", "H4L 2H3", "514-875-1328", "keaijia.jpg", "日式姜烧猪肉 日式鱼排饭 台式炸鸡腿饭 凤梨酥 车轮饼 台湾卤肉饭 咸酥鸡饭 还有12生肖鸡蛋糕，车轮饼（红豆，香芋和奶油3种馅）等特色小吃 ", "3", String.valueOf(45.5121474), String.valueOf(-73.6795692)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"小Q粽子" , "1408 rue St-Louis, Montréal, QC", "H4L 2P3", "514-755-1024", "xiaoqzongzi.jpg", "今年小Q继续为大家提供美味的传统点心，物美价廉，好吃依旧~品种多多，欢迎选购！", "3", String.valueOf(45.5090903), String.valueOf(-73.6734184)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Restaurant Ruby Rouge(红宝石酒楼)" , "1008 Rue Clark, Montréal, QC", "H2Z 1J9", "514-3908828", "hongbaoshi.jpg", "广式炒菜,老字号 — 皮蛋瘦肉粥,牛肉肠粉,鱼翅饺,豉汁蒸排骨,炸明虾饺,奶黄包 蒙城著名的老牌茶餐厅。供应早茶以及午餐", "5", String.valueOf(45.5075837), String.valueOf(-73.5622857)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Qing Hua Dumpling(青花苑（Chinatown）)" , "1019 St Laurent Boulevard Montréal, QC", "H2Z 1J4", "514-903-9887", "qinghuayuanchinatown.jpg", "各种馅料的蒸煎饺子，其中牛肉香菜，咖喱鸡肉以及鸡肉香菇可以说是招牌菜", "7", String.valueOf(45.5081467), String.valueOf(-73.5617617)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Patisserie Gallia Restaurant(嘉莉面包西饼茶餐厅)" , "78 La Gauchetiere West,Montréal, QC", "H2Z 1C1", "514-875-1328", "jialimianbaoxibingchacanting.jpg", "日本草莓芝士蛋糕,芒果冰沙,榴蓮冰沙,定制生日蛋糕等", "3", String.valueOf(45.507136), String.valueOf(-73.5627687)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Maiko Sushi(纯正日式sushi)" , "387 Bernard Street West, Montréal, QC", "H2V 1T6", "514-490-1225", "maikosushi.jpg", "一家正宗的日本寿司餐厅 真的是日本人开的", "6", String.valueOf(45.5232389), String.valueOf(-73.6083345)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Hanashima Fondue Japonaise（花之岛日本餐厅）" , "75 La Gauchetiere West, Montréal, QC", "H2Z 1C1", "514-396-4746", "huazhidao.jpg", "位于中国城的一家特色日本火锅餐厅。围着圆桌排列的小锅别有风味", "1", String.valueOf(45.507214), String.valueOf(-73.5629637)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Fu Kam Wah Restaurant（富金华海鲜酒家）" , "1180 Boulevard Décarie, Montréal, QC", "H4L 2L8", "514-337-2262", "fujinhuahaixianjiujia.jpg", "清蒸鱼，酸辣汤，炒面，清炒苦瓜都是这里的拿手菜", "5", String.valueOf(45.5143569), String.valueOf(-73.6849688)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Restaurant Chez Ping(福满楼海鲜酒家)" , "7401 Newman #1-2, Lasalle, QC", "H8N 2K3", "514-595-1888", "fumanlouhaixianjiujia.jpg", "一家位于lasalle的早茶茶餐厅", "5", String.valueOf(45.4410238), String.valueOf(-73.6235326)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Papa Jackie(爸爸私房菜)" , "4745 GRANDE-ALLEE, BROSSARD, QC", "J4Z 3G1", "450-812-9354", "babasifangcai.jpg", "天天不同特色菜，周周都有PROMOTION 逢周一至周日11:30am-4:00pm 各式早餐粥套餐", "3", String.valueOf(45.4817229), String.valueOf(-73.4570223)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Toyo Sushi Bar(东洋铁板烧)" , "2155 de la Montagne, Montréal, QC", "H3G 1Z8", "514-844-9292", "dongyangtiebanshao.jpg", "东洋铁板烧", "6", String.valueOf(45.4994565), String.valueOf(-73.5799296)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Restaurant Canton(广州饭店)" , "84 Rue De La Gauchetiere O, Montréal, QC", "H2Z 1C1", "514-397-9410", "guangzhoufandian.jpg", "粤式早茶 - 蔬菜春卷,腊味煲,豆腐煲,泰式炒河粉街坊小菜 又是一家物美价廉的粤菜馆", "6", String.valueOf(45.5070507), String.valueOf(-73.5626747)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"YUKI Ramen(YUKI拉面)" , "1616 Rue Sainte-Catherine Ouest 2nd Fl, Montréal, QC", "H3H 1L7", "514-962-6828", "yukilamian.jpg", "各种风味的拉面，现场制作，劲道十足，简直就是导致您变胖的罪魁祸首。工薪价格，很适合学生和上班的朋友们", "7", String.valueOf(45.4939857), String.valueOf(-73.5809401)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Toyo Sushi Bar(东洋铁板烧 （Laval）)" , "1510 Blvd. Chomedey, Laval, QC", "H7V 3N8", "450-688-4020", "dongyangtiebanshaolaval.jpg", "东洋铁板烧 （Laval）", "6", String.valueOf(45.5520674), String.valueOf(-73.74928)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"chezhwang(黄家韩国料理)" , "5545 Chemin Upper Lachine, Montréal, QC", "H4A 2A5", "514-484-5263", "chezhwang.jpg", "这家店是家庭经营模式，让你有在家吃饭的感觉。烤肉很地道，特色菜是猪骨豆腐汤和炖猪骨。冬天的时候吃最棒。大量的骨髓和肉类，份量也足。冷伴猪肘很好吃", "6", String.valueOf(45.4700319), String.valueOf(-73.6102842)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Tong Sing(东升楼酒家（原名东坡楼）)" , "43 Rue De La Gauchetiere E, Montréal, QC", "H2X", "514-866-7123", "dongshengloujiujia.jpg", "吃合菜的餐廳,主打菜色不詳,因為好像都有,不過猜測可能是潮州菜或泰越料理,價格偏低但是菜色不錯,算是比較划算的餐廳 ", "5", String.valueOf(45.5085787), String.valueOf(-73.5618267)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Magic Idea Tea Lounge(魔力点子(Chinatown))" , "30 La Gauchetiere West 2F, Montréal, QC", "H2Z 1C1", "514-868-0657", "molidianzi.jpg", "原味奶茶,伯爵奶茶,薄荷奶茶,蜂蜜奶茶,蜜茶,巧克力,杏仁奶茶,各类小吃", "3", String.valueOf(45.5077196), String.valueOf(-73.5624155)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Restaurant Niukee(牛记小厨)" , "1027 St-Laurent 2/F, Montréal, QC", "H2Z 1J4", "514-868-1866", "niujixiaochu.jpg", "很不错的有北方特色的饭馆，牛记小厨做川菜还是非常好", "2", String.valueOf(45.5081567), String.valueOf(-73.5619642)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Kantapia（Downtown趣味韩餐）" , "364 Rue Sherbrooke Ouest, Montréal, QC", "H3A1B5", "514-508-2585", "kantapia.jpg", "一家美味韩国料理，餐馆名称KANTAPIA来自一个非常流行的韩国卡通，整个故事都是小盆友Doolly둘리和Doh-nuh出去寻找一个叫KANTAPIA的“地球家园” ", "6", String.valueOf(45.5080908), String.valueOf(-73.5736469)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Maison Foo Lam(福临门)" , "9394 De L'Acadie, Montréal, QC", "H4N", "514-383-7878", "fulinmen.jpg", "一个经典的粤菜酒家。价格便宜，并且分量很足。尤其是炸鱿鱼，点心和粥，都很有风味", "5", String.valueOf(45.5333509), String.valueOf(-73.6594565)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Meilleur Choix(品味坊)" , "2125 Rue Saint Marc, Montréal, QC", "H3H 2P1", "514-932-8118", "pinweifang.jpg", "基本上那现在只卖包子，冷面，凉菜（酱牛肉），不过样样都是精品。包子总是供不应求，需要的最好提前打电话", "7", String.valueOf(45.4940174), String.valueOf(-73.5841639)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Restaurant Fung Shing(凤城小馆)" , "1102 Boul St-Laurent, Montréal, QC", "H2V 1T6", "514-866-0469", "fengchengxiaoguan.jpg", "位于中国城的一家别具风味的粤式炒菜。网友评价：最正宗的小龙虾以及各式煲，服务周到且价格合理", "5", String.valueOf(45.5084506), String.valueOf(-73.5633397)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"La Maison Bulgogi" , "2127, Rue Ste-Catherine, Montréal, QC", "H3H 1M6", "514-935-9820", "lamaisonbulgogi.jpg", "一个韩国人开的餐馆，店主曾经在中国生活过，所以餐厅除了供应韩国传统食物，也有中国口味的菜,猪骨土豆汤是最经典的", "6", String.valueOf(45.4911217), String.valueOf(-73.5848518)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Peking Garden(北京酒家 （北京菜）)" , "5339 Chemin Queen Mary, Montréal, QC", "H3X 4B1", "514-484-9139", "beijingjiujia.jpg", "在蒙特利尔貌似很少看到北京菜的，北京酒家就是一家传统北京中餐店，据说有40多年的历史了", "2", String.valueOf(45.4832022), String.valueOf(-73.6320638)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"HongKong Restaurant(香港烧腊海鲜饭店)" , "1023 St-Laurent, Montréal, QC", "H2Z 1J4", "514-8610251", "xianggangshaolahaixianfandian.jpg", "各式烧腊，包括猪肉，鸡肉，牛肉，鸭肉都是这里的特色。另外还提供一些炒菜以及各式炒米", "5", String.valueOf(45.5081034), String.valueOf(-73.5618838)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Park（mtl最佳日本餐厅之一）" , "378 Victoria Ave Westmount, Montréal, QC", "H3Z 2N4", "514-750-7534", "park.jpg", "Park（mtl最佳日本餐厅之一）", "6", String.valueOf(45.4785055), String.valueOf(-73.6050099)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Hoang Oanh Sandwich Vietnamien(黄莺越南面包)" , "1071 St-Laurent,, Montréal, QC", "H2V 1T6", "514-954-0053", "huangyingyuenanmianbao.jpg", "越南面包,烤肉三明治 黄莺越南面包是一家越南人开的店，里边主要经营的是越南面包", "3", String.valueOf(45.5084867), String.valueOf(-73.5625757)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Restaurant Winncie(蓝斯餐厅)" , "3030 Rome, Brossard, QC", "J4Y 1V9", "450-678-7666", "lansi.jpg", "位于南岸的一家中式/日式快餐店，供应馄饨汤，寿司，佐公鸡等简单中餐", "3", String.valueOf(45.4514966), String.valueOf(-73.4583621)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Ramen-Ya(日式拉面大全)" , "4274 Boulevard St-Laurent, Montréal, QC", "H2W 1Z3", "514-286-3832", "ramenya.jpg", "这家店拥有休闲的气氛和开放式的菜单，让你宾至如归", "7", String.valueOf(45.5185177), String.valueOf(-73.5854547)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Tri Express" , "1650 Avenue Laurier Est, Montréal, QC", "H2J 1J2", "514-528-5641", "triexpress.jpg", "这是最早提供Take away服务的寿司店，也就是天天爆满的Tri Express", "6", String.valueOf(45.5353687), String.valueOf(-73.5842298)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Buffet Chinois Toi(台新餐馆)" , "3638, chemin de Chambly, Longueuil, QC", "J4L 1N8", "450-651-7968", "taisun.jpg", "蒙特利尔南岸的一家中餐自助", "8", String.valueOf(45.5123474), String.valueOf(-73.444429)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                    , new String[]{"Zheng Qing Qiao(正清桥私房小菜)" , "1111 St-Urbain, Unit R09B, Montréal, QC", "H2Z 1Y6", "514-750-5484", "zhengqingqiao.jpg", "开在蒙特利尔唐人街的一家广场内，虽然小馆子地方小，但是料还是蛮足的。他家的牛肉面，肉夹馍做的都还不错", "2", String.valueOf(45.5077675), String.valueOf(-73.5641309)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Restaurant Dode & Andy(枫林茶餐厅)" , "1111 St-Urbain #R12, Montréal, QC", "H2Z 1Y6", "514-861-9958", "fenglinchacanting.jpg", "位于唐人街的快餐类茶餐厅，价格合理，分量不错，各种炒饭都别具风味", "5", String.valueOf(45.5077675), String.valueOf(-73.5641309)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"乐春林饼店" , "16 La Gauthetiere East, Montréal, QC", "H2X 1P4", "514-904-0650", "lechunlinbingdian.jpg", "糕点批发店,较多传统糕点。味道淡甜", "7", String.valueOf(45.5079888), String.valueOf(-73.5622235)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"永丰盛" , "1018 Rue Saint-Urbain, Montréal, QC", "H2V 1T6", "514-868-9738", "yongfengsheng.jpg", "主要是面食为主，当然也有炒菜，价格很便宜，另外窗口上贴满了各种报纸的报导", "5", String.valueOf(45.5067117), String.valueOf(-73.5629107)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Kyo Bar Japonais" , "711 Côte de la Place d'Armes, Montréal, QC", "H2Y", "514-282-2711", "kyobar.jpg", "这个酒屋位于Hôtel Place d'Armes广场，这里做寿司的风格和其他地方有点不同", "6", String.valueOf(45.5054518), String.valueOf(-73.5599275)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Ramen Misoya(味噌拉面连锁店)" , "2065 Rue Bishop, Montréal, QC", "H3G 2E8", "514-373-4888", "ramenmisoya.jpg", "这家店是日本连锁店，每一口拉面都能尝到地道的味道。所有的肉汁都是用味噌熬制的", "6", String.valueOf(45.4977751), String.valueOf(-73.5806776)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Restaurant de Wang Xia(王记快餐)" , "4354 Wellington, Montréal, QC", "H4G 1W4", "514-461-9716", "wangjikuaican.jpg", "中式快餐：炒菜，饺子，分量很足，价格超级实惠。各种家常菜和饺子都很可口", "2", String.valueOf(45.4604051), String.valueOf(-73.5694233)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"正宗道口烧鸡饭店" , "4847 RUE DE VERDUN, Montréal, QC", "H4G 1N2", "514-766-3519", "zhengzongdaokoushaoji.jpg", "蒙城最具中国北方传统饮食文化餐馆 多种口味手工水饺 隆重推出酸菜水饺 多种传统口味卤肉，炒菜", "2", String.valueOf(45.4570183), String.valueOf(-73.5742982)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Restaurant La Maison Kam Fung(金丰酒家)" , "7209 Taschereau, unit 111, Brossard, QC", "J4Y 1A1", "450-462-7888", "jinfengnanan.jpg", "这里停车方便，味道差不多，和唐人街的一样好吃", "5", String.valueOf(45.4611628), String.valueOf(-73.4663382)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Sumo Ramen(相扑手拉面馆)" , "1007 Boulevard Saint-Laurent , Montréal, QC", "H2Z 1J4", "514-940-3668", "sumoramen.jpg", "在这家拉面馆可以自己选择面条、肉汤和浇头，创造你想要的拉面味道", "6", String.valueOf(45.5080057), String.valueOf(-73.5615517)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Omma(Rosemont韩餐）" , "177 Rue Bernard Ouest, Montréal, QC", "H2T 2K4", "514-274-1464", "omma.jpg", "这家店是一个非常很时尚的一家。 服务也超级友好，细心周到，尤其很受年轻人的喜欢，价格比其他韩餐馆稍微贵了一点", "6", String.valueOf(45.5251313), String.valueOf(-73.6065769)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Banh Mi Cao Thang(高胜面包)" , "1082 St-Laurent, Montréal, QC", "H2Z 1J5", "514-392-0097", "gaoshengmianbao.jpg", "越南三明治 蒙特利尔首屈一指的越式三明治店。用脆香的面包包裹香菜，肉，以及各式酱料制成，价格非常实惠", "3", String.valueOf(45.5084343), String.valueOf(-73.5628264)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Imadake(日本原汁原味拉面)" , "4006 Rue Sainte-Catherine Ouest, Montréal, QC", "H3Z 1P2", "514-931-8833", "imadake.jpg", "将日本地道的家常菜混入了时尚风。不仅有很棒的亚洲开胃小菜，也有与之相配的美味拉面", "6", String.valueOf(45.4889011), String.valueOf(-73.5868895)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Restaurant Basilic(金不换餐厅)" , "83 La Gauchetiere West, Montréal, QC", "H2Z 1C2", "514-875-1388", "jinbuhuan.jpg", "金不餐厅坐落于唐人街区，里边装修的很好，河粉也还不错。还有其他炒菜可以点。提供中式、泰式、越南料理", "3", String.valueOf(45.5071137), String.valueOf(-73.5630926)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Bubble The Resto Lounge(早霸王)" , "1925 Rue Sainte-Catherine, Montréal, QC", "H3H 1M3", "514-989-8988", "zaobawang.jpg", "主要经营：奶茶，甜品，各样菜式，以及火锅", "1", String.valueOf(45.4926135), String.valueOf(-73.5831424)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Kam Shing Chinese Restaurant(金城)" , "4771 Van Horne Av Montreal, Montréal, QC", "H3W 1H8", "514-341-1628", "jincheng.jpg", "菜单非常丰富，超过230项的粤菜和川菜。食物是地道的中国口味，价格合理，味道鲜美", "5", String.valueOf(45.4947912), String.valueOf(-73.6396792)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Oh! Dumplings(随意馆)" , "1050 Rue Clark, Montréal, QC", "H2Z 1K3", "514-861-1628", "suiyiguan.jpg", "开在蒙特利尔唐人街上，以手工饺子为主打开的这么一个饭馆。饺子口味种类众多，欢迎品尝", "7", String.valueOf(45.5077427), String.valueOf(-73.5626812)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Le Pavillon Nanpic(南北楼)" , "75A La Gauchetiere West, Montréal, QC", "H2Z 1C2", "514-395-8106", "nanbeilou.jpg", "属于一家比较迎合西方人口味的中餐馆。佐公鸡和大蒜虾是这里的热门菜", "5", String.valueOf(45.5072015), String.valueOf(-73.5607804)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Restaurant Chuan Xiang Qing(川湘情)" , "1029 Rue Clark, Montréal, QC", "H2Z 1E6", "514-996-1238", "chuanxiangqing.jpg", "辣菜为主的中华料理，川菜，湘菜", "4", String.valueOf(45.5077268), String.valueOf(-73.5623575)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Keung Kee(强记餐厅)" , "70 Rue de la Gauchetière O, Montréal, QC", "H2Z 1B9", "514-393-1668", "qiangji.jpg", "属于港式中餐，坐落于唐人街，点餐的，适合聚会。晚上关门很晚，可以过来吃夜宵", "5", String.valueOf(45.5072427), String.valueOf(-73.5625407)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Kim Ramen(第一家拉面馆)" , "1441 Rue Saint Mathieu, Montréal, QC", "H3H 2H9", "514-507-8886", "diyijia.jpg", "传统中国手工拉面，鲜香骨头高汤，让身在异乡的我们品尝到家乡的味道", "7", String.valueOf(45.494473), String.valueOf(-73.5820333)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Tong Por(东坡楼酒家)", "12242 Boulevard Laurentien, Montréal, QC", "H4K 1M9", "514-393-9975", "dongpolou.jpg", "提供早茶、点餐。吃惯了金丰早茶的朋友可以去他家试试早茶。每天早茶时间是10:30到下午3点。", "5", String.valueOf(45.5278948), String.valueOf(-73.7234516)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Kanbai(红翻天Downtown)" , "1813 Rue Sainte-Catherine , Montréal, QC", "H3H 1M2", "514-933-6699", "hongfantian1.jpg", "红翻天是蒙特利尔很出名的一家川菜馆，四川味道浓厚，辣劲十足。此家分店就坐落在蒙特利尔市中心", "4", String.valueOf(45.4936616), String.valueOf(-73.5818776)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Epicerie A Lam Kee(林仔记烧腊店)" , "1065 Boulevard Saint-Laurent, Montréal, QC", "H2Z 1J6", "514-396-6582", "linzaiji.jpg", "林仔记烧腊店坐落于唐人街上，主要经营以烤鸭，烤鸡，烤鹌鹑，叉烧等烤制类食品为主", "5", String.valueOf(45.5084061), String.valueOf(-73.5625128)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Tapioca The(锅色添香)" , "1672 Boulevard de Maisonneuve, Montréal, QC", "H3H 1J6", "514-223-4095", "guosetianxiang.jpg", "锅色添香在蒙特利尔算是老牌餐馆了，主要提供川菜，湘菜，干锅，奶茶等", "2", String.valueOf(45.4947736), String.valueOf(-73.5822957)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Shi Tang(食堂)" , "1622 Boulevard de Maisonneuve, Montréal, QC", "H3H 2M8", "514-627-0888", "shitang.jpg", "食堂坐落于蒙特利尔 Downtown 市中心，提供中式快餐，盒饭，豆腐脑，肉饼，酱大骨，酱猪蹄等。很喜欢里边的煎饼，肉串等等小吃", "3", String.valueOf(45.4952758), String.valueOf(-73.5817559)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Mikado Sushi(帝)" , "1731 Rue Saint-Denis, Montréal, QC", "H2X 3K4", "514-844-5705", "mikadosushi.jpg", "蒙特利尔最早的日本料理之一，现在仍然名列前茅", "6", String.valueOf(45.5157177), String.valueOf(-73.5665447)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Kalbi BBQ Restaurent(韩国特色纸上烧烤)" , "1017 st-Laurent, Montréal, QC", "H2Z 1J4", "514-878-3388", "kalbi.jpg", "韩国特色纸上烧烤", "6", String.valueOf(45.5080648), String.valueOf(-73.5617759)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Maison du Nord(北方人家)" , "2130 saint mathieu, Montréal, QC", "H3H 2J4", "514-516-1613", "beifangrenjia.jpg", "北方菜，凉皮肉夹馍烤串", "2", String.valueOf(45.4948477), String.valueOf(-73.5834448)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"烧烤王" , "1441 st-mathieu, Montréal, QC", "H3H 2J4", "514-507-8886", "shaokaowang.jpg", "蒙特利尔第一家炭火烧烤店，以及地道东北菜的店铺", "2", String.valueOf(45.494473), String.valueOf(-73.5820333)});
        db.execSQL("insert into " + TABLES_TABLE_NAME + " values(null , ? , ? , ? , ? , ? , ? , ?, ?, ?)"
                        , new String[]{"Mr.Ma(馬先生)" , "1 Place Ville Marie, Montréal, QC", "H3B 3Y1", "514-866-8000", "maxiansheng.jpg", "蒙城高档中餐馆之一，海鲜和甜点,混沌汤,酸辣汤不错,蒙古牛肉,油炸春卷和牛排", "2", String.valueOf(45.5015138), String.valueOf(-73.5712981)});

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
