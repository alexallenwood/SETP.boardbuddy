package com.example.setpboardbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences bgSave = getSharedPreferences("bgColor", Context.MODE_PRIVATE);
        int colorBG = bgSave.getInt("backgroundColor", 0);
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(colorBG);

    }

    public  void PlayMatchmaking(View view){
        Intent playMatchmaking = new Intent(MainActivity.this,PlayMatchmaking.class);
        startActivity(playMatchmaking);
    }

    public  void GroupEvents(View view){
        Intent groupEvents = new Intent(MainActivity.this,GroupEvents.class);
        startActivity(groupEvents);
    }

    public  void Map(View view){
        Intent map = new Intent(MainActivity.this,Map.class);
        startActivity(map);
    }

    public  void Settings(View view){
        Intent settings = new Intent(MainActivity.this,Settings.class);
        startActivity(settings);
    }

    public  void Profile(View view){
        Intent profile = new Intent(MainActivity.this,Profile.class);
        startActivity(profile);
    }

    public  void MyMatches(View view){
        Intent myMatches = new Intent(MainActivity.this,MyMatches.class);
        startActivity(myMatches);
    }


}
