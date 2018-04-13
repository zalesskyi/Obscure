package com.zalesskyi.android.obscure.app;

import android.app.Application;
import android.content.Context;

import com.zalesskyi.android.obscure.app.di.ApiModule;
import com.zalesskyi.android.obscure.app.di.AppComponent;
import com.zalesskyi.android.obscure.app.di.AppModule;
import com.zalesskyi.android.obscure.app.di.DaggerAppComponent;
import com.zalesskyi.android.obscure.app.di.PresenterModule;


public class ObscureApp extends Application {

    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    public static ObscureApp get(Context context) {
        return (ObscureApp) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.initAppComponent();
    }

    private void initAppComponent(){
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule())
                .presenterModule(new PresenterModule())
                .build();
    }
}
