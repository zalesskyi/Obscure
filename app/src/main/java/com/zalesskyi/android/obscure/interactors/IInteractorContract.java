package com.zalesskyi.android.obscure.interactors;


import com.google.gson.JsonObject;

import java.util.List;

import okhttp3.MultipartBody;
import rx.Observable;

public interface IInteractorContract {

    Observable<JsonObject> toDoSignIn(String email, String password);

    Observable<JsonObject> toDoSignUp(String email, String password);

    Observable<JsonObject> toDoRecoverAccount(String email);

    Observable<JsonObject> toDoSocialAuth(String token);

    Observable<JsonObject> uploadFiles(String action, String authKeyOtEmail, List<MultipartBody.Part> files);

    Observable<JsonObject> uploadFile(String action, String authKeyOrEmail, MultipartBody.Part part);
}
