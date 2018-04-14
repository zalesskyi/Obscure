package com.zalesskyi.android.obscure.app.di;


import android.app.Application;

import com.zalesskyi.android.obscure.realm.IRealmService;
import com.zalesskyi.android.obscure.realm.RealmServiceImpl;
import com.zalesskyi.android.obscure.utils.INetworkCheck;
import com.zalesskyi.android.obscure.utils.IValidator;
import com.zalesskyi.android.obscure.utils.NetworkCheckImpl;
import com.zalesskyi.android.obscure.utils.ValidatorImpl;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

@Module
public class AppModule {

    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @AppScope
    public Application provideApplication() {
        return application;
    }

    @Provides
    @AppScope
    public IValidator provideValidator() {
        return new ValidatorImpl();
    }

    @Provides
    @AppScope
    public INetworkCheck provideNetworkCheck() {
        return new NetworkCheckImpl(application);
    }

    @Provides
    @AppScope
    Realm provideRealm() {
        return Realm.getDefaultInstance();
    }

    @Provides
    @AppScope
    IRealmService provideRealmService(final Realm realm) {
        return new RealmServiceImpl(realm);
    }
}
