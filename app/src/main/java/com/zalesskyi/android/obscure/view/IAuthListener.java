package com.zalesskyi.android.obscure.view;

/**
 * Created by Алексей on 07.04.2018.
 */

public interface IAuthListener {

    void openSignIn();

    void openSignUp();

    void openRecoverAccount();

    void getSignIn(String email, String password);

    void getSignUp(String email, String phone, String password);

    void getRecoverAccount(String email);

    void getSocialAuth(int type);

    void openFirstScreen(int type);
}
