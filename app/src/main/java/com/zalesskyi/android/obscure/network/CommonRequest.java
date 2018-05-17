package com.zalesskyi.android.obscure.network;

/**
 * Created by Алексей on 08.05.2018.
 */

public class CommonRequest {
    protected String email;
    protected String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
