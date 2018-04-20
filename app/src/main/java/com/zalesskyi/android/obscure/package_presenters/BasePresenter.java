package com.zalesskyi.android.obscure.package_presenters;

import android.app.Application;

import com.zalesskyi.android.obscure.realm.IRealmService;
import com.zalesskyi.android.obscure.utils.INetworkCheck;
import com.zalesskyi.android.obscure.utils.IValidator;
import com.zalesskyi.android.obscure.view.IBaseView;
import com.zalesskyi.android.obscure.interactors.IInteractorContract;

/**
 * Created by Алексей on 07.04.2018.
 */

abstract class BasePresenter<V extends IBaseView> {
    protected V view;
    protected IValidator validator;
    protected INetworkCheck networckCheck;
    protected Application application;
    protected IInteractorContract interactor;
    protected IRealmService realmService;

    public void init(V v) {
        view = v;
    }

    public void dismiss() {
        view = null;
    }
}
