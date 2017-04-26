package com.firefox.musicplayer.utils.music;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by FireFox on 2017/4/23.
 */

public interface SearchService {
    @Headers({"Accept: */*",
            "Accept-Language: zh-CN,zh;q=0.8,gl;q=0.6,zh-TW;q=0.4",
            "Connection: keep-alive",
            "Content-Type: application/x-www-form-urlencoded",
            "Referer: http://music.163.com",
            "Host: music.163.com",
            "Referer: http://music.163.com/search/",
            "User-Agent: Mozilla/5.0 (iPhone; CPU iPhone OS 9_1 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13B143 Safari/601.1"})

    @FormUrlEncoded
    @POST("weapi/cloudsearch/get/web")
    Call<ResponseBody> searchMusic(@FieldMap Map<String, String> text);

    @GET("api/song/detail/")
    Call<ResponseBody> searchMusicDetail(@QueryMap Map<String, String> text);

    @GET("api/song/lyric")
    Call<ResponseBody> searchMusicLrc(@QueryMap Map<String, String> text);

    @GET("api/playlist/detail")
    Call<ResponseBody> searchPlayListDetail(@Query("id")String id);

    @FormUrlEncoded
    @POST("weapi/user/playlist/")
    Call<ResponseBody> searchUserPlaylist(@FieldMap Map<String, String> text);

    @FormUrlEncoded
    @POST("api/personalized/newsong")
    Call<ResponseBody> searchHotMusic(@FieldMap Map<String, String> text);

    @GET("discover/playlist/")
    Call<ResponseBody> searchRecommendMusicList(@QueryMap Map<String,String> text);

    @GET("discover/playlist/weapi/v1/play/record")
    Call<ResponseBody> searchUserRecord(Map<String, String> text);

    //未能成功
    @FormUrlEncoded
    @POST("weapi/v1/discovery/recommend/songs")
    Call<ResponseBody> searchRecommend(@Query("csrf_token") String csrf, @FieldMap Map<String, String> text);

}
