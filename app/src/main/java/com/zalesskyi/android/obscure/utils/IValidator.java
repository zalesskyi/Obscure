package com.zalesskyi.android.obscure.utils;

/**
 * Created by Алексей on 09.04.2018.
 */

public interface IValidator {
    boolean isEmailValid(CharSequence email);
    boolean isNameValid(CharSequence name);
    boolean isPasswordValid(CharSequence password);
    boolean isPhoneNumberValid(CharSequence phone);
}
