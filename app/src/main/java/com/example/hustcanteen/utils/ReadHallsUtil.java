package com.example.hustcanteen.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.example.hustcanteen.main.MainActivity;
import com.example.hustcanteen.R;
import com.example.hustcanteen.others.LoginActivity;
import com.example.hustcanteen.model.Repos;
import com.example.hustcanteen.model.Hall;

import java.util.Collections;

import static android.content.Context.MODE_PRIVATE;
import static com.example.hustcanteen.model.Repos.LikeDishList;
import static com.example.hustcanteen.model.Repos.PersonalRecommendList;
import static com.example.hustcanteen.model.Repos.TopDishList;
import static com.example.hustcanteen.model.Repos.recommendArray;
import static com.example.hustcanteen.model.Repos.HallList;
import static com.example.hustcanteen.model.Repos.hallName;
import static com.example.hustcanteen.model.Repos.halls;
import static com.example.hustcanteen.model.Repos.locationString;
import static com.example.hustcanteen.model.Repos.locationX;
import static com.example.hustcanteen.model.Repos.locationY;
import static com.example.hustcanteen.model.Repos.photos;
import static com.example.hustcanteen.model.Repos.picitures;
import static com.example.hustcanteen.model.Repos.DishList;

public class ReadHallsUtil {

    public void loadDatas(Context context) {
        Collections.addAll(halls, locationString);
        picitures.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.hall0));
        picitures.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.hall1));
        picitures.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.hall2));
        picitures.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.hall3));
        picitures.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.hall4));
        picitures.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.hal5));
        for (int i = 0;i<locationString.length;i++){
            Hall hall = new Hall();
            hall.address = locationString[i];
            hall.locationx = locationX[i];
            hall.locationy = locationY[i];
            hall.name = hallName[i];
            hall.picture = picitures.get(i);
            hall.index = i;
            HallList.add(hall);
        }
        DrawableUtil drawableUtil = new DrawableUtil(context);
        photos =  drawableUtil.getImageResourId("canteen");
        ReadDishesUtil readDishesUtil = new ReadDishesUtil();
        readDishesUtil.ReadText(R.raw.datas, context);
        readDishesUtil.ReadScores(R.raw.scores,context);
        SharedPreferences preferences = context.getSharedPreferences("likes",MODE_PRIVATE);
        int number = preferences.getInt("number",0);
        for (int i = 0;i<number;i++){
            LikeDishList.add(DishList.get(preferences.getInt("int"+i,0)-1));
        }
        for (int i = 116;i<DishList.size();i++){
            TopDishList.add(DishList.get(i));
            Log.d("~~~~~~",i+"");
        }
        for (int i1 : recommendArray) {
            PersonalRecommendList.add(DishList.get(i1));
        }
        SharedPreferences preferences1 = context.getSharedPreferences("settings",MODE_PRIVATE);
        if (preferences1!=null){
            Repos.student = preferences1.getString("student","");
            Repos.major = preferences1.getString("major","");
        }
        SharedPreferences preferences2 = context.getSharedPreferences("isFirst",MODE_PRIVATE);
        if (preferences2 == null||preferences2.getBoolean("isFirst",true)) {
            context.startActivity(new Intent(context, LoginActivity.class));
        }else context.startActivity(new Intent(context, MainActivity.class));
    }
}
