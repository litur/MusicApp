package com.example.android.musicapp;

import android.content.Intent;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
import android.support.design.internal.BottomNavigationItemView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CurrentSongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_current_song);

        // Sets the Toolbar as Action Bar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        // Defines custom behaviour on the Action Bar
        ActionBar myActionBar = getSupportActionBar();
        assert myActionBar != null;
        myActionBar.setTitle(R.string.title_activity_current_song);

        // recovers the songId from the calling Activity
        Intent intent = getIntent();
        int index = intent.getIntExtra("SongID", 0);

        // sets the values of TextViews and ImageView according to the values of the retrieved Song
        TextView titleTextView = findViewById(R.id.title_text_view);
        TextView artistTextView = findViewById(R.id.artist_text_view);
        ImageView albumCoverImageView = findViewById(R.id.album_cover_image_view);

        titleTextView.setText(MainActivity.mSongs.getTitle(index));
        artistTextView.setText(MainActivity.mSongs.getArtist(index));
        albumCoverImageView.setImageResource(MainActivity.mAlbums.getAlbumCoverID(MainActivity.mSongs.getAlbumID(index)));

        // sets an intent on the Image to call the AlbumDetailActivity for the specific Album
        final int albumId = MainActivity.mSongs.getAlbumID(index);

        // Set a click listener on that Album Image Button
        albumCoverImageView.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Album Image is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link AlbumDetailActivity}
                Intent albumDetailIntent = new Intent(CurrentSongActivity.this, AlbumDetailActivity.class);
                albumDetailIntent.putExtra("AlbumID", albumId);
                CurrentSongActivity.this.startActivity(albumDetailIntent);
            }
        });

        // Apply grayscale filter to the album Image from
        // https://gist.github.com/nisrulz/3078eaa6357d6f5c0051
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);
        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
        albumCoverImageView.setColorFilter(filter);

        //Defines actions for the bottom navigation menu
        BottomNavigationItemView SongsView = findViewById(R.id.navigation_home);
        assert SongsView != null;
        SongsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent songsIntent = new Intent(CurrentSongActivity.this, MainActivity.class);
                startActivity(songsIntent);
            }
        });

        BottomNavigationItemView AlbumView = findViewById(R.id.navigation_notifications);
        assert AlbumView != null;
        AlbumView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent albumsIntent = new Intent(CurrentSongActivity.this, AlbumActivity.class);
                startActivity(albumsIntent);
            }
        });
    }

    // create an action bar button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //TODO completare comportamento preferiti
    //TODO mettere barriera in layout item della list view delle Songs
    //TODO mettere un pulsante Play

}
