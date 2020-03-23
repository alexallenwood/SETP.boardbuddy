package com.example.setpboardbuddy;

import androidx.appcompat.app.AppCompatActivity;
import android.content.*;
import android.os.Bundle;
import android.view.View;

public class GroupEvents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_events);
    }

    public void BackBtn(View view){
        Intent myIntent = new Intent(GroupEvents.this, MainActivity.class);
        startActivity(myIntent);
    }

}