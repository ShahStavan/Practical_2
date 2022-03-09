package com.example.practical_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Practical_6 extends AppCompatActivity {
    EditText username;
    EditText password;
    TextView successText;
    Button login;
    int attempt = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical6);
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
                else if(attempt > 0 ){
                    if(username.getText().toString() != "Shah Stavan"){
                        username.setError("Invalid Username");
                        username.requestFocus();
                        Toast.makeText(getApplicationContext(),"Login Fail",Toast.LENGTH_LONG).show();
                    }
                    else{
                        password.setError("Invalid Password");
                        password.requestFocus();
                        Toast.makeText(getApplicationContext(),"Login Fail",Toast.LENGTH_LONG).show();
                        attempt = attempt - 1;
                        Toast.makeText(getApplicationContext(), "Attempts Left: " + String.valueOf(attempt),Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    login.setEnabled(false);
                }
            }
        });

    }
}