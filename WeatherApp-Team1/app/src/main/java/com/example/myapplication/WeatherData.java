package com.example.myapplication;

public class WeatherData {
    private double currentTemp;
    private double[] hourly;
    private int[] dailyhigh;
    private int[] dailylow;
    private String icon;
    private String[] dailyicon;
    private double pricipprobabilty;

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

    public int[] getDailyhigh() {
        return dailyhigh;
    }

    public void setDailyhigh(int[] dailyhigh) {
        this.dailyhigh = dailyhigh;
    }

    public int[] getDailylow() {
        return dailylow;
    }

    public void setDailylow(int[] dailylow) {
        this.dailylow = dailylow;
    }

    public String geticon() { return this.icon; }

    public void setIcon(String icon) {this.icon = icon;}

    public double getPricipprobabilty() {
        return pricipprobabilty;
    }

    public void setPricipprobabilty(double pricipprobabilty) {
        this.pricipprobabilty = pricipprobabilty;
    }

    public String[] getDailyicon() {
        return dailyicon;
    }

    public void setDailyicon(String[] dailyicon) {
        this.dailyicon = dailyicon;
    }
}
