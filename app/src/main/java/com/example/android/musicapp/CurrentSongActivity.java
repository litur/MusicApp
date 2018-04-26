package com.example.android.musicapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

import static com.example.android.musicapp.Utility.showToast;

public class CurrentSongActivity extends AppCompatActivity {
    
    public MediaPlayer mediaPlayer = new MediaPlayer();
    public TextView titleTextView;
    public TextView artistTextView;
    public ImageView albumCoverImageView;
    public String mySongTitle;
    public String myArtistName;
    public int myAlbumCoverResID;
    public int myAlbumId;
    public FloatingActionButton myPlayButton;
    public FloatingActionButton myPauseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int myRaw;

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_current_song);

        // recovers the songId from the calling Activity
        Intent intent = getIntent();
        int index = intent.getIntExtra("SongID", 0);

        // recovers the Raw Id of the media file associated to the Song and sets a mediaplayer for the raw
        myRaw = SplashActivity.MSONGS.getRawID(index);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(getApplicationContext(), Uri.parse("android.resource://com.example.android.musicapp/" + String.valueOf(myRaw)));
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mySongTitle = SplashActivity.MSONGS.getTitle(index);
        myArtistName = SplashActivity.MSONGS.getArtist(index);
        myAlbumCoverResID = SplashActivity.MALBUMS.getAlbumCoverID(SplashActivity.MSONGS.getAlbumID(index));
        myAlbumId = SplashActivity.MSONGS.getAlbumID(index);

        initialize();

        // Displays a toastMessage with the name and artist of the Song  Virtually played.
        // And stars the media player

        mediaPlayer.start();
        myPlayButton.setClickable(false);
        showToast(getString(R.string.currently_playing, SplashActivity.MSONGS.getTitle(index), SplashActivity.MSONGS.getArtist(index)), this);

    }

    // Iniziatlizes the layout. It'called on both OnCreate and onConfigurationChanged
    private void initialize() {
        // Sets the Toolbar as Action Bar
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        // Defines custom behaviour on the Action Bar
        ActionBar myActionBar = getSupportActionBar();
        assert myActionBar != null;
        myActionBar.setTitle(R.string.title_activity_current_song);

        // sets the values of TextViews and ImageView according to the values of the retrieved Song
        titleTextView = findViewById(R.id.title_text_view);
        titleTextView.setText(mySongTitle);
        artistTextView = findViewById(R.id.artist_text_view);
        artistTextView.setText(myArtistName);
        albumCoverImageView = findViewById(R.id.album_cover_image_view);
        albumCoverImageView.setImageResource(myAlbumCoverResID);

        applyGreyscaleFilter();

        // sets an intent on the Image to call the AlbumDetailActivity for the specific Album
        // Set a click listener on that Album Image Button
        albumCoverImageView.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Album Image is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link AlbumDetailActivity}
                Intent albumDetailIntent = new Intent(CurrentSongActivity.this, AlbumDetailActivity.class);
                albumDetailIntent.putExtra("AlbumID", myAlbumId);
                CurrentSongActivity.this.startActivity(albumDetailIntent);
            }
        });

        // Handles Play and Pause buttons
        myPlayButton = findViewById(R.id.play_button);
        myPauseButton = findViewById(R.id.pause_button);
        // Set a click listener on the Play Button
        myPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Starts the mediaPlayer
                // Disables the Play Button to prevent multiple playing of the same track
                // Enables the pause Button
                mediaPlayer.start();
                myPlayButton.setClickable(false);
                myPauseButton.setClickable(true);
            }
        });

        // Set a click listener on the Pause Button
        myPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Pauses the mediaPlayer
                // Disables the Pause Button
                // Enables the Play Button
                mediaPlayer.pause();
                myPauseButton.setClickable(false);
                myPlayButton.setClickable(true);
            }
        });

        //Defines actions for the bottom navigation menu
        BottomNavigationItemView SongsView = findViewById(R.id.navigation_songs);
        assert SongsView != null;
        SongsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent songsIntent = new Intent(CurrentSongActivity.this, MainActivity.class);
                startActivity(songsIntent);
            }
        });

        BottomNavigationItemView AlbumView = findViewById(R.id.navigation_albums);
        assert AlbumView != null;
        AlbumView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent albumsIntent = new Intent(CurrentSongActivity.this, AlbumActivity.class);
                startActivity(albumsIntent);
            }
        });

    }

    // Apply grayscale filter to the album Image from
    // https://gist.github.com/nisrulz/3078eaa6357d6f5c0051
    private void applyGreyscaleFilter() {
        ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(0);
        ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
        albumCoverImageView.setColorFilter(filter);
    }

    // create an action bar button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // If the user quits the Activity, the Media Player is killed
    // This is to prevent multiple tracks playing at the same time
    // Probably in this the best option should be handling the MediaPlayer in a service
    // as discussed here (https://developer.android.com/guide/topics/media/mediaplayer.html)
    @Override
    public void onPause() {
        super.onPause();
        mediaPlayer.release();
        mediaPlayer = null;
    }

    // Handles the change os screen orientation to prevent the Activity to be Stopped and so to prevent the Mediaplayer
    // from stopping
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        //int orientation = this.getResources().getConfiguration().orientation;

        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_current_song);
        } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_current_song);
        }
        initialize();
    }
}
