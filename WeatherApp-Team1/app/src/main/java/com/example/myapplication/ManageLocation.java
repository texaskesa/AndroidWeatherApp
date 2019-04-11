package com.example.myapplication;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

public class ManageLocation implements LocationListener {
    Location location;
    @Override
    public void onLocationChanged(Location location) {
        location = location;
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {
    }

    @Override
    public void onProviderDisabled(String s) {

    }

    public void getLocation(LocationManager lm) {
        location = null;
        boolean isGPSEnabled = lm
                .isProviderEnabled(LocationManager.GPS_PROVIDER);

        // getting network status
        boolean isNetworkEnabled = lm
                .isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        try {
            if(isNetworkEnabled){
                lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000,
                        1, this);
                location = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            }else if(isGPSEnabled) {
                lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000,
                        1, this);
                location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            }
            //System.out.println(location.getLatitude() + " " + location.getLongitude());
        } catch (SecurityException e) {
            Log.d("Error", "Location GET Error");
        }
    }

}
