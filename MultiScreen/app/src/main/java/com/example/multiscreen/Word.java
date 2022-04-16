package com.example.multiscreen;

import android.content.res.Resources;

public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int imageResourceID;

    private static final int NO_IMAGE_PROVIDED = -1;


    public Word(String mDefaultTranslation, String mMiwokTranslation){
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        imageResourceID = NO_IMAGE_PROVIDED;
    }

    public Word(String mDefaultTranslation, String mMiwokTranslation,int image){
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.imageResourceID = image;
    }

    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getImageResourceID() { return imageResourceID; }

    public boolean hasImage() {
        return imageResourceID != -1;
    }
}
