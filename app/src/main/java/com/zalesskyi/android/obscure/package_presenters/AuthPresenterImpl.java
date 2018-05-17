package com.zalesskyi.android.obscure.package_presenters;

import android.app.Application;
import android.util.Log;

import com.zalesskyi.android.obscure.interactors.IInteractorContract;
import com.zalesskyi.android.obscure.realm.IRealmService;
import com.zalesskyi.android.obscure.realm.User;
import com.zalesskyi.android.obscure.utils.INetworkCheck;
import com.zalesskyi.android.obscure.utils.IValidator;
import com.zalesskyi.android.obscure.view.auth_operation.activities.AuthActivity;
import com.zalesskyi.android.obscure.view.IBaseView;


public class AuthPresenterImpl extends BasePresenter<IBaseView.IAuthView>
        implements IPresenterContract.IAuthPresenter<IBaseView.IAuthView> {

    public AuthPresenterImpl(Application application, IInteractorContract interactor,
                             IValidator validator, INetworkCheck networkCheck, IRealmService realmService){
        this.application = application;
        this.interactor = interactor;
        this.validator = validator;
        this.networkCheck = networkCheck;
        this.realmService = realmService;
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
        Log.i("AuthAct", "doSignIn");
        this.interactor.toDoSignIn(email, password).doOnRequest(l -> view.showProgress())
                .subscribe(response -> {
                    if (response != null) {
                        //view.openMain();
                        Log.i("AuthPresenter", response.getAsString());
                    }
                }, err -> {
                            view.showError(err.getMessage());
                            Log.e("AuthPresenter", err.getMessage());
                        },
                        () -> view.hideProgress());

        if (!networkCheck.isOnline()) {
            view.showError("No connection");
            return;
        }
        User user = new User();
        user.setId(1);
        user.setEmail(email);
        realmService.addObject(user, User.class)
                .subscribe(userCopy -> {
                    boolean isOk = userCopy != null; // todo replace with callback
                });
    }

    @Override
    public void doSignUp(String email, String password, String passwordConfirmation) {
        interactor.toDoSignUp(email, password, passwordConfirmation)
                .doOnRequest(l -> view.showProgress())
                .subscribe(response -> {
                    if (response != null) {
                        Log.i("AuthPresenter", response.getAsString());
                    }
                }, err -> view.showError(err.getMessage()),
                        () -> view.hideProgress());
    }

    @Override
    public void doRecoverAccount(String email) {

    }

    @Override
    public void doSocialAuth(AuthActivity activity, int type) {

    }
}
