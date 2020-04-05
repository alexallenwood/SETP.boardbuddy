package com.example.setpboardbuddy;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.Calendar;
import java.util.Date;

public class PlayMatchmaking extends AppCompatActivity{
    private static final String url = "jdbc:mysql://10.0.2.2/boardbuddydb";
    private static final String user = "root";
    private static final String pass = "";
    private TextView firstName, locationlat, locationlong, firstName2, locationlat2, locationlong2, firstName3, locationlat3, locationlong3;
    private TextView game;
    Context context;                                                                                    //provides context for the following code - provides information from other parts of the program which are used in this activity / these classes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_matchmaking);

        firstName = findViewById(R.id.txtName);                                                         //Converts the contents of the boxes to TextViews for later use
        locationlat = findViewById(R.id.txtLatitude);
        locationlong = findViewById(R.id.txtLongitude);

        firstName2 = findViewById(R.id.txtName2);
        locationlat2 = findViewById(R.id.txtLatitude2);
        locationlong2 = findViewById(R.id.txtLongitude2);

        firstName3 = findViewById(R.id.txtName3);
        locationlat3 = findViewById(R.id.txtLatitude3);
        locationlong3 = findViewById(R.id.txtLongitude3);

        new MyTask().execute();


//        Spinner mySpinner = (Spinner) findViewById(com.example.setpboardbuddy.R.id.SpinnerSort);
//        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(PlayMatchmaking.this,
//                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.PlayViewSort));
//        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        mySpinner.setAdapter(myAdapter);

        //once page is created the shared preference which is referenced to in the settings is used as the background colour
        SharedPreferences bgSave = getSharedPreferences("bgColor", Context.MODE_PRIVATE);
        int colorBG = bgSave.getInt("backgroundColor", 0);
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(colorBG);

        String[] array1 = getResources().getStringArray(R.array.games_array);                           //Randomises the game to be chosen for the PlayMatchmaking from the string array
        String strGame1 = array1[new Random().nextInt(array1.length)];
        ((TextView) findViewById(R.id.txtGame1)).setText(strGame1);

        String[] array2 = getResources().getStringArray(R.array.games_array);                           //Randomises the game to be chosen for the PlayMatchmaking from the string array
        String strGame2 = array2[new Random().nextInt(array2.length)];
        ((TextView) findViewById(R.id.txtGame2)).setText(strGame2);

        String[] array3 = getResources().getStringArray(R.array.games_array);                           //Randomises the game to be chosen for the PlayMatchmaking from the string array
        String strGame3 = array3[new Random().nextInt(array3.length)];
        ((TextView) findViewById(R.id.txtGame3)).setText(strGame3);

        Calendar cal1 = Calendar.getInstance();                                                          // creates the calendar
        cal1.setTime(new Date());                                                                        // sets the time for the calendar
        cal1.add(Calendar.HOUR_OF_DAY, 1);                                                       // adds one hour to the calendar time for the matchmaking component
        cal1.getTime();
        ((TextView) findViewById(R.id.txttime1)).setText("" + String.format("%1$tA %1$tb %1$td at %1$tI:%1$tM %1$Tp", cal1));       //Formats the time

        Calendar cal2 = Calendar.getInstance(); // creates calendar cal
        cal2.setTime(new Date()); // sets calendar time or date
        cal2.add(Calendar.HOUR_OF_DAY, 2); // adds one hour to the time
        cal2.getTime();
        ((TextView) findViewById(R.id.txttime2)).setText("" + String.format("%1$tA %1$tb %1$td at %1$tI:%1$tM %1$Tp", cal2));       //Formats the time

        Calendar cal3 = Calendar.getInstance(); // creates calendar cal
        cal3.setTime(new Date()); // sets calendar time or date
        cal3.add(Calendar.HOUR_OF_DAY, 3); // adds one hour to the time
        cal3.getTime();
        ((TextView) findViewById(R.id.txttime3)).setText("" + String.format("%1$tA %1$tb %1$td at %1$tI:%1$tM %1$Tp", cal3));       //Formats the time

    }

    public void Back(View view) {
        Intent playMatchmaking = new Intent(PlayMatchmaking.this, MainActivity.class);  //Sends the user back to the MainActivity
        startActivity(playMatchmaking);

    }

    public void ConfirmMatch1(View view) {
        Intent confirmMatch1 = new Intent(getApplicationContext(), PopActivity1.class);     //Confirms the match - starts the Popup activity
        startActivity(confirmMatch1);
    }

    public void ConfirmMatch2(View view) {
        Intent confirmMatch2 = new Intent(getApplicationContext(), PopActivity2.class);     //Confirms the match - starts the Popup activity
        startActivity(confirmMatch2);
    }

    public void ConfirmMatch3(View view) {
        Intent confirmMatch3 = new Intent(getApplicationContext(), PopActivity3.class);     //Confirms the match - starts the Popup activity
        startActivity(confirmMatch3);
    }

    private class MyTask extends AsyncTask<Void, Void, Void>{
        private String Name="", latitude="", longitude="", Name2="", latitude2="", longitude2="", Name3="", latitude3="", longitude3="";        //Defines the strings
        @Override
        protected Void doInBackground(Void... arg0){

            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, pass);

                Statement st = con.createStatement();                                                   //Allows a statement to be passed as an SQL query

                final ResultSet rs = st.executeQuery("select * from users where id = 2");
                rs.next();
                Name = rs.getString(2);
                latitude = rs.getString(7);                                              //Grabs data from the database for the PlayMatchmaking match, setting these Strings to database values
                longitude = rs.getString(8);

            }
            catch(Exception e){
                e.printStackTrace();
            }

            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, pass);

                Statement st = con.createStatement();                                                   //Allows a statement to be passed as an SQL query


                final ResultSet rs = st.executeQuery("select * from users where id = 3");
                rs.next();
                Name2 = rs.getString(2);
                latitude2 = rs.getString(7);                                               //Grabs data from the database for the PlayMatchmaking match, setting these Strings to database values
                longitude2 = rs.getString(8);

            }
            catch(Exception e){
                e.printStackTrace();
            }

            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, pass);

                Statement st = con.createStatement();                                                   //Allows a statement to be passed as an SQL query


                final ResultSet rs = st.executeQuery("select * from users where id = 4");
                rs.next();
                Name3 = rs.getString(2);
                latitude3 = rs.getString(7);                                                //Grabs data from the database for the PlayMatchmaking match, setting these Strings to database values
                longitude3 = rs.getString(8);

            }
            catch(Exception e){
                e.printStackTrace();
            }

            return null;
        }
        @Override
        protected void onPostExecute(Void result){

            firstName.setText(Name);                                                                    //Sets all of the viewable TextViews to the values retrieved from the database
            locationlat.setText(latitude);
            locationlong.setText(longitude);

            firstName2.setText(Name2);                                                                  //Sets all of the viewable TextViews to the values retrieved from the database
            locationlat2.setText(latitude2);
            locationlong2.setText(longitude2);

            firstName3.setText(Name3);                                                                  //Sets all of the viewable TextViews to the values retrieved from the database
            locationlat3.setText(latitude3);
            locationlong3.setText(longitude3);

            super.onPostExecute(result);
        }
    }

    }
