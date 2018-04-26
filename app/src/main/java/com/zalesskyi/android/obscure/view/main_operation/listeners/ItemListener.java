package com.zalesskyi.android.obscure.view.main_operation.listeners;

/**
 * Created by Алексей on 26.04.2018.
 */

public interface ItemListener<T> {
    void open(T item);
    void remove(T item);
}
