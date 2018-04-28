package com.zalesskyi.android.obscure.model;


import io.realm.RealmObject;

public class Owner extends RealmObject {
    private String name;
    private String url;

    public Owner() {

    }

    public Owner(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
