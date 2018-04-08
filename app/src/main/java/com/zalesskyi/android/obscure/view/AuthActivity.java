package com.zalesskyi.android.obscure.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zalesskyi.android.obscure.R;
import com.zalesskyi.android.obscure.package_presenters.AuthPresenterImpl;
import com.zalesskyi.android.obscure.package_presenters.IPresenterContract;
import com.zalesskyi.android.obscure.view.IBaseView;

public class AuthActivity extends BaseActivity implements IBaseView.IAuthView {

    IPresenterContract.IAuthPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new AuthPresenterImpl();
        presenter.init(this);
    }

    @Override
    public void showError(String err) {

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
                case 1:
                    AuthActivity.this.replaceWithAnimFragment(R.id.auth_content, SignInFragment.newInstance(this));
                    break;
                case 2:
                    AuthActivity.this.replaceWithAnimFragment(R.id.auth_content, SignUpFragment.newInstance(this));
                    break;
                case 3:
                    AuthActivity.this.replaceWithAnimFragment(R.id.auth_content, RecoverFragment.newInstance(this));
                    break;
            }
        }
    };
}
