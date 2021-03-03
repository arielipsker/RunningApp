package com.arie.running_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Last10runs_Activity extends AppCompatActivity {
    ListView lv;
    ArrayList<lastResult> lastResultArrayList;
    item_resultAdapter item_resultAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last10runs);
        lastResult l1 = new lastResult(00,00);
        lastResult l2 = new lastResult(00,00);
        lastResult l3 = new lastResult(00,00);
        lastResult l4 = new lastResult(00,00);
        lastResult l5 = new lastResult(00,00);
        lastResult l6 = new lastResult(00,00);
        lastResult l7 = new lastResult(00,00);
        lastResult l8 = new lastResult(00,00);
        lastResult l9 = new lastResult(00,00);
        lastResult l10 = new lastResult(00,00);


        lastResultArrayList = new ArrayList<lastResult>();
        lastResultArrayList.add(l1); lastResultArrayList.add(l2); lastResultArrayList.add(l3);
        lastResultArrayList.add(l4); lastResultArrayList.add(l5); lastResultArrayList.add(l6);
        lastResultArrayList.add(l7); lastResultArrayList.add(l8); lastResultArrayList.add(l9);
        lastResultArrayList.add(l10);

        item_resultAdapter = new item_resultAdapter(this,0,0,lastResultArrayList);

        lv=(ListView) findViewById(R.id.lv);
        lv.setAdapter(item_resultAdapter);
    }
}