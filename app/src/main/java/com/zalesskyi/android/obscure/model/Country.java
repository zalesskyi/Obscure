package com.zalesskyi.android.obscure.model;

import com.google.gson.annotations.SerializedName;

public class Country implements Location {
    @SerializedName("country_id")
    Integer mId;

    @SerializedName("title")
    String mTitle;

    public Country(Integer country_id, String title){
        this.mId = country_id;
        this.mTitle = title;
    }

    @Override
    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        this.mId = id;
    }

    @Override
    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }
}