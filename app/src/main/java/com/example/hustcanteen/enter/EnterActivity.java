package com.example.hustcanteen.enter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.hustcanteen.utils.ReadHallsUtil;


public class EnterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Thread( new Runnable( ) {
            @Override
            public void run() {
                //耗时任务，比如加载网络数据
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        EnterPresenter presenter = new EnterPresenter(new ReadHallsUtil());
                        presenter.LoadDatas(EnterActivity.this);
                        EnterActivity.this.finish();
                    }
                });
            }
        } ).start();
    }
}
