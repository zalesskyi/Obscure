package com.zalesskyi.android.obscure.view.auth_operation.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.zalesskyi.android.obscure.R;

public class NavigationActivity extends AppCompatActivity {

    private Button mBtnSignIn;
    private Button mBtnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        mBtnSignIn = (Button) findViewById(R.id.btn_navigation_activity_sign_in);
        mBtnSignUp = (Button) findViewById(R.id.btn_navigation_activity_sign_up);

        mBtnSignIn.setOnClickListener(view -> {
                Intent i = new Intent(NavigationActivity.this, AuthActivity.class);
                startActivity(i);
        });
        mBtnSignUp.setOnClickListener(view -> {
                Toast.makeText(NavigationActivity.this, "mBtnSignUp pressed", Toast.LENGTH_LONG ).show();
                // todo при нажатии sign up открывается AuthActivity?
        });
    }
}
