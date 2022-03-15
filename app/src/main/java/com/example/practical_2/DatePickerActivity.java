package com.example.practical_2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import android.icu.util.Calendar;

public class DatePickerActivity extends AppCompatActivity {
    DatePicker picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);
        picker = findViewById(R.id.datepicker);
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void showDate(View v){
        String date = picker.getDayOfMonth() + "/" + (picker.getMonth() + 1) + "/" + picker.getYear();
        Toast.makeText(this, date, Toast.LENGTH_SHORT).show();
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(calendar.DAY_OF_MONTH);
        int month = calendar.get(calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        DatePickerDialog dialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        Toast.makeText(getApplicationContext(), "Day: " + datePicker.getDayOfMonth() + "/" + (datePicker.getMonth() + 1) + "/" + datePicker.getYear(), Toast.LENGTH_SHORT).show();
                    }
                }, year, month, day
        );
        dialog.show();
    }
}