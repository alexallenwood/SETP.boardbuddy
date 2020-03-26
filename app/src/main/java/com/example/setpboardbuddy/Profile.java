package com.example.setpboardbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void BackBtn2(View view){
        Intent myIntent = new Intent(Profile.this, MainActivity.class);
        startActivity(myIntent);
    }

    public void EditProfile(View view){
        Intent myIntent = new Intent(Profile.this, edit_profile.class);
        startActivity(myIntent);
    }


}
