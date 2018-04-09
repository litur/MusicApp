package com.example.android.musicapp;

import android.content.Intent;
import android.support.design.internal.BottomNavigationItemView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class AlbumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);


        AlbumList mAlbums = new AlbumList();

        ArrayList<Album> albums = mAlbums.getList();

        AlbumAdapter adapter = new AlbumAdapter(this, albums);

        GridView gridView = findViewById(R.id.albums_grid_view);

        gridView.setAdapter(adapter);

        //Defines actions for the bottom navigation menu
        BottomNavigationItemView SongsView = findViewById(R.id.navigation_home);
        assert SongsView != null;
        SongsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent songsIntent = new Intent(AlbumActivity.this, SongsActivity.class);
                startActivity(songsIntent);
            }
        });

    }
}
