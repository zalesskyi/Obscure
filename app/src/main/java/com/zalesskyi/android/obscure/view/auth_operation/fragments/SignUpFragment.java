package com.zalesskyi.android.obscure.view.auth_operation.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.zalesskyi.android.obscure.R;
import com.zalesskyi.android.obscure.view.IAuthListener;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SignUpFragment extends Fragment {

    private IAuthListener listener;


    @BindView(R.id.sign_up_in_text)
    TextView mSignInTxt;

    @BindView(R.id.sign_up_username_edit_text)
    EditText mUsernameTxt;

    @BindView(R.id.sign_up_password_edit_text)
    EditText mPasswordTxt;

    @BindView(R.id.sign_up_password_confirm_edit_text)
    EditText mPasswordConfirmTxt;

    @BindView(R.id.sign_up_enter)
    View mEnter;

    public SignUpFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public SignUpFragment(IAuthListener listener){
        this.listener = listener;
    }

    public static SignUpFragment newInstance(IAuthListener listener) {
        SignUpFragment fragment = new SignUpFragment(listener);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sign_up, container, false);
        ButterKnife.bind(this, v);

        setupUI();
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void setupUI() {
        mEnter.setOnClickListener(b -> {
            listener.getSignUp(mUsernameTxt.getText().toString(),
                    mPasswordTxt.getText().toString(),
                    mPasswordConfirmTxt.getText().toString());    // todo password confirmation вместо phone
        });

        mSignInTxt.setOnClickListener(view -> {
            listener.openSignIn();
        });
    }
}
