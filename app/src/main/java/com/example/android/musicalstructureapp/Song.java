package com.example.android.musicalstructureapp;

import java.io.Serializable;

public class Song implements Serializable{

    private String mSongName;
    private String mArtistName;
    private String mAlbumName;
    private int mImageCover;

    public Song(String songName, String artistName, String albumName, int imageCover){
        mSongName = songName;
        mArtistName = artistName;
        mImageCover = imageCover;
        mAlbumName = albumName;
    }

    public String getmSongName() {
        return mSongName;
    }

    public String getmArtistName() {
        return mArtistName;
    }

    public String getmAlbumName() {
        return mAlbumName;
    }

    public int getmImageCover() {
        return mImageCover;
    }
}
