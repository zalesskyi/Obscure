package com.zalesskyi.android.obscure.view.detail_operation.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zalesskyi.android.obscure.R;
import com.zalesskyi.android.obscure.model.Message;

public class MyMessageHolder extends RecyclerView.ViewHolder {

    private TextView mMessageText;

    public MyMessageHolder(View itemView) {
        super(itemView);
        mMessageText = itemView.findViewById(R.id.my_message_body);
    }

    public void bindMessage(Message message) {
        mMessageText.setText(message.getText());
    }
}
