package com.zalesskyi.android.obscure.model;

import com.google.gson.annotations.SerializedName;

public class City implements Location {
    @SerializedName("city_id")
    private Integer mId;

    @SerializedName("title")
    private String mTitle;

    @Override
    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
    }

    @Override
    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
