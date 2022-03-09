package com.example.practical_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Practical_10 extends AppCompatActivity {
    EditText num1;
    EditText num2;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical10);
        Bundle extras = new Bundle();
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        send = findViewById(R.id.button2);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Practical_10_add.class);
                i.putExtra("Num1",num1.getText());
                i.putExtra("Num2",num2.getText());
                startActivity(i);
            }
        });

    }
}