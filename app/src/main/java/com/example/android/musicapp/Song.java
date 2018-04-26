package com.example.android.musicapp;


/**
 * Created by RutiglianoL on 31/03/2018.
 * Represents a Song
 */

public class Song {
    // title
    private String mTitle;

    //id
    private int mID;

    // duration of the song in seconds
    private int mDuration;

    // Artist of the Song
    private String mArtist;

    // ID of the Album to which the Song belongs
    private int mAlbumID;

    // ID of the Raw source ID of the audio file associated to the Song
    private int mRawID;

    /**
     * Constructs a new Song with values for tile, Artist, Album, AlbumID and duration
     */
    public Song(int ID, String Title, String Artist, int AlbumID, int duration, int RawID) {

        mID = ID;
        mTitle = Title;
        mArtist = Artist;
        mAlbumID = AlbumID;
        mDuration = duration;
        mRawID = RawID;
    }

    /**
     * Gets the id of the Song
     */
    public int getID() {
        return mID;
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
     * Gets the ID of the Album in which the song is contained
     */
    public int getAlbumID() {
        return mAlbumID;
    }

    /**
     * Gets the ID of the Raw file associated to the Song
     */
    public int getRawID() {
        return mRawID;
    }

}
