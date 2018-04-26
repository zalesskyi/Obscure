package com.zalesskyi.android.obscure.model;

/**
 * Created by Алексей on 26.04.2018.
 */

public class User {
    private String name;
    private String url;

    public User(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
