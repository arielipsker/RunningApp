package com.arie.running_app;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondLevelActivity extends AppCompatActivity {

    ListView lvSecond;
    ArrayList<Week> secondLevel;
    ItemWeek itemWeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_level);

        Week t1 = new Week("Week 1", "run 3 km", "run 3 km", "run 3 km");
        Week t2 = new Week("Week 2", "run 4 km", "run 3 km", "run 3 km");
        Week t3 = new Week("Week 3", "run 4 km", "run 3 km", "run 4 km");

        secondLevel = new ArrayList<Week>();
        secondLevel.add(t1);
        secondLevel.add(t2);
        secondLevel.add(t3);

        itemWeek = new ItemWeek(this,0,0,secondLevel);
        lvSecond = (ListView) findViewById(R.id.lv_second);
        lvSecond.setAdapter(itemWeek);

    }
}