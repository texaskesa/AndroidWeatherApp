package com.example.myapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Calendar;



public class MainActivity extends AppCompatActivity {
    static WeatherData weatherData = new WeatherData();
    static TextView currenttemp;
    static ImageView mainpg;
    static TextView day0;
    static TextView day1;
    static TextView day2;
    static TextView day3;
    static TextView day4;
    static TextView day5;
    static TextView day6;
    static TextView day0high;
    static TextView day0low;
    static TextView day1high;
    static TextView day1low;
    static TextView day2high;
    static TextView day2low;
    static TextView day3high;
    static TextView day3low;
    static TextView day4high;
    static TextView day4low;
    static TextView day5high;
    static TextView day5low;
    static TextView day6high;
    static TextView day6low;
    static ImageView day0jjang;
    static ImageView day1jjang;
    static ImageView day2jjang;
    static ImageView day3jjang;
    static ImageView day4jjang;
    static ImageView day5jjang;
    static ImageView day6jjang;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);
        permissionRequest();
        initialize();
    }

    public void initialize() {
        currenttemp = findViewById(R.id.textView);
        mainpg = findViewById(R.id.mainpicture);
        day0 = findViewById(R.id.day0);
        day1 = findViewById(R.id.day1);
        day2 = findViewById(R.id.day2);
        day3 = findViewById(R.id.day3);
        day4 = findViewById(R.id.day4);
        day5 = findViewById(R.id.day5);
        day6 = findViewById(R.id.day6);
        day0high = findViewById(R.id.day0_high);
        day0low = findViewById(R.id.day0_low);
        day1high = findViewById(R.id.day1_high);
        day1low = findViewById(R.id.day1_low);
        day2high = findViewById(R.id.day2_high);
        day2low = findViewById(R.id.day2_low);
        day3high = findViewById(R.id.day3_high);
        day3low = findViewById(R.id.day3_low);
        day4high = findViewById(R.id.day4_high);
        day4low = findViewById(R.id.day4_low);
        day5high = findViewById(R.id.day5_high);
        day5low = findViewById(R.id.day5_low);
        day6high = findViewById(R.id.day6_high);
        day6low = findViewById(R.id.day6_low);
        day0jjang = findViewById(R.id.day0_jjang);
        day1jjang = findViewById(R.id.day1_jjang);
        day2jjang = findViewById(R.id.day2_jjang);
        day3jjang = findViewById(R.id.day3_jjang);
        day4jjang = findViewById(R.id.day4_jjang);
        day5jjang = findViewById(R.id.day5_jjang);
        day6jjang = findViewById(R.id.day6_jjang);

    }

    public static void update() {
        String[] days = { "SUNDAY", "MONDAY", "TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY"};
        double temp = Math.round(weatherData.getCurrentTemp());
        String temps = temp + "°F";
        currenttemp.setText(temps);
        if(temp>95.0){
            mainpg.setImageResource(R.drawable.jjang_hot);
        }else if(weatherData.geticon().contains("clear")){
            mainpg.setImageResource(R.drawable.jjang_clear);
        }else if(weatherData.geticon().equals("rain")){
            mainpg.setImageResource(R.drawable.jjang_rain);
        }else if(weatherData.geticon().equals("snow")||weatherData.geticon().equals("sleet")){
            mainpg.setImageResource(R.drawable.jjang_snow);
        }else{
            mainpg.setImageResource(R.drawable.jjang_cloudy);
        }

        Calendar day = Calendar.getInstance();
        int weekday = day.get(Calendar.DAY_OF_WEEK);
        weekday = weekday-1;
        int j =0;
        int length = days.length;
        double[] dailyhigh = weatherData.getDailyhigh();
        double[] dailylow = weatherData.getDailylow();
        String[] dailyicon = weatherData.getDailyicon();


        for(int i = weekday; i<length;i++){
            switch(j){
                case 0:
                    day0.setText(days[i]);
                    day0high.setText(Double.toString(dailyhigh[i])+ "°F");
                    day0low.setText(Double.toString(dailylow[i])+ "°F");
                    if(dailyicon[i].contains("clear")){
                        day0jjang.setImageResource(R.drawable.jjang_clear);
                    }else if(dailyicon[i].equals("rain")){
                        day0jjang.setImageResource(R.drawable.jjang_rain);
                    }else if(dailyicon[i].equals("snow")||dailyicon[i].equals("sleet")){
                        day0jjang.setImageResource(R.drawable.jjang_snow);
                    }else{
                        day0jjang.setImageResource(R.drawable.jjang_cloudy);
                    }

                    break;
                case 1:
                    day1.setText(days[i]);
                    day1high.setText(Double.toString(dailyhigh[i])+ "°F");
                    day1low.setText(Double.toString(dailylow[i])+ "°F");
                    if(dailyicon[i].contains("clear")){
                        day1jjang.setImageResource(R.drawable.jjang_clear);
                    }else if(dailyicon[i].equals("rain")){
                        day1jjang.setImageResource(R.drawable.jjang_rain);
                    }else if(dailyicon[i].equals("snow")||dailyicon[i].equals("sleet")){
                        day1jjang.setImageResource(R.drawable.jjang_snow);
                    }else{
                        day1jjang.setImageResource(R.drawable.jjang_cloudy);
                    }

                    break;
                case 2:
                    day2.setText(days[i]);
                    day2high.setText(Double.toString(dailyhigh[i])+ "°F");
                    day2low.setText(Double.toString(dailylow[i])+ "°F");
                    if(dailyicon[i].contains("clear")){
                        day2jjang.setImageResource(R.drawable.jjang_clear);
                    }else if(dailyicon[i].equals("rain")){
                        day2jjang.setImageResource(R.drawable.jjang_rain);
                    }else if(dailyicon[i].equals("snow")||dailyicon[i].equals("sleet")){
                        day2jjang.setImageResource(R.drawable.jjang_snow);
                    }else{
                        day2jjang.setImageResource(R.drawable.jjang_cloudy);
                    }

                    break;
                case 3:
                    day3.setText(days[i]);
                    day3high.setText(Double.toString(dailyhigh[i])+ "°F");
                    day3low.setText(Double.toString(dailylow[i])+ "°F");
                    if(dailyicon[i].contains("clear")){
                        day3jjang.setImageResource(R.drawable.jjang_clear);
                    }else if(dailyicon[i].equals("rain")){
                        day3jjang.setImageResource(R.drawable.jjang_rain);
                    }else if(dailyicon[i].equals("snow")||dailyicon[i].equals("sleet")){
                        day3jjang.setImageResource(R.drawable.jjang_snow);
                    }else{
                        day3jjang.setImageResource(R.drawable.jjang_cloudy);
                    }

                    break;
                case 4:
                    day4.setText(days[i]);
                    day4high.setText(Double.toString(dailyhigh[i])+ "°F");
                    day4low.setText(Double.toString(dailylow[i])+ "°F");
                    if(dailyicon[i].contains("clear")){
                        day4jjang.setImageResource(R.drawable.jjang_clear);
                    }else if(dailyicon[i].equals("rain")){
                        day4jjang.setImageResource(R.drawable.jjang_rain);
                    }else if(dailyicon[i].equals("snow")||dailyicon[i].equals("sleet")){
                        day4jjang.setImageResource(R.drawable.jjang_snow);
                    }else{
                        day4jjang.setImageResource(R.drawable.jjang_cloudy);
                    }

                    break;
                case 5:
                    day5.setText(days[i]);
                    day5high.setText(Double.toString(dailyhigh[i])+ "°F");
                    day5low.setText(Double.toString(dailylow[i])+ "°F");
                    if(dailyicon[i].contains("clear")){
                        day5jjang.setImageResource(R.drawable.jjang_clear);
                    }else if(dailyicon[i].equals("rain")){
                        day5jjang.setImageResource(R.drawable.jjang_rain);
                    }else if(dailyicon[i].equals("snow")||dailyicon[i].equals("sleet")){
                        day5jjang.setImageResource(R.drawable.jjang_snow);
                    }else{
                        day5jjang.setImageResource(R.drawable.jjang_cloudy);
                    }

                    break;
                case 6:
                    day6.setText(days[i]);
                    day6high.setText(Double.toString(dailyhigh[i])+ "°F");
                    day6low.setText(Double.toString(dailylow[i])+ "°F");
                    if(dailyicon[i].contains("clear")){
                        day6jjang.setImageResource(R.drawable.jjang_clear);
                    }else if(dailyicon[i].equals("rain")){
                        day6jjang.setImageResource(R.drawable.jjang_rain);
                    }else if(dailyicon[i].equals("snow")||dailyicon[i].equals("sleet")){
                        day6jjang.setImageResource(R.drawable.jjang_snow);
                    }else{
                        day6jjang.setImageResource(R.drawable.jjang_cloudy);
                    }

                    break;
            }j++;
            if(j==7){
                break;
            }
            if(i == length-1){
                i=0;
                length = weekday;

            }
        }
    }


    public void permissionRequest(){
        String[] permisson = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED || (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED))
        {
            ActivityCompat.requestPermissions(this, permisson, 1);
        }
        LocationManager lm = (LocationManager) getSystemService(LOCATION_SERVICE);
        ManageLocation ml = new ManageLocation();
        ml.getLocation(lm);
        new APIRequest().execute(ml.location);
    }
}
