package com.example.hustcanteen.settings;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hustcanteen.DetailData;
import com.example.hustcanteen.R;
import com.example.hustcanteen.fragment.BaseFragment;
import com.example.hustcanteen.login.LoginActivity;
import com.example.hustcanteen.settings.SettingActivity;
import com.example.hustcanteen.recommendation.RecommendationActivity;

import static com.example.hustcanteen.DetailData.MYLIKE;

public class FragmentMine extends BaseFragment {
    private LinearLayout setting,likes;
    private TextView student,major,login;
    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment3, null);
        setting = view.findViewById(R.id.setting);
        likes = view.findViewById(R.id.likes);
        student = view.findViewById(R.id.student);
        major = view.findViewById(R.id.major);
        login = view.findViewById(R.id.tv_login);
        student.setText(SettingData.student);
        major.setText(SettingData.major);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), SettingActivity.class));
            }
        });
        likes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DetailData.Choice = MYLIKE;
                startActivity(new Intent(getActivity(), RecommendationActivity.class));
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });
        return view;
    }
}
