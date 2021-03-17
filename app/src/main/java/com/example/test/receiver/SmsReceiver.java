package com.example.test.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle= intent.getExtras();
        Object[] objects = (Object[]) bundle.get("pdus");
        SmsMessage smsMessage = SmsMessage.createFromPdu((byte[])objects[0]);
        String address = smsMessage.getOriginatingAddress();
        String body = smsMessage.getMessageBody();
        Toast.makeText(context,address+": "+body,Toast.LENGTH_SHORT).show();
        abortBroadcast();//拦截广播
    }
}
