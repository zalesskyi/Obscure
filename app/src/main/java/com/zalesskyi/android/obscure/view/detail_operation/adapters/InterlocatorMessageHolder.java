package com.zalesskyi.android.obscure.view.detail_operation.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zalesskyi.android.obscure.R;
import com.zalesskyi.android.obscure.model.Message;

public class InterlocatorMessageHolder extends RecyclerView.ViewHolder {
    private TextView mTextView;

    public InterlocatorMessageHolder(View itemView) {
        super(itemView);
        mTextView = itemView.findViewById(R.id.interlocutor_message_body);
    }

    public void bindMessage(Message message) {
        mTextView.setText(message.getText());
    }
}
