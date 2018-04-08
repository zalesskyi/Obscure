package com.zalesskyi.android.obscure.package_presenters;

import com.zalesskyi.android.obscure.view.AuthActivity;
import com.zalesskyi.android.obscure.view.IBaseView;

/**
 * Created by Алексей on 07.04.2018.
 */

public interface IPresenterContract {
    void dismiss();

    interface IAuthPresenter<V extends IBaseView.IAuthView>
            extends IPresenterContract {

        void init(V v);
        void doSignIn(String email, String password);
        void doSignUp(String email, String phone, String password);
        void doRecoverAccount(String email);
        void doSocialAuth(AuthActivity activity, int type);
    }
}
