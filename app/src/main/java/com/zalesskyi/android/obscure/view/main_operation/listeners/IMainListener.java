package com.zalesskyi.android.obscure.view.main_operation.listeners;

import com.zalesskyi.android.obscure.model.Event;

import java.util.List;


public interface IMainListener {
    void getFeed(IMainListener.IDashboardCallback callback);

    void getImage();


    interface IDashboardCallback {
        void showFeed(List<Event> events);
        void showEmptyList();
    }
}
