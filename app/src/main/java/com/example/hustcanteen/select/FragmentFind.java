package com.example.hustcanteen.select;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hustcanteen.R;
import com.example.hustcanteen.base.BaseFragment;

import static com.example.hustcanteen.model.Repos.PersonalRecommendList;
import static com.example.hustcanteen.model.Repos.TopDishList;


public class FragmentFind extends BaseFragment {

    @Override
    public View initView() {
        final View view = View.inflate(mContext, R.layout.fragment1, null);
        RecyclerView rv1 = view.findViewById(R.id.rv_1);
        RecyclerView rv2 = view.findViewById(R.id.rv_2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv2.setLayoutManager(layoutManager);
        DishAdapter adapter = new DishAdapter(TopDishList,getContext());
        rv2.setAdapter(adapter);

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext());
        layoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv1.setLayoutManager(layoutManager1);
        DishAdapter adapter1 = new DishAdapter(PersonalRecommendList,getContext());
        rv1.setAdapter(adapter1);
        TextView tryNew = view.findViewById(R.id.try_new);
        tryNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), SelectActivity.class));
            }
        });
        return view;
    }

}
