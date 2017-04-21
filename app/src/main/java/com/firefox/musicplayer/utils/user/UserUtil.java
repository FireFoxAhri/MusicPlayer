package com.firefox.musicplayer.utils.user;

import android.util.Base64;

import com.firefox.musicplayer.utils.encrypt.EncryptUtil;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by FireFox on 2017/4/20.
 */

public class UserUtil {

    public static void Login(String username, String password) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://music.163.com/weapi/")
                .build();
        UserLoginService service = retrofit.create(UserLoginService.class);
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(username);
        String data = "";
        boolean phoneLogin = false;
        if (m.matches()) {
            phoneLogin = true;
            data = "{\"phone\":\"" + username + "\",\"password\":\"" + EncryptUtil.MD5Encrypt(password.getBytes()) + "\",\"rememberLogin\":\"true\"}";
        } else
            data = "{\"username\":\"" + username + "\",\"password\":\"" + EncryptUtil.MD5Encrypt(password.getBytes()) + "\",\"rememberLogin\":\"true\"}";
        Map<String, String> text = EncryptUtil.encrypt(data);
        Call<ResponseBody> call = null;
        if (phoneLogin)
            call = service.phoneLogin(text);
        else
            call = service.Login(text);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                System.out.println(response.body());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}