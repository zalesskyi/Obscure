package com.zalesskyi.android.obscure.view.detail_operation.adapters;

import android.support.v7.widget.RecyclerView;
import android.widget.Filter;

import com.zalesskyi.android.obscure.model.Location;

import java.util.ArrayList;
import java.util.List;

public class LocationFilter extends Filter {

    private RecyclerView.Adapter mAdapter;
    private List<Location> mOriginalList;
    private List<Location> mFilteredList;

    private FilterResults mFilterResults;

    public LocationFilter(RecyclerView.Adapter adapter, List<Location> originalList) {
        mAdapter = adapter;
        mOriginalList = originalList;
        mFilteredList = new ArrayList<>();

        mFilterResults = new FilterResults();
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        mFilteredList.clear();

        for (Location location : mOriginalList) {
            if (location.getTitle().toLowerCase()
                    .contains(constraint.toString().toLowerCase())) {
                mFilteredList.add(location);
            }
        }

        mFilterResults.count = mFilteredList.size();
        mFilterResults.values = mFilteredList;

        return mFilterResults;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        if (results != null && results.count != 0) {
            ((LocationAdapter) mAdapter).setLocationsList(mFilteredList);
        }
    }
}
