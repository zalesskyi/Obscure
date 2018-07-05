package com.zalesskyi.android.obscure.view.detail_operation.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.zalesskyi.android.obscure.R;
import com.zalesskyi.android.obscure.model.Location;
import com.zalesskyi.android.obscure.view.detail_operation.listeners.LocationItemListener;

import java.util.ArrayList;
import java.util.List;

public class LocationAdapter extends RecyclerView.Adapter<LocationHolder> implements Filterable {

    private Context mContext;
    private LocationItemListener mListener;
    public static final int UNSELECTED = -1;
    public static int sSelectedItem = UNSELECTED;
    private RecyclerView mRecyclerView;
    private List<Location> mOriginalList = new ArrayList<>();
    private LocationFilter mFilter;

    public LocationAdapter(Context ctx, LocationItemListener listener) {
        mContext = ctx;
        mListener = listener;
    }

    @NonNull
    @Override
    public LocationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_location, parent, false);

        return new LocationHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationHolder holder, int position) {
        holder.bindLocation(mOriginalList.get(position));
    }

    @Override
    public int getItemCount() {
        return mOriginalList.size();
    }

    public void addLocation(Location location) {
        mOriginalList.add(location);
        notifyDataSetChanged();
    }

    public void addLocationsList(List<Location> locations) {
        mOriginalList.addAll(locations);
        notifyDataSetChanged();
    }

    public void setLocationsList(List<Location> locations) {
        mOriginalList.clear();
        mOriginalList.addAll(locations);
        notifyDataSetChanged();
    }

    @Override
    public Filter getFilter() {
        if (mFilter == null) {
            mFilter = new LocationFilter(
                    this, new ArrayList<>(mOriginalList));
        }
        return mFilter;
    }
}
