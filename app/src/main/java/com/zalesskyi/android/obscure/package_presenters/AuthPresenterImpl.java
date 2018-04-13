package com.zalesskyi.android.obscure.package_presenters;

import android.app.Application;

import com.zalesskyi.android.obscure.interactors.AuthInteractorImpl;
import com.zalesskyi.android.obscure.interactors.IInteractorContract;
import com.zalesskyi.android.obscure.utils.INetworkCheck;
import com.zalesskyi.android.obscure.utils.IValidator;
import com.zalesskyi.android.obscure.view.AuthActivity;
import com.zalesskyi.android.obscure.view.IBaseView;

import javax.inject.Inject;


public class AuthPresenterImpl extends BasePresenter<IBaseView.IAuthView>
        implements IPresenterContract.IAuthPresenter<IBaseView.IAuthView> {


    public AuthPresenterImpl(Application application, IInteractorContract interactor,
                             IValidator validator, INetworkCheck networkCheck){
        this.application = application;
        this.interactor = interactor;
        this.validator = validator;
        this.networckCheck = networkCheck;
    }

    @Override
    public void init(IBaseView.IAuthView iAuthView) {
        super.init(iAuthView);
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    @Override
    public void doSignIn(String email, String password) {
        this.interactor.toDoSignIn(email, password).doOnRequest(l -> view.showProgress())
                .subscribe(response -> {
                    if (response != null) {
                        view.openMain();
                    }
                }, err -> view.showError(err.getMessage()),
                        () -> view.hideProgress());
    }

    @Override
    public void doSignUp(String email, String phone, String password) {

    }

    @Override
    public void doRecoverAccount(String email) {

    }

    @Override
    public void doSocialAuth(AuthActivity activity, int type) {

    }
}
