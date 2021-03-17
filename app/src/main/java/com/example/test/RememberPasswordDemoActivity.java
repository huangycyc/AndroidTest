package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class RememberPasswordDemoActivity extends AppCompatActivity {
    private SharedPreferences preferences;//key,value 键值对方式存储数据
    private EditText etUsername,etPsw;
    private CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remember_password_demo);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);


        etUsername = findViewById(R.id.et_remember_username);
        etPsw = findViewById(R.id.et_remember_psw);
        checkBox = findViewById(R.id.cb_remember_rememberpsw);

        boolean isRemember = preferences.getBoolean("remember",false);
        if (isRemember){
            etUsername.setText(preferences.getString("username",""));
            etPsw.setText(preferences.getString("psw",""));
            checkBox.setChecked(true);
        }

    }

    public void setLoginBtn(View view) {
        //当登录按钮被按下，检测是否需要记住密码，如果是那么就要将用户名和密码进行保存
        boolean remember = checkBox.isChecked();
        SharedPreferences.Editor editor = preferences.edit();
        if(remember){
            //此处，用户名和密码的正确性验证工作就忽略不写了
            String userName = etUsername.getText().toString();
            String psw = etPsw.getText().toString();
            editor.putString("username",userName);
            editor.putString("psw",psw);
            editor.putBoolean("remember",true);
            editor.apply();
            Toast.makeText(this,"用户名和密码已保存",Toast.LENGTH_SHORT).show();

        }else{
            editor.clear();
            editor.apply();
        }
        Intent intent_Main = new Intent(this,MainActivity.class);
        startActivity(intent_Main);
    }
}