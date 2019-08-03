package com.example.hustcanteen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hustcanteen.adapter.PagerSlideAdapter;
import com.example.hustcanteen.fragment.BaseFragment;
import com.example.hustcanteen.fragment.FragmentFind;
import com.example.hustcanteen.location.LocationFragment;
import com.example.hustcanteen.fragment.FragmentMine;
import com.example.hustcanteen.utils.Dish;
import com.example.hustcanteen.utils.Hall;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.hustcanteen.location.LocationData.HallList;
import static com.example.hustcanteen.location.LocationData.hallName;
import static com.example.hustcanteen.location.LocationData.halls;
import static com.example.hustcanteen.location.LocationData.locationString;
import static com.example.hustcanteen.location.LocationData.locationX;
import static com.example.hustcanteen.location.LocationData.locationY;
import static com.example.hustcanteen.location.LocationData.picitures;
import static com.example.hustcanteen.recommendation.RecommendationData.DishList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.page_0) TextView text0;
    @BindView(R.id.page_1) TextView text1;
    @BindView(R.id.page_2) TextView text2;
    @BindView(R.id.main_tab_line) ImageView tab_line;
    @BindView(R.id.main_pager) ViewPager mViewPager;
    @BindView(R.id.image1) ImageView image1;
    @BindView(R.id.image2) ImageView image2;
    @BindView(R.id.image3) ImageView image3;
    @BindView(R.id.ll1) LinearLayout ll1;
    @BindView(R.id.ll2) LinearLayout ll2;
    @BindView(R.id.ll3) LinearLayout ll3;
    private int screenWidth;
    private List<BaseFragment> mFragmentList = new ArrayList<>();
    private PagerSlideAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        initWidth();
        setListener();

    }


    private void initData() {
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
            Dish dish = new Dish();
            dish.score = i%5;
            dish.hall = hallName[i];
            dish.picture = picitures.get(i);
            dish.name = hallName[i+1];
            DishList.add(dish);
        }

        //temporary
        mFragmentList.add(new FragmentFind());
        mFragmentList.add(new LocationFragment());
        mFragmentList.add(new FragmentMine());
        adapter = new PagerSlideAdapter(getSupportFragmentManager(), mFragmentList);
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(0);
        text0.setTextColor(getResources().getColor(R.color.orange));
    }

    private void setListener() {

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) tab_line.getLayoutParams();
                lp.leftMargin = screenWidth/3*position + positionOffsetPixels/3;
                tab_line.setLayoutParams(lp);
            }

            @Override
            public void onPageSelected(int position) {
                resetTextView();
                switch (position) {
                    case 0:
                        text0.setTextColor(getResources().getColor(R.color.orange));
                        image1.setImageResource(R.drawable.fragment1on);
                        image2.setImageResource(R.drawable.fragment2off);
                        image3.setImageResource(R.drawable.fragment3off);
                        break;
                    case 1:
                        text1.setTextColor(getResources().getColor(R.color.orange));
                        image1.setImageResource(R.drawable.fragment1off);
                        image2.setImageResource(R.drawable.fragment2on);
                        image3.setImageResource(R.drawable.fragment3off);
                        break;
                    case 2:
                        text2.setTextColor(getResources().getColor(R.color.orange));
                        image1.setImageResource(R.drawable.fragment1off);
                        image2.setImageResource(R.drawable.fragment2off);
                        image3.setImageResource(R.drawable.fragment3on);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        ll1.setOnClickListener(this);
        ll3.setOnClickListener(this);
        ll2.setOnClickListener(this);

    }

    private void resetTextView() {
        text0.setTextColor(Color.BLACK);
        text1.setTextColor(Color.BLACK);
        text2.setTextColor(Color.BLACK);
    }

    private void initWidth() {
        DisplayMetrics dpMetrics = new DisplayMetrics();
        getWindow().getWindowManager().getDefaultDisplay().getMetrics(dpMetrics);
        screenWidth = dpMetrics.widthPixels;
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) tab_line.getLayoutParams();
        lp.width = screenWidth / 3;
        tab_line.setLayoutParams(lp);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll1:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.ll2:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.ll3:
                mViewPager.setCurrentItem(2);
                break;
        }
    }
}
