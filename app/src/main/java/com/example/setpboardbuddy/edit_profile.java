package com.example.setpboardbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class edit_profile extends AppCompatActivity {

    private EditText newUsername;
    private EditText newShortBio;
    private EditText newPassword;
    private String Uname;
    private String shortBio;
    private String Pword;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        newUsername = findViewById(R.id.enterUsrname);
        newShortBio = findViewById(R.id.enterShortBio);
        newPassword = findViewById(R.id.enterPword);
        save = (Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(); // call when the button is clicked to validate the input.
            }
        });

    }

    public void save(){
        initialize(); //initialize the input to string variables.
        if (!validate()){
            Toast.makeText(this, "Your details are invalid, please check and try again", Toast.LENGTH_SHORT).show();
        }
        else {
            onEnterSuccess();
        }
    }

    private void onEnterSuccess() {
        //TODO what will go after the valid input
    }
    public boolean validate(){
        boolean valid = true;
        if(Uname.isEmpty()||Uname.length()>30) {
            newUsername.setError("Please enter valid name");
            valid = false;
        }
        if(Pword.isEmpty()||Pword.length()>30) {
            newUsername.setError("Please enter valid password");
            valid = false;
        }
        if (shortBio.isEmpty() || shortBio.length()>30) {
            newShortBio.setError("Please enter a short biography");
            valid = false;
        }
        return valid;

    }

    private void initialize() {
        Uname = newUsername.getText().toString().trim();
        shortBio = newShortBio.getText().toString().trim();
        Pword = newPassword.getText().toString().trim();

    }

}
