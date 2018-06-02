package com.zalesskyi.android.obscure.view.detail_operation.fragments;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import java.io.IOException;

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
        getMock();
    }

    private void getMock() {
        Bitmap image = null;
        try {
            AssetManager assetManager = getActivity().getAssets();
            image = BitmapFactory.decodeStream(assetManager.open("pig.jpg"));
            mMessagesAdapter.addMessage(new Message(getActivity(), true, "Hey there!", null, null));
            mMessagesAdapter.addMessage(new Message(getActivity(), false, "Hi", null, null));
            mMessagesAdapter.addMessage(new Message(getActivity(), false, "What's up?", null, null));
            mMessagesAdapter.addMessage(new Message(getActivity(), true, "Gastroenteritis means inflammation of stomach as well as the gastrointestinal tract.", null, null));
            mMessagesAdapter.addMessage(new Message(getActivity(), true, null, image, null));
            mMessagesAdapter.addMessage(new Message(getActivity(), false, "Hi man! I find wery good flat near Kotti. Let`s roll", null, null));
            mMessagesAdapter.addMessage(new Message(getActivity(), false, null, null, "PATH"));
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
