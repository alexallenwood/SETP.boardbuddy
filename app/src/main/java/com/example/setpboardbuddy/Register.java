package com.example.setpboardbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

public class Register extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText name, surname, age, email, password, latitude, longitude;
    boolean Register = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

//        Spinner spinner = (Spinner)findViewById(R.id.spinner);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.boardgames, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//        spinner.setOnItemSelectedListener(this);

        name = (EditText) findViewById(R.id.inptForenameReg);       //Gives each input box EditText names for the contents to later be converted to String
        surname = (EditText) findViewById(R.id.inptSurnameReg);
        age = (EditText) findViewById(R.id.inptAgeReg);
        email = (EditText) findViewById(R.id.inptEmailReg);
        password = (EditText) findViewById(R.id.inptPassReg);
        latitude = (EditText) findViewById(R.id.latitudeReg);
        longitude = (EditText) findViewById(R.id.longitudeReg);


//         String strLongitude = Location.convert(mLastKnownLocation.getLongitude(), Location.FORMAT_DEGREES);
//         String strLatitude = Location.convert(mLastKnownLocation.getLatitude(), Location.FORMAT_DEGREES);
//
//        EditText latitudeReg = findViewById(R.id.latitudeReg);
//        EditText longitudeReg = findViewById(R.id.longitudeReg);
//        latitudeReg.setText("yes");
//        longitudeReg.setText("no");
    }

     @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }


    public void Register(View view) {

        String str_name = name.getText().toString();        //Converts all of the inputs into strings so the DatabaseHelper can read the values
        String str_surname = surname.getText().toString();
        String str_age = age.getText().toString();
        String str_email = email.getText().toString();
        String str_password = password.getText().toString();
        String str_latitude = latitude.getText().toString();
        String str_longitude = longitude.getText().toString();


        String type = "register";       //Sets the type for the database worker

        DatabaseHelper databaseHelper = new DatabaseHelper(this);       //Sends the values to the AsyncTask (DatabaseHelper)
        databaseHelper.execute(type, str_name, str_surname, str_age, str_email, str_password, str_latitude, str_longitude);


        if (Register = true) {          //Lets the user know if their credentials have been registered
            CharSequence text = "User registered!\nPlease log in using your credentials.";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(Register.this, text, duration);        //Shows the string in a Toast notification
            toast.show();
            Intent registerUser = new Intent(Register.this,Login.class);
            startActivity(registerUser);    //Sends the user back to the login page
        }


    }


}
