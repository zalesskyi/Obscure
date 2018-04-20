package com.zalesskyi.android.obscure.view.auth_operation.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zalesskyi.android.obscure.R;
import com.zalesskyi.android.obscure.view.IAuthListener;


public class SignInFragment extends Fragment {

    private IAuthListener listener;
    public SignInFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public SignInFragment(IAuthListener listener){
        this.listener = listener;
    }

    public static SignInFragment newInstance(IAuthListener listener) {
        SignInFragment fragment = new SignInFragment();
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
}
