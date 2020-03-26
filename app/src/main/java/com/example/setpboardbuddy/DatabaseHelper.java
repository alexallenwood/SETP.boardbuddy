package com.example.setpboardbuddy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;

import android.content.Intent;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import android.util.Log;
import android.widget.Toast;
import android.app.Activity;

public class DatabaseHelper extends AsyncTask<String, Void, String> {
    Context context;
    AlertDialog alertDialog;

    Boolean login = false;
    Boolean register = false;


    DatabaseHelper(Context ctx) { //Constructor
        context = ctx;
        this.context = context.getApplicationContext();
    }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String login_url = "http://192.168.0.47/login.php";
        String register_url = "http://192.168.0.47/register.php";


        if (type.equals("login")) {
            register = false;
            login = true;
            try {
                String email = params[1];
                String password = params[2];

                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&"
                                 + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

                String result = "";
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();

            }

        } else if(type.equals("register")){
            login = false;
            register = true;
            try {
                String name = params[1];
                String surname = params[2];
                String age = params[3];
                String email = params[4];
                String password = params[5];
                String latitude = params[6];
                String longitude = params[7];



                URL url = new URL(register_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&"
                                 + URLEncoder.encode("surname", "UTF-8") + "=" + URLEncoder.encode(surname, "UTF-8") + "&"
                                 + URLEncoder.encode("age", "UTF-8") + "=" + URLEncoder.encode(age, "UTF-8") + "&"
                                 + URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&"
                                 + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8") + "&"
                                 + URLEncoder.encode("latitude", "UTF-8") + "=" + URLEncoder.encode(latitude, "UTF-8") + "&"
                                 + URLEncoder.encode("longitude", "UTF-8") + "=" + URLEncoder.encode(longitude, "UTF-8");


                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

                String result = "";
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();

            }

    }



        return null;
    }

    @Override
    protected void onPostExecute(String result) {

        super.onPostExecute(result);
        if (login == true){
            if (result.contains("true")) {
                CharSequence text = "Login Success";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                context.startActivity(new Intent(context, MainActivity.class));

            } else {
                CharSequence text = "User credentials not recognised.\nTry again or register as a user.";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        }

    }


    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Status");

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);

    }

}

