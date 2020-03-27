package com.example.setpboardbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    boolean Approved = false;
    public EditText Username;
    public EditText Password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Password = findViewById(R.id.inptPassword);
        Username = findViewById(R.id.inptEmail);

    }

    public void Login(View view) {
        Intent login = new Intent(Login.this, MainActivity.class);
        if (Username.getText().toString().equals("test")) {
            Password.setText("test");
            Approved = true;
        }
        else {
            CharSequence text = "User credentials not recognised.\nTry again or register as a user.";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(Login.this, text, duration);
            toast.show();
        }
        if (Approved == true){
            startActivity(login);
        }
    }

    public void Register (View view){
        Intent register = new Intent(Login.this, Register.class);
        startActivity(register);
    }
}
