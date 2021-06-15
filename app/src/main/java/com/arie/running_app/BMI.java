package com.arie.running_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BMI extends AppCompatActivity implements View.OnClickListener {

    private EditText etHeight;
    private EditText etWeight;
    private TextView tvResult;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        etHeight = (EditText) findViewById(R.id.etHeight);
        etWeight = (EditText) findViewById(R.id.etWeight);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(this);
    }


        private void displayBMI(float bmi){
            String bmiLabel = "";
            if (bmi<15){
                bmiLabel = "very_severely_underweight";
            }
            else if (bmi<16 && bmi>15){
                bmiLabel = "severely_underweight";
            }
            else if (bmi<18.5 && bmi>16){
                bmiLabel = "underweight";
            }
            else if (bmi<25 && bmi>18.5){
                bmiLabel = "normal";
            }
            else if (bmi<30 && bmi>25){
                bmiLabel = "overweight";
            }
            else if (bmi<35 && bmi>30){
                bmiLabel = "severely_overweight";
            }
            else if (bmi>35){
                bmiLabel = "very_severely_overweight";
            }


            bmiLabel = bmi + "\n\n" + bmiLabel;
            tvResult.setText(bmiLabel);
        }

    @Override
    public void onClick(View v) {
        if (v == btnCalculate){
            String heightStr = etHeight.getText().toString();
            String weightStr = etWeight.getText().toString();

            if (heightStr != null && !"".equals(weightStr) && weightStr != null && !"".equals(weightStr)) {
                float heightValue = Float.parseFloat(heightStr) / 100;
                float weightValue = Float.parseFloat(weightStr);

                float bmi = weightValue / (heightValue * heightValue);

                displayBMI(bmi);
            }
        }
    }
}
