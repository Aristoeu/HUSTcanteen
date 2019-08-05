package com.example.hustcanteen.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.Toast;
import static com.example.hustcanteen.location.LocationData.photos;

import com.example.hustcanteen.location.LocationView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static com.example.hustcanteen.recommendation.RecommendationData.DishList;

public class ReadDishes {
    public void ReadText(int i, Context context) {
        Resources resources = context.getResources();
        InputStream StdInfo = null;
        int index = 0;
        try {
            StdInfo = resources.openRawResource(i);
            if (StdInfo.available() == 0)
                return;
            if (StdInfo != null) {
                //用utf-8读取文件
                Scanner input = new Scanner(StdInfo, "utf-8");
                while (input.hasNext()) {
                    //将读取出来的数据文件
                    Dish dish = new Dish();
                    dish.name = input.next();
                    dish.index = Integer.valueOf(input.next());
                    dish.hall = input.next();
                    dish.price = Float.valueOf(input.next());
                    dish.kind = input.next();
                    dish.taste1 = input.next();
                    dish.taste2 = input.next();
                    dish.picture = BitmapFactory.decodeResource(context.getResources(),photos.get(index++));
                    dish.isChosen = false;
                    DishList.add(dish);
                    Log.d("~~~~~~","name:"+dish.name+" index:"+dish.index+" hall:"+dish.hall+" price:"+dish.price+" kind:"+dish.kind+" taste1:"+dish.taste1+" taste2:"+dish.taste2);
                }
            }
        } catch (IOException e) {
            Toast.makeText(context, "not exist!", Toast.LENGTH_LONG);
        }
    }
        public void ReadScores(int i, Context context) {
        Resources resources = context.getResources();
        InputStream StdInfo = null;
        int index = 0;
        try {
            StdInfo = resources.openRawResource(i);
            if (StdInfo.available() == 0)
                return;
            if (StdInfo != null) {
                //用utf-8读取文件
                Scanner input = new Scanner(StdInfo, "utf-8");
                while (input.hasNext()) {
                    //将读取出来的数据文件
                    Dish dish = DishList.get(index++);
                    dish.score = Integer.valueOf(input.next());
                    }
            }
        } catch (IOException e) {
            Toast.makeText(context, "not exist!", Toast.LENGTH_LONG);
        }
    }
    public class myCompratorPrice1 implements Comparator<Dish> {
        @Override
        public int compare(Dish o1, Dish o2){
            double a1=o1.price;
            double a2=o2.price;
            return (int) (a1-a2);
        }
    }
    public void sortPrice1(List<Dish> targetList){
        Collections.sort(targetList,new myCompratorPrice1());
    }
    public class myCompratorPrice2 implements Comparator<Dish> {
        @Override
        public int compare(Dish o1, Dish o2){
            double a1=o1.price;
            double a2=o2.price;
            return (int) (a2-a1);
        }
    }
    public void sortPrice2(List<Dish> targetList){
        Collections.sort(targetList,new myCompratorPrice2());
    }
    public class myCompratorScore1 implements Comparator<Dish> {
        @Override
        public int compare(Dish o1, Dish o2){
            double a1=o1.score;
            double a2=o2.score;
            return (int) (a1-a2);
        }
    }
    public void sortScore1(List<Dish> targetList){
        Collections.sort(targetList,new myCompratorScore1());
    }
    public class myCompratorScore2 implements Comparator<Dish> {
        @Override
        public int compare(Dish o1, Dish o2){
            double a1=o1.score;
            double a2=o2.score;
            return (int) (a2-a1);
        }
    }
    public void sortScore2(List<Dish> targetList){
        Collections.sort(targetList,new myCompratorScore2());
    }
}
