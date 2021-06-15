package com.arie.running_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FirstLevelActivity extends AppCompatActivity {

    ListView lvProgram;
    ArrayList<Week> firstLevel;
    ItemWeek itemWeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_level2);

        Week t1 = new Week("Week 1", "run 3 km", "run 2 km", "run 2 km");
        Week t2 = new Week("Week 2", "run 3 km", "run 2 km", "run 3 km");
        Week t3 = new Week("Week 3", "run 3 km", "run 3 km", "run 3 km");

        firstLevel = new ArrayList<Week>();
        firstLevel.add(t1);
        firstLevel.add(t2);
        firstLevel.add(t3);


        itemWeek = new ItemWeek(this,0,0,firstLevel);
        lvProgram = (ListView) findViewById(R.id.lv_program);
        lvProgram.setAdapter(itemWeek);
    }
}