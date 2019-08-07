package com.example.hustcanteen.utils;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hustcanteen.R;
import com.example.hustcanteen.model.Dish;
import com.example.hustcanteen.recommendation.RecommendationGridAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.example.hustcanteen.model.Repos.CurrentDishList;

public class ClassifyUtil {
    public void setClassifiedData(Context context, View view, String item1, String item2) {
        RecyclerView recyclerView = view.findViewById(R.id.rv_grid);
        //ReadDishesUtil readDishes = new ReadDishesUtil();
        //readDishes.sortPrice();
        List<Dish> huncai = new ArrayList<>();
        for (int i = 0;i<CurrentDishList.size();i++)
            if (CurrentDishList.get(i).kind.equals(item1) ||CurrentDishList.get(i).kind.equals(item2))
                huncai.add(CurrentDishList.get(i));
        RecommendationGridAdapter adapter = new RecommendationGridAdapter(huncai,context);
        recyclerView.setLayoutManager(new GridLayoutManager(context,3));
        recyclerView.setAdapter(adapter);
    }
    public void setClassifiedData(Context context, View view, String item1) {
        RecyclerView recyclerView = view.findViewById(R.id.rv_grid);
        //ReadDishesUtil readDishes = new ReadDishesUtil();
        //readDishes.sortPrice();
        List<Dish> huncai = new ArrayList<>();
        for (int i = 0;i<CurrentDishList.size();i++)
            if (CurrentDishList.get(i).kind.equals(item1) )
                huncai.add(CurrentDishList.get(i));
        RecommendationGridAdapter adapter = new RecommendationGridAdapter(huncai,context);
        recyclerView.setLayoutManager(new GridLayoutManager(context,3));
        recyclerView.setAdapter(adapter);
    }
}
