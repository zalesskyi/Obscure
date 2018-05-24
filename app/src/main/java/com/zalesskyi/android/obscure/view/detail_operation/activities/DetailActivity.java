package com.zalesskyi.android.obscure.view.detail_operation.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zalesskyi.android.obscure.R;
import com.zalesskyi.android.obscure.view.detail_operation.fragments.ChatDetailFragment;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        FragmentManager mFragmentManager = getSupportFragmentManager();
        Fragment fragment = mFragmentManager.findFragmentById(R.id.activity_detail);

        if (fragment == null) {
            fragment = new ChatDetailFragment();
            mFragmentManager.beginTransaction()
                    .add(R.id.activity_detail, fragment)
                    .commit();
        }
    }
}
