package com.example.hustcanteen.others;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hustcanteen.main.MainActivity;
import com.example.hustcanteen.R;
import com.example.hustcanteen.model.Repos;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.login_Certain) TextView certain;
    @BindView(R.id.clear1) ImageView clear1;
    @BindView(R.id.clear2) ImageView clear2;
    @BindView(R.id.clear3) ImageView clear3;
    @BindView(R.id.clear4) ImageView clear4;
    @BindView(R.id.edit_text1) EditText editText1;
    @BindView(R.id.edit_text2) EditText editText2;
    @BindView(R.id.edit_text3) EditText editText3;
    @BindView(R.id.edit_text4) EditText editText4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        clear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText1.setText("");
            }
        });
        clear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText2.setText("");
            }
        });
        clear3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText3.setText("");
            }
        });
        clear4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText4.setText("");
            }
        });
        certain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText1.getText().toString().equals("")||editText2.getText().toString().equals("")){
                    Toast.makeText(getApplication(),"请填写名字和专业哦",Toast.LENGTH_SHORT).show();
                }else {
                    Repos.initSettings(editText1,editText2,LoginActivity.this);
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                }
            }
        });
    }

}
