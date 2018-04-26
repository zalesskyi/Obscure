package com.zalesskyi.android.obscure.model;

import android.support.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Event {
    private long mId;
    private String mTitle;
    private User mOwner;
    private Place mPlace;

    private String mUrlToPhoto;
    private long mCreatedAt;

    public Event(long id, String title, User owner, @Nullable String urlToPhoto, long createdAt, Place place) {
        mId = id;
        mTitle = title;
        mOwner = owner;
        mUrlToPhoto = urlToPhoto;
        mCreatedAt = createdAt;
        mPlace = place;
    }

    public long getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public User getOwner() {
        return mOwner;
    }

    public String getUrlToPhoto() {
        return mUrlToPhoto;
    }

    /**
     * @return строку в удобочитаемом виде,
     * основанную на кол-ве миллисекунд с 01.01.1970
     */
    public String getCreatedAt() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy hh:mm");
        return dateFormat.format(new Date(mCreatedAt));
    }

    /**
     * @return строку с названием страны
     * по указанной широте и долготе.
     */
    public String getAddress() {
        return mPlace.getAddress();
    }
}
