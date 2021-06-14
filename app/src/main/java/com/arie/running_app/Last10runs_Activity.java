package com.arie.running_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
/**@author Arie Lipsker */

public class Last10runs_Activity extends AppCompatActivity {
    ListView lv;
    ArrayList<lastResult> lastResultArrayList;
    item_resultAdapter item_resultAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last10runs);
        SharedPreferences sp = getSharedPreferences("details1", 0);


        lastResultArrayList = new ArrayList<lastResult>();
        for (int i = 1; i < 11; i++) {
            String timeDate = sp.getString(String.valueOf(i),null);
            if (timeDate != null) {
                String[] strArray = timeDate.split("-");
                lastResultArrayList.add(new lastResult(strArray[0], strArray[1]));
            }
        }




        item_resultAdapter = new item_resultAdapter(this,0,0,lastResultArrayList);
        lv=(ListView) findViewById(R.id.lv);
        lv.setAdapter(item_resultAdapter);
    }
}