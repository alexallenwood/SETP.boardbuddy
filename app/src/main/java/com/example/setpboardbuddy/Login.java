package com.example.setpboardbuddy;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
    EditText Email, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);    //Sets the view for the activity


        Email = findViewById(R.id.inptEmail);       //Assigns the input boxes EditText names
        Password = findViewById(R.id.inptPassword);


    }


    public void Login(View view) throws InterruptedException {

        String email = Email.getText().toString();
        String password = Password.getText().toString();
        String type = "login";          //sets the type for the DatabaseHelper

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        databaseHelper.execute(type, email, password);          //Inputs the EditText values into the AsyncTask (DatabaseHelper)

    }


    public void Register (View view){
        Intent register = new Intent(Login.this, Register.class);
        startActivity(register);        //Starts the register activity when the "Register" button is pressed
    }

}
