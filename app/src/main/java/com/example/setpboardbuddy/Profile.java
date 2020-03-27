package com.example.setpboardbuddy;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;

import android.content.Context;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.view.View;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //once page is created the shared preference which is referenced to in the settings is used as the background colour
        SharedPreferences bgSave = getSharedPreferences("bgColor", Context.MODE_PRIVATE);
        int colorBG = bgSave.getInt("backgroundColor", 0);
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(colorBG);

    }


    //Back button to work properly
    public void BackBtn2(View view){
        Intent myIntent = new Intent(Profile.this, MainActivity.class);
        startActivity(myIntent);
    }

    //for edit profile button, which redirect to edit profile activity
    public void EditProfile(View view){
        Intent myIntent = new Intent(Profile.this, edit_profile.class);
        startActivity(myIntent);
    }


}
