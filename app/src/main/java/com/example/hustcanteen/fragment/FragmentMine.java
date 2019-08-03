package com.example.hustcanteen.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.example.hustcanteen.R;
import com.example.hustcanteen.SettingActivity;
import com.example.hustcanteen.recommendation.RecommendationActivity;

public class FragmentMine extends BaseFragment {
    private LinearLayout setting,likes;
    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment3, null);
        setting = view.findViewById(R.id.setting);
        likes = view.findViewById(R.id.likes);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), SettingActivity.class));
            }
        });
        likes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), RecommendationActivity.class));
            }
        });
        return view;
    }
}
