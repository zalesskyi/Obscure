package com.zalesskyi.android.obscure.view.detail_operation.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zalesskyi.android.obscure.R;
import com.zalesskyi.android.obscure.model.Message;
import com.zalesskyi.android.obscure.view.detail_operation.adapters.MessagesAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChatDetailFragment extends Fragment {

    private MessagesAdapter mMessagesAdapter;

    @BindView(R.id.messages_list)
    RecyclerView mMessagesRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_chat_detail, parent, false);
        ButterKnife.bind(this, v);
        setupUI();
        return v;
    }

    public void setupUI() {
        mMessagesAdapter = new MessagesAdapter(getActivity(), null);
        mMessagesRecyclerView.setAdapter(mMessagesAdapter);
        mMessagesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mMessagesAdapter.addMessage(new Message(true, "Hey there!"));
        mMessagesAdapter.addMessage(new Message(false, "Hi"));
        mMessagesAdapter.addMessage(new Message(false, "What's up?"));
        mMessagesAdapter.addMessage(new Message(true, "Take it easy!"));
    }
}
