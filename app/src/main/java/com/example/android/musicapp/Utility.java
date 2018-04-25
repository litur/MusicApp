package com.example.android.musicapp;

import android.content.Context;
import android.view.ViewDebug;
import android.widget.Toast;


/**
 * Created by RutiglianoL on 31/03/2018.
 */

class Utility {

    /**
     * Converts the duration (ie of a Song) from seconds to the format (mm:ss)
     *
     * @param durationInSeconds a duration in secondds
     * @return duration
     */
    static String convertDuration(Integer durationInSeconds) {
        int mins = durationInSeconds / 60;
        int secs = durationInSeconds - mins * 60;
        String secsString;
        if (secs < 10)
            secsString = "0" + String.valueOf(secs);
        else
            secsString = String.valueOf(secs);

        String duration = String.valueOf(mins) + ":" + secsString;
        return duration;
    }

    /**
     * Displays the given Message in a toast
     * @param toastMessage the message (string) to be displayed by the toast
     */
    static void showToast(String toastMessage, Context context) {

        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, toastMessage, duration);
        toast.show();
    }


}
