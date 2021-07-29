package com.myfirst.sendbroadcastwithintheappwithsecurity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class LocalReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intent1 = new Intent(context,MainActivity2.class);
        intent1.putExtra("data",intent.getStringExtra("message"));
        context.startActivity(intent1);
    }
}
