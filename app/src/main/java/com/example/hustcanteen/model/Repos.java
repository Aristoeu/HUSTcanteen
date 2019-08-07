package com.example.hustcanteen.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class Repos {
    public static final int RECOMENDATION = 1;
    public static final int MYLIKE = 2;
    public static double[] locationX = {30.5126827383,30.5199664337,30.5168382889,30.5164778027,30.5170641128,30.5175632442
            ,30.5207012432,30.5165193973,30.5223839065,30.5218663140,30.5202720842,30.5180235666,30.5206670904,30.5206716865
            ,30.5199369015,30.5198259862,30.5213899048,30.5218755568};
    public static double[] locationY = {114.4383256941,114.4384329825,114.4257968707,114.4270092292,114.4384705334,114.4385509997
            ,114.4411634713,114.4262152953,114.4214538036,114.4212928711,114.4234955354,114.4110384446,114.4142580384,114.4114836912
            ,114.4121927375,114.4118762368,114.4114368415,114.4147429166};
    public static String[] hallName = {"东教工","韵苑食堂","东一食堂","东三","学一","学二","东篱食堂","紫荆园","集锦园","喻园","集贤楼",
            "百惠园","枫林湾","西华园","西一","西二","氧气层","百景园"};
    public static String[] locationString = {"华中科技大学东校区-教工食堂","华中科技大学东校区-韵苑学生食堂","湖北省武汉市洪山区东三路",
            "湖北省武汉市洪山区关山街道剑桥春天社区东北方向","湖北省武汉市洪山区关山街道关山口社区东北方向","华中科技大学(东校区) 约87米"};
    public static List<String> halls = new ArrayList<>();
    public static List<Bitmap> picitures = new ArrayList<>();
    public static List<Integer> photos = new ArrayList<>();
    public static List<Hall> HallList = new ArrayList<>();
    public static List<Hall> ChosenHallList = new ArrayList<>();
    public static Boolean p_10;
    public static Boolean p10_20;
    public static Boolean p21_30;
    public static Boolean p30_;
    public static Boolean zhongkou;
    public static Boolean qingdan;
    public static Boolean wusuowei;
    public static Boolean tian;
    public static Boolean mala;
    public static Boolean zhongyou;
    public static Boolean hunduo;
    public static Boolean suduo;
    public static Boolean tangduo;
    public static Boolean tangshao;
    public static List<Dish> SelectedList = new ArrayList<>();
    public static List<Dish> TopDishList = new ArrayList<>();
    public static int[] recommendArray = {1, 4, 5, 6, 16, 21, 23, 25, 27};
    public static List<Dish> PersonalRecommendList = new ArrayList<>();
    public static String student;
    public static String major;
    public static Dish dishDetail = new Dish();
    public static List<Dish> LikeDishList = new ArrayList<>();
    public static int Choice = 1;
    public static List<Dish> CurrentDishList = new ArrayList<>();
    public static List<Dish> DishList = new ArrayList<>();

    public static void initSettings(EditText editText1, EditText editText2, Context context) {
        student = editText1.getText().toString();
        major = editText2.getText().toString();
        SharedPreferences.Editor editor = context.getSharedPreferences("isFirst", Context.MODE_PRIVATE).edit();
        editor.putBoolean("isFirst", false);
        editor.apply();
        SharedPreferences.Editor editor1 = context.getSharedPreferences("settings", Context.MODE_PRIVATE).edit();
        editor1.putString("student", student);
        editor1.putString("major", major);
        editor1.apply();
    }
}
