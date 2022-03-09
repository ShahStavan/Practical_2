package com.example.practical_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Practical_5 extends AppCompatActivity {
    EditText username;
    EditText password;
    TextView successText;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical5);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.button);
        successText = findViewById(R.id.s_text);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(username.getText().toString() == "Shah Stavan" && password.getText().toString() == "stavan098"){
                    successText.setText("Login Successful");
                }
                else{
                    login.setEnabled(false);
                    Toast.makeText(getApplicationContext(),"Login Fail",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}