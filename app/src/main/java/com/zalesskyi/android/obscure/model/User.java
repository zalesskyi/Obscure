package com.zalesskyi.android.obscure.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Алексей on 02.05.2018.
 */

public class User {
    @SerializedName("login")
    private String mLogin;

    @SerializedName("avatar_url")
    private String mAvatarUrl;

    @SerializedName("repos_url")
    private String mReposUrl;

    public User(String login, String avatarUrl, String reposUrl) {
        mLogin = login;
        mAvatarUrl = avatarUrl;
        mReposUrl = reposUrl;
    }

    public String getLogin() {
        return mLogin;
    }

    public void setLogin(String login) {
        mLogin = login;
    }

    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        mAvatarUrl = avatarUrl;
    }

    public String getReposUrl() {
        return mReposUrl;
    }

    public void setReposUrl(String reposUrl) {
        mReposUrl = reposUrl;
    }
}
