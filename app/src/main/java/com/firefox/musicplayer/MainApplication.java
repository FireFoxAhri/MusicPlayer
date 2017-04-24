package com.firefox.musicplayer;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by FireFox on 2017/4/22.
 */

public class MainApplication extends Application {
    private static Context context;
    private static SharedPreferences sharedPreferences;
    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);
        context=getApplicationContext();
    }

    public static Context getInstance()
    {
        return context;
    }

}
