package com.example.myapplication;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    TextView result, resultText ,button;
    String gender = "";
    EditText age, height , weight;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.bmi_index);
        age =  (EditText)findViewById(R.id.age);
        height =  (EditText)findViewById(R.id.height);
        weight = (EditText)findViewById(R.id.weight);
        resultText = (TextView)findViewById(R.id.bmi_title);
        button =  (TextView) findViewById(R.id.btn);
    }


    public void chooseGenderMale(View view) {
        gender = "MALE";

    }

    public void chooseGenderFemale(View view) {
        gender= "FEMALE";
    }



    public void calculateBMI(View view) {

        float heightIndex  , weightIndex,convertHeight;
        String ageIndex;


        convertHeight = Integer.parseInt(height.getText().toString());
        heightIndex = convertHeight / 100;
        weightIndex = Integer.parseInt( weight.getText().toString());
        ageIndex = age.getText().toString();

        float bmi =  weightIndex /( heightIndex * heightIndex ) ;
        String bmiResult =  String.format("%.1f", bmi);

        if(height.getText().toString().matches(" ")  ||  weight.getText().toString().matches(" ") ) {
            Log.d(TAG, "blank");
            Toast.makeText( this, "Fields cannot to blank", Toast.LENGTH_SHORT).show();
        } else if(bmi < 18.5) {
            resultText.setText("Thin");
            resultText.setTextColor(getResources().getColor(R.color.bmi_thin_color));
            result.setText(bmiResult);
        }
        else if (bmi < 24.9) {
            resultText.setText("Normal");
            resultText.setTextColor(getResources().getColor(R.color.bmi_title_color));
            result.setText(bmiResult);
        } else if (bmi < 29.9) {
            resultText.setText("Weight gain");
            resultText.setTextColor(getResources().getColor(R.color.bmi_big_color));
            result.setText(bmiResult);
        } else if (bmi < 34.9) {
            resultText.setText("Obesity level 1");
            resultText.setTextColor(getResources().getColor(R.color.bmi_fat_color));
            result.setText(bmiResult);
        }
        else if (bmi < 39.9 ) {
            resultText.setText("Obesity level 2");
            resultText.setTextColor(getResources().getColor(R.color.bmi_fat_2_color));
            result.setText(bmiResult);
        }
        else {
            resultText.setText("Obesity level 3");
            resultText.setTextColor(getResources().getColor(R.color.bmi_fat_3_color));
            result.setText(bmiResult);
        }

    }
}