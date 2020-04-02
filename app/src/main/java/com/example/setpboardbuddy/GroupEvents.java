package com.example.setpboardbuddy;

import androidx.appcompat.app.AppCompatActivity;


import android.content.*;


import android.content.Context;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.view.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class GroupEvents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_events);


        //once page is created the shared preference which is referenced to in the settings is used as the background colour
        SharedPreferences bgSave = getSharedPreferences("bgColor", Context.MODE_PRIVATE);
        int colorBG = bgSave.getInt("backgroundColor", 0);
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(colorBG);

    }

    public void BackBtn(View view){
        Intent myIntent = new Intent(GroupEvents.this, MainActivity.class);
        startActivity(myIntent);
    }


        //For Sort_By drop down list//
        Spinner SortByGE = (Spinner) findViewById(R.id.sort_byGE);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(GroupEvents.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Sort_By_Events));

        //Giving drop down layout//
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SortByGE.setAdapter(myAdapter);
    }

    //For back button to function properly
    public  void Back(View view) {
        Intent MainActivity = new Intent(GroupEvents.this, MainActivity.class);
        startActivity(MainActivity);
    }


}
