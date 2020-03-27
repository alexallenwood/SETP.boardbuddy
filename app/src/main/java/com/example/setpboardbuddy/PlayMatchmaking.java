package com.example.setpboardbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class PlayMatchmaking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_matchmaking);
        SharedPreferences bgSave = getSharedPreferences("bgColor", Context.MODE_PRIVATE);
        int colorBG = bgSave.getInt("backgroundColor", 0);
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(colorBG);
    }
}
