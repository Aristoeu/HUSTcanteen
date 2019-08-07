package com.example.hustcanteen.recommendation;

import android.view.View;

import com.example.hustcanteen.R;
import com.example.hustcanteen.base.BaseFragment;
import com.example.hustcanteen.utils.ClassifyUtil;

public class FragmentSet extends BaseFragment {

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.recommendation, null);
        RecommendationPresenter recommendationPresenter = new RecommendationPresenter(new ClassifyUtil());
        recommendationPresenter.setClassifiedData(getContext(),view,"套饭");
        return view;
    }
}
