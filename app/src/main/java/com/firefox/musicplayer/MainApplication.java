package com.firefox.musicplayer;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by FireFox on 2017/4/22.
 */

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);


    }
}
