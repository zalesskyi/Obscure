package com.zalesskyi.android.obscure.view.main_operation.activities;

import android.Manifest;
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
import android.widget.Toast;

import com.mvc.imagepicker.ImagePicker;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.zalesskyi.android.obscure.R;
import com.zalesskyi.android.obscure.app.ObscureApp;
import com.zalesskyi.android.obscure.package_presenters.IPresenterContract;
import com.zalesskyi.android.obscure.view.BaseActivity;
import com.zalesskyi.android.obscure.view.IBaseView;
import com.zalesskyi.android.obscure.view.auth_operation.activities.NavigationActivity;
import com.zalesskyi.android.obscure.view.detail_operation.activities.DetailActivity;
import com.zalesskyi.android.obscure.view.main_operation.fragments.EditProfileFragment;
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

        @Override
        public void chooseCountry() {
            DetailActivity.newIntent(MainActivity.this, DetailActivity.SCREEN_TYPE_LOCATION_LIST);
        }

        @Override
        public void chooseRegion() {

        }

        @Override
        public void chooseCity() {

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

        Fragment fragment = EditProfileFragment.newInstance(mMainListener);

        replaceWithAnimFragment(R.id.content_main, fragment);

        //mPresenter.doGetUsers(0, 20);
        //getPick();
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
                mPresenter.doUploadFile("/image/upload", file);
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

    /*private void getPick() {
        new RxPermissions(this)
                .request(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(granted -> {
                    if (granted) {
                        ImagePicker.pickImage(this);
                    } else {
                        Toast.makeText(this, "Вы не дали разрешения на использования камеры", Toast.LENGTH_LONG).show();
                    }
                });
    }*/
}
