package com.zalesskyi.android.obscure.view.auth_operation.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.zalesskyi.android.obscure.R;
import com.zalesskyi.android.obscure.view.IAuthListener;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SignInFragment extends Fragment {

    @BindView(R.id.sign_in_username_edit_text)
    EditText mUsernameTxt;

    @BindView(R.id.sign_in_password_edit_text)
    EditText mPasswordTxt;

    @BindView(R.id.sign_in_enter)
    View mEnter;

    @BindView(R.id.sign_in_up_text)
    TextView mSignUp;

    private IAuthListener listener;
    public SignInFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public SignInFragment(IAuthListener listener){
        this.listener = listener;
    }

    public static SignInFragment newInstance(IAuthListener listener) {
        SignInFragment fragment = new SignInFragment(listener);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sign_in, container, false);
        ButterKnife.setDebug(true);
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
        mEnter.setOnClickListener(view -> {
            listener.getSignIn(mUsernameTxt.getText().toString(), mPasswordTxt.getText().toString());
        });

        mSignUp.setOnClickListener(view -> {
            listener.openSignUp();
        });
    }
}
