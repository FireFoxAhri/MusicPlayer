package com.firefox.musicplayer;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by FireFox on 2017/4/22.
 */

public class MainApplication extends Application {
    private static MainApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);
        instance=this;
    }

    public static Context getInstance()
    {
        return instance;
    }
}
