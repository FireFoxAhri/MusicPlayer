package com.firefox.musicplayer.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.widget.Toast;

import com.firefox.musicplayer.ui.music.MusicPlayList;

public class PlayMusicService extends Service {

    MusicPlayList musicPlayList;

    public PlayMusicService() {
    }


    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String url=intent.getStringExtra("sourceuri");
        Toast.makeText(this,url, Toast.LENGTH_SHORT).show();
            MediaPlayer player=new MediaPlayer();
            player = MediaPlayer.create(PlayMusicService.this, Uri.parse(url));//实例化对象，通过播放本机服务器上的一首音乐
            player.setLooping(false);//设置不循环播放
            player.start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }




}
