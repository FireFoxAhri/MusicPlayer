package com.firefox.musicplayer.bean;

/**
 * Created by FireFox on 2017/4/25.
 */

public class LyricBean {

    /**
     * sgc : true
     * sfy : false
     * qfy : false
     * lrc : {"version":7,"lyric":"[00:29.620]细雨带风湿透黄昏的街道\n[00:35.050]抹去雨水双眼无帮地仰望\n[00:40.240]望向孤单的晚灯是那伤感的记忆\n[00:48.630]再次泛起心里无数的思念\n[00:54.000]以往片刻欢笑仍挂在脸上\n[00:58.770]愿你此刻可会知是我衷心的说声\n[01:06.310]喜欢你\n[01:08.940]那双眼动人笑声更迷人\n[01:14.330]愿再可轻抚你那可爱面容\n[01:22.490]挽手说梦话象昨天你共我\n[01:42.970]满带理想的我曾经多冲动\n[01:48.340]埋怨与她相爱难有自由\n[01:53.040]愿你此刻可会知是我衷心的说声\n[02:00.420]喜欢你\n[02:03.230]那双眼动人笑声更迷人\n[02:08.540]愿再可轻抚你那可爱面容\n[02:16.750]挽手说梦话象昨天你共我\n[02:24.740]每晚夜里自我独行\n[02:27.670]随处荡 多冰冷\n[02:35.070]以往为了自我挣扎从不知她的痛苦\n[02:49.380]喜欢你\n[02:52.020]那双眼动人笑声更迷人\n[02:57.420]愿再可轻抚你那可爱面容\n[03:05.590]挽手说梦话象昨天你共我\n[03:13.870]挽手说梦话象昨天你共我\n"}
     * code : 200
     */

    private boolean sgc;
    private boolean sfy;
    private boolean qfy;
    private LrcBean lrc;
    private int code;

    public boolean isSgc() {
        return sgc;
    }

    public void setSgc(boolean sgc) {
        this.sgc = sgc;
    }

    public boolean isSfy() {
        return sfy;
    }

    public void setSfy(boolean sfy) {
        this.sfy = sfy;
    }

    public boolean isQfy() {
        return qfy;
    }

    public void setQfy(boolean qfy) {
        this.qfy = qfy;
    }

    public LrcBean getLrc() {
        return lrc;
    }

    public void setLrc(LrcBean lrc) {
        this.lrc = lrc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class LrcBean {
        /**
         * version : 7
         * lyric : [00:29.620]细雨带风湿透黄昏的街道
         [00:35.050]抹去雨水双眼无帮地仰望
         [00:40.240]望向孤单的晚灯是那伤感的记忆
         [00:48.630]再次泛起心里无数的思念
         [00:54.000]以往片刻欢笑仍挂在脸上
         [00:58.770]愿你此刻可会知是我衷心的说声
         [01:06.310]喜欢你
         [01:08.940]那双眼动人笑声更迷人
         [01:14.330]愿再可轻抚你那可爱面容
         [01:22.490]挽手说梦话象昨天你共我
         [01:42.970]满带理想的我曾经多冲动
         [01:48.340]埋怨与她相爱难有自由
         [01:53.040]愿你此刻可会知是我衷心的说声
         [02:00.420]喜欢你
         [02:03.230]那双眼动人笑声更迷人
         [02:08.540]愿再可轻抚你那可爱面容
         [02:16.750]挽手说梦话象昨天你共我
         [02:24.740]每晚夜里自我独行
         [02:27.670]随处荡 多冰冷
         [02:35.070]以往为了自我挣扎从不知她的痛苦
         [02:49.380]喜欢你
         [02:52.020]那双眼动人笑声更迷人
         [02:57.420]愿再可轻抚你那可爱面容
         [03:05.590]挽手说梦话象昨天你共我
         [03:13.870]挽手说梦话象昨天你共我

         */

        private int version;
        private String lyric;

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public String getLyric() {
            return lyric;
        }

        public void setLyric(String lyric) {
            this.lyric = lyric;
        }
    }
}
