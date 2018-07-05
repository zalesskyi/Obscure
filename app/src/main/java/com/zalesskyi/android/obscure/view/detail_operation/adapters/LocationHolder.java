package com.zalesskyi.android.obscure.view.detail_operation.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zalesskyi.android.obscure.R;
import com.zalesskyi.android.obscure.model.Location;
import com.zalesskyi.android.obscure.view.detail_operation.listeners.LocationItemListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LocationHolder extends RecyclerView.ViewHolder {

    private LocationItemListener mItemListener;

    @BindView(R.id.location_title)
    TextView mLocationText;

    public LocationHolder(View itemView, LocationItemListener listener) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mItemListener = listener;
    }

    public void bindLocation(Location location) {
        mLocationText.setText(location.getTitle());
        itemView.setOnClickListener(v -> mItemListener.choose(location));
    }
}
