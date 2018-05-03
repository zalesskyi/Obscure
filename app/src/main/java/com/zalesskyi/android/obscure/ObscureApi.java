package com.zalesskyi.android.obscure;


import com.google.gson.JsonObject;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface ObscureApi {

    @FormUrlEncoded
    @POST("/sign_in")
    Observable<JsonObject> signIn(@Field("email") String email, @Field("password") String password);
}
