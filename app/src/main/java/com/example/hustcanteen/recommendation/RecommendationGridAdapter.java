package com.example.hustcanteen.recommendation;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.hustcanteen.detail.DetailActivity;
import com.example.hustcanteen.R;
import com.example.hustcanteen.model.Dish;
import static com.example.hustcanteen.model.Repos.dishDetail;

import java.util.List;

public class RecommendationGridAdapter extends RecyclerView.Adapter<RecommendationGridAdapter.ViewHolder> {
    private List<Dish> list;
    private Context context;
    static class ViewHolder extends RecyclerView.ViewHolder{
        private transient ImageView imageView;
        private transient TextView title,hall;
        private transient ProgressBar star;
        private transient LinearLayout layout;
        public ViewHolder(View view){
            super(view);
            imageView =view.findViewById(R.id.picture);
            title = view.findViewById(R.id.title);
            star = view.findViewById(R.id.scores);
            hall = view.findViewById(R.id.hall);
            layout = view.findViewById(R.id.big_layout);
        }
    }
    public RecommendationGridAdapter(List<Dish> list,Context context){
        this.list = list;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dish,null);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Dish dish = list.get(position);
        holder.imageView.setImageBitmap(list.get(position).picture);
        holder.title.setText(list.get(position).name);
        holder.hall.setText(list.get(position).hall);
        holder.star.setProgress(list.get(position).score);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dishDetail = dish;
                context.startActivity(new Intent(context, DetailActivity.class));
            }
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

}
