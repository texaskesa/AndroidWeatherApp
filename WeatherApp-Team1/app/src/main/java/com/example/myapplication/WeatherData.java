package com.example.myapplication;

public class WeatherData {
    private double currentTemp;
    private double[] hourly;
    private double[] dailyhigh;
    private double[] dailylow;
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
