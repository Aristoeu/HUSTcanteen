package com.example.hustcanteen.TryNew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.hustcanteen.DetailData;
import com.example.hustcanteen.R;
import com.example.hustcanteen.recommendation.RecommendationActivity;
import com.example.hustcanteen.settings.SettingData;
import com.example.hustcanteen.utils.Dish;

import java.util.ArrayList;
import java.util.List;

import static com.example.hustcanteen.DetailData.RECOMENDATION;
import static com.example.hustcanteen.TryNew.SelectData.SelectedList;
import static com.example.hustcanteen.recommendation.RecommendationData.DishList;

public class TryNewActivity extends AppCompatActivity {
    private ViewPager tryNewViewPager;
    private View view1,view2,view3,view5;
    private List<View> viewList;
    private CheckBox less10,from10to20,from21to30,more30,fcts,mianshi,huncai,sucai,hucai,gaodian,zhongkou,qingdan,wusuowei,tian,mala,zhongyou,hunduo,suduo,tangduo,tangshao;
    private ProgressBar progressBar;
    private TextView next1,next2,next3,next4,district1,district2,hall1,hall2,hall3,hall4,hall5,hall6;
    private int d1 = 2,d2 = 3;
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
        tryNewViewPager = findViewById(R.id.try_new_viewpager);
        final LayoutInflater inflater = getLayoutInflater();
        view1 = inflater.inflate(R.layout.try_new_1,null);
        view2 = inflater.inflate(R.layout.try_new_2,null);
        view3 = inflater.inflate(R.layout.try_new_3,null);
       // view4 = inflater.inflate(R.layout.try_new_4,null);
        view5 = inflater.inflate(R.layout.try_new_5,null);
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
       // next4 = view4.findViewById(R.id.next_certain_4);
      //  fcts = view4.findViewById(R.id.fcts);
      //  mianshi = view4.findViewById(R.id.mianshi);
      //  huncai = view4.findViewById(R.id.huncaii);
      //  sucai = view4.findViewById(R.id.sucaii);
      //  hucai = view4.findViewById(R.id.huicaii);
       // gaodian = view4.findViewById(R.id.gaodian);
        less10 = view5.findViewById(R.id.less10);
        from10to20 = view5.findViewById(R.id.from10to20);
        from21to30 = view5.findViewById(R.id.from21to30);
        more30 = view5.findViewById(R.id.more30);
        progressBar = view5.findViewById(R.id.loading);
        TextView end = view5.findViewById(R.id.end_certain);
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                SelectedList = new ArrayList<>();
                SelectData.p_10 = less10.isChecked();
                SelectData.p10_20 = from10to20.isChecked();
                SelectData.p21_30 = from21to30.isChecked();
                SelectData.p30_ = more30.isChecked();
                //SelectData.mianshi = mianshi.isChecked();
                //SelectData.fcts = fcts.isChecked();
                //SelectData.gaodian = gaodian.isChecked();
                //SelectData.huicai = hucai.isChecked();
                //SelectData.huncai = huncai.isChecked();
                //SelectData.sucai = sucai.isChecked();
                SelectData.zhongkou = zhongkou.isChecked();
                SelectData.qingdan = qingdan.isChecked();
                SelectData.tian = tian.isChecked();
                SelectData.wusuowei = wusuowei.isChecked();
                SelectData.mala = mala.isChecked();
                SelectData.zhongyou = zhongyou.isChecked();
                SelectData.hunduo = hunduo.isChecked();
                SelectData.suduo = suduo.isChecked();
                SelectData.tangduo = tangduo.isChecked();
                SelectData.tangshao = tangshao.isChecked();
                SelectModel selectModel = new SelectModel();
                for (int i = 0;i<DishList.size();i++){
                    if (selectModel.judge(i)){
                        SelectedList.add(DishList.get(i));
                    }
                }
                progressBar.setVisibility(View.INVISIBLE);
                if(SelectedList.isEmpty())Log.d("~~~~~~","没找到");
                for (int i = 0;i<SelectedList.size();i++){
                    Dish dish = SelectedList.get(i);
                    Log.d("~~~~~~","name:"+dish.name+" index:"+dish.index+" hall:"+dish.hall+" price:"+dish.price+" kind:"+dish.kind);
                }
                DetailData.Choice = RECOMENDATION;
                startActivity(new Intent(TryNewActivity.this, RecommendationActivity.class));
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
                Log.d("~~~~~~","click "+d1+"  "+d2);
                if (d1 == 2&&d2 == 3){
                    Message message = new Message();
                    message.what = 2;
                    mHandler.sendMessage(message);
                    Message message1 = new Message();
                    message1.what = 4;
                    mHandler.sendMessage(message1);
                }
                if (d1 == 1&&d2 == 3){
                    Message message = new Message();
                    message.what = 1;
                    mHandler.sendMessage(message);
                    Message message1 = new Message();
                    message1.what = 5;
                    mHandler.sendMessage(message1);
                }
                if (d1 == 3&&d2 == 1){
                    Message message = new Message();
                    message.what = 3;
                    mHandler.sendMessage(message);
                    Message message1 = new Message();
                    message1.what = 5;
                    mHandler.sendMessage(message1);
                }
                if (d1 == 2&&d2 == 1){
                    Message message = new Message();
                    message.what = 2;
                    mHandler.sendMessage(message);
                    Message message1 = new Message();
                    message1.what = 6;
                    mHandler.sendMessage(message1);
                }
                if (d1 == 3&&d2 == 2){
                    Message message = new Message();
                    message.what = 3;
                    mHandler.sendMessage(message);
                    Message message1 = new Message();
                    message1.what = 4;
                    mHandler.sendMessage(message1);
                }
                if (d1 == 1&&d2 == 2){
                    Message message = new Message();
                    message.what = 1;
                    mHandler.sendMessage(message);
                    Message message1 = new Message();
                    message1.what = 6;
                    mHandler.sendMessage(message1);
                }
            }
        });
        district2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("~~~~~~","click");
                if (d1 == 2&&d2 == 3){
                    Log.d("~~~~~~","do");
                    Message message = new Message();
                    message.what = 3;
                    mHandler.sendMessage(message);
                    Message message1 = new Message();
                    message1.what = 7;
                    mHandler.sendMessage(message1);
                    Log.d("~~~~~~",d2+"");
                }
                if (d1 == 3&&d2 == 1){
                    Message message = new Message();
                    message.what = 1;
                    mHandler.sendMessage(message);
                    Message message1 = new Message();
                    message1.what = 8;
                    mHandler.sendMessage(message1);
                }
                if (d1 == 1&&d2 == 3){
                    Message message = new Message();
                    message.what = 3;
                    mHandler.sendMessage(message);
                    Message message1 = new Message();
                    message1.what = 8;
                    mHandler.sendMessage(message1);
                }
                if (d1 == 2&&d2 == 1){
                    Message message = new Message();
                    message.what = 1;
                    mHandler.sendMessage(message);
                    Message message1 = new Message();
                    message1.what = 9;
                    mHandler.sendMessage(message1);
                }
                if (d1 == 3&&d2 == 2){
                    Message message = new Message();
                    message.what = 2;
                    mHandler.sendMessage(message);
                    Message message1 = new Message();
                    message1.what = 7;
                    mHandler.sendMessage(message1);
                }
                if (d1 == 1&&d2 == 2){
                    Message message = new Message();
                    message.what = 2;
                    mHandler.sendMessage(message);
                    Message message1 = new Message();
                    message1.what = 9;
                    mHandler.sendMessage(message1);
                }
            }
        });
    }

    private void setEastHall() {
        hall1.setText("韵苑食堂");
        hall2.setText("东园食堂");
        hall3.setText("东篱餐厅");
        hall4.setText("学一食堂");
        hall5.setText("学二食堂");
        hall6.setText("东教工食堂");
    }

    private void setMiddleHall() {
        hall1.setText("东一食堂");
        hall2.setText("东三食堂");
        hall3.setText("喻园餐厅");
        hall4.setText(" 集锦园 ");
        hall5.setText(" 集贤楼 ");
        hall6.setText("紫荆园食堂");
    }

    private void setWestHall() {
        hall1.setText("西一食堂");
        hall2.setText("西二食堂");
        hall3.setText(" 百景园 ");
        hall4.setText(" 西华园 ");
        hall5.setText(" 百惠园 ");
        hall6.setText("枫林湾食堂");
    }

}
