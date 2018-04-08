package com.zalesskyi.android.obscure.package_presenters;

import com.zalesskyi.android.obscure.view.IBaseView;
import com.zalesskyi.android.obscure.interactors.IInteractorContract;

/**
 * Created by Алексей on 07.04.2018.
 */

abstract class BasePresenter<V extends IBaseView> {
    protected V view;
    protected IInteractorContract interactor;

    public void init(V v) {
        view = v;
    }

    public void dismiss() {
        view = null;
    }
}
