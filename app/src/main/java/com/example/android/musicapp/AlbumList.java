package com.example.android.musicapp;

import java.util.ArrayList;

/**
 * Created by RutiglianoL on 05/04/2018.
 */

public class AlbumList extends ArrayList {


    private ArrayList<Album> albumArrayList;

    {
        albumArrayList = new ArrayList<Album>();
    }

    //We create an ArrayList of Album Objects
    public AlbumList() {

        albumArrayList.add(new Album("Californication", R.drawable.californication));
        albumArrayList.add(new Album("Metallica", R.drawable.metallica));
        albumArrayList.add(new Album("Mellon Collie and the Infinite Sadness", R.drawable.metallica));
    }

    /**
     * Gets the entire ArrayList of Albums
     */
    public ArrayList<Album> getList() {
        return albumArrayList;
    }

    /**
     * Gets the title of the i Album in the AlbumList
     */
    public String getTitle(int i) {
        return albumArrayList.get(i).getTitle();
    }

    /**
     * Gets the cover ID  of the i Album in the AlbumList
     */
    public int getAlbumCoverID(int i) {
        return albumArrayList.get(i).getAlbumCoverID();
    }

}
