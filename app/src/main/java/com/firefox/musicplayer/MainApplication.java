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
    private static int nextIndex = -1;
    private static int currentIndex = 0;

    public static int getNextIndex() {
        return nextIndex;
    }

    public static void setNextIndex(int nextIndex) {
        MainApplication.nextIndex = nextIndex;
    }



    public static int getCurrentIndex() {
        return currentIndex;
    }

    public static void setCurrentIndex(int currentIndex) {
        MainApplication.currentIndex = currentIndex;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);
        context = getApplicationContext();

        MusicStore musicStore = new MusicStore(this);
        if (playList == null) {
            playList = MusicStore.getPlayList();
        }
    }

    public static ArrayList<Music> getPlayList() {
        return playList;
    }

    public static Context getInstance() {
        return context;
    }


    public static void nextPlay(Music music) {
        if (playList.contains(music)) {
            nextIndex = playList.indexOf(music);
        } else {
            playList.add(music);
            nextIndex = playList.size() - 1;
        }
        MusicStore musicStore = new MusicStore(context);
        musicStore.updatePlayList(playList);
    }

}
