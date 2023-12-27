package com.example.myapplication;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    TextView result;
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

    }


    public void chooseGenderMale(View view) {
        gender = "MALE";
    }

    public void chooseGenderFemale(View view) {
        gender= "FEMALE";
    }

    public void calculateBMI(View view) {

        float heightIndex  , weightIndex;
        int ageIndex;

        heightIndex =  Integer.parseInt(height.getText().toString());
        weightIndex = Integer.parseInt( weight.getText().toString());
        ageIndex = Integer.parseInt(age.getText().toString());

        float bmi =  weightIndex / heightIndex;




    }
}