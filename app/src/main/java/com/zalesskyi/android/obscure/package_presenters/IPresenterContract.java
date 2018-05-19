package com.zalesskyi.android.obscure.package_presenters;

import android.content.Intent;
import android.view.View;

import com.zalesskyi.android.obscure.view.auth_operation.activities.AuthActivity;
import com.zalesskyi.android.obscure.view.IBaseView;
import com.zalesskyi.android.obscure.view.main_operation.listeners.IMainListener;

/**
 * Created by Алексей on 07.04.2018.
 */

public interface IPresenterContract {
    void dismiss();

    interface IAuthPresenter<V extends IBaseView.IAuthView>
            extends IPresenterContract {

        void init(V v);
        void doSignIn(String email, String password);
        void doSignUp(String email, String password, String passwordConfirm);
        void doRecoverAccount(String email);
        void doSocialAuth(AuthActivity activity, int type);
        void onActivityResult(int requestCode, int resultCode, Intent data);
    }

    interface ISplashPresenter<V extends IBaseView.ISplashView> {
        void init(V v);
        void doCheckUserData(); // todo 1 где вызывается?
    }

    interface IMainPresenter<V extends IBaseView.IMainView> {
        void doLogout(String token, int type);
        void doGetFeed(IMainListener.IDashboardCallback callback);
        void doGetUsers();
        void init(V view);
        void dismiss();
    }
}
