package com.arie.running_app;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class RunningProgramActivity extends AppCompatActivity implements OnClickListener{

    Button btnReturnToMenu,btnFirstLevel,btnSecondLevel,btnThirdLevel,btnInfinityLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_running_program);
        btnReturnToMenu = findViewById(R.id.btnReturn);
        btnReturnToMenu.setOnClickListener(this);
        btnSecondLevel = findViewById(R.id.btnSecond);
        btnSecondLevel.setOnClickListener(this);
        btnThirdLevel = findViewById(R.id.btnThird);
        btnThirdLevel.setOnClickListener(this);
        btnFirstLevel = findViewById(R.id.btnFirst);
        btnFirstLevel.setOnClickListener(this);
        btnInfinityLevel = findViewById(R.id.btnInfinity);
        btnInfinityLevel.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (v == btnReturnToMenu){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        if (v == btnFirstLevel){
            Intent intent = new Intent(this, FirstLevelActivity.class);
            startActivity(intent);
        }
        if (v == btnSecondLevel){
            Intent intent = new Intent(this, SecondLevelActivity.class);
            startActivity(intent);
        }
        if (v == btnThirdLevel){
            Intent intent = new Intent(this, ThirdLevelActivity.class);
            startActivity(intent);
        }
        if (v == btnInfinityLevel){
            Intent intent = new Intent(this, InfintyLevelActivity.class);
            startActivity(intent);
        }

    }
}