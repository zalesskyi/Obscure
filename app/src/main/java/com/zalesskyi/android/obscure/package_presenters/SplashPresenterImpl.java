package com.zalesskyi.android.obscure.package_presenters;

import android.app.Application;

import com.zalesskyi.android.obscure.realm.IRealmService;
import com.zalesskyi.android.obscure.realm.User;
import com.zalesskyi.android.obscure.view.IBaseView;


public class SplashPresenterImpl extends BasePresenter<IBaseView.ISplashView>
        implements IPresenterContract.ISplashPresenter<IBaseView.ISplashView> {

    public SplashPresenterImpl(Application application, IRealmService realmService) {
        this.application = application;
        this.realmService = realmService;
    }

    @Override
    public void init(IBaseView.ISplashView v) {
        super.init(v);
    }

    @Override
    public void doCheckUserData() {
        realmService.getLastObject(User.class).subscribe(user -> {
            view.checkUserData(user != null);
        });
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }
}
