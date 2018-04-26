package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.internal.BottomNavigationItemView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Recovers the songs data from the SongList and sets the ListView
        ArrayList<Song> songs = SplashActivity.MSONGS.getList();
        SongAdapter adapter = new SongAdapter(this, songs);
        ListView listView = findViewById(R.id.songListView);
        listView.setAdapter(adapter);

        // Sets the Toolbar as Action Bar
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        // Defines custom behaviour on the Action Bar
        ActionBar myActionBar = getSupportActionBar();
        assert myActionBar != null;
        myActionBar.setTitle(R.string.title_activity_main);


        //Defines actions for the bottom navigation menu
        BottomNavigationItemView AlbumView = findViewById(R.id.navigation_albums);
        assert AlbumView != null;
        AlbumView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent albumsIntent = new Intent(MainActivity.this, AlbumActivity.class);
                startActivity(albumsIntent);
            }
        });

    }
}

