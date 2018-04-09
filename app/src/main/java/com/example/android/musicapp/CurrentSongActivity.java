package com.example.android.musicapp;

import android.content.Intent;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CurrentSongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_current_song);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SongList mSongs = new SongList();
        AlbumList mAlbums = new AlbumList();

        Intent intent = getIntent();

        int index = intent.getIntExtra("SongID", 0);

        TextView titleTextView = findViewById(R.id.title_text_view);
        TextView artistTextView = findViewById(R.id.artist_text_view);
        ImageView albumCoverImageView = findViewById(R.id.album_cover_image_view);

        titleTextView.setText(mSongs.getTitle(index));
        artistTextView.setText(mSongs.getArtist(index));
        albumCoverImageView.setImageResource(mAlbums.getAlbumCoverID(mSongs.getAlbumID(index)));


        // Apply grayscale filter to the album Image from
        // https://gist.github.com/nisrulz/3078eaa6357d6f5c0051
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);
        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
        albumCoverImageView.setColorFilter(filter);
    }

}
