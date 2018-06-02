package com.zalesskyi.android.obscure.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.util.TypedValue;

public class Message {
    Context mContext;
    private boolean isMine;
    private String mText;
    private Bitmap mImage;
    private String mPathToSound;

    public Message(Context ctx, boolean isMine, String text, Bitmap image, String pathToSound) {
        mContext = ctx;
        this.isMine = isMine;
        mText = text;
        mImage = scaleBitmap(image);
        mPathToSound = pathToSound;
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

    public Bitmap getImage() {
        return mImage;
    }

    public void setImage(Bitmap image) {
        mImage = image;
    }

    public String getPathToSound() {
        return mPathToSound;
    }

    public void setPathToSound(String pathToSound) {
        mPathToSound = pathToSound;
    }

    private Bitmap scaleBitmap(@Nullable Bitmap bm) {
        if (bm == null) {
            return null;
        }
        int x = bm.getWidth();
        int y = bm.getHeight();

        int x1 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 240, mContext.getResources().getDisplayMetrics());
        int y1 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, y * 240 / x, mContext.getResources().getDisplayMetrics());

        return Bitmap.createScaledBitmap(bm, x1, y1, false);
    }
}
