package com.zalesskyi.android.obscure.interactors;


import rx.Observable;

public interface IInteractorContract {

    <T extends  Object> Observable<T> toDoSignIn(String email, String password);

    <T extends  Object> Observable<T> toDoSignUp(String email, String password);

    <T extends Object> Observable<T> toDoRecoverAccount(String email);

    <T extends Object> Observable<T> toDoSocialAuth(String token);
}
