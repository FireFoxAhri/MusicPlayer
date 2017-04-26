package com.firefox.musicplayer;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.firefox.musicplayer.bean.Music;
import com.firefox.musicplayer.database.MusicStore;

import java.util.ArrayList;

/**
 * Created by FireFox on 2017/4/22.
 */

public class MainApplication extends Application {
    private static Context context;
    private static ArrayList<Music> playList = null;

    public static int getCurrentIndex() {
        return currentIndex;
    }

    public static void setCurrentIndex(int currentIndex) {
        MainApplication.currentIndex = currentIndex;
    }

    private static int currentIndex=0;

    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);
        context = getApplicationContext();

        if (playList == null) {
            MusicStore database = new MusicStore(this);
            playList= MusicStore.getPlayList();
        }
    }

    public static ArrayList<Music> getPlayList() {
        return playList;
    }

    public static Context getInstance() {
        return context;
    }

}
