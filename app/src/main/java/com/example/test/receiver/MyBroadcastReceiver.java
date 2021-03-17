package com.example.test.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.test.MainActivity;
import com.example.test.MyBroadcastActivity;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"接收到了自定义广播",Toast.LENGTH_SHORT).show();
    }
}
