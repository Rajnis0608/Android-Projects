package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    android.widget.Button mCalculatebmi;
    TextView mCurrentHeight;
    TextView mCurrentWeight;
    TextView mCurrentAge;
    ImageView mIncrementAge,mIncrementWeight,mDecrementAge,mDecrementWeight;
    SeekBar mSeekbarForHeight;
    RelativeLayout mMale, mFemale;

    int intWeight = 55;
    int intAge = 22;
    int currentProgress;
    String mIntProgress = "170";
    String typeOfUser = "0";
    String weight2 = "55";
    String age2 = "22";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        mCalculatebmi = findViewById(R.id.calculateButton);
        mCurrentAge = findViewById(R.id.currentAge);
        mCurrentWeight = findViewById(R.id.currentWeight);
        mCurrentHeight = findViewById(R.id.currentHeight);
        mIncrementAge = findViewById(R.id.incrementAge);
        mDecrementAge = findViewById(R.id.decrementAge);
        mIncrementWeight = findViewById(R.id.incrementWeight);
        mDecrementWeight = findViewById(R.id.decrementWeight);
        mSeekbarForHeight = findViewById(R.id.seekbarForHeight);
        mMale = findViewById(R.id.male);
        mFemale = findViewById(R.id.female);

        mMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.gender_focus));
                mFemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.gender_notfocus));
                typeOfUser = "Male";
            }
        });

        mFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFemale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.gender_focus));
                mMale.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.gender_notfocus));
                typeOfUser = "Female";
            }
        });

        mSeekbarForHeight.setMax(300);
        mSeekbarForHeight.setProgress(170);
        mSeekbarForHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                currentProgress = i;
                mIntProgress = String.valueOf(currentProgress);
                mCurrentHeight.setText(mIntProgress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mIncrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intAge++;
                age2 = String.valueOf(intAge);
                mCurrentAge.setText(age2);
            }
        });

        mDecrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intAge--;
                age2 = String.valueOf(intAge);
                mCurrentAge.setText(age2);
            }
        });

        mIncrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intWeight++;
                weight2 = String.valueOf(intWeight);
                mCurrentWeight.setText(weight2);
            }
        });

        mDecrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intWeight--;
                weight2 = String.valueOf(intWeight);
                mCurrentWeight.setText(weight2);
            }
        });

        mCalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                if (typeOfUser.equals("0")){
                    Toast.makeText(getApplicationContext(), "Select Your Gender First", Toast.LENGTH_SHORT).show();
                }else if (mIntProgress == "0") {
                    Toast.makeText(getApplicationContext(), "Select Your Height", Toast.LENGTH_SHORT).show();
                }else if (intAge <= 0){
                    Toast.makeText(getApplicationContext(), "Invalid Age", Toast.LENGTH_SHORT).show();
                }else if (intWeight <= 0){
                    Toast.makeText(getApplicationContext(), "Invalid Weight", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(MainActivity.this, BMICalculation.class);
                    intent.putExtra("gender",typeOfUser);
                    intent.putExtra("height",mIntProgress);
                    intent.putExtra("weight",weight2);
                    intent.putExtra("age",age2);
                    startActivity(intent);
                }


            }
        });

    }
}