package com.example.android.musicapp;

import java.util.ArrayList;

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


}
