package com.zalesskyi.android.obscure.package_presenters;

import android.content.Intent;

import com.zalesskyi.android.obscure.view.IBaseView;

/**
 * Created by Алексей on 20.04.2018.
 */

public class MainPresenterImpl extends BasePresenter
        implements IPresenterContract.IMainPresenter {
    @Override
    public void doLogout(String token, int type) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void init(IBaseView.IMainView view) {
        super.init(view);
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }
}
