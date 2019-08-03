package com.example.hustcanteen.recommendation;

import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hustcanteen.R;
import com.example.hustcanteen.fragment.BaseFragment;

import static com.example.hustcanteen.recommendation.RecommendationData.DishList;

public class Fragment1 extends BaseFragment {
    private RecyclerView mRvGrid;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.recommendation, null);
        mRvGrid = view.findViewById(R.id.rv_grid);
//由于在此我要设置的是网格的RecyclerView，所以还需为RecyclerView设置布局
        RecommendationGridAdapter adapter = new RecommendationGridAdapter(DishList);
        mRvGrid.setLayoutManager(new GridLayoutManager(getContext(),3));
        mRvGrid.setAdapter(adapter);
        return view;
    }

}
