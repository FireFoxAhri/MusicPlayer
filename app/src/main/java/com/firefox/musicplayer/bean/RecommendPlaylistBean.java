package com.firefox.musicplayer.bean;

import java.util.List;

/**
 * Created by FireFox on 2017/4/24.
 */

public class RecommendPlaylistBean {


    /**
     * hasTaste : false
     * code : 200
     * category : 0
     * result : [{"id":702531269,"type":0,"name":"日常一笑? 这些充满魔性喜感的影视原声","copywriter":"编辑推荐：欢乐幽默的影视原声，只为博你一笑","picUrl":"http://p1.music.126.net/JGYvA7d0vRs3qrfRFL_C1w==/18588343581086356.jpg","canDislike":false,"playCount":469008.4,"trackCount":126,"highQuality":false,"alg":"featured"},{"id":556734085,"type":0,"name":"【欧美】魅暗电子|迷离女声.迷失于残光下","copywriter":"编辑推荐：迷离女声，听完好像做了一场梦","picUrl":"http://p1.music.126.net/cVcDwYWgRiyTBLoSUPLngQ==/18503681185593222.jpg","canDislike":false,"playCount":201930.4,"trackCount":62,"highQuality":false,"alg":"featured"},{"id":548626796,"type":0,"name":"重温旧梦·电影里的深情告白","copywriter":"热门歌单推荐","picUrl":"http://p1.music.126.net/HJ33z38SWj4ZGjGl6hheSQ==/18678503534940630.jpg","canDislike":true,"playCount":2645629.5,"trackCount":53,"highQuality":false,"alg":"hot_server"},{"id":377539909,"type":0,"name":"器乐纯音 | 独立音乐人的无言之声","copywriter":"在器乐声中感知独立音乐人的内心世界","picUrl":"http://p1.music.126.net/AmyP8_c4VaN52A5lZHTi4g==/1397479292528900.jpg","canDislike":true,"playCount":1596058.1,"trackCount":154,"highQuality":true,"alg":"hot_server"},{"id":632503024,"type":0,"name":"梦幻旋律｜Chillstep 轻度失眠患者福利","copywriter":"热门歌单推荐","picUrl":"http://p1.music.126.net/Y7yByRiR0ewrV0rf3GSPnA==/18745573743806401.jpg","canDislike":true,"playCount":2278932.2,"trackCount":67,"highQuality":false,"alg":"hot_server"},{"id":105258318,"type":0,"name":"【欧美】动画剧集的魔性洗脑曲","copywriter":"欧美动画中的那些神曲","picUrl":"http://p1.music.126.net/-ZKHhXSWkaaUSqphJeQSSQ==/3433774818854125.jpg","canDislike":true,"playCount":1651185.4,"trackCount":202,"highQuality":true,"alg":"hot_server"}]
     */

    private boolean hasTaste;
    private int code;
    private int category;
    private List<ResultBean> result;

    public boolean isHasTaste() {
        return hasTaste;
    }

    public void setHasTaste(boolean hasTaste) {
        this.hasTaste = hasTaste;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * id : 702531269
         * type : 0
         * name : 日常一笑? 这些充满魔性喜感的影视原声
         * copywriter : 编辑推荐：欢乐幽默的影视原声，只为博你一笑
         * picUrl : http://p1.music.126.net/JGYvA7d0vRs3qrfRFL_C1w==/18588343581086356.jpg
         * canDislike : false
         * playCount : 469008.4
         * trackCount : 126
         * highQuality : false
         * alg : featured
         */

        private int id;
        private int type;
        private String name;
        private String copywriter;
        private String picUrl;
        private boolean canDislike;
        private double playCount;
        private int trackCount;
        private boolean highQuality;
        private String alg;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCopywriter() {
            return copywriter;
        }

        public void setCopywriter(String copywriter) {
            this.copywriter = copywriter;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public boolean isCanDislike() {
            return canDislike;
        }

        public void setCanDislike(boolean canDislike) {
            this.canDislike = canDislike;
        }

        public double getPlayCount() {
            return playCount;
        }

        public void setPlayCount(double playCount) {
            this.playCount = playCount;
        }

        public int getTrackCount() {
            return trackCount;
        }

        public void setTrackCount(int trackCount) {
            this.trackCount = trackCount;
        }

        public boolean isHighQuality() {
            return highQuality;
        }

        public void setHighQuality(boolean highQuality) {
            this.highQuality = highQuality;
        }

        public String getAlg() {
            return alg;
        }

        public void setAlg(String alg) {
            this.alg = alg;
        }
    }
}
