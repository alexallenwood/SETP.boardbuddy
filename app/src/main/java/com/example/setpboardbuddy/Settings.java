package com.example.setpboardbuddy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {
    //defining variables
    TextView txt;
    Button b1, b2, b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // initialises the background colour for all activities screen before colourblind mode button presses
        int Bcolor = Color.parseColor("#FFFFFF");
        View view = Settings.this.getWindow().getDecorView();
        view.setBackgroundColor(Bcolor);
        SharedPreferences bgSave = Settings.this.getSharedPreferences("bgColor", Context.MODE_PRIVATE);
        SharedPreferences.Editor bgeditor = bgSave.edit();
        bgeditor.putInt("backgroundColor", Bcolor);
        bgeditor.apply();

        // setting variables to the appropriate buttons and text ID (b1 = 1st button)
        txt = (TextView) findViewById(R.id.textView);
        b1 = (Button) findViewById(R.id.btnCBMode);
        b2 = (Button) findViewById(R.id.btnTxtSize);
        b3 = (Button) findViewById(R.id.btnNightMode);


        //checks if button colourblind button(b1) has been clicked
            b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Bcolor = Color.parseColor("#236B8E");
                int Tcolor = Color.parseColor("#FFA500");
                View view = Settings.this.getWindow().getDecorView();
                view.setBackgroundColor(Bcolor);
                txt.setTextColor(Tcolor);
                b1.setBackgroundColor(Tcolor);
                b2.setBackgroundColor(Tcolor);
                b3.setBackgroundColor(Tcolor);
                SharedPreferences bgSave = Settings.this.getSharedPreferences("bgColor", Context.MODE_PRIVATE);
                //SharedPreferences txtSave = Settings.this.getSharedPreferences("txtColor", Context.MODE_PRIVATE);
                //SharedPreferences.Editor txteditor = txtSave.edit();
                SharedPreferences.Editor bgeditor = bgSave.edit();
                bgeditor.putInt("backgroundColor", Bcolor);
                bgeditor.apply();
                //txteditor.putInt("textColor", Bcolor);
                //txteditor.apply();
            }

            //   b1.setBackgroundColor(Color.parseColor("#236B8E"));
            //   b2.setBackgroundColor(Color.parseColor("#236B8E"));
            // txt.setTextColor(Color.parseColor("#FFA500"));
        });

    }


}




