package com.zalesskyi.android.obscure.interactors;

import com.zalesskyi.android.obscure.ObscureApi;
import com.zalesskyi.android.obscure.model.UsersList;

import rx.Observable;


public class AuthInteractorImpl extends BaseInteractor implements IInteractorContract {

    public AuthInteractorImpl(ObscureApi api) {
        this.api = api;
    }

    @Override
    public <T> Observable<T> toDoSignIn(String email, String password) {
        return api.getUsersList();
    }

    @Override
    public <T> Observable<T> toDoSignUp(String email, String password) {
        return null;
    }

    @Override
    public <T> Observable<T> toDoRecoverAccount(String email) {
        return null;
    }

    @Override
    public <T> Observable<T> toDoSocialAuth(String token) {
        return null;
    }
}
