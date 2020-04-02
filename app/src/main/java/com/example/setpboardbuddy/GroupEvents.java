package com.example.setpboardbuddy;

import androidx.appcompat.app.AppCompatActivity;

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
