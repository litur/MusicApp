package com.example.android.musicapp;

/**
 * Created by RutiglianoL on 05/04/2018.
 * Represents an Album of Songs
 */

public class Album {

    // ID of the Album
    private int mID;

    // title
    private String mAlbumTitle;

    // the resource ID of the Album Cover
    private int mAlbumCover;

    /**
     * Constructs a new Album with values for ID, tile and resource for the Album Cover
     */
    public Album(int ID, String Title, int AlbumCover) {

        mID = ID;
        mAlbumTitle = Title;
        mAlbumCover = AlbumCover;

    }

    /**
     * Gets the ID of the Album
     */
    public int getID() {
        return mID;
    }

    /**
     * Gets the title of the Album
     */
    public String getTitle() {
        return mAlbumTitle;
    }

    /**
     * Gets the id of the resource of the Album Cover
     */
    public int getAlbumCoverID() {
        return mAlbumCover;
    }
}
