package com.example.hustcanteen.recommendation;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hustcanteen.R;
import com.example.hustcanteen.base.BaseFragment;
import com.example.hustcanteen.model.Dish;
import com.example.hustcanteen.utils.ReadDishesUtil;

import java.util.ArrayList;
import java.util.List;

import static com.example.hustcanteen.model.Repos.CurrentDishList;

public class FragmentAllDish extends BaseFragment {
    private RecyclerView mRvGrid;
    private List<Dish> list_ = new ArrayList<>();
    private ReadDishesUtil readDishesUtil = new ReadDishesUtil();

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.recommendation1, null);
        list_ = CurrentDishList;
        mRvGrid = view.findViewById(R.id.rv_grid);
        TextView price1 = view.findViewById(R.id.price_1);
        TextView price2 = view.findViewById(R.id.price_2);
        TextView score1 = view.findViewById(R.id.star_1);
        TextView score2 = view.findViewById(R.id.star_2);
        RecommendationGridAdapter adapter = new RecommendationGridAdapter(CurrentDishList,getContext());
        mRvGrid.setLayoutManager(new GridLayoutManager(getContext(),3));
        mRvGrid.setAdapter(adapter);
        price1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readDishesUtil.sortPrice1(list_);
                UpdateRecyclerView();
            }
        });
        price2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readDishesUtil.sortPrice2(list_);
                UpdateRecyclerView();
            }
        });
        score1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readDishesUtil.sortScore1(list_);
                UpdateRecyclerView();
            }
        });
        score2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readDishesUtil.sortScore2(list_);
                UpdateRecyclerView();
            }
        });
        return view;
    }

    private void UpdateRecyclerView() {
        RecommendationGridAdapter adapter = new RecommendationGridAdapter(list_,getContext());
        mRvGrid.setLayoutManager(new GridLayoutManager(getContext(),3));
        mRvGrid.setAdapter(adapter);
    }

}
