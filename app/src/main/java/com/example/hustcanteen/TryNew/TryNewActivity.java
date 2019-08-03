package com.example.hustcanteen.TryNew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hustcanteen.R;

import java.util.ArrayList;
import java.util.List;

public class TryNewActivity extends AppCompatActivity {
    private ViewPager tryNewViewPager;
    private View view1,view2,view3,view4,view5;
    private List<View> viewList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try_new);
        tryNewViewPager = findViewById(R.id.try_new_viewpager);
        LayoutInflater inflater = getLayoutInflater();
        view1 = inflater.inflate(R.layout.try_new_1,null);
        view2 = inflater.inflate(R.layout.try_new_2,null);
        view3 = inflater.inflate(R.layout.try_new_3,null);
        view4 = inflater.inflate(R.layout.try_new_4,null);
        view5 = inflater.inflate(R.layout.try_new_5,null);
        viewList = new ArrayList<View>();
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewList.add(view4);
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

    }
}
