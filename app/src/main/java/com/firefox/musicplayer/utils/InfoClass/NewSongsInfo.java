package com.firefox.musicplayer.utils.InfoClass;

/**
 * Created by 俗 on 2017/4/23.
 */
public class NewSongsInfo{
    private String name;
    private String sourceurl;

    public NewSongsInfo(String name, String sourceurl) {
        this.name = name;
        this.sourceurl = sourceurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSourceurl() {
        return sourceurl;
    }

    public void setSourceurl(String sourceurl) {
        this.sourceurl = sourceurl;
    }
}