package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BMICalculation extends AppCompatActivity {

    android.widget.Button mrecalculateBmi;

    TextView mBMIDisplay,mBMICategory,mGender;
    Intent intent;
    ImageView mImageView;
    String mBMI;
    float intBMI;

    String height;
    String weight;
    float intHeight,intWeight;
    RelativeLayout mBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalculation);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color =\" white \"></font>"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1e1d1d"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        intent = getIntent();

        mBMIDisplay = findViewById(R.id.bmidisplay);
        mBMICategory = findViewById(R.id.bmicategory);
        mGender = findViewById(R.id.genderDisplay);
        mBackground = findViewById(R.id.contentLayout);
        mImageView = findViewById(R.id.reult);

        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");

        intHeight = Float.parseFloat(height);
        intWeight = Float.parseFloat(weight);
        intHeight /= 100;
        intBMI = intWeight/(intHeight*intHeight);

        mBMI = Float.toString(intBMI);

        if(intBMI < 16){
            mBMICategory.setText("Severe Thinness");
            mBackground.setBackgroundColor(getResources().getColor(R.color.cross));
            mImageView.setImageResource(R.drawable.crosss);
        }else if(intBMI < 16.9){
            mBMICategory.setText("Moderate Thinness");
            mBackground.setBackgroundColor(getResources().getColor(R.color.warning));
            mImageView.setImageResource(R.drawable.warning);
        }else if (intBMI < 18.4){
            mBMICategory.setText("Mild Thinness");
            mBackground.setBackgroundColor(getResources().getColor(R.color.warning));
            mImageView.setImageResource(R.drawable.warning);
        }else if(intBMI < 25){
            mBMICategory.setText("Normal");
            mBackground.setBackgroundColor(getResources().getColor(R.color.ok));
            mImageView.setImageResource(R.drawable.ok);
        }else if(intBMI < 29.4 ){
            mBMICategory.setText("Overweight");
            mBackground.setBackgroundColor(getResources().getColor(R.color.warning));
            mImageView.setImageResource(R.drawable.warning);
        }else {
            mBMICategory.setText("Obesity");
            mBackground.setBackgroundColor(getResources().getColor(R.color.cross));
            mImageView.setImageResource(R.drawable.crosss);
        }

        mGender.setText(intent.getStringExtra("gender"));
        mBMIDisplay.setText(mBMI);

        mrecalculateBmi = findViewById(R.id.recalculateBmi);

        mrecalculateBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BMICalculation.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}