package com.zalesskyi.android.obscure.view.auth_operation.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zalesskyi.android.obscure.R;
import com.zalesskyi.android.obscure.app.ObscureApp;
import com.zalesskyi.android.obscure.package_presenters.IPresenterContract;
import com.zalesskyi.android.obscure.view.IBaseView;
import com.zalesskyi.android.obscure.view.main_operation.activities.MainActivity;

import javax.inject.Inject;

public class SplashActivity extends AppCompatActivity implements IBaseView.ISplashView {

    private final int SPLASH_DISPLAY_LENGTH = 3000;

    @Inject
    IPresenterContract.ISplashPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ObscureApp.get(this).getAppComponent().inject(this);
        presenter.init(this);
        presenter.doCheckUserData();
    }

    @Override
    public void checkUserData(boolean isLoggedIn) {
        if(isLoggedIn){
            new Handler().postDelayed(() -> {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                SplashActivity.this.startActivity(intent);
                SplashActivity.this.finish();
            }, SPLASH_DISPLAY_LENGTH);

        }else {
            new Handler().postDelayed(() -> {
                Intent intent = new Intent(SplashActivity.this, NavigationActivity.class);
                SplashActivity.this.startActivity(intent);
                SplashActivity.this.finish();
            }, SPLASH_DISPLAY_LENGTH);
        }
    }

    @Override
    public void showError(String s) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
