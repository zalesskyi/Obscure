package com.zalesskyi.android.obscure.network;

/**
 * Created by Алексей on 12.05.2018.
 */

public class SignUpRequest extends CommonRequest {
    private String passwordConfirmation;

    public SignUpRequest(String email, String password, String passwordConfirm) {
        setEmail(email);
        setPassword(password);
        passwordConfirmation = passwordConfirm;
    }
}
