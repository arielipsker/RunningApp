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
import java.util.Queue;

public class startRunningActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv;
    Button btn, btnMap;
    SharedPreferences sp;
    String time;
    int numberTimer;
    Date date = new Date(1,2,3);

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
        sp = getSharedPreferences("details1", 0);
        numberTimer = sp.getInt("numberTimer",0);

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(broadcastReceiver, new IntentFilter("RUNNING_TIME"));
    }

    @Override
    protected void onPause() {
        super.onPause();


    }

    @Override
    public void onClick(View v) {
        if(v == btn){
            stopService(new Intent(this,StopwatchService.class));
            unregisterReceiver(broadcastReceiver);
            sp = getSharedPreferences("details1",0);
            SharedPreferences.Editor editor=sp.edit();
            Toast.makeText(this,"time"+time,Toast.LENGTH_LONG).show();
            for (int i = 9; i > 0 ; i--) {
                int j = i;
                if (sp.contains(String.valueOf(j))) {
                    j++;
                    editor.putString(String.valueOf(j),sp.getString(String.valueOf(i),""));
                }
            }
            editor.putString("1", time + "-" + date.getCurrentDate());

            editor.commit();
            Intent intent = new Intent();
            intent.putExtra("RUNNING", false);
            setResult(1, intent);
            finish();
        }
        if (v == btnMap)
        {
            startActivity(new Intent(this,MapsActivity.class));
        }


    }
}