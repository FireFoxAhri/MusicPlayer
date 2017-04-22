package com.firefox.musicplayer.utils.user;

import android.util.Base64;

import com.firefox.musicplayer.bean.UserBean;
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
import retrofit2.converter.gson.GsonConverterFactory;
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

    public static Call<ResponseBody> Login(String username, String password) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://music.163.com/")
                .build();
        UserLoginService service = retrofit.create(UserLoginService.class);
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(username);
        Map<String, String> text = null;

        if (m.matches()) {
            String data = "{\"phone\":\"" + username + "\",\"password\":\"" + EncryptUtil.MD5Encrypt(password.getBytes()) + "\",\"rememberLogin\":\"true\"}";
            text = EncryptUtil.encrypt(data);
            return service.phoneLogin(text);
        } else {
            String data = "{\"username\":\"" + username + "\",\"password\":\"" + EncryptUtil.MD5Encrypt(password.getBytes()) + "\",\"rememberLogin\":\"true\"}";
            text = EncryptUtil.encrypt(data);
            return service.Login(text);
        }
    }
}