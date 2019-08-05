package com.example.hustcanteen.recommendation;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hustcanteen.R;
import com.example.hustcanteen.fragment.BaseFragment;
import com.example.hustcanteen.utils.Dish;
import com.example.hustcanteen.utils.ReadDishes;

import java.util.ArrayList;
import java.util.List;

import static com.example.hustcanteen.DetailData.CurrentDishList;
import static com.example.hustcanteen.TryNew.SelectData.SelectedList;
import static com.example.hustcanteen.recommendation.RecommendationData.DishList;

public class Fragment1 extends BaseFragment {
    private RecyclerView mRvGrid;
    private TextView price1,price2,score1,score2;
    List<Dish> list_ = new ArrayList<>();
    ReadDishes readDishes = new ReadDishes();

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.recommendation1, null);
        list_ = CurrentDishList;
        mRvGrid = view.findViewById(R.id.rv_grid);
        price1 = view.findViewById(R.id.price_1);
        price2 = view.findViewById(R.id.price_2);
        score1 = view.findViewById(R.id.star_1);
        score2 = view.findViewById(R.id.star_2);
//由于在此我要设置的是网格的RecyclerView，所以还需为RecyclerView设置布局
        RecommendationGridAdapter adapter = new RecommendationGridAdapter(CurrentDishList,getContext());
        mRvGrid.setLayoutManager(new GridLayoutManager(getContext(),3));
        mRvGrid.setAdapter(adapter);
        price1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readDishes.sortPrice1(list_);
                RecommendationGridAdapter adapter = new RecommendationGridAdapter(list_,getContext());
                mRvGrid.setLayoutManager(new GridLayoutManager(getContext(),3));
                mRvGrid.setAdapter(adapter);
            }
        });
        price2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readDishes.sortPrice2(list_);
                RecommendationGridAdapter adapter = new RecommendationGridAdapter(list_,getContext());
                mRvGrid.setLayoutManager(new GridLayoutManager(getContext(),3));
                mRvGrid.setAdapter(adapter);
            }
        });
        score1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readDishes.sortScore1(list_);
                RecommendationGridAdapter adapter = new RecommendationGridAdapter(list_,getContext());
                mRvGrid.setLayoutManager(new GridLayoutManager(getContext(),3));
                mRvGrid.setAdapter(adapter);
            }
        });
        score2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readDishes.sortScore2(list_);
                RecommendationGridAdapter adapter = new RecommendationGridAdapter(list_,getContext());
                mRvGrid.setLayoutManager(new GridLayoutManager(getContext(),3));
                mRvGrid.setAdapter(adapter);
            }
        });
        return view;
    }

}
