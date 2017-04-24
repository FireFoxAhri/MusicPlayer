package com.firefox.musicplayer.utils.user;

import com.firefox.musicplayer.MainApplication;
import com.firefox.musicplayer.utils.encrypt.EncryptUtil;
import com.firefox.musicplayer.utils.net.AddCookiesInterceptor;
import com.firefox.musicplayer.utils.net.PersistentCookieJar;
import com.firefox.musicplayer.utils.net.PersistentCookieStore;
import com.firefox.musicplayer.utils.net.ReceivedCookiesInterceptor;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by FireFox on 2017/4/20.
 */

public class UserUtil {
    public static Call<ResponseBody> userInfo(int userID) {
        OkHttpClient client = new OkHttpClient.Builder()
                .cookieJar(new PersistentCookieJar())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl("https://music.163.com/")
                .build();
        UserLoginService service = retrofit.create(UserLoginService.class);
        String data = String.format("{\"userId\":\"%d\",\"csrf_token\":\"\"}", userID);
        Map<String, String> text = EncryptUtil.encrypt(data);
        return service.userInfo(text);
    }

    public static Call<ResponseBody> SignIn(int type) {

        OkHttpClient client = new OkHttpClient.Builder()
                //.cookieJar(new PersistentCookieJar())
                .addInterceptor(new ReceivedCookiesInterceptor(MainApplication.getInstance()))
                .addInterceptor(new AddCookiesInterceptor(MainApplication.getInstance(), ""))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl("https://music.163.com/")
                .build();
        UserLoginService service = retrofit.create(UserLoginService.class);
        String data = String.format("{\"type\":1}");
        Map<String, String> text = EncryptUtil.encrypt(data);
        return service.userInfo(text);
    }

    public static Call<ResponseBody> Login(String username, final String password) {
        OkHttpClient client = new OkHttpClient.Builder()
                //.cookieJar(new PersistentCookieJar())
                .addInterceptor(new ReceivedCookiesInterceptor(MainApplication.getInstance()))
                .addInterceptor(new AddCookiesInterceptor(MainApplication.getInstance(), ""))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl("https://music.163.com/")
                .build();
        UserLoginService service = retrofit.create(UserLoginService.class);
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(username);
        Map<String, String> text = null;

        if (m.matches()) {
            String data = String.format("{\"phone\":\"%s\",\"password\":\"%s\",\"rememberLogin\":\"true\"}", username, EncryptUtil.MD5Encrypt(password.getBytes()));
            text = EncryptUtil.encrypt(data);
            return service.phoneLogin(text);
        } else {
            String data = String.format("{\"username\":\"%s\",\"password\":\"%s\",\"rememberLogin\":\"true\"}", username, EncryptUtil.MD5Encrypt(password.getBytes()));
            text = EncryptUtil.encrypt(data);
            return service.Login(text);
        }
    }
}