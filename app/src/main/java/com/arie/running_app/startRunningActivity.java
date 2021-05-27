package com.arie.running_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class startRunningActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv;
    Button btn, btnMap;
    SharedPreferences sp;
    String time;

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int hours = intent.getIntExtra("hours", 0);
            int minutes = intent.getIntExtra("minutes", 0);
            int seconds = intent.getIntExtra("seconds", 0);
            tv.setText(String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, seconds));
            time = (String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, seconds));

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_running);
        tv = (TextView) findViewById(R.id.tv_showTime);
        btn = findViewById(R.id.botton_stopRunning);
        btn.setOnClickListener(this);
        btnMap = findViewById(R.id.btnMap);
        btnMap.setOnClickListener(this);

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
            sp = getSharedPreferences("details1",0);
            SharedPreferences.Editor editor=sp.edit();
            Toast.makeText(this,"time"+time,Toast.LENGTH_LONG).show();
            editor.putString("lastTimer",time);
            editor.putInt("numberTimer",1);
            editor.putString("9Timer",time);
            editor.putInt("numberTimer",2);
            editor.putString("8Timer",time);
            editor.putInt("numberTimer",3);
            editor.putString("7Timer",time);
            editor.putInt("numberTimer",4);
            editor.putString("6Timer",time);
            editor.putInt("numberTimer",5);
            editor.putString("5Timer",time);
            editor.putInt("numberTimer",6);
            editor.putString("4Timer",time);
            editor.putInt("numberTimer",7);
            editor.putString("3Timer",time);
            editor.putInt("numberTimer",8);
            editor.putString("2Timer",time);
            editor.putInt("numberTimer",9);
            editor.putString("firstTimer",time);
            editor.putInt("numberTimer",10);
            editor.commit();
            finish();
        }
        if (v == btnMap)
        {
            startActivity(new Intent(this,MapsActivity.class));
        }


    }
}