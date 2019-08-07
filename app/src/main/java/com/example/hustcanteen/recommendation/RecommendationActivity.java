package com.example.hustcanteen.recommendation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hustcanteen.R;
import com.example.hustcanteen.base.PagerSlideAdapter;
import com.example.hustcanteen.base.BaseFragment;
import com.example.hustcanteen.model.Repos;

import static com.example.hustcanteen.model.Repos.SelectedList;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecommendationActivity extends AppCompatActivity implements View.OnClickListener,RecommendationView{
    @BindView(R.id.page_0) TextView text0;
    @BindView(R.id.page_1) TextView text1;
    @BindView(R.id.page_2) TextView text2;
    @BindView(R.id.page_3) TextView text3;
    @BindView(R.id.page_4) TextView text4;
    @BindView(R.id.page_5) TextView text5;
    @BindView(R.id.page_6) TextView text6;
    @BindView(R.id.page_7) TextView text7;
    @BindView(R.id.back) ImageView back;
    @BindView(R.id.main_tab_line) ImageView tab_line;
    @BindView(R.id.main_pager) ViewPager mViewPager;
    @BindView(R.id.tv_choice) TextView tv_choice;
    private int screenWidth;
    private List<BaseFragment> mFragmentList = new ArrayList<>();
    private PagerSlideAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendation);
        ButterKnife.bind(this);
        if (Repos.Choice == Repos.RECOMENDATION){
            Repos.CurrentDishList = SelectedList;
            tv_choice.setText("为你推荐");
        }
        if (Repos.Choice == Repos.MYLIKE){
            Repos.CurrentDishList = Repos.LikeDishList;
            tv_choice.setText("我的收藏");
        }
        initFragmentList();
        initWidth();
        setListener();

    }
    @Override
    public void initFragmentList() {
        mFragmentList.add(new FragmentAllDish());
        mFragmentList.add(new FragmentMeat());
        mFragmentList.add(new FragmentVegetables());
        mFragmentList.add(new FragmentDinner());
        mFragmentList.add(new FragmentMuslin());
        mFragmentList.add(new FragmentSet());
        mFragmentList.add(new FragmentCakes());
        mFragmentList.add(new FragmentSoup());
        adapter = new PagerSlideAdapter(getSupportFragmentManager(), mFragmentList);
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(0);
        text0.setTextColor(Color.parseColor("#A84646"));
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    @Override
    public void setListener() {

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) tab_line.getLayoutParams();
                lp.leftMargin = screenWidth/8*position + positionOffsetPixels/8;
                tab_line.setLayoutParams(lp);
            }

            @Override
            public void onPageSelected(int position) {
                resetTextView();
                switch (position) {
                    case 0:
                        text0.setTextColor(Color.parseColor("#A84646"));
                        break;
                    case 1:
                        text1.setTextColor(Color.parseColor("#A84646"));
                        break;
                    case 2:
                        text2.setTextColor(Color.parseColor("#A84646"));
                        break;
                    case 3:
                        text3.setTextColor(Color.parseColor("#A84646"));
                        break;
                    case 4:
                        text4.setTextColor(Color.parseColor("#A84646"));
                        break;
                    case 5:
                        text5.setTextColor(Color.parseColor("#A84646"));
                        break;
                    case 6:
                        text6.setTextColor(Color.parseColor("#A84646"));
                        break;
                    case 7:
                        text7.setTextColor(Color.parseColor("#A84646"));
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        text0.setOnClickListener(this);
        text1.setOnClickListener(this);
        text2.setOnClickListener(this);
        text3.setOnClickListener(this);
        text4.setOnClickListener(this);
        text5.setOnClickListener(this);
        text6.setOnClickListener(this);
        text7.setOnClickListener(this);
    }
    @Override
    public void resetTextView() {
        text0.setTextColor(Color.BLACK);
        text1.setTextColor(Color.BLACK);
        text2.setTextColor(Color.BLACK);
        text3.setTextColor(Color.BLACK);
        text4.setTextColor(Color.BLACK);
        text5.setTextColor(Color.BLACK);
        text6.setTextColor(Color.BLACK);
        text7.setTextColor(Color.BLACK);
    }
    @Override
    public void initWidth() {
        DisplayMetrics dpMetrics = new DisplayMetrics();
        getWindow().getWindowManager().getDefaultDisplay().getMetrics(dpMetrics);
        screenWidth = dpMetrics.widthPixels;
        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) tab_line.getLayoutParams();
        lp.width = screenWidth / 8;
        tab_line.setLayoutParams(lp);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.page_0:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.page_1:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.page_2:
                mViewPager.setCurrentItem(2);
                break;
            case R.id.page_3:
                mViewPager.setCurrentItem(3);
                break;
            case R.id.page_4:
                mViewPager.setCurrentItem(4);
                break;
            case R.id.page_5:
                mViewPager.setCurrentItem(5);
                break;
            case R.id.page_6:
                mViewPager.setCurrentItem(6);
                break;
            case R.id.page_7:
                mViewPager.setCurrentItem(7);
                break;
        }
    }
}
