package com.zalesskyi.android.obscure.model;

import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Event extends RealmObject {
    @PrimaryKey
    private long mId;

    private String mTitle;
    private Owner mOwner;
    private Place mPlace;


    private String mUrlToPhoto;
    private long mCreatedAt;

    public long getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public Owner getOwner() {
        return mOwner;
    }

    public String getUrlToPhoto() {
        return mUrlToPhoto;
    }

    public void setId(long id) {
        mId = id;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public void setOwner(Owner owner) {
        mOwner = owner;
    }

    public void setPlace(Place place) {
        mPlace = place;
    }

    public void setUrlToPhoto(String urlToPhoto) {
        mUrlToPhoto = urlToPhoto;
    }

    public void setCreatedAt(long createdAt) {
        mCreatedAt = createdAt;
    }

    public Place getPlace() {
        return mPlace;
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
    public String getAddress(Context ctx) {
        return mPlace.getAddress(ctx);
    }
}
