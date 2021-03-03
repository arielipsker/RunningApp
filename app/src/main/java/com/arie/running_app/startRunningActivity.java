package com.arie.running_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class startRunningActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv;
    Button btn;
    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int hours = intent.getIntExtra("hours", 0);
            int minutes = intent.getIntExtra("minutes", 0);
            int seconds = intent.getIntExtra("seconds", 0);
            tv.setText(String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, seconds));
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_running);
        tv = (TextView) findViewById(R.id.tv_showTime);
        btn = findViewById(R.id.botton_stopRunning);
        btn.setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(broadcastReceiver, new IntentFilter("RUNNING_TIME"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);

    }

    @Override
    public void onClick(View v) {
        if(v == btn){
            stopService(new Intent(this,StopwatchService.class));
            finish();
        }

    }
}