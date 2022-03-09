package com.example.practical_2;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Practical_10_add extends AppCompatActivity {
    TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical10_add);
        Bundle extras = getIntent().getExtras();
        answer = findViewById(R.id.answer);
        int num1 = getIntent().getIntExtra("Num1",0);
        int num2 = getIntent().getIntExtra("Num2",0);
        int add = num1 + num2;
        answer.setText("Sum:" + add);
    }
}