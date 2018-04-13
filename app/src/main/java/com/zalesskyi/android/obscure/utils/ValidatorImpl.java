package com.zalesskyi.android.obscure.utils;

import android.text.TextUtils;


public class ValidatorImpl implements IValidator {

    @Override
    public boolean isEmailValid(CharSequence email) {
        return !TextUtils.isEmpty(email.toString()) && android.util.Patterns.EMAIL_ADDRESS.matcher(email.toString()).matches();
    }

    @Override
    public boolean isNameValid(CharSequence name) {
        return false;
    }

    @Override
    public boolean isPasswordValid(CharSequence password) {
        return password.toString().matches("[0-9a-zA-Z!@#$%^&*]{6,}");
    }

    @Override
    public boolean isPhoneNumberValid(CharSequence phone) {
        return false;
    }
}