package com.zalesskyi.android.obscure.app.di;

import com.zalesskyi.android.obscure.interactors.AuthInteractorImpl;
import com.zalesskyi.android.obscure.interactors.IInteractorContract;

import dagger.Module;
import dagger.Provides;

@Module
public class ApiModule {

    @Provides
    @AppScope
    IInteractorContract providesInteractor(){
        return new AuthInteractorImpl();
    }
}
