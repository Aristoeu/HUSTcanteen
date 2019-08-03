package com.example.hustcanteen.recommendation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.hustcanteen.R;
import com.example.hustcanteen.utils.Dish;
import com.example.hustcanteen.utils.Hall;

import java.util.List;

public class RecommendationGridAdapter extends RecyclerView.Adapter<RecommendationGridAdapter.ViewHolder> {
    private List<Dish> list;
    static class ViewHolder extends RecyclerView.ViewHolder{
        private transient ImageView imageView;
        private transient TextView title,star,hall;
        public ViewHolder(View view){
            super(view);
            imageView =view.findViewById(R.id.picture);
            title = view.findViewById(R.id.title);
            star = view.findViewById(R.id.score);
            hall = view.findViewById(R.id.hall);
        }
    }
    public RecommendationGridAdapter(List<Dish> list){
        this.list = list;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dish,null);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Dish dish = list.get(position);
        holder.imageView.setImageBitmap(list.get(position).picture);
        holder.title.setText(list.get(position).name);
        holder.hall.setText(list.get(position).hall);
        String stars = "";
        switch (list.get(position).score){
            case 0:stars = "★★★★★";break;
            case 1:stars = "★☆☆☆☆";break;
            case 2:stars = "★★☆☆☆";break;
            case 3:stars = "★★★☆☆";break;
            case 4:stars = "★★★★☆";break;
        }
        holder.star.setText(stars);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    public void refresh(List<Dish> newList) {
        //刷新数据
        list.removeAll(list);
        list.addAll(newList);
        notifyDataSetChanged();
    }
}
