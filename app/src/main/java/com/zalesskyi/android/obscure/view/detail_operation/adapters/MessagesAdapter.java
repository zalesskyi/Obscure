package com.zalesskyi.android.obscure.view.detail_operation.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zalesskyi.android.obscure.R;
import com.zalesskyi.android.obscure.model.Message;
import com.zalesskyi.android.obscure.view.main_operation.listeners.ItemListener;

import java.util.ArrayList;
import java.util.List;

public class MessagesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int MY_MESSAGE_TYPE = 0;
    public static final int NOT_MY_MESSAGE_TYPE = 1;
    public static final int DATE_TYPE = 2;

    private Context mContext;
    private List<Message> mMessages;
    private ItemListener mListener;

    public MessagesAdapter(Context ctx, ItemListener listener) {
        mContext = ctx;
        mMessages = new ArrayList<>();
        mListener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        if (mMessages.get(position).isMine()) {
            return MY_MESSAGE_TYPE;
        }
        return NOT_MY_MESSAGE_TYPE;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v;
        if (viewType == MY_MESSAGE_TYPE) {
            v = inflater.inflate(R.layout.item_chat_detail_my_message, parent, false);
            return new MyMessageHolder(v);
        } else {
            v = inflater.inflate(R.layout.item_chat_detail_interlocutor_message, parent, false);
            return new InterlocatorMessageHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyMessageHolder) {
            MyMessageHolder h = (MyMessageHolder) holder;
            h.bindMessage(mMessages.get(position));
        } else {
            InterlocatorMessageHolder h = (InterlocatorMessageHolder) holder;
            h.bindMessage(mMessages.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mMessages.size();
    }

    public void addMessage(Message msg) {
        mMessages.add(msg);
        notifyDataSetChanged();
    }
}
