package com.arie.running_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

SharedPreferences sp;
Dialog dialog;
Button button_dialog, btnLogin, botton_lastRuns;
EditText etUsername, etPassword;
TextView tvHello;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = getSharedPreferences("details1",0);
        button_dialog = findViewById(R.id.button_dialog);
        button_dialog.setOnClickListener(this);
        botton_lastRuns = findViewById(R.id.botton_lastRuns);
        botton_lastRuns.setOnClickListener(this);
        tvHello=findViewById(R.id.tvHello);
        String etUsername = sp.getString("Username",null);
        String etPassword=sp.getString("Password",null);
        if(etUsername!= null&&etPassword!=null)
        {
            tvHello.setText("welcome1 " + etUsername);

        }
        running = false;

    }

    public void btnStart(View view) {
        Intent intent = new Intent(this, startRunningActivity.class);
        startActivity(intent);
        if (!running) {
            Intent serivceIntent = new Intent(this,StopwatchService.class);
            startService(serivceIntent);
            running = true;
        }
    }

    @Override
    public void onClick(View v) {
        if(v==button_dialog)
        {
            dialog = new Dialog(this);
            dialog.setContentView(R.layout.login_dialog);
            etUsername = dialog.findViewById(R.id.etUserName);
            etPassword = dialog.findViewById(R.id.etPassword);
            btnLogin = dialog.findViewById(R.id.btnLogin);
            btnLogin.setOnClickListener(this);
            dialog.show();

        }
        if(v == btnLogin){
            dialog.dismiss();
        }
        if(btnLogin==v)
        {
            SharedPreferences.Editor editor=sp.edit();
            editor.putString("Username",etUsername.getText().toString());
            editor.putString("Password",etPassword.getText().toString());
            editor.commit();
        }
        if(v==botton_lastRuns){
            Intent intent = new Intent(this, Last10runs_Activity.class);
            startActivity(intent);
        }
    }
}