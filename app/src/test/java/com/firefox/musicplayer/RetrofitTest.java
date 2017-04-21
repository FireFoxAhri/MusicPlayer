package com.firefox.musicplayer;

import android.util.Base64;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by FireFox on 2017/4/21.
 */

public class RetrofitTest {
    public static void main(String[] args) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://music.163.com/weapi/login/")
                .build();

        LoginService service = retrofit.create(LoginService.class);

        Call<ResponseBody> call = service.login(new User());
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
    @POST("cellphone")
    Call<ResponseBody> login(@Body User user);
}

class User {
    String phone = "13163388532";
    String password = Base64.encodeToString("zjs19941118".getBytes(), Base64.DEFAULT);
    String rememberLogin = "true";
}
