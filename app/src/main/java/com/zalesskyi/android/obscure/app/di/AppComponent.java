package com.zalesskyi.android.obscure.app.di;

import com.zalesskyi.android.obscure.view.AuthActivity;

import dagger.Component;

@AppScope
@Component(modules = {AppModule.class, ApiModule.class, PresenterModule.class})
public interface AppComponent {

    void inject(AuthActivity activity);
}
