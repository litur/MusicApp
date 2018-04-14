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

        songArrayList.add(new Song("Scar Tissue", "Red Hot Chili Peppers", 0, 312));
        songArrayList.add(new Song("Otherside", "Red Hot Chili Peppers", 0, 243));
        songArrayList.add(new Song("Enter Sandman", "Metallica", 1, 389));
        songArrayList.add(new Song("Zero", "The Smashing Pumpkins", 2, 160));
        songArrayList.add(new Song("Bullet with Butterfly Wings", "The Smashing Pumpkins", 2, 258));
        songArrayList.add(new Song("Drive", "R.E.M.", 3, 269));
        songArrayList.add(new Song("Sweetness Follows", "R.E.M.", 3, 260));
        songArrayList.add(new Song("Wish You were here", "Pink Floyd", 4, 340));
        songArrayList.add(new Song("Question!", "System of a Down", 5, 201));
    }

    /**
     * Gets an ArrayList of Songs belonging to a specific Album
     * params @myAlbumID the ID of  the Album of which we want to retrieve the songs
     */
    public ArrayList<Song> getAlbumSongs(int myAlbumID) {

        ArrayList<Song> albumSongArrayList = new ArrayList<Song>();

        // Cycles through the songArrayList
        // If it finds a song belonging to the Album, the song is added to the AlbumSongArrayList
        for (int i = 0; i < songArrayList.size(); i++) {
            if (songArrayList.get(i).getAlbumID() == myAlbumID) {
                albumSongArrayList.add(songArrayList.get(i));
            }
        }
        return albumSongArrayList;
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
     * Gets the Artist of the i Song in the SongList
     */
    public int getAlbumID(int i) {
        return songArrayList.get(i).getAlbumID();
    }
}
