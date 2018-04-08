package com.zalesskyi.android.obscure.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zalesskyi.android.obscure.R;


public class SignUpFragment extends Fragment {

    private IAuthListener listener;

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
