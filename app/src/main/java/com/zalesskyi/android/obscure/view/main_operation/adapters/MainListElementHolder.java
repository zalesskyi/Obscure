package com.zalesskyi.android.obscure.view.main_operation.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zalesskyi.android.obscure.R;
import com.zalesskyi.android.obscure.model.Event;
import com.zalesskyi.android.obscure.view.main_operation.listeners.ItemListener;

/**
 * Created by Алексей on 26.04.2018.
 */

public class MainListElementHolder extends RecyclerView.ViewHolder {
    private Context mContext;
    private ItemListener<Event> mListener;

    private View mParent;
    private TextView mEventTitle;
    private TextView mEventDate;
    private ImageView mEventImage;
    private ImageView mOwnerImage;
    private TextView mOwnerName;
    private TextView mEventLocation;

    MainListElementHolder(Context ctx, ItemListener<Event> listener, View v) {
        super(v);

        mContext = ctx;
        mListener = listener;

        mParent = v;
        mEventTitle = v.findViewById(R.id.event_title_text);
        mEventDate = v.findViewById(R.id.event_date_text);
        mEventImage = v.findViewById(R.id.event_image);
        mOwnerImage = v.findViewById(R.id.event_owner_image);
        mOwnerName = v.findViewById(R.id.event_owner_name);
        mEventLocation = v.findViewById(R.id.event_location);
    }

    public void bindMainListElement(Event event) {
        mEventTitle.setText(event.getTitle());
        mEventDate.setText(event.getCreatedAt());
        Picasso.with(mContext).load(event.getUrlToPhoto()).into(mEventImage);
        Picasso.with(mContext).load(event.getOwner().getUrl()).into(mOwnerImage);
        mOwnerName.setText(event.getOwner().getName());
        mEventLocation.setText(event.getAddress(mContext));

        mParent.setOnClickListener(v -> mListener.open(event));
    }
}