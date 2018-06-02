package com.zalesskyi.android.obscure.view.detail_operation.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zalesskyi.android.obscure.R;
import com.zalesskyi.android.obscure.model.Message;

public class InterlocatorMessageHolder extends RecyclerView.ViewHolder {
    private TextView mTextView;
    private ImageView mPic;
    private View mSoundView;

    public InterlocatorMessageHolder(View itemView) {
        super(itemView);
        mTextView = itemView.findViewById(R.id.interlocutor_message_body);
        mPic = itemView.findViewById(R.id.interlocutor_pic_message);
        mSoundView = itemView.findViewById(R.id.interlocutor_audio);
    }

    public void bindMessage(Message message) {
        if (message.getText() != null) {
            mTextView.setText(message.getText());
            mPic.setVisibility(View.GONE);
            mTextView.setVisibility(View.VISIBLE);
            mSoundView.setVisibility(View.GONE);
        } else if (message.getImage() != null) {
            mPic.setImageBitmap(message.getImage());
            mTextView.setVisibility(View.GONE);
            mPic.setVisibility(View.VISIBLE);
            mSoundView.setVisibility(View.GONE);
        } else if (message.getPathToSound() != null) {
            mSoundView.setVisibility(View.VISIBLE);
            mPic.setVisibility(View.GONE);
            mTextView.setVisibility(View.GONE);
        }
    }
}
