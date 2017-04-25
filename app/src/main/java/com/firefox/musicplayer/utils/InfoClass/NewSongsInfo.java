package com.firefox.musicplayer.utils.InfoClass;

/**
 * Created by 俗 on 2017/4/23.
 */
public class NewSongsInfo{
    private String name;
    private String sourceurl;
    private String  imageurl;

    public NewSongsInfo(String name, String imageurl, String sourceurl) {
        this.name = name;
        this.sourceurl = sourceurl;
        this.imageurl = imageurl;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
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