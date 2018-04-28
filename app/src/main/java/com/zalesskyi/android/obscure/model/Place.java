package com.zalesskyi.android.obscure.model;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import io.realm.RealmObject;

public class Place extends RealmObject {
    private static final String TAG = "Place";

    private double mLongitude;
    private double mLatitude;

    public Place() {

    }

    public Place(double latitude, double longitude) {
        mLongitude = longitude;
        mLatitude = latitude;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public void setLongitude(double longitude) {
        mLongitude = longitude;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public void setLatitude(double latitude) {
        mLatitude = latitude;
    }


    public String getAddress(Context ctx) {
        try {
            Geocoder geo = new Geocoder(ctx, Locale.getDefault());
            List<Address> addresses = geo.getFromLocation(mLatitude, mLongitude, 1);
            if (addresses.size() > 0) {
                return addresses.get(0).getCountryName();
            } else {
                return "Address is not defined";
            }
        } catch (IOException exc) {
            exc.printStackTrace();
            Log.e(TAG, exc.getMessage());
        }
        return null;
    }
}
