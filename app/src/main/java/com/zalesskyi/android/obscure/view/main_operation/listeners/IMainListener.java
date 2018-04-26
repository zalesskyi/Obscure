package com.zalesskyi.android.obscure.view.main_operation.listeners;

import com.zalesskyi.android.obscure.model.Event;

import java.util.List;

/**
 * Created by Алексей on 26.04.2018.
 */

public interface IMainListener {
    void getFeed(IMainListener.IDashboardCallback callback);


    interface IDashboardCallback {
        void showFeed(List<Event> events);
    }
}
