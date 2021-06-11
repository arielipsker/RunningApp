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
            if (bmi<20){
                bmiLabel = getString(R.string.very_severely_underweight);
            }

//            if (Float.compare(bmi, 15f) <= 0) {
//                bmiLabel = getString(R.string.very_severely_underweight);
//            } else if (Float.compare(bmi, 15f) > 0  &&  Float.compare(bmi, 16f) <= 0) {
//                bmiLabel = getString(R.string.severely_underweight);
//            } else if (Float.compare(bmi, 16f) > 0  &&  Float.compare(bmi, 18.5f) <= 0) {
//                bmiLabel = getString(R.string.underweight);
//            } else if (Float.compare(bmi, 18.5f) > 0  &&  Float.compare(bmi, 25f) <= 0) {
//                bmiLabel = getString(R.string.normal);
//            } else if (Float.compare(bmi, 25f) > 0  &&  Float.compare(bmi, 30f) <= 0) {
//                bmiLabel = getString(R.string.overweight);
//            } else if (Float.compare(bmi, 30f) > 0  &&  Float.compare(bmi, 35f) <= 0) {
//                bmiLabel = getString(R.string.obese_class_i);
//            } else if (Float.compare(bmi, 35f) > 0  &&  Float.compare(bmi, 40f) <= 0) {
//                bmiLabel = getString(R.string.obese_class_ii);
//            } else {
//                bmiLabel = getString(R.string.obese_class_iii);
//            }

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
