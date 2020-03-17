package com.example.setpboardbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MyMatches extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_matches);
    }

    public  void MainActivity(View view) {
        Intent MainActivity = new Intent(MyMatches.this, MainActivity.class);
        startActivity(MainActivity);
    }
}
