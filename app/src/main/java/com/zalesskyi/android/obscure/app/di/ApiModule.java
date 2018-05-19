package com.zalesskyi.android.obscure.app.di;

import android.app.Application;
import android.util.Config;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zalesskyi.android.obscure.ObscureApi;
import com.zalesskyi.android.obscure.interactors.InteractorImpl;
import com.zalesskyi.android.obscure.interactors.IInteractorContract;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {

    /*@Provides
    @AppScope
    IInteractorContract providesInteractor(){
        return new InteractorImpl();
    }*/

    @Provides
    @AppScope
    public OkHttpClient provideOkHttpClient() {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();

        if (Config.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(logging);
        }

        builder.connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(60 * 1000, TimeUnit.MILLISECONDS);

        return builder.build();
    }

    @Provides
    @AppScope
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder
                .setLenient()
                .create();
    }

    @Provides
    @AppScope
    public Retrofit provideRestAdapter(Application application, Gson gson, OkHttpClient okHttpClient) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.client(okHttpClient)
                .baseUrl("http://37.57.92.40:8084/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson));
        return builder.build();
    }

    @Provides
    @AppScope
    public ObscureApi provideApiService(Retrofit restAdapter) {
        return restAdapter.create(ObscureApi.class);
    }

    @Provides
    @AppScope
    public IInteractorContract provideInteractor(ObscureApi apiService) {
        return new InteractorImpl(apiService);
    }
}
