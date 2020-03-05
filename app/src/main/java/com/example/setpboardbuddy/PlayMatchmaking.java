package com.example.setpboardbuddy;

import androidx.annotation.ArrayRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;



public class PlayMatchmaking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_matchmaking);

        Spinner mySpinner = (Spinner) findViewById(com.example.setpboardbuddy.R.id.SpinnerSort);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(PlayMatchmaking.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.PlayViewSort));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

    }

    public  void Back(View view){
        Intent playMatchmaking = new Intent(PlayMatchmaking.this, MainActivity.class);
        startActivity(playMatchmaking);
    }



}
