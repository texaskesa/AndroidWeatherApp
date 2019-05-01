package com.example.myapplication;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class APIRequest extends AsyncTask<ManageLocation, Void, String> {
    @Override
    protected String doInBackground(ManageLocation... s) {
        ManageLocation ml = s[0];
        String urll = "https://api.darksky.net/forecast/d1f231c034c0f2bb4a95c4bf057b224e/";
        try {
            URL url = new URL( urll + ml.location.getLatitude() + "," + ml.location.getLongitude());
            HttpURLConnection darkSkyConnenction = (HttpURLConnection) url.openConnection();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(darkSkyConnenction.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                bufferedReader.close();

                return stringBuilder.toString();
            }
            finally{
                darkSkyConnenction.disconnect();
            }
        }
        catch(Exception e) {
            Log.e("ERROR", e.getMessage(), e);
            return null;
        }
    }
    @Override
    protected void onPostExecute(String result) {
        try {
            JSONObject weatherData = new JSONObject(result);
            JSONObject current = weatherData.getJSONObject("currently");
            String temp = current.getString("temperature");
            String iconTemp = current.getString("icon");
            Boolean tooHot = false;
            /*if (Integer.parseInt(temp) >= 100) {
                tooHot = true;
            }*/
            String icon = "";
            if (iconTemp.equals("clear-day") || iconTemp.equals("clear-night") || iconTemp.equals("wind")) {
                icon = "clear";
            } else if (iconTemp.equals("rain")) {
                icon = "rain";
            } else if (iconTemp.equals("snow") || iconTemp.equals("sleet")) {
                icon = "snow";
            } else {
                icon = "cloudy";
            }
            String precipProbability = current.getString("precipProbability");
            JSONObject daily = weatherData.getJSONObject("daily");
            JSONArray data = daily.getJSONArray("data");
            JSONObject todayData = (JSONObject) data.get(0);
            String todayHigh = todayData.getString("temperatureHigh");
            String todayLow = todayData.getString("temperatureLow");

            JSONObject day2 = (JSONObject) data.get(1);
            String day2high = day2.getString("temperatureHigh");
            String day2low = day2.getString("temperatureLow");
            String day2per = day2.getString("percipProbability");
            String[] day2Arr = {day2high, day2low, day2per};

            JSONObject day3 = (JSONObject) data.get(2);
            String day3high = day3.getString("temperatureHigh");
            String day3low = day3.getString("temperatureLow");
            String day3per = day3.getString("percipProbability");
            String[] day3Arr = {day3high, day3low, day3per};

            JSONObject day4 = (JSONObject) data.get(3);
            String day4high = day4.getString("temperatureHigh");
            String day4low = day4.getString("temperatureLow");
            String day4per = day4.getString("percipProbability");
            String[] day4Arr = {day4high, day4low, day4per};

            JSONObject day5 = (JSONObject) data.get(4);
            String day5high = day5.getString("temperatureHigh");
            String day5low = day5.getString("temperatureLow");
            String day5per = day5.getString("percipProbability");
            String[] day5Arr = {day5high, day5low, day5per};

            JSONObject day6 = (JSONObject) data.get(5);
            String day6high = day6.getString("temperatureHigh");
            String day6low = day6.getString("temperatureLow");
            String day6per = day6.getString("percipProbability");
            String[] day6Arr = {day6high, day6low, day6per};

            JSONObject day7 = (JSONObject) data.get(6);
            String day7high = day7.getString("temperatureHigh");
            String day7low = day7.getString("temperatureLow");
            String day7per = day7.getString("percipProbability");
            String[] day7Arr = {day7high, day7low, day7per};

            MainActivity.wd.setCurrentTemp(Double.parseDouble(temp));
            MainActivity.wd.setIcon(icon);
            double[] exmaple = new double[7];
            exmaple[0] = Double.parseDouble(day2high);
            exmaple[1] = Double.parseDouble(day3high);


        } catch (JSONException e) {
            // Appropriate error handling code
        }
    }
}
