package com.firefox.musicplayer.bean;

/**
 * Created by FireFox on 2017/4/24.
 */

public class Music {
    private String musicName;
    private String musicURL;
    private String musicID;
    private String albumName;
    private String sAlbumURL;
    private String bAlbumURL;
    private String lrcURL;
    private String artistName;
    private boolean isLocal;

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getMusicURL() {
        return musicURL;
    }

    public void setMusicURL(String musicURL) {
        this.musicURL = musicURL;
    }

    public String getMusicID() {
        return musicID;
    }

    public void setMusicID(String musicID) {
        this.musicID = musicID;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getsAlbumURL() {
        return sAlbumURL;
    }

    public void setsAlbumURL(String sAlbumURL) {
        this.sAlbumURL = sAlbumURL;
    }

    public String getbAlbumURL() {
        return bAlbumURL;
    }

    public void setbAlbumURL(String bAlbumURL) {
        this.bAlbumURL = bAlbumURL;
    }

    public String getLrcURL() {
        return lrcURL;
    }

    public void setLrcURL(String lrcURL) {
        this.lrcURL = lrcURL;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public boolean isLocal() {
        return isLocal;
    }

    public void setLocal(boolean local) {
        isLocal = local;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Music music = (Music) o;

        return musicURL != null ? musicURL.equals(music.musicURL) : music.musicURL == null;

    }

    @Override
    public int hashCode()
    {
        return musicURL != null ? musicURL.hashCode() : 0;
    }
}
