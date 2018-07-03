package com.zalesskyi.android.obscure.view.detail_operation.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zalesskyi.android.obscure.R;
import com.zalesskyi.android.obscure.model.Location;
import com.zalesskyi.android.obscure.view.detail_operation.adapters.LocationAdapter;
import com.zalesskyi.android.obscure.view.detail_operation.listeners.IDetailListener;
import com.zalesskyi.android.obscure.view.detail_operation.listeners.LocationItemListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LocationListFragment extends Fragment implements IDetailListener.LocationListCallback {

    private static final String LOCATION_TYPE_EXTRA = "location_type";
    private static final String LOCATION_ID_EXTRA = "location_id";

    public static final int LOCATION_TYPE_COUNTRIES = 0;
    public static final int LOCATION_TYPE_REGIONS = 1;
    public static final int LOCATION_TYPE_CITIES = 2;

    private LocationAdapter mAdapter;
    private IDetailListener mListener;
    private int mType;
    private int mLocationId;

    private LocationItemListener itemListener = location -> {
        if (mType == LOCATION_TYPE_COUNTRIES) {
            mListener.openRegionsFragment(location.getId());
        } else if (mType == LOCATION_TYPE_REGIONS) {
            mListener.openCitiesFragment(location.getId());
        } else if (mType == LOCATION_TYPE_CITIES) {
            // todo локация выбрана
        }
    };

    @BindView(R.id.location_list)
    RecyclerView mRecyclerView;

    public static LocationListFragment newInstance(int type, IDetailListener listener, int locationId) {
        LocationListFragment fragment = new LocationListFragment();
        fragment.mListener = listener;
        Bundle args = new Bundle();
        args.putInt(LOCATION_TYPE_EXTRA, type);
        args.putInt(LOCATION_ID_EXTRA, locationId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mType = getArguments().getInt(
                LOCATION_TYPE_EXTRA, LOCATION_TYPE_COUNTRIES);
        mLocationId = getArguments().getInt(LOCATION_ID_EXTRA, -1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_location_list, parent, false);

        ButterKnife.bind(this, v);
        setupUI();

        return v;
    }

    private void setupUI() {
        mAdapter = new LocationAdapter(getActivity(), itemListener);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        if (mType == LOCATION_TYPE_COUNTRIES) {
            mListener.getCountries(this);
        } else if (mType == LOCATION_TYPE_REGIONS) {
            mListener.getRegions(this, mLocationId);
        } else if (mType == LOCATION_TYPE_CITIES) {
            mListener.getCities(this, mLocationId);
        }
    }

    @Override
    public void showLocationList(List<Location> list) {
        mAdapter.addLocationsList(list);
    }
}
