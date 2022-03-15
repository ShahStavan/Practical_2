package com.example.practical_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ContextMenuExample extends AppCompatActivity {
    ListView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu_example);
        view = findViewById(R.id.listView);
        view.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                new String[] {"Dev", "Stavan","Tanmay","Samarth"}));
        registerForContextMenu(view);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                showMessage("Home selected");
                return true;
            case R.id.about:
                showMessage("About Selected");
                return true;
            case R.id.services:
                showMessage("Services Selected");
                return true;
            case R.id.contact:
                showMessage("Contact selected");
                return true;
        }
        return false;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
    }
    public void showMessage(String str){
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}