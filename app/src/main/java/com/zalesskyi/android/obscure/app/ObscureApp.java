package com.zalesskyi.android.obscure.app;

import android.app.Application;
import android.content.Context;

import com.zalesskyi.android.obscure.app.di.ApiModule;
import com.zalesskyi.android.obscure.app.di.AppComponent;
import com.zalesskyi.android.obscure.app.di.AppModule;
import com.zalesskyi.android.obscure.app.di.DaggerAppComponent;
import com.zalesskyi.android.obscure.app.di.PresenterModule;

import io.realm.Realm;
import io.realm.RealmConfiguration;


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
        initRealmConfiguration();
    }

    private void initAppComponent(){
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule())
                .presenterModule(new PresenterModule())
                .build();
    }

    private void initRealmConfiguration() {
        Realm.init(this);
        RealmConfiguration realmConfig = new RealmConfiguration.Builder()
                .name("interpipe.realm")
                .schemaVersion(1)
                .build();
        Realm.setDefaultConfiguration(realmConfig);
    }
}
