package com.zalesskyi.android.obscure.view.detail_operation.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zalesskyi.android.obscure.R;
import com.zalesskyi.android.obscure.app.ObscureApp;
import com.zalesskyi.android.obscure.model.Country;
import com.zalesskyi.android.obscure.model.Location;
import com.zalesskyi.android.obscure.model.Region;
import com.zalesskyi.android.obscure.package_presenters.DetailPresenterImpl;
import com.zalesskyi.android.obscure.package_presenters.IPresenterContract;
import com.zalesskyi.android.obscure.view.BaseActivity;
import com.zalesskyi.android.obscure.view.IBaseView;
import com.zalesskyi.android.obscure.view.detail_operation.fragments.ChatDetailFragment;
import com.zalesskyi.android.obscure.view.detail_operation.fragments.LocationListFragment;
import com.zalesskyi.android.obscure.view.detail_operation.listeners.IDetailListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


// todo DetailActivity хост и для ListLocation, и для ChatDetailFragment?
public class DetailActivity extends BaseActivity implements IBaseView.IDetailView {
    public static final String DETAIL_TYPE_EXTRA = "detail_type";

    public static final int SCREEN_TYPE_CHAT_DETAIL = 0;
    public static final int SCREEN_TYPE_LOCATION_LIST = 1;

    private int mType;
    private FragmentManager mFragmentManager;

    @Inject
    IPresenterContract.IDetailPresenter mPresenter;

    private IDetailListener mDetailListener = new IDetailListener() {
        @Override
        public void getCountries(LocationListCallback callback) {
            List<Location> countries = new ArrayList<>();
            countries.add(new Country(1, "Ukraine"));
            countries.add(new Country(2, "UK"));
            countries.add(new Country(3, "USA"));
            countries.add(new Country(4, "Russia"));
            callback.showLocationList(countries);
            // todo mPresenter.doGetCountries(1, 10, callback);
        }

        @Override
        public void getRegions(LocationListCallback callback, int countryId) {
            List<Location> regions = new ArrayList<>();
            regions.add(new Region(1, "Dnipropetrovsk region"));
            regions.add(new Region(2, "Kiev region"));
            regions.add(new Region(3, "Donetsk region"));
            regions.add(new Region(4, "Lviv region"));
            callback.showLocationList(regions);

            //todo mPresenter.doGetStates(countryId, 1, 10, callback);
        }

        @Override
        public void getCities(LocationListCallback callback, int regionId) {
            List<Location> countries = new ArrayList<>();
            countries.add(new Country(1, "Dnipro"));
            countries.add(new Country(2, "Nikopol"));
            countries.add(new Country(3, "Zhovti Vody"));
            countries.add(new Country(4, "Kamyanske"));
            callback.showLocationList(countries);

            //todo mPresenter.doGetCities(regionId, 1, 10, callback);
        }

        @Override
        public void openCountriesFragment() {
            replaceWithAnimFragment(R.id.activity_detail,
                    LocationListFragment.newInstance(LocationListFragment.LOCATION_TYPE_COUNTRIES, mDetailListener, -1));
        }

        @Override
        public void openRegionsFragment(int countryId) {
            replaceWithAnimFragment(R.id.activity_detail,
                    LocationListFragment.newInstance(LocationListFragment.LOCATION_TYPE_REGIONS, mDetailListener, countryId));
        }

        @Override
        public void openCitiesFragment(int regionId) {
            replaceWithAnimFragment(R.id.activity_detail,
                    LocationListFragment.newInstance(LocationListFragment.LOCATION_TYPE_CITIES, mDetailListener, regionId));
        }
    };

    public static Intent newIntent(Context ctx, int type) {
        Intent i = new Intent(ctx, DetailActivity.class);
        i.putExtra(DETAIL_TYPE_EXTRA, type);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ObscureApp.get(this).getAppComponent().inject(this);
        mPresenter.init(this);

        mType = getIntent().getIntExtra(DETAIL_TYPE_EXTRA, SCREEN_TYPE_LOCATION_LIST);

        setupUI();
    }


    private void setupUI() {
        mFragmentManager = getSupportFragmentManager();
        Fragment fragment = mFragmentManager.findFragmentById(R.id.activity_detail);

        if (fragment == null) {
            if (mType == SCREEN_TYPE_CHAT_DETAIL) {
                fragment = new ChatDetailFragment();
                mFragmentManager.beginTransaction()
                        .add(R.id.activity_detail, fragment)
                        .commit();
            } else if (mType == SCREEN_TYPE_LOCATION_LIST) {
                fragment = LocationListFragment.newInstance(
                        LocationListFragment.LOCATION_TYPE_COUNTRIES, mDetailListener, -1);
                mFragmentManager.beginTransaction()
                        .add(R.id.activity_detail, fragment)
                        .commit();

            }
        }
    }

    @Override
    public void showError(String err) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
