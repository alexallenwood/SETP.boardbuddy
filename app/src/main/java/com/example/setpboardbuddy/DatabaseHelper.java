package com.example.setpboardbuddy;
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
import android.widget.Toast;                                                                        //Imports the content and widgets android/java requires


public class DatabaseHelper extends AsyncTask<String, Void, String> {
    Context context;
                                                                                                    //provides context for the following code - provides information from other parts of the program which are used in this activity / these classes

    Boolean login = false;                                                                          //Sets login and register booleans for later use
    Boolean register = false;


    DatabaseHelper(Context ctx) { //Constructor
        context = ctx;
        this.context = context.getApplicationContext();                                             //provides context for the following code - provides information from other parts of the program which are used in this activity / these classes
    }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String login_url = "http://???????/login.php";                                            //provides a connection to the localhost database, using the php files stored in the "www" folder in WAMP server
        String register_url = "http://?????/register.php";                                        //CHANGE THE "???????" to your IPV4 IP ADDRESS for the WAMP server to work and connect to the database (which is locally set up)


        if (type.equals("login")) {                                                                  //Determines if the Database helper should run the "login" code or the "register" code
            register = false;
            login = true;
            try {
                String email = params[1];                                                            //Inputs the email and password to match against the database under the following parameter numbers
                String password = params[2];

                URL url = new URL(login_url);                                                       //Gets a connection to the database from the PHP file
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");                                         //Uses POST to be able to identify the items in the PHP file
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));              //Writes an output stream to compare against the database
                String post_data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&"
                                 + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();                                                             //Flushes out the buffered writer
                bufferedWriter.close();
                outputStream.close();                                                               //Closes the streams

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

                String result = "";
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    result += line;                                                                 //Moves onto the next line in the database
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;                                                                        //Closes the readers

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();

            }

        } else if(type.equals("register")){                                                         //Determines if the Database helper should run the "register" code or the "login" code
            login = false;
            register = true;
            try {
                String name = params[1];                                                            //Inputs the name, surname, age, email, password and location of the user to register the user in the database
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

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));                       //Writes output stream to put into the database
                String post_data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&"
                                 + URLEncoder.encode("surname", "UTF-8") + "=" + URLEncoder.encode(surname, "UTF-8") + "&"
                                 + URLEncoder.encode("age", "UTF-8") + "=" + URLEncoder.encode(age, "UTF-8") + "&"
                                 + URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&"
                                 + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8") + "&"
                                 + URLEncoder.encode("latitude", "UTF-8") + "=" + URLEncoder.encode(latitude, "UTF-8") + "&"
                                 + URLEncoder.encode("longitude", "UTF-8") + "=" + URLEncoder.encode(longitude, "UTF-8");


                bufferedWriter.write(post_data);
                bufferedWriter.flush();                                                               //Flushes out the buffered writer
                bufferedWriter.close();
                outputStream.close();                                                                 //Closes the streams

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));

                String result = "";
                String line;                                                                            //Moves onto the next line in the database

                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;                                                                          //Closes the readers

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

        super.onPostExecute(result);                                                                 //After the AsyncTask has completed its work, this section allows the user access if the username and password are correct
        if (login == true){
            if (result.contains("true")) {
                CharSequence text = "Login Success";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                context.startActivity(new Intent(context, MainActivity.class));                       //Starts the activity if the login credentials are correct

            } else {
                CharSequence text = "User credentials not recognised.\nTry again or register as a user.";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        }

    }


    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);

    }

}

