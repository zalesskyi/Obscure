package com.zalesskyi.android.obscure.view.main_operation.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.zalesskyi.android.obscure.R;
import com.zalesskyi.android.obscure.view.main_operation.listeners.IMainListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class EditProfileFragment extends Fragment {

    private IMainListener mListener;

    public static EditProfileFragment newInstance(IMainListener listener) {
        EditProfileFragment fragment = new EditProfileFragment();
        fragment.mListener = listener;
        return fragment;
    }

    @BindView(R.id.edit_profile_photo)
    CircleImageView mUserPhoto;

    @BindView(R.id.editprofile_et_name)
    EditText mNameEditText;

    @BindView(R.id.editprofile_et_surname)
    EditText mSurnameEditText;

    @BindView(R.id.edit_profile_choose_country)
    TextView mCountryPick;

    @BindView(R.id.edit_profile_choose_region)
    TextView mRegionPick;

    @BindView(R.id.edit_profile_choose_city)
    TextView mCityPick;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_edit_profile, parent, false);
        ButterKnife.bind(this, v);

        if (mListener != null) {
            setupUI();
        }
        return v;
    }

    private void setupUI() {
        mCountryPick.setOnClickListener(v -> {
            mListener.chooseCountry();
        });
    }
}
