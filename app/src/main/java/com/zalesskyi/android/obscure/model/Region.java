package com.zalesskyi.android.obscure.model;

import com.google.gson.annotations.SerializedName;

public class Region implements Location {
    @SerializedName("region_id")
    Integer mId;

    @SerializedName("title")
    String mTitle;

    public Region(Integer id, String title) {
        mId = id;
        mTitle = title;
    }

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
