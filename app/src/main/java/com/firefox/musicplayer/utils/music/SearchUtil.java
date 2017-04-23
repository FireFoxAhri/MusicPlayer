package com.firefox.musicplayer.utils.music;

import android.telecom.CallScreeningService;
import android.util.Log;
import android.view.View;

import com.firefox.musicplayer.bean.SearchMusicBean;
import com.firefox.musicplayer.utils.encrypt.EncryptUtil;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by FireFox on 2017/4/23.
 */

public class SearchUtil {
    private static SearchService service = null;
    private static Gson gson = null;

    static {
        gson = new Gson();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://music.163.com/")
                .build();
        service = retrofit.create(SearchService.class);
    }

    public static Call<ResponseBody> SearchMusic(String musicName, int offset, int limit) {

        String data = String.format(Locale.SIMPLIFIED_CHINESE, "{\"hlpretag\":\"\",\"\":\"\",\"s\":\"%s\",\"type\":\"1\",\"offset\":\"%d\",\"total\":\"true\",\"limit\":\"%d\"}", musicName, offset, limit);
        Map<String, String> text = EncryptUtil.encrypt(data);
        Call<ResponseBody> call = service.searchMusic(text);
        return call;
    }

}
