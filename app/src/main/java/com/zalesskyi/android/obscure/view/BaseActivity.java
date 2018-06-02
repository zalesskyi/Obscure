package com.zalesskyi.android.obscure.view;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.zalesskyi.android.obscure.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Алексей on 07.04.2018.
 */

public class BaseActivity extends AppCompatActivity {

    protected FragmentManager mFragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mFragmentManager = getSupportFragmentManager();
    }

    protected void replaceWithAnimFragment(int id, Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.move_right_in_activity, R.anim.move_left_out_activity, R.anim.move_left_in_activity, R.anim.move_right_out_activity).replace(id, fragment).addToBackStack(tag);
        fragmentTransaction.commit();
    }

    protected void replaceWithAnimFragment(int id, Fragment fragment) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.move_right_in_activity, R.anim.move_left_out_activity, R.anim.move_left_in_activity, R.anim.move_right_out_activity).replace(id, fragment);
        fragmentTransaction.commit();
    }

    public boolean saveBitmapToFile(final Bitmap bitmap,
                                    final Bitmap.CompressFormat format,
                                    final int quality,
                                    final File file) {

        if (file == null)
            return false;
        if (file.getParent() != null && !file.isDirectory())
            file.mkdirs();
        OutputStream fos;
        try {
            fos = new FileOutputStream(file);
            bitmap.compress(format, quality, fos);
            fos.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
