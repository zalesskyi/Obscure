package com.zalesskyi.android.obscure.view;

public interface IBaseView {
    void showError(String err);

    void showProgress();
    void hideProgress();

    interface IAuthView extends IBaseView {
        void openMain();
    }
}
