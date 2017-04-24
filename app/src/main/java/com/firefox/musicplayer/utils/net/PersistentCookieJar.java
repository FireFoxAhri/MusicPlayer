package com.firefox.musicplayer.utils.net;

import android.content.SharedPreferences;

import com.firefox.musicplayer.MainApplication;

import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * Created by FireFox on 2017/4/23.
 */

public class PersistentCookieJar implements CookieJar {
    private final PersistentCookieStore cookieStore = new PersistentCookieStore(MainApplication.getInstance());

    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        if (cookies != null && cookies.size() > 0) {
            for (Cookie item : cookies) {
                cookieStore.add(url, item);
            }
        }
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        List<Cookie> cookies = cookieStore.get(url);
        return cookies;
    }
}
