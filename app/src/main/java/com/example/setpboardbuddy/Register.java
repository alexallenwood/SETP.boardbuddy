package com.example.setpboardbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    boolean Register = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void Register(View view) {
        if (Register = true) {
            CharSequence text = "User registered!\nPlease log in using your credentials.";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(Register.this, text, duration);
            toast.show();
            Intent registerUser = new Intent(Register.this,Login.class);
            startActivity(registerUser);
        }
    }
}