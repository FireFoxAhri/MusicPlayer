package com.firefox.musicplayer.listener;

import com.firefox.musicplayer.bean.Music;

public interface OnLoadInformationListener
{
    void onLoadInformation(Music music, boolean isPlaying, boolean isContinue);
}
