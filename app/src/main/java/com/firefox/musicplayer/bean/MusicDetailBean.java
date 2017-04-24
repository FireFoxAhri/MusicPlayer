package com.firefox.musicplayer.bean;

import java.util.List;

/**
 * Created by FireFox on 2017/4/24.
 */

public class MusicDetailBean {

    /**
     * songs : [{"name":"Moon Without The Stars","id":28377211,"position":14,"alias":[],"status":0,"fee":0,"copyrightId":0,"disc":"2","no":15,"artists":[{"name":"Quiana","id":194643,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0},{"name":"Jerry Barnes","id":0,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0}],"album":{"name":"古树旋律 Deemo","id":2774288,"type":"专辑","size":127,"picId":6046214441318535,"blurPicUrl":"http://p1.music.126.net/LH7PtVBMt02PbphpyAiNmw==/6046214441318535.jpg","companyId":0,"pic":6046214441318535,"picUrl":"http://p1.music.126.net/LH7PtVBMt02PbphpyAiNmw==/6046214441318535.jpg","publishTime":1384272000007,"description":"","tags":"","company":"雷亚游戏","briefDesc":"","artist":{"name":"","id":0,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0},"songs":[],"alias":[],"status":3,"copyrightId":0,"commentThreadId":"R_AL_3_2774288","artists":[{"name":"群星","id":122455,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0}],"subType":"录音室版"},"starred":false,"popularity":95,"score":95,"starredNum":0,"duration":213864,"playedNum":0,"dayPlays":0,"hearTime":0,"ringtone":"","crbt":null,"audition":null,"copyFrom":"","commentThreadId":"R_SO_4_28377211","rtUrl":null,"ftype":0,"rtUrls":[],"copyright":2,"mvid":0,"bMusic":{"name":"Moon Without The Stars","id":46689712,"size":2590737,"extension":"mp3","sr":44100,"dfsId":6027522743661760,"bitrate":96000,"playTime":213864,"volumeDelta":-2.65076E-4},"mp3Url":"http://m2.music.126.net/t24d6GoZRkqxzFAovlZEQw==/6027522743661760.mp3","rtype":0,"rurl":null,"hMusic":null,"mMusic":{"name":"Moon Without The Stars","id":46689711,"size":4300608,"extension":"mp3","sr":44100,"dfsId":6037418348311743,"bitrate":160000,"playTime":213864,"volumeDelta":-2.65076E-4},"lMusic":{"name":"Moon Without The Stars","id":46689712,"size":2590737,"extension":"mp3","sr":44100,"dfsId":6027522743661760,"bitrate":96000,"playTime":213864,"volumeDelta":-2.65076E-4}}]
     * equalizers : {}
     * code : 200
     */

    private EqualizersBean equalizers;
    private int code;
    private List<SongsBean> songs;

    public EqualizersBean getEqualizers() {
        return equalizers;
    }

    public void setEqualizers(EqualizersBean equalizers) {
        this.equalizers = equalizers;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<SongsBean> getSongs() {
        return songs;
    }

    public void setSongs(List<SongsBean> songs) {
        this.songs = songs;
    }

    public static class EqualizersBean {
    }


}
