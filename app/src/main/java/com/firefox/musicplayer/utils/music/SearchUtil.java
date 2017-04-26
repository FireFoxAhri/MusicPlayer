package com.firefox.musicplayer.utils.music;

import com.firefox.musicplayer.MainApplication;
import com.firefox.musicplayer.utils.encrypt.EncryptUtil;
import com.firefox.musicplayer.utils.net.PersistentCookieJar;
import com.firefox.musicplayer.utils.net.PersistentCookieStore;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import okhttp3.Cookie;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by FireFox on 2017/4/23.
 */

public class SearchUtil {
    private static SearchService service = null;
    private static PersistentCookieStore persistentCookieStore = null;

    static {
        OkHttpClient client = new OkHttpClient.Builder()
                .cookieJar(new PersistentCookieJar())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl("https://music.163.com/")
                .build();
        service = retrofit.create(SearchService.class);
        persistentCookieStore = new PersistentCookieStore(MainApplication.getInstance());
    }

    public static Call<ResponseBody> SearchHotMusic() {
        String data = "{\"type\": \"recommend\"}";
        Map<String, String> text = EncryptUtil.encrypt(data);
        return service.searchHotMusic(text);
    }

    public static Call<ResponseBody> SearchUserRecord(int userID){
        String data = "{\"uid\":" + userID + ",\"limit\":1000,\"offset\":0,\"total\":true,\"type\":\"-1\"}";
        Map<String, String> text = EncryptUtil.encrypt(data);
        return service.searchUserRecord(text);
    }

    public static Call<ResponseBody> SearchRecommendMusicList(String order, int limit, int offset) {
        Map<String, String> text = new HashMap<>();
        text.put("order", order);
        text.put("limit", String.valueOf(limit));
        text.put("offset", String.valueOf(offset));
        return service.searchRecommendMusicList(text);
    }

    public static Call<ResponseBody> SearchPlaylistDetail(int PlaylistID) {
        return service.searchPlayListDetail(String.valueOf(PlaylistID));
    }

    public static Call<ResponseBody> SearchUserPlaylist(int userID) {
        String data = "{\"uid\":" + userID + ",\"wordwrap\":\"7\",\"offset\":\"0\",\"total\":\"true\",\"limit\":\"1000\"}";
        Map<String, String> text = EncryptUtil.encrypt(data);
        return service.searchUserPlaylist(text);
    }

    public static Call<ResponseBody> SearchMusic(String musicName, int offset, int limit) {

        String data = String.format(Locale.SIMPLIFIED_CHINESE, "{\"hlpretag\":\"\",\"\":\"\",\"s\":\"%s\",\"type\":\"1\",\"offset\":\"%d\",\"total\":\"true\",\"limit\":\"%d\"}", musicName, offset, limit);
        Map<String, String> text = EncryptUtil.encrypt(data);
        return service.searchMusic(text);
    }

    public static Call<ResponseBody> SearchMusicDetail(int musicID) {
        Map<String, String> text = new HashMap<>();
        String id = String.valueOf(musicID);
        text.put("id", id);
        text.put("ids", "[" + id + "]");
        return service.searchMusicDetail(text);
    }

    public static Call<ResponseBody> SearchMusicLrc(int musicID) {
        Map<String, String> text = new HashMap<>();
        String id = String.valueOf(musicID);
        text.put("id", id);
        text.put("lv", "-1");
        return service.searchMusicLrc(text);
    }

//暂时不做
//    public static ResultBean parseRecommendMusicList(String s) {
//        ResultBean resultBean = new ResultBean();
//        List<SongsBean> songs = resultBean.getSongs();
//        Document document = Jsoup.parse(s);
//        Element elements = document.getElementById("m-pl-container");
//        Elements es = elements.getElementsByTag("li");
//        for (Element aa : es) {
//            SongsBean songsBean = new SongsBean();
//            Elements bb = aa.getElementsByClass("j-flag");
//            for (Element cc : bb) {
//                songsBean.setu(cc.attr("src").replace("?param=140y140", "?param=240y240"));
//            }
//            Elements bbb = aa.getElementsByClass("msk");
//            for (Element ccc : bbb) {
//                songsBean.setTitle(ccc.attr("title"));
//                String tmp = ccc.attr("href");
//                songsBean.setListId(tmp.substring(13));
//            }
//            songs.add(songsBean);
//        }
//        return resultBean;
//    }

    //未实现
    public static Call<ResponseBody> DailyRecommend() {
        List<Cookie> cookies = persistentCookieStore.getCookies();
        String csrf = "";
        for (Cookie cookie : cookies) {
            if (cookie.name().equals("__csrf")) {
                csrf = cookie.value();
            }
        }
        String data = String.format("{\"offset\": \"0\", \"total\": \"true\", \"limit\": \"20\", \"csrf_token\":\"%s\"}", csrf);
        Map<String, String> text = EncryptUtil.encrypt(data);
        return service.searchRecommend(csrf, text);
    }
}
