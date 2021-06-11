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
    Date date = new Date(1,2,3);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last10runs);
        SharedPreferences sp = getSharedPreferences("details1", 0);
        String timer1 = sp.getString("timer1",null);
        String timer2 = sp.getString("timer2",null);
//        String nineResult = sp.getString("9Timer",null);
//        String eightResult = sp.getString("8Timer",null);
//        String sevenResult = sp.getString("7Timer",null);
//        String sixResult = sp.getString("6Timer",null);
//        String fiveResult = sp.getString("5Timer",null);
//        String fourResult = sp.getString("4Timer",null);
//        String threeResult = sp.getString("3Timer",null);
//        String twoResult = sp.getString("2Timer",null);
//        String firstResult = sp.getString("firstTimer",null);

//        String etPassword=sp.getString("Password",null);
//        if(etUsername!= null&&etPassword!=null)
//        {
//            tvHello.setText("welcome " + etUsername);
//
//        }

        lastResult l1 = new lastResult(timer1,date.getCurrentDate());
        lastResult l2 = new lastResult(timer2,date.getCurrentDate());
        lastResult l3 = new lastResult("00",null);
        lastResult l4 = new lastResult("00",null);
        lastResult l5 = new lastResult("00",null);
        lastResult l6 = new lastResult("00",null);
        lastResult l7 = new lastResult("00",null);
        lastResult l8 = new lastResult("00",null);
        lastResult l9 = new lastResult("00",null);
        lastResult l10 = new lastResult("00",null);


        lastResultArrayList = new ArrayList<lastResult>();
        lastResultArrayList.add(l1);
        lastResultArrayList.add(l2);
//        lastResultArrayList.add(l3);
//        lastResultArrayList.add(l4); lastResultArrayList.add(l5); lastResultArrayList.add(l6);
//        lastResultArrayList.add(l7); lastResultArrayList.add(l8); lastResultArrayList.add(l9);
//        lastResultArrayList.add(l10);

        item_resultAdapter = new item_resultAdapter(this,0,0,lastResultArrayList);
        lv=(ListView) findViewById(R.id.lv);
        lv.setAdapter(item_resultAdapter);
    }
}