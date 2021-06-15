package com.arie.running_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ThirdLevelActivity extends AppCompatActivity {

    ListView lvThird;
    ArrayList<Week> thirdLevel;
    ItemWeek itemWeek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_level);

        Week t1 = new Week("Week 1", "run 4 km", "run 4 km", "run 4 km");
        Week t2 = new Week("Week 2", "run 5 km", "run 4 km", "run 4 km");
        Week t3 = new Week("Week 3", "run 5 km", "run 4 km", "run 5 km");
        Week t4 = new Week("Week 4", "run 5 km", "run 5 km", "run 5 km");

        thirdLevel = new ArrayList<Week>();
        thirdLevel.add(t1);
        thirdLevel.add(t2);
        thirdLevel.add(t3);
        thirdLevel.add(t4);

        itemWeek = new ItemWeek(this,0,0,thirdLevel);
        lvThird = (ListView) findViewById(R.id.lv_third);
        lvThird.setAdapter(itemWeek);
    }
}