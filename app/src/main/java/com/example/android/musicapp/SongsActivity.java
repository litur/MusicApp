package com.example.android.musicapp;

import android.content.Intent;
import android.support.design.internal.BottomNavigationItemView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;


public class SongsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);

        SongList mSongs = new SongList();

        ArrayList<Song> songs = mSongs.getList();

        SongAdapter adapter = new SongAdapter(this, songs);

        ListView listView = findViewById(R.id.songListView);

        listView.setAdapter(adapter);

        //Defines actions for the bottom navigation menu
        BottomNavigationItemView AlbumView = findViewById(R.id.navigation_notifications);
        assert AlbumView != null;
        AlbumView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent albumsIntent = new Intent(SongsActivity.this, AlbumActivity.class);
                startActivity(albumsIntent);
            }
        });
    }


}
