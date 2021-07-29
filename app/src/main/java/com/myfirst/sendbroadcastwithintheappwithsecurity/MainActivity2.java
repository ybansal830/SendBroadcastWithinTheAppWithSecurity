package com.myfirst.sendbroadcastwithintheappwithsecurity;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mTextView = findViewById(R.id.textView);
        mTextView.setText(getIntent().getStringExtra("data"));
    }
}