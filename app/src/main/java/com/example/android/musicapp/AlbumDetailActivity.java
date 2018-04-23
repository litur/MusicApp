package com.example.android.musicapp;

import android.content.Intent;
import android.support.design.internal.BottomNavigationItemView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class AlbumDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_detail);

        // Sets the Toolbar as Action Bar
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        // recovers the AlbumId from the calling Activity
        Intent intent = getIntent();
        int index = intent.getIntExtra("AlbumID", 0);

        // Defines custom behaviour on the Action Bar
        ActionBar myActionBar = getSupportActionBar();
        assert myActionBar != null;
        myActionBar.setTitle(SplashActivity.MALBUMS.getTitle(index));

        //Sets the Cover Image in the dedicated ImageView
        ImageView albumCover = findViewById(R.id.album_cover_image);
        albumCover.setImageResource(SplashActivity.MALBUMS.getAlbumCoverID(index));

        ArrayList<Song> songs = SplashActivity.MSONGS.getAlbumSongs(index);

        SongAdapter adapter = new SongAdapter(this, songs);

        ListView listView = findViewById(R.id.album_songs_list_view);

        listView.setAdapter(adapter);

        //Defines actions for the bottom navigation menu
        BottomNavigationItemView SongsView = findViewById(R.id.navigation_songs);
        assert SongsView != null;
        SongsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent songsIntent = new Intent(AlbumDetailActivity.this, MainActivity.class);
                startActivity(songsIntent);
            }
        });

        BottomNavigationItemView AlbumView = findViewById(R.id.navigation_albums);
        assert AlbumView != null;
        AlbumView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent albumsIntent = new Intent(AlbumDetailActivity.this, AlbumActivity.class);
                startActivity(albumsIntent);
            }
        });
    }
}
