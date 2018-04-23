package com.example.android.musicapp;

import android.content.Context;
import android.widget.Toast;


/**
 * Created by RutiglianoL on 31/03/2018.
 */

public class Utility {

    public static String convertDuration(Integer durationInSeconds) {
        int mins = durationInSeconds / 60;
        int secs = durationInSeconds - mins * 60;

        String duration = mins + ":" + secs;
        return duration;
    }

    /**
     * Displays the given Message in a toast
     *
     * @param toastMessage the message (string) to be displayed by the toast
     */
    public static void showToast(String toastMessage, Context context) {

        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, toastMessage, duration);
        toast.show();
    }


}
