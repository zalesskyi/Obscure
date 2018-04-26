package com.zalesskyi.android.obscure.package_presenters;

import android.content.Intent;

import com.zalesskyi.android.obscure.realm.User;
import com.zalesskyi.android.obscure.view.IBaseView;

/**
 * Created by Алексей on 20.04.2018.
 */

public class MainPresenterImpl extends BasePresenter<IBaseView.IMainView>
        implements IPresenterContract.IMainPresenter {

    /*public MainPresenterImpl(Application application, IInteractorContract interactor,
                             IValidator validator, INetworkCheck networkCheck, IRealmService realmService) {
        this.application = application;
        this.interactor = interactor;
        this.validator = validator;
        this.networkCheck = networkCheck;
        this.realmService = realmService;
    }*/

    @Override
    public void doLogout(String token, int type) {
        // todo сделать дома
        realmService.deleteObject(1, User.class).subscribe((next) -> {
            view.closeMain();
        }, (err) -> {
            view.showError(err.getMessage());
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void init(IBaseView.IMainView view) {
        super.init(view);
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }
}
