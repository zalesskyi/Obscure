package com.zalesskyi.android.obscure.model;

public class Message {
    private boolean isMine;
    private String mText;

    public Message(boolean isMine, String text) {
        this.isMine = isMine;
        mText = text;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }
}
