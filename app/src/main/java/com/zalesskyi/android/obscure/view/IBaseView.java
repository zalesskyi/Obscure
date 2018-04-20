package com.zalesskyi.android.obscure.view;

public interface IBaseView {
    void showError(String err);

    void showProgress();
    void hideProgress();

    interface IAuthView extends IBaseView {
        void openMain();
    }

    interface ISplashView extends IBaseView {
        void checkUserData(boolean isContains);
    }

    interface IMainView extends IBaseView {
        void doneLogout(String token, int type);
        void closeMain();
    }
}
