package com.example.hustcanteen.select;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hustcanteen.R;
import com.example.hustcanteen.model.Repos;
import com.example.hustcanteen.recommendation.RecommendationActivity;
import com.example.hustcanteen.model.Dish;

import java.util.ArrayList;
import java.util.List;

import static com.example.hustcanteen.model.Repos.RECOMENDATION;
import static com.example.hustcanteen.model.Repos.SelectedList;
import static com.example.hustcanteen.model.Repos.DishList;

public class SelectActivity extends AppCompatActivity implements SelectView {
    private ViewPager tryNewViewPager;
    private List<View> viewList;
    private CheckBox less10,from10to20,from21to30,more30,zhongkou,qingdan,wusuowei,tian,mala,zhongyou,hunduo,suduo,tangduo,tangshao;
    private ProgressBar progressBar;
    private TextView next1,next2,next3,district1,district2,hall1,hall2,hall3,hall4,hall5,hall6,end;
    private int d1 = 2,d2 = 3;
    private SelectPresenter presenter = new SelectPresenter();
    private Handler mHandler = new Handler(){
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1: setEastHall();break;
                case 2: setWestHall();break;
                case 3: setMiddleHall();break;
                case 4:{
                    d1 = 1;
                    district1.setText("东边食堂");
                    break;
                }
                case 5:{
                    d1 = 2;
                    district1.setText("西边食堂");
                    break;
                }
                case 6:{
                    d1 = 3;
                    district1.setText("中间食堂");
                    break;
                }
                case 7:{
                    d2 = 1;
                    district2.setText("东边食堂");
                    break;
                }
                case 8:{
                    d2 = 2;
                    district2.setText("西边食堂");
                    break;
                }
                case 9:{
                    d2 = 3;
                    district2.setText("中间食堂");
                    break;
                }
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try_new);
        initViews();
        setClickListener();
    }

    public void initViews() {
        tryNewViewPager = findViewById(R.id.try_new_viewpager);
        final LayoutInflater inflater = getLayoutInflater();
        View view1 = inflater.inflate(R.layout.try_new_1, null);
        View view2 = inflater.inflate(R.layout.try_new_2, null);
        View view3 = inflater.inflate(R.layout.try_new_3, null);
        View view5 = inflater.inflate(R.layout.try_new_5, null);
        viewList = new ArrayList<View>();
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewList.add(view5);
        PagerAdapter pagerAdapter = new PagerAdapter() {

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                // TODO Auto-generated method stub
                return arg0 == arg1;
            }

            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return viewList.size();
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                // TODO Auto-generated method stub
                container.removeView(viewList.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                // TODO Auto-generated method stub
                View v = viewList.get(position);
                ViewGroup parent = (ViewGroup) v.getParent();
                if (parent == null) {
                    // parent.removeAllViews();
                    container.addView(v);
                }
                return viewList.get(position);
            }
        };
        tryNewViewPager.setAdapter(pagerAdapter);
        next1 = view1.findViewById(R.id.certain_next1);
        district1 = view1.findViewById(R.id.district1);
        district2 = view1.findViewById(R.id.district2);
        hall1 = view1.findViewById(R.id.hal1);
        hall2 = view1.findViewById(R.id.hal2);
        hall3 = view1.findViewById(R.id.hal3);
        hall4 = view1.findViewById(R.id.hal4);
        hall5 = view1.findViewById(R.id.hal5);
        hall6 = view1.findViewById(R.id.hal6);
        next2 = view2.findViewById(R.id.certain_next2);
        zhongkou = view2.findViewById(R.id.zhongkou);
        qingdan = view2.findViewById(R.id.qingdan);
        wusuowei = view2.findViewById(R.id.wusuowei);
        tian = view2.findViewById(R.id.tian);
        next3 = view3.findViewById(R.id.certain_next3);
        mala = view3.findViewById(R.id.mala);
        zhongyou = view3.findViewById(R.id.zhongyou);
        hunduo = view3.findViewById(R.id.hunduo);
        suduo = view3.findViewById(R.id.suduo);
        tangduo = view3.findViewById(R.id.tangduo);
        tangshao = view3.findViewById(R.id.tangshao);
        less10 = view5.findViewById(R.id.less10);
        from10to20 = view5.findViewById(R.id.from10to20);
        from21to30 = view5.findViewById(R.id.from21to30);
        more30 = view5.findViewById(R.id.more30);
        progressBar = view5.findViewById(R.id.loading);
        end = view5.findViewById(R.id.end_certain);
    }

    public void setClickListener() {
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateCheckBox();
                startActivity(new Intent(SelectActivity.this, RecommendationActivity.class));
                //finish();
            }
        });
        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tryNewViewPager.setCurrentItem(1);
            }
        });
        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tryNewViewPager.setCurrentItem(2);
            }
        });
        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tryNewViewPager.setCurrentItem(3);
            }
        });

        district1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.UpdateDistrict1(d1,d2,mHandler);
            }
        });
        district2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.UpdateDistrict2(d1,d2,mHandler);
            }
        });
    }

    public void UpdateCheckBox() {
        progressBar.setVisibility(View.VISIBLE);
        SelectedList = new ArrayList<>();
        Repos.p_10 = less10.isChecked();
        Repos.p10_20 = from10to20.isChecked();
        Repos.p21_30 = from21to30.isChecked();
        Repos.p30_ = more30.isChecked();
        Repos.zhongkou = zhongkou.isChecked();
        Repos.qingdan = qingdan.isChecked();
        Repos.tian = tian.isChecked();
        Repos.wusuowei = wusuowei.isChecked();
        Repos.mala = mala.isChecked();
        Repos.zhongyou = zhongyou.isChecked();
        Repos.hunduo = hunduo.isChecked();
        Repos.suduo = suduo.isChecked();
        Repos.tangduo = tangduo.isChecked();
        Repos.tangshao = tangshao.isChecked();
        SelectPresenter selectPresenter = new SelectPresenter();
        for (int i = 0;i<DishList.size();i++){
            if (selectPresenter.judge(i)){
                SelectedList.add(DishList.get(i));
            }
        }
        progressBar.setVisibility(View.INVISIBLE);
        if(SelectedList.isEmpty()){
            Looper.prepare();
            Toast.makeText(SelectActivity.this,"没找到哦，换个口味试试吧",Toast.LENGTH_SHORT).show();
            Looper.loop();
            Log.d("~~~~~~","没找到");
        }
        for (int i = 0;i<SelectedList.size();i++){
            Dish dish = SelectedList.get(i);
            Log.d("~~~~~~","name:"+dish.name+" index:"+dish.index+" hall:"+dish.hall+" price:"+dish.price+" kind:"+dish.kind);
        }
        Repos.Choice = RECOMENDATION;
    }

    public void setEastHall() {
        hall1.setText("韵苑食堂");
        hall2.setText("东园食堂");
        hall3.setText("东篱餐厅");
        hall4.setText("学一食堂");
        hall5.setText("学二食堂");
        hall6.setText("东教工食堂");
    }

    public void setMiddleHall() {
        hall1.setText("东一食堂");
        hall2.setText("东三食堂");
        hall3.setText("喻园餐厅");
        hall4.setText(" 集锦园 ");
        hall5.setText(" 集贤楼 ");
        hall6.setText("紫荆园食堂");
    }

    public void setWestHall() {
        hall1.setText("西一食堂");
        hall2.setText("西二食堂");
        hall3.setText(" 百景园 ");
        hall4.setText(" 西华园 ");
        hall5.setText(" 百惠园 ");
        hall6.setText("枫林湾食堂");
    }

}
