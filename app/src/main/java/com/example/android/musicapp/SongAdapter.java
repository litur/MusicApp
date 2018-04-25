package com.example.android.musicapp;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.android.musicapp.Utility.convertDuration;

/**
 * Created by RutiglianoL on 31/03/2018.
 */

public class SongAdapter extends ArrayAdapter<Song> {

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param Song    A List of Song objects to display in a list
     */

    public SongAdapter(Activity context, ArrayList<Song> Song) {

        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.

        super(context, 0, Song);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final int mySong;

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_songs, parent, false);
        }

        // Gets the {@link Song} object located at this position in the list
        Song currentSong = getItem(position);

        // Finds the TextView for the Song title and sets the value
        TextView titleTextView = listItemView.findViewById(R.id.title_text_view);
        assert currentSong != null;
        titleTextView.setText(currentSong.getTitle());

        // Finds the TextView for the Artist and sets the value
        TextView artistTextView = listItemView.findViewById(R.id.artist_text_view);
        artistTextView.setText(currentSong.getArtist());

        // Finds the TextView for the Album title and sets the value
        TextView albumTextView = listItemView.findViewById(R.id.album_textview);
        albumTextView.setText(SplashActivity.MALBUMS.getTitle(currentSong.getAlbumID()));

        // Finds the TextView for the duration of the Song  and sets the value
        TextView durationTextView = listItemView.findViewById(R.id.duration_text_view);
        durationTextView.setText(convertDuration(currentSong.getDuration()));

        ImageView playButton = listItemView.findViewById(R.id.play_imageView);

        mySong = currentSong.getID();

        // Set a click listener on that Play Button
        playButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the Play Button is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link CurrentSongActivity}
                Intent playIntent = new Intent(getContext(), CurrentSongActivity.class);
                playIntent.putExtra("SongID", mySong);
                getContext().startActivity(playIntent);
            }
        });

        // Return the whole list item layout
        // so that it can be shown in the ListView
        return listItemView;
    }


}
