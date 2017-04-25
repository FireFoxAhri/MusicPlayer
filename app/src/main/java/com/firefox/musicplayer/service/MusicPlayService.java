package com.firefox.musicplayer.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.firefox.musicplayer.MainApplication;
import com.firefox.musicplayer.bean.Music;
import com.firefox.musicplayer.listener.OnLoadInformationListener;
import com.firefox.musicplayer.listener.OnProgressListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by FireFox on 2017/4/24.
 */

public class MusicPlayService extends Service implements MediaPlayer.OnCompletionListener {
    private OnProgressListener onProgressListener;
    private OnLoadInformationListener onLoadInformationListener;
    ArrayList<Music> playList = null;
    static MediaPlayer mediaPlayer;

    public static final int ORDER_PLAY = 0;//顺序播放
    public static final int RANDOM_PLAY = 1;//随机播放
    public static final int SINGLE_PLAY = 2;//单曲循环
    private int playMode = ORDER_PLAY;
    private int currentIndex = 0;


    boolean flag_play = false;
    boolean flag_continue = false;

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = new MediaPlayer();
        playList = MainApplication.getPlayList();
        mediaPlayer.setOnCompletionListener(this);
    }

    public void startPlay(int index) {
        if (index >= 0 && index < playList.size()) {
            try {
                flag_play = true;
                flag_continue = false;
                mediaPlayer.reset();
                mediaPlayer.setDataSource(playList.get(index).getMusicURL());
                mediaPlayer.prepare();
                mediaPlayer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            currentIndex = (currentIndex + index) % playList.size();
            mediaPlayer.reset();
            startPlay(currentIndex);
        }
    }


    public class PlayBinder extends Binder {
        public MusicPlayService getService() {
            return MusicPlayService.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new PlayBinder();
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        switch (playMode) {
            case ORDER_PLAY://顺序播放
                startPlay(++currentIndex);
                break;
            case RANDOM_PLAY://随机播放
                mediaPlayer.reset();
                startPlay(new Random().nextInt(playList.size()));
                break;
            case SINGLE_PLAY://单曲循环
                mediaPlayer.reset();
                startPlay(currentIndex);
                break;
        }
    }
}
