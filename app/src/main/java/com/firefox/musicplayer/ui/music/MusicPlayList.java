package com.firefox.musicplayer.ui.music;

import android.app.Application;

import com.firefox.musicplayer.bean.Music;
import com.firefox.musicplayer.database.MusicStore;

import java.util.ArrayList;

/**
 * Created by 凛 on 2016/3/26.
 */
public class MusicPlayList extends Application
{
    private ArrayList<Music> musicList;
    private int currentIndex;          //当前播放下标
    private int nextIndex;

    @Override
    public void onCreate()
    {
        super.onCreate();
        if (musicList == null)
        {
            MusicStore database = new MusicStore(this);
            musicList = database.getPlayList();
        }
    }

    public int getCurrentIndex()
    {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex)
    {
        this.currentIndex = currentIndex;
    }

    public int getNextIndex()
    {
        return nextIndex;
    }

    public void setNextIndex(int nextIndex)
    {
        this.nextIndex = nextIndex;
    }

    public ArrayList<Music> getMusicList()
    {
        return musicList;
    }

    public void insertMusic(Music music)
    {
        if (musicList.contains(music))
        {
            currentIndex = musicList.indexOf(music);
        } else
        {
            musicList.add(music);
            currentIndex = musicList.size() - 1;
        }
        MusicStore musicStore = new MusicStore(this);
        musicStore.updatePlayList(musicList);
    }
    public void nextPlay(Music music)
    {
        if (musicList.contains(music))
        {
            nextIndex = musicList.indexOf(music);
        } else
        {
            musicList.add(music);
            nextIndex = musicList.size() - 1;
        }
        MusicStore musicStore = new MusicStore(this);
        musicStore.updatePlayList(musicList);
    }

}
