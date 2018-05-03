package com.zalesskyi.android.obscure.view.auth_operation.activities;

import android.os.Bundle;
import android.widget.Toast;

import com.zalesskyi.android.obscure.R;
import com.zalesskyi.android.obscure.app.ObscureApp;
import com.zalesskyi.android.obscure.package_presenters.IPresenterContract;
import com.zalesskyi.android.obscure.view.BaseActivity;
import com.zalesskyi.android.obscure.view.IAuthListener;
import com.zalesskyi.android.obscure.view.IBaseView;
import com.zalesskyi.android.obscure.view.auth_operation.fragments.RecoverFragment;
import com.zalesskyi.android.obscure.view.auth_operation.fragments.SignInFragment;
import com.zalesskyi.android.obscure.view.auth_operation.fragments.SignUpFragment;

import javax.inject.Inject;

public class AuthActivity extends BaseActivity implements IBaseView.IAuthView {

    private static final int SCREEN_TYPE_SIGN_IN = 1;
    private static final int SCREEN_TYPE_SIGN_UP = 2;
    private static final int SCREEN_TYPE_RECOVER_ACCOUNT = 3;

    @Inject
    IPresenterContract.IAuthPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        ObscureApp.get(this).getAppComponent().inject(this);
        presenter.init(this);
        onAuthListener.openFirstScreen(SCREEN_TYPE_SIGN_IN);
    }

    @Override
    public void showError(String err) {
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void openMain() {

    }

    private IAuthListener onAuthListener = new IAuthListener() {

        @Override
        public void openSignIn() {
            AuthActivity.this.replaceWithAnimFragment(R.id.auth_content, SignInFragment.newInstance(this), "Auth");
        }

        @Override
        public void openSignUp() {
            AuthActivity.this.replaceWithAnimFragment(R.id.auth_content, SignUpFragment.newInstance(this), "Auth");
        }

        @Override
        public void openRecoverAccount() {
            AuthActivity.this.replaceWithAnimFragment(R.id.auth_content, RecoverFragment.newInstance(this), "Auth");
        }

        @Override
        public void getSignIn(String email, String password) {
            presenter.doSignIn(email, password);
        }

        @Override
        public void getSignUp(String email, String phone, String password) {
            presenter.doSignUp(email, phone, password);
        }

        @Override
        public void getRecoverAccount(String email) {
            presenter.doRecoverAccount(email);
        }

        @Override
        public void getSocialAuth(int type) {
            presenter.doSocialAuth(AuthActivity.this, type);
        }

        @Override
        public void openFirstScreen(int type) {
            switch (type){
                case SCREEN_TYPE_SIGN_IN:
                    AuthActivity.this.replaceWithAnimFragment(R.id.auth_content, SignInFragment.newInstance(this));
                    break;
                case SCREEN_TYPE_SIGN_UP:
                    AuthActivity.this.replaceWithAnimFragment(R.id.auth_content, SignUpFragment.newInstance(this));
                    break;
                case SCREEN_TYPE_RECOVER_ACCOUNT:
                    AuthActivity.this.replaceWithAnimFragment(R.id.auth_content, RecoverFragment.newInstance(this));
                    break;
            }
        }
    };
}
