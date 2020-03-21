package com.example.setpboardbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.widget.Button;

public class Login extends AppCompatActivity {
    EditText Username, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Password = findViewById(R.id.inptPassword);
        Username = findViewById(R.id.inptEmail);

    }


    public void Login(View view) throws InterruptedException {

        String username = Username.getText().toString();
        String password = Password.getText().toString();
        String type = "login";

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        databaseHelper.execute(type, username, password);

    }



    public void Register (View view){
        Intent register = new Intent(Login.this, Register.class);
        startActivity(register);
    }

}
