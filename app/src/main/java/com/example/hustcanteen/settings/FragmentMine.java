package com.example.hustcanteen.settings;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hustcanteen.R;
import com.example.hustcanteen.base.BaseFragment;
import com.example.hustcanteen.others.LoginActivity;
import com.example.hustcanteen.model.Repos;
import com.example.hustcanteen.recommendation.RecommendationActivity;

import static com.example.hustcanteen.model.Repos.MYLIKE;

public class FragmentMine extends BaseFragment {
    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment3, null);
        LinearLayout setting = view.findViewById(R.id.setting);
        LinearLayout likes = view.findViewById(R.id.likes);
        TextView student = view.findViewById(R.id.student);
        TextView major = view.findViewById(R.id.major);
        TextView login = view.findViewById(R.id.tv_login);
        student.setText(Repos.student);
        major.setText(Repos.major);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), SettingActivity.class));
            }
        });
        likes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Repos.Choice = MYLIKE;
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
