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

        albumArrayList.add(new Album(0, "Californication", R.drawable.californication));
        albumArrayList.add(new Album(1, "Metallica", R.drawable.metallica));
        albumArrayList.add(new Album(2, "Mellon Collie and the Infinite Sadness", R.drawable.mellon_collie));
        albumArrayList.add(new Album(3, "Automatic for the People", R.drawable.automatic));
        albumArrayList.add(new Album(4, "Wish You Were Here", R.drawable.wishyouwerehere));
        albumArrayList.add(new Album(5, "Mesmerize", R.drawable.mesmerize));
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
