package com.zalesskyi.android.obscure.package_presenters;

import android.content.Intent;
import android.view.View;

import com.zalesskyi.android.obscure.view.auth_operation.activities.AuthActivity;
import com.zalesskyi.android.obscure.view.IBaseView;
import com.zalesskyi.android.obscure.view.detail_operation.listeners.IDetailListener;
import com.zalesskyi.android.obscure.view.main_operation.listeners.IMainListener;

import java.io.File;

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
        void doGetUsers(Integer limit, Integer offset);
        void doEditProfile(Integer countryId, Integer stateId,
                           Integer cityId, String name,
                           String lastName, Integer imageId);

        void doUploadFile(String action, File file);
        void init(V view);
        void dismiss();
    }

    interface IDetailPresenter<V extends IBaseView.IDetailView> {
        void doGetCountries(Integer limit, Integer offset, IDetailListener.LocationListCallback callback);
        void doGetStates(Integer countryId, Integer limit, Integer offset, IDetailListener.LocationListCallback callback);
        void doGetCities(Integer stateId, Integer limit, Integer offset, IDetailListener.LocationListCallback callback);
        //void doUploadFile()
        void init(V view);
        void dismiss();
    }
}
