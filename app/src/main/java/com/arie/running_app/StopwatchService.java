package com.arie.running_app;

import android.app.IntentService;
import android.content.Intent;

import androidx.annotation.Nullable;

public class StopwatchService extends IntentService {

    private long seconds = 0;
    private boolean running = true;
    public StopwatchService() {
        super("StopwatchService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        while (running){
            seconds++;
            Intent timeIntent = new Intent();
            timeIntent.putExtra("seconds",(int) (seconds % 60));
            timeIntent.putExtra("minutes",(int) ((seconds % 3600) / 60));
            timeIntent.putExtra("hours",(int) (seconds / 3600));
            timeIntent.setAction("RUNNING_TIME");
            sendBroadcast(timeIntent);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        running = false;
    }
}
