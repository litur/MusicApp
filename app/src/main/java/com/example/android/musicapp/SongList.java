package com.example.android.musicapp;

import java.util.ArrayList;

/**
 * Created by RutiglianoL on 03/04/2018.
 */

public class SongList extends ArrayList {

    private ArrayList<Song> songArrayList;

    {
        songArrayList = new ArrayList<Song>();
    }

    //We create an ArrayList of Song Objects

    public SongList() {

        songArrayList.add(new Song("Scar Tissue", "Red Hot Chili Peppers", "Californication", 0, 312));
        songArrayList.add(new Song("Otherside", "Red Hot Chili Peppers", "Californication", 0, 243));
        songArrayList.add(new Song("Enter Sandman", "Metallica", "Metallica", 1, 389));
        songArrayList.add(new Song("Zero", "The Smashing Pumpkins", "Mellon Collie and the Infinite Sadness", 2, 155));
    }

    /**
     * Gets the entire ArrayList of Songs
     */
    public ArrayList<Song> getList() {
        return songArrayList;
    }

    /**
     * Gets the title of the i Song in the SongList
     */
    public String getTitle(int i) {
        return songArrayList.get(i).getTitle();
    }

    /**
     * Gets the Artist of the i Song in the SongList
     */
    public String getArtist(int i) {
        return songArrayList.get(i).getArtist();
    }

    /**
     * Gets the title of the Album of the i Song in the SongList
     */
    public String getAlbum(int i) {
        return songArrayList.get(i).getAlbum();
    }

    /**
     * Gets the Artist of the i Song in the SongList
     */
    public int getAlbumID(int i) {
        return songArrayList.get(i).getAlbumID();
    }
}
