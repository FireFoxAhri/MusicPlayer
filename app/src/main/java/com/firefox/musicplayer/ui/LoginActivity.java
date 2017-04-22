package com.firefox.musicplayer.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;

import com.firefox.musicplayer.R;
import com.firefox.musicplayer.bean.UserBean;
import com.firefox.musicplayer.ui.base.BaseActivity;
import com.firefox.musicplayer.utils.user.UserUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 俗 on 2017/4/20.
 */

public class LoginActivity extends BaseActivity {
    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btnLogin)
    Button btnLogin;

    @OnClick(R.id.btnLogin)
    public void onViewClicked() {
        Call<ResponseBody> call = UserUtil.Login(etAccount.getText().toString(), etPassword.getText().toString());
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Gson gson = new Gson();
                System.out.println(response.code());
                if (response.code() == 200) {
                    try {
                        UserBean user = gson.fromJson(response.body().string(), UserBean.class);
                        System.out.println(user.toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (response.code() == 502) {
                    try {
                        Map<String, String> errMsg = gson.fromJson(response.body().string(), new TypeToken<Map<String, String>>() {
                        }.getType());
                        System.out.println(errMsg.get("msg"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_layout);
        ButterKnife.bind(this);
    }


}
