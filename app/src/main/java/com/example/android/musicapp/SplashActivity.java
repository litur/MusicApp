package com.example.android.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    // Initialize the SongList and AlbumList used throughout the whole application
    // Since, for the scope of the app, we don't need to modify them they are declared as final
    public static final SongList MSONGS = new SongList();
    public static final AlbumList MALBUMS = new AlbumList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
