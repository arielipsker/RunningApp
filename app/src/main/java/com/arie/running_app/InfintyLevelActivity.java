package com.arie.running_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InfintyLevelActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnReturnMenu, btnReturnProgram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infinty_level);
        btnReturnMenu = findViewById(R.id.btnReturnToMenu1);
        btnReturnMenu.setOnClickListener(this);
        btnReturnProgram = findViewById(R.id.btnReturnToRunningProgram);
        btnReturnProgram.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == btnReturnMenu){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        if (v == btnReturnProgram){
            Intent intent = new Intent(this, RunningProgramActivity.class);
            startActivity(intent);
        }

    }
}