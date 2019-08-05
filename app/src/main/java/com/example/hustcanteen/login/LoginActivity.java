package com.example.hustcanteen.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRatingBar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hustcanteen.MainActivity;
import com.example.hustcanteen.R;
import com.example.hustcanteen.settings.SettingData;

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
                SettingData.student = editText1.getText().toString();
                SettingData.major = editText2.getText().toString();
                SharedPreferences.Editor editor = getSharedPreferences("isFirst",MODE_PRIVATE).edit();
                editor.putBoolean("isFirst",false);
                editor.apply();
                SharedPreferences.Editor editor1 = getSharedPreferences("settings",MODE_PRIVATE).edit();
                editor1.putString("student",SettingData.student);
                editor1.putString("major",SettingData.major);
                editor1.apply();
                finish();
            }
        });
    }
}
