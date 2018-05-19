package com.zalesskyi.android.obscure.interactors;


import android.app.Activity;
import android.support.annotation.Nullable;

import com.facebook.AccessToken;
import com.google.gson.JsonObject;

import java.util.List;

import okhttp3.MultipartBody;
import rx.Observable;

public interface IInteractorContract {

    Observable<JsonObject> toDoSignIn(String email, String password);

    Observable<JsonObject> toDoSignUp(String email, String password, String passwordConfirm);

    Observable<JsonObject> getUsersList(Integer limit, Integer offset);

    Observable<JsonObject> getCountriesList(Integer limit, Integer offset);

    Observable<JsonObject> getRegionsList(Integer countryId, Integer limit, Integer offset);

    Observable<JsonObject> getCitiesList(Integer regionId, Integer limit, Integer offset);

    Observable<JsonObject> toDoEditProfile(@Nullable Integer countryId,
                                           @Nullable Integer regionId,
                                           @Nullable Integer cityId,
                                           String name,
                                           String lastName,
                                           Integer imageId);

    Observable<JsonObject> toDoRecoverAccount(String email);

    Observable<JsonObject> toDoSocialAuth(String token);

    Observable<JsonObject> uploadFiles(String action, String authKeyOtEmail, List<MultipartBody.Part> files);

    Observable<JsonObject> uploadFile(String action, String authKeyOrEmail, MultipartBody.Part part);
}
