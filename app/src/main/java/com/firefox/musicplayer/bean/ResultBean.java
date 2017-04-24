package com.firefox.musicplayer.bean;

import java.util.List;

/**
 * Created by FireFox on 2017/4/24.
 */

public class ResultBean {

    private int songCount;
    private List<SongsBean> songs;

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public List<SongsBean> getSongs() {
        return songs;
    }

    public void setSongs(List<SongsBean> songs) {
        this.songs = songs;
    }

}