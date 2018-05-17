package com.zalesskyi.android.obscure.view.auth_operation.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.zalesskyi.android.obscure.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NavigationActivity extends AppCompatActivity {

    @BindView(R.id.btn_navigation_activity_sign_in)
    Button mBtnSignIn;

    @BindView(R.id.btn_navigation_activity_sign_up)
    Button mBtnSignUp;

    @BindView(R.id.btn_navigation_activity_skip)
    Button mBtnSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        ButterKnife.bind(this);

        setupUI();
    }

    private void setupUI() {
        mBtnSignIn.setOnClickListener(view -> {
            Intent i = AuthActivity.newIntent(NavigationActivity.this, AuthActivity.SCREEN_TYPE_SIGN_IN);
            startActivity(i);
        });
        mBtnSignUp.setOnClickListener(view -> {
            Intent i = AuthActivity.newIntent(NavigationActivity.this, AuthActivity.SCREEN_TYPE_SIGN_UP);
            startActivity(i);
        });
    }
}
