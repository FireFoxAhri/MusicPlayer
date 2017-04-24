package com.firefox.musicplayer.utils.user;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by FireFox on 2017/4/21.
 */

public interface UserLoginService {
    @Headers({"Content-Type: application/x-www-form-urlencoded",
            "Host: music.163.com",
            "Referer: http://music.163.com/search/",
            "User-Agent: 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36"})

    @POST("weapi/login")
    Call<ResponseBody> Login(@QueryMap Map<String, String> text);

    @FormUrlEncoded
    @POST("weapi/login/cellphone")
    Call<ResponseBody> phoneLogin(@FieldMap Map<String, String> text);

    @POST("weapi/subcount")
    Call<ResponseBody> userInfo(@QueryMap Map<String, String> text);

    @FormUrlEncoded
    @POST("weapi/point/dailyTask")
    Call<ResponseBody> signIn(@FieldMap Map<String, String> text);
}
