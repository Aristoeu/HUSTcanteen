package com.example.hustcanteen.recommendation;

import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hustcanteen.R;
import com.example.hustcanteen.fragment.BaseFragment;
import com.example.hustcanteen.utils.Dish;

import java.util.ArrayList;
import java.util.List;

import static com.example.hustcanteen.DetailData.CurrentDishList;
import static com.example.hustcanteen.TryNew.SelectData.SelectedList;

public class Fragment6 extends BaseFragment {

    private RecyclerView recyclerView;
    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.recommendation, null);
        recyclerView = view.findViewById(R.id.rv_grid);
        //ReadDishes readDishes = new ReadDishes();
        //readDishes.sortPrice();
        List<Dish> huncai = new ArrayList<>();
        for (int i = 0;i<CurrentDishList.size();i++)
            if (CurrentDishList.get(i).kind.equals("套饭") )
                huncai.add(CurrentDishList.get(i));
        RecommendationGridAdapter adapter = new RecommendationGridAdapter(huncai,getContext());
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        recyclerView.setAdapter(adapter);
        return view;
    }
}
