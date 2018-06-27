package com.zalesskyi.android.obscure.view.detail_operation.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zalesskyi.android.obscure.R;
import com.zalesskyi.android.obscure.model.Location;

import java.util.ArrayList;
import java.util.List;

public class LocationAdapter extends RecyclerView.Adapter<LocationHolder>{

    private Context mContext;
    private LocationItemListener mListener;
    private List<Location> mList = new ArrayList<>();

    @NonNull
    @Override
    public LocationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_location, parent, false);

        return new LocationHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationHolder holder, int position) {
        holder.bindLocation(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
