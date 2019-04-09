package com.example.myapplication;

public class WeatherData {
    private double currentTemp;
    private double[] hourly;
    private double[] dailyhigh;
    private double[] dailylow;

    public double getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(double currentTemp) {
        this.currentTemp = currentTemp;
    }

    public double[] getHourly() {
        return hourly;
    }

    public void setHourly(double[] hourly) {
        this.hourly = hourly;
    }

    public double[] getDailyhigh() {
        return dailyhigh;
    }

    public void setDailyhigh(double[] dailyhigh) {
        this.dailyhigh = dailyhigh;
    }

    public double[] getDailylow() {
        return dailylow;
    }

    public void setDailylow(double[] dailylow) {
        this.dailylow = dailylow;
    }
}
