package com.zalesskyi.android.obscure;


import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import rx.Observable;

public interface ObscureApi {

    //@FormUrlEncoded
    @POST("/sign_in")
    Observable<Response<ResponseBody>> signIn(@Header("Content-Type") String contentType, @Body RequestBody request);

    @POST("/sign_up")
    Observable<Response<ResponseBody>> signUp(@Body RequestBody request);

    @POST("/")
    Observable<Response<ResponseBody>> commonRequest(@Header("Content-Type") String contentType,
                                                     @Header("action") String action,
                                                     @Header("authkey") String token,
                                                     @Header("Accept-Language") String language,
                                                     @Header("time-zone") String timezone,
                                                     @Body RequestBody body);

    @Multipart
    Observable<ResponseBody> uploadFile(@Header("action") String action,
                                        @Header("authkey") String token,
                                        @Part MultipartBody.Part avatar);

    @Multipart
    @POST
    Observable<ResponseBody> uploadArrayFiles(@Header("action") String action,
                                              @Header("authkey") String token,
                                              @Part List<MultipartBody.Part> file);

    @Multipart
    @POST("/users/list")
    Observable<Response<ResponseBody>> getUsersList(@Body RequestBody body); // todo 17.05

    @Multipart
    @POST("/logout")
    Observable<Response<ResponseBody>> logOut(@Body RequestBody body); // todo 17.05


    @Multipart
    @POST("/password/email")
    Observable<Response<ResponseBody>> resetPassword(@Body RequestBody body); // todo 17.05

    @Multipart
    @POST("/countries")
    Observable<Response<ResponseBody>> getCountries(@Body RequestBody body); // todo 17.05

    @Multipart
    @POST("/states/{id}")
    Observable<Response<ResponseBody>> getRegions(@Body RequestBody body); // todo 17.05

    @Multipart
    @POST("/cities")
    Observable<Response<ResponseBody>> getCities(@Body RequestBody body); // todo 17.05

    @Multipart
    @POST("/user/update")
    Observable<Response<ResponseBody>> editProfile(@Body RequestBody body); // todo 17.05
}
