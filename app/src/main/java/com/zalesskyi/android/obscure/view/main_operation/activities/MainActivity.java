package com.zalesskyi.android.obscure.view.main_operation.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.ImageFormat;
import android.media.Image;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.mvc.imagepicker.ImagePicker;
import com.zalesskyi.android.obscure.R;
import com.zalesskyi.android.obscure.app.ObscureApp;
import com.zalesskyi.android.obscure.package_presenters.IPresenterContract;
import com.zalesskyi.android.obscure.view.BaseActivity;
import com.zalesskyi.android.obscure.view.IBaseView;
import com.zalesskyi.android.obscure.view.auth_operation.activities.NavigationActivity;
import com.zalesskyi.android.obscure.view.main_operation.fragments.MainFragment;
import com.zalesskyi.android.obscure.view.main_operation.listeners.IMainListener;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;

import static android.graphics.Bitmap.CompressFormat.JPEG;

public class MainActivity extends BaseActivity implements IBaseView.IMainView {
    public static final String TAG = "MainOperation";

    private BottomNavigationView mNavigationView;
    private FragmentManager mFragmentManager;

    @Inject
    IPresenterContract.IMainPresenter mPresenter;

    public static Intent newIntent(Context ctx) {
        return new Intent(ctx, MainActivity.class);
    }

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


    private IMainListener mMainListener = new IMainListener() {
        @Override
        public void getFeed(IDashboardCallback callback) {
            mPresenter.doGetFeed(callback);
        }

        @Override
        public void getImage() {
            ImagePicker.pickImage(MainActivity.this);
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

        ObscureApp.get(this).getAppComponent().inject(this);
        mPresenter.init(this);

        /*Fragment fragment = mFragmentManager.findFragmentById(R.id.content_main);

        if (fragment == null) {
            fragment = MainFragment.newInstance(mMainListener);

            mFragmentManager.beginTransaction()
                    .add(R.id.content_main, fragment)
                    .commit();
        }*/

        //mPresenter.doGetUsers(0, 20);
        mPresenter.doEditProfile(1, 1, 1, "Petro", "Poroh", 1);
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
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            Bitmap bitmap = ImagePicker.getImageFromResult(this, requestCode, resultCode, data);
            File outputDir = MainActivity.this.getCacheDir();
            try {
                File file = File.createTempFile("photo", ".jpeg", outputDir);
                MainActivity.this.saveBitmapToFile(bitmap, JPEG, 75, file);
                //mPresenter.sendFile(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
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
