package com.firefox.musicplayer.utils.user;

import android.util.Base64;

import okhttp3.Request;

/**
 * Created by FireFox on 2017/4/20.
 */

public class UserUtil {
    public static void Login(String username, String password) {

        String data = "{\"phone\":\""+username+"\",\"password\":\""+ Base64.encodeToString(password.getBytes(),Base64.DEFAULT) +"\",\"rememberLogin\":\"true\"}";
        Request request=new Request.Builder()
                .url("https://music.163.com/weapi/login/cellphone")
                .addHeader("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36")
                .addHeader("Referer","http://music.163.com/search/")
                .build();

    }
}
