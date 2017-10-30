package com.sun.l_listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleAdapterActivity extends AppCompatActivity {

    private ListView listView;
    private List<Map<String, Object>> mDataList;
    private SimpleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter);

        initData();
        listView = (ListView) findViewById(R.id.list_view);
        mAdapter = new SimpleAdapter(this, mDataList, R.layout
                .list_item, new String[]{"img", "title", "major_material",
                "minor_material", "price","pick"}, new int[]{R
                .id.img_menu, R.id.tv_title, R.id.tv_major_material, R.id.tv_minor_material, R.id
                .tv_price});
        listView.setAdapter(mAdapter);

    }

    public void initData() {
        int[] images = {R.drawable.gongbaojiding, R.drawable.shuizhuroupian,
                R.drawable.xihucuyu, R.drawable.yuxiangrousi,
                R.drawable.suanlajidantang};
        String[] titles = {"宫保鸡丁", "水煮肉片", "西湖醋鱼", "鱼香肉丝", "酸辣鸡蛋汤"};
        String[] price = {"￥29.9", "￥39.0", "￥38.9", "￥26.9", "￥16.9"};
        String[] majorMaterial = {"主料：鸡胸肉 黄瓜 胡萝卜 花生米",
                "主料：猪里脊肉 大白菜",
                "主料：草鱼",
                "主料：猪里脊肉 胡萝卜 青椒",
                "主料：西红柿 肉末 木耳 豆腐  "};
        String[] minorMaterial = {"辅料：葱 姜 花椒 红干辣椒 蒜 酱油 盐 糖 醋 味精 淀粉 白胡椒粉",
                "辅料：油 盐 糖 料酒 淀粉 辣椒 鸡蛋 葱 姜 蒜 鸡精 韩式辣椒酱",
                "辅料：盐 生抽 大红浙醋 绍兴黄酒 糖 姜末 水淀粉 白胡椒粉",
                "辅料：葱末 姜丝 蒜末 豆瓣酱 甜面酱 醋 白糖 胡椒粉 植物油 生抽",
                "辅料：盐 鸡精 胡椒粉 老抽 陈醋"};
        String[] contents = {
                "宫保鸡丁，是一道闻名中外的特色传统名菜。鲁菜、川菜、贵州菜中都有收录，原料、做法有差别。该菜式的起源与鲁菜中的酱爆鸡丁，和贵州菜的胡辣子鸡丁有关，后被清朝山东巡抚、四川总督丁宝桢改良发扬，形成了一道新菜式——宫保鸡丁，并流传至今，此道菜也被归纳为北京宫廷菜。之后宫保鸡丁也流传到国外。",
                "水煮肉片是一道地方新创名菜，起源于自贡，发扬于西南，属于川菜中著名的家常菜。其起源于上世纪30年代， 自贡名厨范吉安(1887 -1982年)" +
                        "，创新出风味突出的水煮肉片。因肉片未经划油，以水煮熟故名水煮肉片。",
                "西湖醋鱼别名为叔嫂传珍，宋嫂鱼，是浙江杭州饭店的一道传统地方风味名菜。",
                "鱼香肉丝（英文名：Stir-fried Pork Strips in Fish " +
                        "Sauce）是一道特色传统名菜，以鱼香调味而得名，属川菜。相传灵感来自老菜泡椒肉丝，民国年间由四川籍厨师创制而成。",
                "酸辣鸡蛋汤是一款简单的汤类美食，主要原料有猪肉50克、胡萝卜、竹笋各50克等。逢年过节，或寒冬腊月，煮上一锅热腾腾的酸辣鸡蛋汤，暖身提神，回味无穷"};

        mDataList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("img", images[i]);
            map.put("title", titles[i]);
            map.put("major_material", majorMaterial[i]);
            map.put("minor_material", minorMaterial[i]);
            map.put("price", price[i]);
            mDataList.add(map);
        }
    }
}
