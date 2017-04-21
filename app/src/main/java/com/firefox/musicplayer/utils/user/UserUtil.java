package com.firefox.musicplayer.utils.user;

import android.util.Base64;

import com.firefox.musicplayer.utils.encrypt.EncryptUtil;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;

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

        String data = "{\"phone\":\"" + username + "\",\"password\":\"" + EncryptUtil.MD5Encrypt(password.getBytes()) + "\",\"rememberLogin\":\"true\"}";


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://music.163.com/weapi/login/")
                .build();

        LoginService service = retrofit.create(LoginService.class);
        Map<String, String> text = EncryptUtil.encrypt(data);

        Call<ResponseBody> call = service.login(text);

        // 用法和OkHttp的call如出一辙,
        // 不同的是如果是Android系统回调方法执行在主线程
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    System.out.println(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}

interface LoginService {
    @Headers({"Content-Type: application/x-www-form-urlencoded",
            "Host: music.163.com",
            "Referer: http://music.163.com/search/",
            "User-Agent: 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36"})
    @POST("cellphone")
    Call<ResponseBody> login(@QueryMap Map<String, String> text);
}


class User {
    User(String phone, String password, String rememberLogin) {
        this.phone = phone;
        this.password = Base64.encodeToString("zjs19941118".getBytes(), Base64.DEFAULT);
        this.rememberLogin = rememberLogin;
    }

    String phone;
    String password;
    String rememberLogin;
}