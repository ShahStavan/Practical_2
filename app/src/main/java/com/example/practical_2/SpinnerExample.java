 package com.example.practical_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

 public class SpinnerExample extends AppCompatActivity {
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_example);
        spinner = findViewById(R.id.spinner);
    }
    public void showSpinner(View v){
        ArrayAdapter<String> names = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,
                new String[] {"Dev", "Stavan", "Tanmay", "Samarth"});
        spinner.setAdapter(names);
    }
}