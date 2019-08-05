package com.example.hustcanteen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hustcanteen.login.LoginActivity;
import com.example.hustcanteen.settings.SettingData;
import com.example.hustcanteen.utils.Dish;
import com.example.hustcanteen.utils.DrawableUtil;
import com.example.hustcanteen.utils.Hall;
import com.example.hustcanteen.utils.ReadDishes;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.hustcanteen.DetailData.LikeDishList;
import static com.example.hustcanteen.location.LocationData.HallList;
import static com.example.hustcanteen.location.LocationData.hallName;
import static com.example.hustcanteen.location.LocationData.halls;
import static com.example.hustcanteen.location.LocationData.locationString;
import static com.example.hustcanteen.location.LocationData.locationX;
import static com.example.hustcanteen.location.LocationData.locationY;
import static com.example.hustcanteen.location.LocationData.picitures;
import static com.example.hustcanteen.location.LocationData.photos;
import static com.example.hustcanteen.recommendation.RecommendationData.DishList;

public class EnterActivity extends AppCompatActivity {
    @BindView(R.id.layout) RelativeLayout enter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        ButterKnife.bind(this);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences1 = getSharedPreferences("settings",MODE_PRIVATE);
                if (preferences1!=null){
                    SettingData.student = preferences1.getString("student","");
                    SettingData.major = preferences1.getString("major","");
                }
                SharedPreferences preferences = getSharedPreferences("isFirst",MODE_PRIVATE);
                if (preferences == null||preferences.getBoolean("isFirst",true)) {
                    startActivity(new Intent(EnterActivity.this, LoginActivity.class));
                }
                EnterActivity.this.finish();
            }
        });
        final DrawableUtil drawableUtil = new DrawableUtil(this);
        new Thread( new Runnable( ) {
            @Override
            public void run() {
                //耗时任务，比如加载网络数据
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        photos =  drawableUtil.getImageResourId("canteen");
                        Log.d("~~~~~~",photos.size()+"");
                        loadDatas();
                    }
                });
            }
        } ).start();
    }

    private void loadDatas() {
        for (int i = 0;i<locationString.length;i++)
            halls.add(locationString[i]);
        picitures.add(BitmapFactory.decodeResource(getResources(), R.drawable.hall0));
        picitures.add(BitmapFactory.decodeResource(getResources(), R.drawable.hall1));
        picitures.add(BitmapFactory.decodeResource(getResources(), R.drawable.hall2));
        picitures.add(BitmapFactory.decodeResource(getResources(), R.drawable.hall3));
        picitures.add(BitmapFactory.decodeResource(getResources(), R.drawable.hall4));
        picitures.add(BitmapFactory.decodeResource(getResources(), R.drawable.hal5));
        for (int i = 0;i<locationString.length;i++){
            Hall hall = new Hall();
            hall.address = locationString[i];
            hall.locationx = locationX[i];
            hall.locationy = locationY[i];
            hall.name = hallName[i];
            hall.picture = picitures.get(i);
            hall.index = i;
            HallList.add(hall);
/*  Dish dish = new Dish();
dish.score = i%5;
dish.hall = hallName[i];
dish.picture = picitures.get(i);
dish.name = hallName[i+1];
DishList.add(dish);*/
        }
        ReadDishes readDishes = new ReadDishes();
        readDishes.ReadText(R.raw.datas, EnterActivity.this);
        readDishes.ReadScores(R.raw.scores,EnterActivity.this);
        SharedPreferences preferences = getSharedPreferences("likes",MODE_PRIVATE);
        int number = preferences.getInt("number",0);
        for (int i = 0;i<number;i++){
            LikeDishList.add(DishList.get(preferences.getInt("int"+i,0)-1));
        }
    }
}
