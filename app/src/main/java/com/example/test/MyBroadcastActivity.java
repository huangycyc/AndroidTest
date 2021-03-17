package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.test.receiver.NetworkChangeReceiver;

public class MyBroadcastActivity extends AppCompatActivity {
    private NetworkChangeReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_broadcast);
        //和静态注册不懂，动态注册Receiver不要写到mainfest文件中
        //意图过滤器
        IntentFilter intentFilter = new IntentFilter();
        receiver = new NetworkChangeReceiver();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(receiver,intentFilter);
    }

    public void setMyBroadcast(View view) {
        //手动自定义发送广播

        Intent intent = new Intent();
        intent.setAction("com.example.test.MY_BROADCAST");
//        Toast.makeText(this,"发送了一条广播",Toast.LENGTH_SHORT).show();
        sendBroadcast(intent);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}