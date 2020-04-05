package com.example.setpboardbuddy;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class MyMatches extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_matches);


        //once page is created the shared preference which is referenced to in the settings is used as the background colour
        SharedPreferences bgSave = getSharedPreferences("bgColor", Context.MODE_PRIVATE);
        int colorBG = bgSave.getInt("backgroundColor", 0);
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(colorBG);


        //For Sort_By drop down list//
        Spinner SortBy = (Spinner) findViewById(R.id.Sort_by);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MyMatches.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Sort_By_Itms));

        //Giving drop down layout//
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SortBy.setAdapter(myAdapter);

        //Sort actions//
        SortBy.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    //For back button to function properly//
    public  void MainActivity(View view) {
        Intent MainActivity = new Intent(MyMatches.this, MainActivity.class);
        startActivity(MainActivity);

    }



}
