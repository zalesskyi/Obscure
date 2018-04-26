package com.zalesskyi.android.obscure.view.main_operation.activities;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.zalesskyi.android.obscure.R;
import com.zalesskyi.android.obscure.package_presenters.IPresenterContract;
import com.zalesskyi.android.obscure.package_presenters.MainPresenterImpl;
import com.zalesskyi.android.obscure.view.IBaseView;
import com.zalesskyi.android.obscure.view.auth_operation.activities.NavigationActivity;
import com.zalesskyi.android.obscure.view.main_operation.fragments.MainFragment;

public class MainActivity extends AppCompatActivity implements IBaseView.IMainView {
    private static final String TAG = "MainActivity";

    private BottomNavigationView mNavigationView;
    private FragmentManager mFragmentManager;

    private IPresenterContract.IMainPresenter mPresenter;

    private BottomNavigationView.OnNavigationItemSelectedListener
            mOnItemBottomItemSelectedListener = item -> {
                if (item.getItemId() == R.id.navigation_home) {
                    Log.i(TAG, "Go home");
                    return true;
                } else if (item.getItemId() == R.id.navigation_dashboard) {
                    Log.i(TAG, "Go to the dashboard");
                    return true;
                } else if (item.getItemId() == R.id.navigation_notifications) {
                    Log.i(TAG, "Go to the notifications");
                    return true;
                } else {
                    return false;
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mFragmentManager = getSupportFragmentManager();

        mNavigationView = findViewById(R.id.navigation);
        mNavigationView.setOnNavigationItemSelectedListener(mOnItemBottomItemSelectedListener);

        mPresenter = new MainPresenterImpl();
        mPresenter.init(this);

        Fragment fragment = mFragmentManager.findFragmentById(R.id.content_main);

        if (fragment == null) {
            fragment = MainFragment.newInstance();

            mFragmentManager.beginTransaction()
                    .add(R.id.content_main, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_return:
                mPresenter.doLogout(null, 0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void doneLogout(String token, int type) {

    }

    @Override
    public void closeMain() {
        Intent i = new Intent(this, NavigationActivity.class);
        startActivity(i);
        finish();
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
}
