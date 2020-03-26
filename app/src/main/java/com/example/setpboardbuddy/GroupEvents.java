package com.example.setpboardbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GroupEvents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_events);
    }
    public  void Back(View view) {
        Intent MainActivity = new Intent(GroupEvents.this, MainActivity.class);
        startActivity(MainActivity);
    }

}
