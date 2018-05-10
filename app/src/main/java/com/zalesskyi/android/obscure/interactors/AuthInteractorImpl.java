package com.zalesskyi.android.obscure.interactors;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.zalesskyi.android.obscure.ObscureApi;

import java.io.IOException;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class AuthInteractorImpl extends BaseInteractor implements IInteractorContract {

    public AuthInteractorImpl(ObscureApi api) {
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
    public Observable<JsonObject> toDoSignUp(String email, String password) {
        return null;
    }

    @Override
    public Observable<JsonObject> toDoRecoverAccount(String email) {
        return null;
    }

    @Override
    public Observable<JsonObject> toDoSocialAuth(String token) {
        return null;
    }

    @Override
    public Observable<JsonObject> uploadFiles(String action, String authKeyOrEmail, List<MultipartBody.Part> part) {
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
    public Observable<JsonObject> uploadFile(String action, String authKeyOrEmail, MultipartBody.Part part) {
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
