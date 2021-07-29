package com.myfirst.sendbroadcastwithintheappwithsecurity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private LocalReceiver localReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.send");
                intent.putExtra("message", "send via broadcast");
                sendBroadcast(intent, Manifest.permission.CAMERA);
            }
        });
        IntentFilter intentFilter = new IntentFilter("com.send");
        localReceiver = new LocalReceiver();
        registerReceiver(localReceiver,intentFilter,Manifest.permission.CAMERA,null);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
    }


    @Override
    protected void onDestroy() {
        unregisterReceiver(localReceiver);
        super.onDestroy();
    }
}
