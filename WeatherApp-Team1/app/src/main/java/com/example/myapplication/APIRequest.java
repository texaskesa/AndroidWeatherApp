package com.example.myapplication;

import android.location.Location;
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

import static com.example.myapplication.MainActivity.weatherData;


public class APIRequest extends AsyncTask<Location, Void, String> {
    @Override
    protected String doInBackground(Location... s) {
        String baseURL = "https://api.darksky.net/forcast/";

        try{
            URL url = new URL("https://api.darksky.net/forecast/d1f231c034c0f2bb4a95c4bf057b224e/" + s[0].getLatitude()+ "," + s[0].getLongitude());
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            try{
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String line,responseStr="";
                while ((line = bufferedReader.readLine()) != null) {
                    responseStr = responseStr + line + "\n";
                }
                bufferedReader.close();
                return responseStr;
            }
            finally{
                urlConnection.disconnect();

            }
        }
        catch(Exception e){
            Log.e("ERROR", e.getMessage(),e);
            return null;

        }



    }



    @Override
    protected void onPostExecute(String result) {

        try{
            JSONObject object = (JSONObject) new JSONTokener(result).nextValue();
            JSONObject current = object.getJSONObject("currently");

            double prec = current.getDouble("precipProbability");
            double temp = current.getDouble("temperature");
            String icon = current.getString("icon");
            double[] tmps = new double[5];

            JSONObject hourly = object.getJSONObject("hourly");
            JSONArray hourlyArr = hourly.getJSONArray("data");
            for(int i = 0; i <5 ; i++){
                JSONObject hourlyObj = hourlyArr.getJSONObject(i);
                tmps[i] = hourlyObj.getDouble("temperature");

            }


            JSONObject daily = object.getJSONObject("daily");
            JSONArray dailyArr = daily.getJSONArray("data");
            int[] tempHigh = new int[7];
            int[] tempLow = new int[7];
            String[] dailyicon = new String[7];
            for(int i = 0; i<7 ; i++) {
                JSONObject dailyObj = dailyArr.getJSONObject(i);
                tempHigh[i] = dailyObj.getInt("temperatureHigh");
                dailyicon[i] = dailyObj.getString("icon");
            }

            for(int i =0 ; i<7 ; i++) {
                JSONObject dailyObj = dailyArr.getJSONObject(i);
                tempLow[i] = dailyObj.getInt("temperatureLow");
            }

            weatherData.setCurrentTemp(temp);
            weatherData.setIcon(icon);
            weatherData.setHourly(tmps);
            weatherData.setDailyhigh(tempHigh);
            weatherData.setDailylow(tempLow);
            weatherData.setPricipprobabilty(prec*100);
            weatherData.setDailyicon(dailyicon);
        }

        catch(JSONException e){
            System.out.println(e);
        }

        for (int i = 0 ; i < 7 ; i++) {
            System.out.println(weatherData.getDailyicon()[i]);
        }
        MainActivity.update();
    }
}

