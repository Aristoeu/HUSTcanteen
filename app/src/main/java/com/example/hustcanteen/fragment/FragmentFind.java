package com.example.hustcanteen.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.hustcanteen.R;
import com.example.hustcanteen.TryNew.TryNewActivity;

import java.util.ArrayList;
import java.util.List;


public class FragmentFind extends BaseFragment {
    private ViewPager viewPager1,viewPager2;
    private List<View> viewList,viewList2;//view数组
    private ImageView image1,image2,image3,image4,image5,image6;
    private TextView tryNew;
    @Override
    public View initView() {
        final View view = View.inflate(mContext, R.layout.fragment1, null);
        viewPager1 = view.findViewById(R.id.viewpager1);
        viewPager2 = view.findViewById(R.id.viewpager2);
        image1 = view.findViewById(R.id.image1);
        image2 = view.findViewById(R.id.image2);
        image3 = view.findViewById(R.id.image3);
        image4 = view.findViewById(R.id.image4);
        image5 = view.findViewById(R.id.image5);
        image6 = view.findViewById(R.id.image6);
        tryNew = view.findViewById(R.id.try_new);
        LayoutInflater inflater = getLayoutInflater();
        View view1 = inflater.inflate(R.layout.recommend1,null);
        View view2 = inflater.inflate(R.layout.recommend2,null);
        View view3 = inflater.inflate(R.layout.recommend3,null);
        View view4 = inflater.inflate(R.layout.recommend4,null);
        View view5 = inflater.inflate(R.layout.recommend5,null);
        View view6 = inflater.inflate(R.layout.recommend6,null);
        viewList = new ArrayList<View>();// 将要分页显示的View装入数组中
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewList2 = new ArrayList<>();
        viewList2.add(view4);
        viewList2.add(view5);
        viewList2.add(view6);
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
        PagerAdapter pagerAdapter2 = new PagerAdapter() {

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                // TODO Auto-generated method stub
                return arg0 == arg1;
            }

            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return viewList2.size();
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                // TODO Auto-generated method stub
                container.removeView(viewList2.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                // TODO Auto-generated method stub
                View v = viewList2.get(position);
                ViewGroup parent = (ViewGroup) v.getParent();
                if (parent == null) {
                    // parent.removeAllViews();
                    container.addView(v);
                }
                return viewList2.get(position);
            }
        };
        viewPager1.setAdapter(pagerAdapter);
        viewPager2.setAdapter(pagerAdapter2);
        tryNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), TryNewActivity.class));
            }
        });
        setListener();
        return view;
    }

    private void setListener() {

        viewPager1.setOnPageChangeListener(new ViewPager.OnPageChangeListener(){
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        image1.setImageResource(R.drawable.circle_main);
                        image2.setImageResource(R.drawable.circle_unchecked);
                        image3.setImageResource(R.drawable.circle_unchecked);
                        break;
                    case 1:
                        image1.setImageResource(R.drawable.circle_unchecked);
                        image2.setImageResource(R.drawable.circle_main);
                        image3.setImageResource(R.drawable.circle_unchecked);
                        break;
                    case 2:
                        image1.setImageResource(R.drawable.circle_unchecked);
                        image2.setImageResource(R.drawable.circle_unchecked);
                        image3.setImageResource(R.drawable.circle_main);
                        break;
                }
            }
        });
        viewPager2.setOnPageChangeListener(new ViewPager.OnPageChangeListener(){
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        image4.setImageResource(R.drawable.circle_main);
                        image5.setImageResource(R.drawable.circle_unchecked);
                        image6.setImageResource(R.drawable.circle_unchecked);
                        break;
                    case 1:
                        image4.setImageResource(R.drawable.circle_unchecked);
                        image5.setImageResource(R.drawable.circle_main);
                        image6.setImageResource(R.drawable.circle_unchecked);
                        break;
                    case 2:
                        image4.setImageResource(R.drawable.circle_unchecked);
                        image5.setImageResource(R.drawable.circle_unchecked);
                        image6.setImageResource(R.drawable.circle_main);
                        break;
                }
            }
        });

    }
}
