package com.example.setpboardbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class edit_profile extends AppCompatActivity {
    private static final int RESULT_LOAD_IMAGE = 1;
    private EditText newUsername;
    private EditText newShortBio;
    private EditText newPassword;
    private EditText newCPassword;
    private String Uname;
    private String shortBio;
    private String Pword;
    private String CPword;
    private ImageView profilePic;
    ImageView imageToUpload;
    Button save;

    private static final String url = "jdbc:mysql://10.0.2.2/boardbuddydb";
    private static final String user = "root";
    private static final String pass = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        profilePic = (ImageView) findViewById(R.id.profilePic);
        profilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.profilePic:
                        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);
                        break;

                }
            }


            protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                edit_profile.super.onActivityResult(requestCode, resultCode, data);
                if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data != null) {
                    Uri selectedImage = data.getData();
                    imageToUpload.setImageURI(selectedImage);
                }
            }

        });
        newUsername = findViewById(R.id.enterUsrname);
        newShortBio = findViewById(R.id.enterShortBio);
        newPassword = findViewById(R.id.enterPword2);
        newCPassword = findViewById(R.id.enterCPword);
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
        if(Uname.isEmpty()||Uname.length()>20) {
            newUsername.setError("Please enter valid name");
            valid = false; //Return true if username is valid and false if password is invalid.
        }
        if(Pword.isEmpty()||Pword.length()>20) {
            newUsername.setError("Please enter valid password");
            valid = false; //Return true if password is valid and false if password is invalid.
        }
        if (shortBio.isEmpty() || shortBio.length()>20) {
            newShortBio.setError("Please enter a short biography");
            valid = false; //Return true if short bio is valid and false if password is invalid.
        }
        if (CPword.isEmpty() || CPword.length()>20) {
            newCPassword.setError("Please try again and confirm password");
            valid = false; //Return true if confirm password is valid and false if password is invalid.
            if (!newPassword.equals(newCPassword)) {
                Toast.makeText(edit_profile.this, "Password do not match", Toast.LENGTH_SHORT).show();
            }
        }
        return valid;

    }

    private void initialize() {
        Uname = newUsername.getText().toString().trim();
        shortBio = newShortBio.getText().toString().trim();
        Pword = newPassword.getText().toString().trim();
        CPword = newCPassword.getText().toString().trim();

    }

    public void BackBtn3(View view){
        Intent myIntent = new Intent(edit_profile.this, Profile.class);
        startActivity(myIntent);
    }



}
