package com.example.hustcanteen.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hustcanteen.R;
import com.example.hustcanteen.base.PagerSlideAdapter;
import com.example.hustcanteen.base.BaseFragment;
import com.example.hustcanteen.select.FragmentFind;
import com.example.hustcanteen.location.LocationFragment;
import com.example.hustcanteen.model.Repos;
import com.example.hustcanteen.settings.FragmentMine;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
    @Override
    public void onDestroy() {
        SharedPreferences.Editor editor = getSharedPreferences("likes",MODE_PRIVATE).edit();
        editor.putInt("number", Repos.LikeDishList.size());
        for (int i = 0; i< Repos.LikeDishList.size(); i++){
            editor.putInt("int"+i, Repos.LikeDishList.get(i).index);
        }
        editor.commit();
        super.onDestroy();
    }
}
