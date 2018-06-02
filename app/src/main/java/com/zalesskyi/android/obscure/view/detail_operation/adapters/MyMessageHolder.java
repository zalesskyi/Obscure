package com.zalesskyi.android.obscure.view.detail_operation.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zalesskyi.android.obscure.R;
import com.zalesskyi.android.obscure.model.Message;

public class MyMessageHolder extends RecyclerView.ViewHolder {

    private TextView mMessageText;
    private ImageView mMessagePic;
    private View mSoundView;

    public MyMessageHolder(View itemView) {
        super(itemView);
        mMessageText = itemView.findViewById(R.id.my_message_body);
        mMessagePic = itemView.findViewById(R.id.my_pic_message);
        mSoundView = itemView.findViewById(R.id.my_audio);
    }

    public void bindMessage(Message message) {
        if (message.getText() != null) {
            mMessageText.setText(message.getText());
            mMessagePic.setVisibility(View.GONE);
            mMessageText.setVisibility(View.VISIBLE);
        } else if (message.getImage() != null) {
            mMessagePic.setImageBitmap(message.getImage());
            mMessageText.setVisibility(View.GONE);
            mMessagePic.setVisibility(View.VISIBLE);
        } else if (message.getPathToSound() != null) {
            mSoundView.setVisibility(View.VISIBLE);
            mMessagePic.setVisibility(View.GONE);
            mMessageText.setVisibility(View.GONE);
        }
    }
}
