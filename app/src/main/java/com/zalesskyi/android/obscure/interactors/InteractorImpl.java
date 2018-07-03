package com.zalesskyi.android.obscure.interactors;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.zalesskyi.android.obscure.ObscureApi;
import com.zalesskyi.android.obscure.network.CommonRequest;

import java.io.IOException;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class InteractorImpl extends BaseInteractor implements IInteractorContract {

    public InteractorImpl(ObscureApi api) {
        this.api = api;
    }

    @Override
    public Observable<JsonObject> toDoSignIn(String email, String password) {
        CommonRequest req = new CommonRequest();
        req.setEmail(email);
        req.setPassword(password);
        String json = toJson(req);
        String encoded = encode(json);

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"data\""+encoded+"}");
        Log.i("AuthAct", "toDoSignIn");
        return api.signIn("application/form-data", body)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .map(responseBodyResponse -> {
                    try {
                        String decoded = responseBodyResponse.body().string();
                        String j = decode(decoded);
                        return new Gson().fromJson(j, JsonObject.class);
                    } catch (IOException exc) {
                        exc.printStackTrace();
                    }
                    return null;
                });
    }

    @Override
    public Observable<JsonObject> toDoSignUp(String email, String password, String passwordConfirm) {
        CommonRequest request = new CommonRequest();
        request.setEmail(email);
        request.setPassword(password);
        request.setPassword_confirmation(passwordConfirm);
        String json = toJson(request);
        String b64 = encode(json);
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"data\""+b64+"}");
        return api.signUp(body)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .map(response -> {
                    try {
                        String base64 = response.body().string();
                        String j = decode(base64);
                        return new Gson().fromJson(j, JsonObject.class);
                    } catch (IOException exc) {
                        exc.printStackTrace();
                    }
                    return null;
                });
    }

    @Override
    public Observable<JsonObject> toDoGetUsersList(Integer limit, Integer offset) {
        CommonRequest request = new CommonRequest();
        request.setLimit(limit);
        request.setOffset(offset);
        String json = toJson(request);
        String b64 = encode(json);
        MediaType type = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(type, "{\"data\"" + b64 + "}");

        return api.getUsersList(body)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .map(response -> {
                    try {
                        String base64 = response.body().string();
                        String j = decode(base64);
                        return new Gson().fromJson(j, JsonObject.class);
                    } catch (IOException exc) {
                        exc.printStackTrace();
                    }
                    return null;
                });
    }

    @Override
    public Observable<JsonObject> toDoGetCountriesList(Integer limit, Integer offset) {
        CommonRequest request = new CommonRequest();
        request.setLimit(limit);
        request.setOffset(offset);
        String json = toJson(request);
        String b64 = encode(json);
        MediaType type = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(type, "{\"data\"" + b64 + "}");

        return api.getCountries(body)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .map(response -> {
                    try {
                        String base64 = response.body().string();
                        String j = decode(base64);
                        return new Gson().fromJson(j, JsonObject.class);
                    } catch (IOException exc) {
                        exc.printStackTrace();
                    }
                    return null;
                });
    }

    @Override
    public Observable<JsonObject> toDoGetRegionsList(Integer countryId, Integer limit, Integer offset) {
        CommonRequest request = new CommonRequest();
        request.setCountry_id(countryId);
        request.setLimit(limit);
        request.setOffset(offset);
        String json = toJson(request);
        String b64 = encode(json);
        MediaType type = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(type, "{\"data\"" + b64 + "}");

        return api.getUsersList(body)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .map(response -> {
                    try {
                        String base64 = response.body().string();
                        String j = decode(base64);
                        return new Gson().fromJson(j, JsonObject.class);
                    } catch (IOException exc) {
                        exc.printStackTrace();
                    }
                    return null;
                });
    }

    @Override
    public Observable<JsonObject> toDoGetCitiesList(Integer regionId, Integer limit, Integer offset) {
        CommonRequest request = new CommonRequest();
        request.setLimit(limit);
        request.setOffset(offset);
        request.setCity_id(regionId);
        String json = toJson(request);
        String b64 = encode(json);
        MediaType type = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(type, "{\"data\"" + b64 + "}");

        return api.getCities(body)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .map(response -> {
                    try {
                        String base64 = response.body().string();
                        String j = decode(base64);
                        return new Gson().fromJson(j, JsonObject.class);
                    } catch (IOException exc) {
                        exc.printStackTrace();
                    }
                    return null;
                });
    }

    @Override
    public Observable<JsonObject> toDoEditProfile(@Nullable Integer countryId,
                                                  @Nullable Integer regionId,
                                                  @Nullable Integer cityId,
                                                  String name, String lastName,
                                                  Integer imageId) {
        CommonRequest request = new CommonRequest();
        request.setCountry_id(countryId);
        request.setCity_id(regionId);
        request.setName(name);
        request.setLastName(lastName);
        request.setImage_id(imageId);
        String json = toJson(request);
        String b64 = encode(json);
        MediaType type = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(type, "{\"data\"" + b64 + "}");

        return api.getUsersList(body)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .map(response -> {
                    try {
                        String base64 = response.body().string();
                        String j = decode(base64);
                        return new Gson().fromJson(j, JsonObject.class);
                    } catch (IOException exc) {
                        exc.printStackTrace();
                    }
                    return null;
                });
    }

    @Override
    public Observable<JsonObject> toDoRecoverAccount(String email) {
        CommonRequest request = new CommonRequest();
        request.setEmail(email);
        String json = toJson(request);
        String b64 = encode(json);
        MediaType type = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(type, "{\"data\"" + b64 + "}");

        return api.getUsersList(body)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .map(response -> {
                    try {
                        String base64 = response.body().string();
                        String j = decode(base64);
                        return new Gson().fromJson(j, JsonObject.class);
                    } catch (IOException exc) {
                        exc.printStackTrace();
                    }
                    return null;
                });
    }

    @Override
    public Observable<JsonObject> toDoSocialAuth(String token) {
        return null;
    }

    @Override
    public Observable<JsonObject> toDoUploadFiles(String action, String authKeyOrEmail, List<MultipartBody.Part> part) {
        Log.d("RETy", "OneInteractorImpl uploadGalleryFiles() action " + action + ", authKey " + authKeyOrEmail + " part.size() " + part.size());
        return api.uploadArrayFiles(action, authKeyOrEmail, part) //image, //, description
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .doOnError(throwable -> Log.d("RETy", "OneInteractorImpl response error outside" + throwable.getMessage()))
                .map(response -> {
                    try {
                        Log.d("RETy", "OneInteractorImpl response " + response);
                        Log.d("RETy", "OneInteractorImpl getCommonRequest() doOnNext() response.string() " + response.string());
                        String decode = decode(response.string());
                        Log.d("RETy", "OneInteractorImpl response decode " + decode);
                        JsonObject object = new Gson().fromJson(decode, JsonObject.class);
                        Log.d("RETy", "OneInteractorImpl response object " + object);
                        return new Gson().fromJson(decode, JsonObject.class);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                });
    }

    @Override
    public Observable<JsonObject> toDoUploadFile(String action, String authKeyOrEmail, MultipartBody.Part part) {
        Log.d("RETy", "OneInteractorImpl uploadFile() action " + action + ", authKey " + authKeyOrEmail);
        return api.uploadFile(action, authKeyOrEmail, part) //image, //, description
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .doOnError(throwable -> Log.d("Account", "OneInteractorImpl response error outside" + throwable.getMessage()))
                .map(response -> {
                    try {
                        Log.d("RETy", "OneInteractorImpl response " + response.string());
                        String decode = decode(response.string());
                        Log.d("RETy", "OneInteractorImpl response decode " + decode);
                        String json = this.decode(decode);
                        Log.d("RETy", "OneInteractorImpl response json " + json);
                        return new Gson().fromJson(json, JsonObject.class);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                });
    }

}
