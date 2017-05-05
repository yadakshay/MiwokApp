package com.example.android.miwok;

/**
 * Created by Akshay on 30-04-2017.
 */


// declaration of new class
public class Word {
    private  String mMiwok_word, mDefault_word;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mAudioId;

    // Constructor for creating object in main program
    public Word(String defaultTranslation, String miwokTranslation, int audioID){
        mMiwok_word = miwokTranslation;
        mDefault_word = defaultTranslation;
        mAudioId = audioID;
    }

    // Second constructor to add an image
    public Word(String defaultTranslation, String miwokTranslation, int imageId, int audioID){
        mMiwok_word = miwokTranslation;
        mDefault_word = defaultTranslation;
        mImageResourceId = imageId;
        mAudioId = audioID;
    }
    //Methods of the class:
    // get miwok word method
    public String getMiwok_Word(){
        return mMiwok_word;
    }

    //get default word method
    public String getDefault_word() {
        return mDefault_word;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public int getmAudioId() {
        return mAudioId;
    }

    public boolean isImagePresent(){
            return mImageResourceId != NO_IMAGE_PROVIDED;
        }



}

