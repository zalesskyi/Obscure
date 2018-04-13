package com.zalesskyi.android.obscure.app.di;

import com.zalesskyi.android.obscure.ObscureApi;
import com.zalesskyi.android.obscure.interactors.AuthInteractorImpl;
import com.zalesskyi.android.obscure.interactors.IInteractorContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Алексей on 09.04.2018.
 */

@Module
public class ApiModule {

    @Provides
    @AppScope
    IInteractorContract providesInteractor(){
        return new AuthInteractorImpl();
    }
}
