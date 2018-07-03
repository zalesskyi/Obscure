package com.zalesskyi.android.obscure.app.di;

import android.app.Application;

import com.zalesskyi.android.obscure.interactors.IInteractorContract;
import com.zalesskyi.android.obscure.package_presenters.AuthPresenterImpl;
import com.zalesskyi.android.obscure.package_presenters.DetailPresenterImpl;
import com.zalesskyi.android.obscure.package_presenters.IPresenterContract;
import com.zalesskyi.android.obscure.package_presenters.MainPresenterImpl;
import com.zalesskyi.android.obscure.package_presenters.SplashPresenterImpl;
import com.zalesskyi.android.obscure.realm.IRealmService;
import com.zalesskyi.android.obscure.utils.INetworkCheck;
import com.zalesskyi.android.obscure.utils.IValidator;

import dagger.Module;
import dagger.Provides;


@Module
public class PresenterModule {

    @Provides
    @AppScope
    IPresenterContract.IAuthPresenter providesAuthPresenter(Application application, IInteractorContract interactor,
                                                            IValidator validator, INetworkCheck networkCheck, IRealmService realmService){
        return new AuthPresenterImpl(application, interactor, validator, networkCheck, realmService);
    }

    @Provides
    @AppScope
    IPresenterContract.ISplashPresenter providesSplashPresenter(Application application, IRealmService realmService) {
        return new SplashPresenterImpl(application, realmService);
    }

    @Provides
    @AppScope
    IPresenterContract.IMainPresenter providesMainPresenter(Application application, IInteractorContract interactor
            , IValidator validator, INetworkCheck networkCheck, IRealmService realmService) {
        return new MainPresenterImpl(application, interactor, validator, networkCheck, realmService);
    }

    @Provides
    @AppScope
    IPresenterContract.IDetailPresenter providesDetailPresenter(Application application, IInteractorContract interactor,
                                                                IValidator validator, INetworkCheck networkCheck, IRealmService realmService) {
        return new DetailPresenterImpl(application, interactor, validator, networkCheck, realmService);
    }
}
