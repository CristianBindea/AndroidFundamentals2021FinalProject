package com.cristianbindea.androidfundamentals2021finalproject;

public class DataConverter {
    public static int timeTotalMinutes(int hours, int minutes) {
        return hours * 60 + minutes;
    }

    public static String timeInt2String(int time) {

        int hours = time / 60;
        int minutes = time % 60;
        return hours + " : " + minutes;
    }
}
