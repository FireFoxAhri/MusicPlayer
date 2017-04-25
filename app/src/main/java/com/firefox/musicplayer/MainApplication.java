package com.firefox.musicplayer;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.firefox.musicplayer.bean.Music;

import java.util.ArrayList;

/**
 * Created by FireFox on 2017/4/22.
 */

public class MainApplication extends Application {
    private static Context context;
    private static ArrayList<Music> playList = null;


    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);
        context = getApplicationContext();

        if (playList == null) {

        }
    }

    public static ArrayList<Music> getPlayList() {
        return playList;
    }

    public static void setPlayList(ArrayList<Music> playList) {
        MainApplication.playList = playList;
    }

    public static Context getInstance() {
        return context;
    }

}
