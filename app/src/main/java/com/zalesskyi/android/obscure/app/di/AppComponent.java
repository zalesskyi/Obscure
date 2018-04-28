package com.zalesskyi.android.obscure.app.di;

import com.zalesskyi.android.obscure.view.auth_operation.activities.AuthActivity;
import com.zalesskyi.android.obscure.view.auth_operation.activities.SplashActivity;
import com.zalesskyi.android.obscure.view.main_operation.activities.MainActivity;

import dagger.Component;

@AppScope
@Component(modules = {AppModule.class, ApiModule.class, PresenterModule.class})
public interface AppComponent {

    void inject(AuthActivity activity);
    void inject(SplashActivity activity);
    void inject(MainActivity activity);
}
