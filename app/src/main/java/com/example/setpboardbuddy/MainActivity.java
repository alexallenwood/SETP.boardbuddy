package com.example.setpboardbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent backLogin = new Intent(MainActivity.this, Login.class);                  //Executes the "back" intent and switches back to the MainActivity (menu)
    }

    public  void PlayMatchmaking(View view){
        Intent playMatchmaking = new Intent(MainActivity.this,PlayMatchmaking.class);   //Executes the "Play" intent and switches to the PlayMatchmaking activity
        startActivity(playMatchmaking);
    }

    public  void GroupEvents(View view){
        Intent groupEvents = new Intent(MainActivity.this,GroupEvents.class);           //Executes the "Group" intent and switches to the GroupEvents activity
        startActivity(groupEvents);
    }

    public  void Map(View view){
        Intent map = new Intent(MainActivity.this,LocationPermission.class);
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
