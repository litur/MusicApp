package com.example.android.musicapp;


/**
 * Created by RutiglianoL on 31/03/2018.
 * Represents a Song
 */

public class Song {
    // title
    private String mTitle;

    //id
    private String mid;

    // duration of the song in seconds
    private int mDuration;

    // Artist of the Song
    private String mArtist;

    // Album to which the Song belongs
    private String mAlbum;

    // ID of the Album to which the Song belongs
    private int mAlbumID;


    /**
     * Constructs a new Song with values for tile, Artist, Album, AlbumID and duration
     */
    public Song(String Title, String Artist, String Album, int AlbumID, int duration) {

        mTitle = Title;
        mArtist = Artist;
        mAlbum = Album;
        mAlbumID = AlbumID;
        mDuration = duration;

    }

    /**
     * Gets the title of the Song
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Gets the duration of the Song
     */
    public int getDuration() {
        return mDuration;
    }

    /**
     * Gets the Artist of the Song
     */
    public String getArtist() {
        return mArtist;
    }

    /**
     * Gets the title of the Album in which the song is contained
     */
    public String getAlbum() {
        return mAlbum;
    }

    /**
     * Gets the ID of the Album in which the song is contained
     */
    public int getAlbumID() {
        return mAlbumID;
    }


}
