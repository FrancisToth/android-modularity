package com.example.androidmontreal.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RaceResultUtil {

    private static Date date = new Date();
    private static SimpleDateFormat raceResultFormat = new SimpleDateFormat("mm:ss");

    public static synchronized String toString(long result) {
        date.setTime(result);
        return raceResultFormat.format(date);
    }
}
