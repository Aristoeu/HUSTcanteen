package com.example.hustcanteen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.hustcanteen.DetailData.LikeDishList;
import static com.example.hustcanteen.DetailData.dishDetail;

public class DetailActivity extends AppCompatActivity {
    @BindView(R.id.detail_give_star) TextView GiveStars;
    @BindView(R.id.detail_hall) TextView tv_hall;
    @BindView(R.id.detail_kind) TextView tv_kind;
    @BindView(R.id.detail_name) TextView tv_name;
    @BindView(R.id.detail_price) TextView tv_price;
    @BindView(R.id.rb_scores) androidx.appcompat.widget.AppCompatRatingBar rb_scores;
    @BindView(R.id.detail_taste1) TextView tv_taste1;
    @BindView(R.id.detail_taste2) TextView tv_taste2;
    @BindView(R.id.back) ImageView back;
    @BindView(R.id.photo_detail) ImageView iv_photo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        GiveStars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LikeDishList.add(dishDetail);
                Toast.makeText(getApplication(), "已收藏", Toast.LENGTH_SHORT).show();
            }
        });
        tv_hall.setText("地址："+dishDetail.hall);
        tv_kind.setText(dishDetail.kind);
        tv_name.setText(dishDetail.name);
        tv_price.setText("价格："+dishDetail.price+"元");
        tv_taste1.setText(dishDetail.taste1);
        tv_taste2.setText(dishDetail.taste2);
        rb_scores.setProgress(dishDetail.score);
        iv_photo.setImageBitmap(dishDetail.picture);
    }
    @Override
    protected void onDestroy() {
        dishDetail.score = rb_scores.getProgress();
        super.onDestroy();
    }
}
