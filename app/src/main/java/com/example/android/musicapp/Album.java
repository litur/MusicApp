package com.example.android.musicapp;

/**
 * Created by RutiglianoL on 05/04/2018.
 * Represents an Album of Song
 */

public class Album {

    // title
    private String mAlbumTitle;

    // the resource ID of the Album Cover
    private int mAlbumCover;

    /**
     * Constructs a new Album with values for tile and resource for the Album Cover
     */
    public Album(String Title, int AlbumCover) {

        mAlbumTitle = Title;
        mAlbumCover = AlbumCover;

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
