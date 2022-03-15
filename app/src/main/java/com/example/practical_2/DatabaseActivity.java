package com.example.practical_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practical_2.utils.DbHelper;

public class DatabaseActivity extends AppCompatActivity {
    EditText roll_no_edit, name_edit;
    String roll_no, name;
    DbHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        roll_no_edit = findViewById(R.id.roll_no);
        name_edit = findViewById(R.id.name);
        helper = new DbHelper(this);
    }
    public void insert(View v){
        setData();
        boolean success = helper.insertStudent(roll_no, name);
        if(success){
            showMessage("Inserted");
            return;
        }
        showMessage("Not inserted");
    }
    public void update(View v){
        setData();
        boolean success = helper.updateStudent(roll_no, name);
        if(success){
            showMessage("Updated");
            return;
        }
        showMessage("Not updated");
    }
    public void delete(View v){
        setData();
        boolean success = helper.deleteStudent(roll_no);
        if(success){
            showMessage("Deleted");
            return;
        }
        showMessage("Not deleted");
    }
    public void viewData(View v){
        setData();
        Cursor cursor = helper.getAllData();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Data").setMessage(msg).create().show();
    }
    public void setData(){
       roll_no = roll_no_edit.getText().toString();
       name = name_edit.getText().toString();
    }
    public void showMessage(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}