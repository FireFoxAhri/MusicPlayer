package com.firefox.musicplayer.utils.net;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.functions.Action1;

/**
 * Created by FireFox on 2017/4/24.
 */

public class AddCookiesInterceptor implements Interceptor {
    private Context context;
    private String lang;

    public AddCookiesInterceptor(Context context, String lang) {
        super();
        this.context = context;
        this.lang = lang;

    }

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {

        final Request.Builder builder = chain.request().newBuilder();
        builder.addHeader("Cookie", "_ntes_nnid=4248f5a31b0ee1132ec160e2794653d7,1491485819508; _ntes_nuid=4248f5a31b0ee1132ec160e2794653d7; usertrack=ZUcIhljx2oW34ihaAypOAg==; __utma=187553192.1327630480.1492245126.1492828271.1492828271.1; __utmz=187553192.1492828271.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); __oc_uuid=bf8b92f0-2703-11e7-9141-216dcedaccb0; _ga=GA1.2.1327630480.1492245126; JSESSIONID-WYYY=EeWRofhpYGemiYeOSfd%2BnJpC65aAXMs%2FdwdoPVUSEpjkt8fZdww6TMZUuJDzg0Fu6NmFP42ZQb91hixb%5CjmUPzt%5CAvGpFnyNYS6N4XG%2Bp2JYvp63RRibTjRqlHwoAFtHcnJEPj3DWPhaWe2ESnKGOxA5A4rUSTVKzl6h3g4GKNs5sZOg%3A1493012347219; _iuqxldmzr_=32; MUSIC_U=43b776736b94be1f600c63240678e2d23fc7b39e0d3e8f875b304d91a5ad6ed10fd8702b3d3a43a0b4ec89ae2957bcecc00117b6f2f45bc3c3061cd18d77b7a0; __remember_me=true; __csrf=723b7873a0c23ee017510f33c02f6c0c; __utma=94650624.2042183695.1491485820.1492952099.1493010547.10; __utmb=94650624.4.10.1493010547; __utmc=94650624; __utmz=94650624.1493010547.10.6.utmcsr=baidu|utmccn=(organic)|utmcmd=organic");
//        SharedPreferences sharedPreferences = context.getSharedPreferences("cookie", Context.MODE_PRIVATE);
//        Observable.just(sharedPreferences.getString("cookie", ""))
//                .subscribe(new Action1<String>() {
//                    @Override
//                    public void call(String cookie) {
//                        if (cookie.contains("lang=ch")) {
//                            cookie = cookie.replace("lang=ch", "lang=" + lang);
//                        }
//                        if (cookie.contains("lang=en")) {
//                            cookie = cookie.replace("lang=en", "lang=" + lang);
//                        }
//                        //添加cookie
//                        builder.addHeader("Cookie", cookie);
//                    }
//                });
        return chain.proceed(builder.build());
    }
}