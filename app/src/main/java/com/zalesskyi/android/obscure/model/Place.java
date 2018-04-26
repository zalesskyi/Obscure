package com.zalesskyi.android.obscure.model;

import android.content.Context;
import android.location.Geocoder;

import java.io.IOException;
import java.util.Locale;

/**
 * Created by Алексей on 26.04.2018.
 */

public class Place {
    private double mLongitude;
    private double mLatitude;

    private Context mContext;
    private Geocoder mGeo;

    public Place(Context ctx, double longitude, double latitude) {
        mContext = ctx;
        mLongitude = longitude;
        mLatitude = latitude;
        mGeo = new Geocoder(mContext, Locale.getDefault());
    }

    public String getAddress() {
        try {
            return mGeo.getFromLocation(mLatitude, mLongitude, 1).get(0).getCountryName();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        return null;
    }
}
