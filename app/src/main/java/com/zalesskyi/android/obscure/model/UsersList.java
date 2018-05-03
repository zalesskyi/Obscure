package com.zalesskyi.android.obscure.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Алексей on 02.05.2018.
 */

public class UsersList {

    @SerializedName("total_count")
    private int mCount;

    @SerializedName("items")
    private ArrayList<User> mUsers;

    public UsersList(int count, ArrayList<User> users) {
        mCount = count;
        mUsers = users;
    }

    public int getCount() {
        return mCount;
    }

    public void setCount(int count) {
        mCount = count;
    }

    public ArrayList<User> getUsers() {
        return mUsers;
    }

    public void setUsers(ArrayList<User> users) {
        mUsers = users;
    }
}
