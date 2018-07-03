package com.zalesskyi.android.obscure.view.detail_operation.listeners;

import com.zalesskyi.android.obscure.model.Location;

import java.util.List;

public interface IDetailListener {
    void getCountries(LocationListCallback callback);
    void getRegions(LocationListCallback callback, int countryId);
    void getCities(LocationListCallback callback, int regionId);

    void openCountriesFragment();
    void openRegionsFragment(int countryId);
    void openCitiesFragment(int regionId);

    interface LocationListCallback {
        void showLocationList(List<Location> list);
    }
}
