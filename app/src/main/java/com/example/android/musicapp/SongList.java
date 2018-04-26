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

        songArrayList.add(new Song(0, "Scar Tissue", "Red Hot Chili Peppers", 0, 312, R.raw.song1));
        songArrayList.add(new Song(1, "Otherside", "Red Hot Chili Peppers", 0, 243, R.raw.song2));
        songArrayList.add(new Song(2, "Enter Sandman", "Metallica", 1, 389, R.raw.song3));
        songArrayList.add(new Song(3, "Zero", "The Smashing Pumpkins", 2, 160, R.raw.song4));
        songArrayList.add(new Song(4, "Bullet with Butterfly Wings", "The Smashing Pumpkins", 2, 258, R.raw.song5));
        songArrayList.add(new Song(5, "Drive", "R.E.M.", 3, 269, R.raw.song6));
        songArrayList.add(new Song(6, "Sweetness Follows", "R.E.M.", 3, 260, R.raw.song7));
        songArrayList.add(new Song(7, "Wish You were here", "Pink Floyd", 4, 340, R.raw.song8));
        songArrayList.add(new Song(8, "Question!", "System of a Down", 5, 201, R.raw.song9));
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

    /**
     * Gets the ID of the associated Raw file of the i Song in the SongList
     */
    public int getRawID(int i) {
        return songArrayList.get(i).getRawID();
    }
}
